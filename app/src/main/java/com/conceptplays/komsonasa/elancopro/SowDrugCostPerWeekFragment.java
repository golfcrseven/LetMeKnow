package com.conceptplays.komsonasa.elancopro;


import android.app.Fragment;
import android.content.Context;
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
 * A simple {@link Fragment} subclass.
 */
public class SowDrugCostPerWeekFragment extends android.support.v4.app.Fragment {
    DataBaseAdapter db;
    HelperClass hc;
    FeedSowsFragment pop;

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
    Double C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22,C23,C24,C25;
    Double P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P15,P16,P17,P18,P19,P20,P21,P22,P23,P24,P25;

    ArrayList<Double> sumVal = new ArrayList<Double>();

    public SowDrugCostPerWeekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sow_drug_cost_per_week, container, false);

        db = new DataBaseAdapter(getActivity());
        hc = new HelperClass();
        pop = new FeedSowsFragment();

        infltr = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parent = (LinearLayout)v.findViewById(R.id.layout_for_add);
        tvTotalCost = (TextView)v.findViewById(R.id.totalCost);

        getData();
        setData();

        return v;
    }

    public  void getData() {

        getPopB();//Population(B)
        getFeedC();//FeedConsumption(C)

        db.open();
        Cursor cursor;
        cursor = db.getAll(db.DRUG_SOW_PERSOW_TABLE, "asc");
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
                Total.add(getTotal(cursor.getString(3), Double.valueOf(cursor.getString(2))).toString());
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }


    public void setData(){
        parent.removeAllViewsInLayout();
        TotalCost = 0.0;

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

            SowDrugCostPerSowFragment  PerSow = new SowDrugCostPerSowFragment();
            ArrayList<String> drugList = new ArrayList<String>();
            drugList.clear();
            drugList = PerSow.getDrug(Long.valueOf(DrugIdList.get(position)), this.db);
            txtNo.setText((position+1)+")");
            tvDrugName.setText(drugList.get(0).toString());
            tvDrugPrice.setText(drugList.get(1).toString()+" ฿");
            tvUsage.setText(Usage.get(position).toString());
            tvTotal.setText(hc.df3(hc.string2double(Total.get(position))));
            Double cost = (hc.string2double9df(Total.get(position))*hc.string2double(drugList.get(1)));//total*price
            TotalCost = TotalCost+cost;
            tvCost.setText(hc.df2(cost));

            Button btnEdt = (Button)custom.findViewById(R.id.edtBtnPerSow);
            ViewGroup.LayoutParams params = btnEdt.getLayoutParams();
            params.height = 0;
            btnEdt.setVisibility(View.INVISIBLE);
            Button btnRemove = (Button)custom.findViewById(R.id.btnRemove);
            btnRemove.setVisibility(View.GONE);

            parent.addView(custom);
        }
        tvTotalCost.setText(hc.df2(TotalCost));
    }
    
    public void getPopB(){
        ArrayList ar = pop.getB(this.db);
        P4 = Double.valueOf(ar.get(8).toString());
        P5 = Double.valueOf(ar.get(9).toString());
        P6 = Double.valueOf(ar.get(10).toString());
        P7 = Double.valueOf(ar.get(11).toString());
        P8 = Double.valueOf(ar.get(12).toString());
        P9 = Double.valueOf(ar.get(13).toString());
        P10 = Double.valueOf(ar.get(14).toString());
        P11 = Double.valueOf(ar.get(15).toString());
        P12 = Double.valueOf(ar.get(16).toString());
        P13 = Double.valueOf(ar.get(17).toString());
        P14 = Double.valueOf(ar.get(18).toString());
        P15 = Double.valueOf(ar.get(19).toString());
        P16 = Double.valueOf(ar.get(20).toString());
        P17 = Double.valueOf(ar.get(21).toString());
        P18 = Double.valueOf(ar.get(22).toString());
        P19 = Double.valueOf(ar.get(23).toString());
        P20 = Double.valueOf(ar.get(24).toString());
        P21 = Double.valueOf(ar.get(25).toString());
        P22 = Double.valueOf(ar.get(26).toString());
        P23 = Double.valueOf(ar.get(4).toString());
        P24 = Double.valueOf(ar.get(4).toString());
        P25 = Double.valueOf(ar.get(4).toString());
    }

    public void getFeedC(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.FDSOW_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                C4 = Double.valueOf(cursor.getString(1));
                C5 = Double.valueOf(cursor.getString(2));
                C6 = Double.valueOf(cursor.getString(3));
                C7 = Double.valueOf(cursor.getString(4));
                C8 = Double.valueOf(cursor.getString(5));
                C9 = Double.valueOf(cursor.getString(6));
                C10 = Double.valueOf(cursor.getString(7));
                C11 = Double.valueOf(cursor.getString(8));
                C12 = Double.valueOf(cursor.getString(9));
                C13 = Double.valueOf(cursor.getString(10));
                C14 = Double.valueOf(cursor.getString(11));
                C15 = Double.valueOf(cursor.getString(12));
                C16 = Double.valueOf(cursor.getString(13));
                C17 = Double.valueOf(cursor.getString(14));
                C18 = Double.valueOf(cursor.getString(15));
                C19 = Double.valueOf(cursor.getString(16));
                C20 = Double.valueOf(cursor.getString(17));
                C21 = Double.valueOf(cursor.getString(18));
                C22 = Double.valueOf(cursor.getString(19));
                C23 = Double.valueOf(cursor.getString(20));
                C24 = Double.valueOf(cursor.getString(21));
                C25 = Double.valueOf(cursor.getString(22));

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    public void getFCH(Double usage){

        sumVal.set(0,usage*((C4*7)*P4)/1000);
        sumVal.set(1,usage*((C5*7)*P5)/1000);
        sumVal.set(2,usage*((C6*7)*P6)/1000);
        sumVal.set(3,usage*((C7*7)*P7)/1000);
        sumVal.set(4,usage*((C8*7)*P8)/1000);
        sumVal.set(5,usage*((C9*7)*P9)/1000);
        sumVal.set(6,usage*((C10*7)*P10)/1000);
        sumVal.set(7,usage*((C11*7)*P11)/1000);
        sumVal.set(8,usage*((C12*7)*P12)/1000);
        sumVal.set(9,usage*((C13*7)*P13)/1000);
        sumVal.set(10,usage*((C14*7)*P14)/1000);
        sumVal.set(11,usage*((C15*7)*P15)/1000);
        sumVal.set(12,usage*((C16*7)*P16)/1000);
        sumVal.set(13,usage*((C17*7)*P17)/1000);
        sumVal.set(14,usage*((C18*7)*P18)/1000);
        sumVal.set(15,usage*((C19*7)*P19)/1000);
        sumVal.set(16,usage*((C20*7)*P20)/1000);
        sumVal.set(17,usage*((C21*7)*P21)/1000);
        sumVal.set(18,usage*((C22*7)*P22)/1000);
        sumVal.set(19,usage*((C23*7)*P23)/1000);
        sumVal.set(20,usage*((C24*7)*P24)/1000);
        sumVal.set(21,usage*((C25*7)*P25)/1000);
    }

    public Double getTotal(String string, Double usage) {
        Double sum = 0.000000000;
        sumVal.clear();

        for (int i=1; i<=string.length(); i++){
            sumVal.add(0.0);
        }
        getFCH(usage);
        //StringBuilder opt = new StringBuilder();
        for (int i=1; i<=string.length(); i++){
            String data = String.valueOf(string.charAt(i-1));
            if(data.equals("1")){
                sum = sum+hc.string2double9df(hc.df9(sumVal.get(i-1)));
                //opt.append(sumVal.get(i-1).toString()+"|");
            }else{
                sum = sum+0;
            }
        }
        //Toast.makeText(getActivity(), P4.toString(), Toast.LENGTH_LONG).show();
        String total = hc.df9(sum);
        sum = hc.string2double9df(total);
        sumVal.clear();
        return sum;

    }

    @Override
    public void onResume(){
        super.onResume();

        getData();
        setData();
    }

}
