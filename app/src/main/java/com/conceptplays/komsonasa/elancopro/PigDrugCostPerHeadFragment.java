package com.conceptplays.komsonasa.elancopro;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.conceptplays.komsonasa.elancopro.Class.HelperClass;
import com.conceptplays.komsonasa.elancopro.DB.DataBaseAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

import java.util.ArrayList;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class PigDrugCostPerHeadFragment extends android.support.v4.app.Fragment {
    DataBaseAdapter db;
    HelperClass hc;

    LayoutInflater infltr;
    LinearLayout parent;
    ArrayList<Long> ListID = new ArrayList<Long>();
    ArrayList<String> DrugIdList = new ArrayList<String>();
    ArrayList<CharSequence> DrugId = new ArrayList<CharSequence>();
    ArrayList<String> Option = new ArrayList<String>();
    ArrayList<Double> Usage = new ArrayList<Double>();
    ArrayList<String> Cost = new ArrayList<String>();
    ArrayList<String> Total = new ArrayList<String>();
    Double TotalCost = 0.0;
    TextView tvTotalCost;
    public PigDrugCostPerHeadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sow_drug_cost_per_sow, container, false);


        db = new DataBaseAdapter(getActivity());
        hc = new HelperClass();

        infltr = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parent = (LinearLayout)v.findViewById(R.id.layout_for_add);
        tvTotalCost = (TextView)v.findViewById(R.id.totalCost);

        getData();
        setData();

        Button btnAdd = (Button) getActivity().findViewById(R.id.btnAddMedicine);
        btnAdd.setVisibility(View.VISIBLE);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrugId.clear();
                getData();

                Intent intent;
                intent = new Intent(getActivity(), AddDrugsActivity.class);
                intent.putExtra("listID",DrugId);
                intent.putExtra("title","Per Head");
                startActivity(intent);
            }
        });

       return  v;
    }


    public  void getData() {
        db.open();
        Cursor cursor;
        cursor = db.getAll(db.DRUG_PIG_TABLE, "asc");
        cursor.requery();
        ListID.clear();
        DrugIdList.clear();
        Option.clear();
        Usage.clear();
        Total.clear();
        if(cursor.moveToFirst()){
            do{
                ListID.add(Long.valueOf(cursor.getString(0)));
                DrugIdList.add(String.valueOf(cursor.getString(1)));
                DrugId.add(cursor.getString(1));
                Usage.add(Double.valueOf(cursor.getString(2)));
                Option.add(cursor.getString(3));
                Total.add(String.valueOf(cursor.getString(5)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    public void setData(){
        parent.removeAllViewsInLayout();
        TotalCost = 0.000000000;
        for (int i=1; i<=DrugIdList.size();i++){
            final int position = i-1;
            View custom = infltr.inflate(R.layout.sub_view_drug_cost, null);
            if((position%2)==1)
                custom.setBackgroundColor(Color.parseColor("#ebebeb"));
            TextView txtNo = (TextView)custom.findViewById(R.id.drugNo);
            final TextView tvDrugName = (TextView)custom.findViewById(R.id.drugName);
            final TextView tvDrugPrice = (TextView)custom.findViewById(R.id.drugPrice);
            TextView tvUsage = (TextView)custom.findViewById(R.id.usage);
            TextView tvTotal = (TextView)custom.findViewById(R.id.total);
            TextView tvCost = (TextView)custom.findViewById(R.id.cost);

            ArrayList<String> drugList = new ArrayList<String>();
            drugList.clear();
            drugList = getDrug(Long.valueOf(DrugIdList.get(position)), db);
            txtNo.setText((position+1)+")");
            tvDrugName.setText(drugList.get(0).toString());
            tvDrugPrice.setText(hc.df2(hc.string2double(drugList.get(1).toString()))+" ฿");
            tvUsage.setText(Usage.get(position).toString());
            tvTotal.setText(hc.df3(hc.string2double(Total.get(position))));
            Double cost = (hc.string2double9df(Total.get(position))*hc.string2double9df(drugList.get(1)));//total*price
            TotalCost = TotalCost+cost;
            tvCost.setText(hc.df2(cost));

            Button btnEdt = (Button)custom.findViewById(R.id.edtBtnPerSow);
            btnEdt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;
                    intent = new Intent(getActivity(), PigDrugPerHeadActivity.class);
                    intent.putExtra("listID",Long.valueOf(ListID.get(position)));
                    intent.putExtra("option",Option.get(position).toString());
                    intent.putExtra("drugName", tvDrugName.getText().toString());
                    intent.putExtra("drugPrice", tvDrugPrice.getText().toString());
                    intent.putExtra("title", "Per Head");
                    startActivity(intent);
                }
            });

            Button btnRemove = (Button)custom.findViewById(R.id.btnRemove);
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                    dialog.setMessage("Are you confirm to remove drugs?");
                    dialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                            // TODO Auto-generated method stub
                        }
                    });
                    dialog.setNegativeButton("REMOVE", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                            if(deleted(Long.valueOf(ListID.get(position)))){
                                getData();
                                setData();
                            }
                        }
                    });
                    dialog.show();
                }
            });
            parent.addView(custom);
        }
        tvTotalCost.setText(hc.df2(TotalCost));
    }

    public ArrayList getDrug(Long id, DataBaseAdapter db) {

        String name = null;
        Double price = null;
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.DRUG_TABLE, id);
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                name = String.valueOf(cursor.getString(1));
                price = Double.valueOf(cursor.getString(2));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.clear();
        arrayList.add(name);
        arrayList.add(String.valueOf(price));


        return  arrayList;
    }

    private boolean deleted(Long id){
        db.open();
        boolean bool;
        bool =  db.deleteRow(db.DRUG_PIG_TABLE, id);
        db.close();
        return bool;
    }

    @Override
    public void onResume(){
        super.onResume();

        getData();
        setData();
    }
}
