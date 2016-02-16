package com.conceptplays.komsonasa.elancopro;


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
 * A simple {@link android.app.Fragment} subclass.
 */
public class PigDrugCostPerWeekFragment extends android.support.v4.app.Fragment {
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
    Double M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22,M23,M24,M25;
    Double P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P15,P16,P17,P18,P19,P20,P21,P22,P23,P24,P25;

    ArrayList<Double> sumVal = new ArrayList<Double>();

    public PigDrugCostPerWeekFragment() {
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
        getFeedM();//FeedConsumption(M)

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
        P4 = Double.valueOf(ar.get(8+28).toString());
        P5 = Double.valueOf(ar.get(9+28).toString());
        P6 = Double.valueOf(ar.get(10+28).toString());
        P7 = Double.valueOf(ar.get(11+28).toString());
        P8 = Double.valueOf(ar.get(12+28).toString());
        P9 = Double.valueOf(ar.get(13+28).toString());
        P10 = Double.valueOf(ar.get(14+28).toString());
        P11 = Double.valueOf(ar.get(15+28).toString());
        P12 = Double.valueOf(ar.get(16+28).toString());
        P13 = Double.valueOf(ar.get(17+28).toString());
        P14 = Double.valueOf(ar.get(18+28).toString());
        P15 = Double.valueOf(ar.get(19+28).toString());
        P16 = Double.valueOf(ar.get(20+28).toString());
        P17 = Double.valueOf(ar.get(21+28).toString());
        P18 = Double.valueOf(ar.get(22+28).toString());
        P19 = Double.valueOf(ar.get(23+28).toString());
        P20 = Double.valueOf(ar.get(24+28).toString());
        P21 = Double.valueOf(ar.get(25+28).toString());
        P22 = Double.valueOf(ar.get(26+28).toString());
        P23 = Double.valueOf(ar.get(27+28).toString());
        P24 = Double.valueOf(ar.get(28+28).toString());
        P25 = Double.valueOf(ar.get(29+28).toString());
    }


    public void getFeedM(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.FDPIG_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                M4 = Double.valueOf(cursor.getString(1));
                M5 = Double.valueOf(cursor.getString(2));
                M6 = Double.valueOf(cursor.getString(3));
                M7 = Double.valueOf(cursor.getString(4));
                M8 = Double.valueOf(cursor.getString(5));
                M9 = Double.valueOf(cursor.getString(6));
                M10 = Double.valueOf(cursor.getString(7));
                M11 = Double.valueOf(cursor.getString(8));
                M12 = Double.valueOf(cursor.getString(9));
                M13 = Double.valueOf(cursor.getString(10));
                M14 = Double.valueOf(cursor.getString(11));
                M15 = Double.valueOf(cursor.getString(12));
                M16 = Double.valueOf(cursor.getString(13));
                M17 = Double.valueOf(cursor.getString(14));
                M18 = Double.valueOf(cursor.getString(15));
                M19 = Double.valueOf(cursor.getString(16));
                M20 = Double.valueOf(cursor.getString(17));
                M21 = Double.valueOf(cursor.getString(18));
                M22 = Double.valueOf(cursor.getString(19));
                M23 = Double.valueOf(cursor.getString(20));
                M24 = Double.valueOf(cursor.getString(21));
                M25 = Double.valueOf(cursor.getString(22));

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    public void getFCH(Double usage){

        sumVal.set(0,usage*((M4*7)*P4)/1000);
        sumVal.set(1,usage*((M5*7)*P5)/1000);
        sumVal.set(2,usage*((M6*7)*P6)/1000);
        sumVal.set(3,usage*((M7*7)*P7)/1000);
        sumVal.set(4,usage*((M8*7)*P8)/1000);
        sumVal.set(5,usage*((M9*7)*P9)/1000);
        sumVal.set(6,usage*((M10*7)*P10)/1000);
        sumVal.set(7,usage*((M11*7)*P11)/1000);
        sumVal.set(8,usage*((M12*7)*P12)/1000);
        sumVal.set(9,usage*((M13*7)*P13)/1000);
        sumVal.set(10,usage*((M14*7)*P14)/1000);
        sumVal.set(11,usage*((M15*7)*P15)/1000);
        sumVal.set(12,usage*((M16*7)*P16)/1000);
        sumVal.set(13,usage*((M17*7)*P17)/1000);
        sumVal.set(14,usage*((M18*7)*P18)/1000);
        sumVal.set(15,usage*((M19*7)*P19)/1000);
        sumVal.set(16,usage*((M20*7)*P20)/1000);
        sumVal.set(17,usage*((M21*7)*P21)/1000);
        sumVal.set(18,usage*((M22*7)*P22)/1000);
        sumVal.set(19,usage*((M23*7)*P23)/1000);
        sumVal.set(20,usage*((M24*7)*P24)/1000);
        sumVal.set(21,usage*((M25*7)*P25)/1000);
    }

    private Double getTotal(String string, Double usage) {
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
