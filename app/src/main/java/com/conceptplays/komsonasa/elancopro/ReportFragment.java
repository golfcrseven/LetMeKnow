package com.conceptplays.komsonasa.elancopro;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.conceptplays.komsonasa.elancopro.Class.HelperClass;
import com.conceptplays.komsonasa.elancopro.DB.DataBaseAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReportFragment extends Fragment {

	public ReportFragment(){}

    android.os.Handler customHandler;
    DataBaseAdapter db;
    FeedSowsFragment pop;
    SowDrugCostPerWeekFragment SDC;
    HelperClass hc;



    TextView rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12,rb13,rb14,rb15,rb16,rb17,rb18,rb19,rb20;
    TextView rb21,rb22,rb23,rb24,rb25,rb26,rb27,rb28,rb29,rb30,rb31,rb32,rb33,rb34,rb35,rb36,rb37,rb38,rb39,rb40;
    TextView rb41,rb42,rb43,rb44,rb45,rb46,rb47,rb48,rb49,rb50,rb51,rb52,rb53,rb54,rb55,rb56,rb57,rb58,rb59,rb60;
    TextView rb61,rb62,rb63,rb64,rb65;

    TextView RC1,RC2,RC3,RC4,RC5,RC6,RC7,RC8,RC9,RC10,RC11,RC12,RC13,RC14,RC15,RC16,RC17,RC18,RC19,RC20;
    TextView RC21,RC22,RC23,RC24,RC25,RC26,RC27,RC28,RC29,RC30,RC31,RC32,RC33,RC34,RC35,RC36,RC37,RC38,RC39,RC40;
    TextView RC41,RC42,RC43,RC44,RC45,RC46,RC47,RC48,RC49,RC50,RC51,RC52,RC53,RC54,RC55,RC56,RC57,RC58,RC59,RC60;
    TextView RC61,RC62,RC63,RC64,RC65;

    TextView RD15,RD16,RD17,RD18,RD19;
    TextView RD21,RD22,RD23,RD24,RD25,RD26,RD27,RD28,RD29,RD30,RD31,RD32,RD33,RD34,RD35,RD36,RD37,RD38,RD39,RD40;
    TextView RD41,RD42,RD43,RD44,RD45,RD46,RD47,RD48,RD49,RD50,RD51,RD52,RD53,RD54,RD55,RD56,RD57,RD58,RD59,RD60;
    TextView RD61,RD62,RD63,RD64,RD65;

    Double C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22,C23,C24,C25,C26,C27,C28,C29;
    Double E26,E27,E28,E29,D26,D27,D28,D29,H26,H27,H28,H29,H30;
    Double I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22,I23,I24,I25,I26,I27,I28,I29,I30;
    Double pB3,pB4, pB5,pB6,pB7,pB8,pB9,pB10,pB11,pB12,pB13,pB14,pB15,pB16,pB17,pB18,pB19,pB20,pB21,pB22,pB23,pB24,pB25,pB26,pB27;
    Double pB28,pB29,pB30,pB31,pB32,pB33,pB34,pB35,pB36,pB37,pB38,pB39,pB40,pB41,pB42,pB43,pB44,pB45,pB46;
    Double pB47,pB48,pB49,pB50,pB51,pB52,pB53,pB54,pB55,pB56,pB57,pB58,pB59,pB60,pB61,pB62,pB63,pB64,pB65;

    Double M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22,M23,M24,M25,M26,M27,M28,M29,M30,M31,M32;
    Double N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22,N23,N24,N25,N26,N27,N28,N29,N30,N31,N32;
    Double O4,O5,O6,O7,O8,O9,O10,O11,O12,O13,O14,O15,O16,O17,O18,O19,O20,O21,O22,O23,O24,O25,O26,O27,O28,O29,O30,O31,O32;
    Double Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14,Q15,Q16,Q17,Q18,Q19,Q20,Q21,Q22,Q23,Q24,Q25,Q26,Q27,Q28,Q29,Q30,Q31,Q32;
    Double R4,R5,R6,R7,R8,R9,R10,R11,R12,R13,R14,R15,R16,R17,R18,R19,R20,R21,R22,R23,R24,R25,R26,R27,R28,R29,R30,R31,R32;
    Double S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21,S22,S23,S24,S25,S26,S27,S28,S29,S30,S31,S32;

    Double num1, num2, num3,num4, num5,num6, num7;

    ArrayList<String> Total = new ArrayList<String>();
    ArrayList<String> TotalSow = new ArrayList<String>();
    ArrayList<Double> sumVal = new ArrayList<Double>();
    ArrayList<String> TotalMonth = new ArrayList<String>();
    ArrayList<Double> sumValMonth = new ArrayList<Double>();
    ArrayList<String> DrugIdList = new ArrayList<String>();

    ArrayList<String> pigDrugIdList = new ArrayList<String>();
    ArrayList<String> pigDrugTotal = new ArrayList<String>();
    ArrayList<String> pigDrugHeadTotal = new ArrayList<String>();
    ArrayList<String> pigDrugWeekTotal = new ArrayList<String>();
    ArrayList<Double> sumValPigDrug = new ArrayList<Double>();

    ArrayList<String> InjectionIdList = new ArrayList<String>();
    ArrayList<String> InjectionTotal = new ArrayList<String>();
    ArrayList<String> InjectionPigletTotal = new ArrayList<String>();
    ArrayList<String> InjectionTotalMonth = new ArrayList<String>();

    ArrayList<String> VaccineIdList = new ArrayList<String>();
    ArrayList<String> VaccineTotal = new ArrayList<String>();
    ArrayList<String> VaccinePiglietTotal = new ArrayList<String>();
    ArrayList<String> VaccineTotalMonth = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {

        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_AppCompat_Light);
        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);
        View v = inflater.inflate(R.layout.fragment_report, container, false);

        Button btnAdd = (Button) getActivity().findViewById(R.id.btnAddMedicine);
        btnAdd.setVisibility(View.VISIBLE);
        btnAdd.setText("Elanco    ");
        btnAdd.setTextSize(19);

        //Hide Scrollview Bar
        final ScrollView sView = (ScrollView)v.findViewById(R.id.scrollViewID);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);



        db = new DataBaseAdapter(getActivity());
        pop = new FeedSowsFragment();
        SDC = new SowDrugCostPerWeekFragment();
        hc = new HelperClass();

        rb7 = (TextView)v.findViewById(R.id.RB7);
        rb8 = (TextView)v.findViewById(R.id.RB8);
        rb9 = (TextView)v.findViewById(R.id.RB9);
        rb10 = (TextView)v.findViewById(R.id.RB10);
        rb11 = (TextView)v.findViewById(R.id.RB11);
        rb12 = (TextView)v.findViewById(R.id.RB12);
        rb13 = (TextView)v.findViewById(R.id.RB13);
        rb21 = (TextView)v.findViewById(R.id.RB21);
        rb22 = (TextView)v.findViewById(R.id.RB22);
        rb23 = (TextView)v.findViewById(R.id.RB23);
        rb24 = (TextView)v.findViewById(R.id.RB24);
        rb25 = (TextView)v.findViewById(R.id.RB25);
        rb26 = (TextView)v.findViewById(R.id.RB26);
        rb27 = (TextView)v.findViewById(R.id.RB27);
        rb28 = (TextView)v.findViewById(R.id.RB28);
        rb29 = (TextView)v.findViewById(R.id.RB29);
        rb31 = (TextView)v.findViewById(R.id.RB31);
        rb33 = (TextView)v.findViewById(R.id.RB33);
        rb35 = (TextView)v.findViewById(R.id.RB35);
        rb43 = (TextView)v.findViewById(R.id.RB43);
        rb44 = (TextView)v.findViewById(R.id.RB44);
        rb45 = (TextView)v.findViewById(R.id.RB45);
        rb46 = (TextView)v.findViewById(R.id.RB46);
        rb47 = (TextView)v.findViewById(R.id.RB47);
        rb48 = (TextView)v.findViewById(R.id.RB48);
        rb49 = (TextView)v.findViewById(R.id.RB49);
        rb50 = (TextView)v.findViewById(R.id.RB50);
        rb51 = (TextView)v.findViewById(R.id.RB51);
        rb52 = (TextView)v.findViewById(R.id.RB52);
        rb53 = (TextView)v.findViewById(R.id.RB53);
        rb54 = (TextView)v.findViewById(R.id.RB54);
        rb55 = (TextView)v.findViewById(R.id.RB55);
        rb57 = (TextView)v.findViewById(R.id.RB57);
        rb59 = (TextView)v.findViewById(R.id.RB59);
        rb61 = (TextView)v.findViewById(R.id.RB61);

        RC15 = (TextView)v.findViewById(R.id.RC15);
        RC16 = (TextView)v.findViewById(R.id.RC16);
        RC17 = (TextView)v.findViewById(R.id.RC17);
        RC18 = (TextView)v.findViewById(R.id.RC18);
        RC19 = (TextView)v.findViewById(R.id.RC19);
        RC20 = (TextView)v.findViewById(R.id.RC20);
        RC21 = (TextView)v.findViewById(R.id.RC21);
        RC22 = (TextView)v.findViewById(R.id.RC22);
        RC23 = (TextView)v.findViewById(R.id.RC23);
        RC24 = (TextView)v.findViewById(R.id.RC24);
        RC25 = (TextView)v.findViewById(R.id.RC25);
        RC26 = (TextView)v.findViewById(R.id.RC26);
        RC27 = (TextView)v.findViewById(R.id.RC27);
        RC28 = (TextView)v.findViewById(R.id.RC28);
        RC29 = (TextView)v.findViewById(R.id.RC29);
        RC30 = (TextView)v.findViewById(R.id.RC30);
        RC31 = (TextView)v.findViewById(R.id.RC31);
        RC32 = (TextView)v.findViewById(R.id.RC32);
        RC33 = (TextView)v.findViewById(R.id.RC33);
        RC34 = (TextView)v.findViewById(R.id.RC34);
        RC35 = (TextView)v.findViewById(R.id.RC35);
        RC37 = (TextView)v.findViewById(R.id.RC37);
        RC38 = (TextView)v.findViewById(R.id.RC38);
        RC39 = (TextView)v.findViewById(R.id.RC39);
        RC40 = (TextView)v.findViewById(R.id.RC40);
        RC41 = (TextView)v.findViewById(R.id.RC41);
        RC42 = (TextView)v.findViewById(R.id.RC42);
        RC43 = (TextView)v.findViewById(R.id.RC43);
        RC44 = (TextView)v.findViewById(R.id.RC44);
        RC45 = (TextView)v.findViewById(R.id.RC45);
        RC46 = (TextView)v.findViewById(R.id.RC46);
        RC47 = (TextView)v.findViewById(R.id.RC47);
        RC48 = (TextView)v.findViewById(R.id.RC48);
        RC49 = (TextView)v.findViewById(R.id.RC49);
        RC50 = (TextView)v.findViewById(R.id.RC50);
        RC51 = (TextView)v.findViewById(R.id.RC51);
        RC52 = (TextView)v.findViewById(R.id.RC52);
        RC53 = (TextView)v.findViewById(R.id.RC53);
        RC54 = (TextView)v.findViewById(R.id.RC54);
        RC55 = (TextView)v.findViewById(R.id.RC55);
        RC56 = (TextView)v.findViewById(R.id.RC56);
        RC57 = (TextView)v.findViewById(R.id.RC57);
        RC58 = (TextView)v.findViewById(R.id.RC58);
        RC59 = (TextView)v.findViewById(R.id.RC59);
        RC60 = (TextView)v.findViewById(R.id.RC60);
        RC61 = (TextView)v.findViewById(R.id.RC61);
        RC63 = (TextView)v.findViewById(R.id.RC63);
        RC64 = (TextView)v.findViewById(R.id.RC64);
        RC65 = (TextView)v.findViewById(R.id.RC65);

        RD15 = (TextView)v.findViewById(R.id.RD15);
        RD16 = (TextView)v.findViewById(R.id.RD16);
        RD17 = (TextView)v.findViewById(R.id.RD17);
        RD18 = (TextView)v.findViewById(R.id.RD18);
        RD19 = (TextView)v.findViewById(R.id.RD19);
        RD21 = (TextView)v.findViewById(R.id.RD21);
        RD22 = (TextView)v.findViewById(R.id.RD22);
        RD23 = (TextView)v.findViewById(R.id.RD23);
        RD24 = (TextView)v.findViewById(R.id.RD24);
        RD25 = (TextView)v.findViewById(R.id.RD25);
        RD26 = (TextView)v.findViewById(R.id.RD26);
        RD27 = (TextView)v.findViewById(R.id.RD27);
        RD28 = (TextView)v.findViewById(R.id.RD28);
        RD29 = (TextView)v.findViewById(R.id.RD29);
        RD30 = (TextView)v.findViewById(R.id.RD30);
        RD31 = (TextView)v.findViewById(R.id.RD31);
        RD32 = (TextView)v.findViewById(R.id.RD32);
        RD33 = (TextView)v.findViewById(R.id.RD33);
        RD34 = (TextView)v.findViewById(R.id.RD34);
        RD35 = (TextView)v.findViewById(R.id.RD35);

        RD37 = (TextView)v.findViewById(R.id.RD37);
        RD38 = (TextView)v.findViewById(R.id.RD38);
        RD39 = (TextView)v.findViewById(R.id.RD39);
        RD40 = (TextView)v.findViewById(R.id.RD40);
        RD41 = (TextView)v.findViewById(R.id.RD41);
        RD42 = (TextView)v.findViewById(R.id.RD42);

        RD43 = (TextView)v.findViewById(R.id.RD43);
        RD44 = (TextView)v.findViewById(R.id.RD44);
        RD45 = (TextView)v.findViewById(R.id.RD45);
        RD46 = (TextView)v.findViewById(R.id.RD46);
        RD47 = (TextView)v.findViewById(R.id.RD47);
        RD48 = (TextView)v.findViewById(R.id.RD48);
        RD49 = (TextView)v.findViewById(R.id.RD49);
        RD50 = (TextView)v.findViewById(R.id.RD50);
        RD51 = (TextView)v.findViewById(R.id.RD51);
        RD52 = (TextView)v.findViewById(R.id.RD52);
        RD53 = (TextView)v.findViewById(R.id.RD53);
        RD54 = (TextView)v.findViewById(R.id.RD54);
        RD55 = (TextView)v.findViewById(R.id.RD55);
        RD56 = (TextView)v.findViewById(R.id.RD56);
        RD57 = (TextView)v.findViewById(R.id.RD57);
        RD58 = (TextView)v.findViewById(R.id.RD58);
        RD59 = (TextView)v.findViewById(R.id.RD59);
        RD60 = (TextView)v.findViewById(R.id.RD60);
        RD61 = (TextView)v.findViewById(R.id.RD61);
        RD63 = (TextView)v.findViewById(R.id.RD63);
        RD64 = (TextView)v.findViewById(R.id.RD64);
        RD65 = (TextView)v.findViewById(R.id.RD65);

        getData();
        return v;
    }

    protected void getData(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.INDEX_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                num1 = Double.valueOf(cursor.getString(1));
                num2 = Double.valueOf(cursor.getString(2));
                num3 = Double.valueOf(cursor.getString(3));
                num4 = Double.valueOf(cursor.getString(4));
                num5 = Double.valueOf(cursor.getString(5));
                num6 = Double.valueOf(cursor.getString(6));
                num7 = Double.valueOf(cursor.getString(7));

            }while(cursor.moveToNext());
        }else{
            ShowDialog(getActivity(),"Not complete data!","You must input performance data.", true);
        }
        cursor.close();
        db.close();

        setData();
    }

    public  void setData(){
        DecimalFormat df = new DecimalFormat("#,###,###.#");
        DecimalFormat df0 = new DecimalFormat("#,###,###");

        double dataB5 = num1;
        double dataB6 = num2;//(float) ((num2/(dataB5/18))*100.0);
        double dataB7 = num3;//(float) (100.0*(num3*12)/dataB5);
        double dataB9 = num5;
        Integer dataB8 = (int) Math.ceil(num4); //(int) Math.ceil(num4*100/(100-dataB9));
        double dataB10 = num6;
        double dataB11 = num7;

        rb7.setText(df.format(dataB5));
        rb8.setText(df.format(dataB6));
        rb9.setText(df.format(dataB7));
        rb10.setText(df.format(dataB8));
        rb11.setText(df.format(dataB9));
        rb12.setText(df.format(dataB10));
        rb13.setText(df.format(dataB11));


        getPopB();


        RC15.setText(hc.df1(pB4));
        RC16.setText(hc.df1(pB5));
        RC17.setText(hc.df1(pB6));
        RC18.setText(hc.df1(pB7));
        RC19.setText(hc.df1(pB8));
        RC20.setText(hc.df1(pB4));

        RD15.setText(hc.df1(pB4*4.285));
        RD16.setText(hc.df1(pB5*4.285));
        RD17.setText(hc.df1(pB6*4.285));
        RD18.setText(hc.df1(pB7*4.285));
        RD19.setText(hc.df1(pB8*4.285));



        Double F4,F5,F6,F7,F8,F9,F10,F11,F12,F13,F14,F15,F16,F17,F18,F19,F20,F21,F22,F23,F24,F25;
        Double G26,G27,G28,G29,G30;

        F4 = pB9;
        F5 = pB10;
        F6 = pB11;
        F7 = pB12;
        F8 = pB13;
        F9 = pB14;
        F10 = pB15;
        F11 = pB16;
        F12 = pB17;
        F13 = pB18;
        F14 = pB19;
        F15 = pB20;
        F16 = pB21;
        F17 = pB22;
        F18 = pB23;
        F19 = pB24;
        F20 = pB25;
        F21 = pB26;
        F22 = pB27;
        F23 = pB5;
        F24 = F23;
        F25 = F23;

        Double sumF6_F22 = (F6+F7+F8+F9+F10+F11+F12+F13+F14+F15+F16+F17+F18+F19+F20+F21+F22);

        getFDSOW();

        C26 =(C4+C5)/2;
        Double sumC6_C22 = (C6+C7+C8+C9+C10+C11+C12+C13+C14+C15+C16+C17+C18+C19+C20+C21+C22);
        Double sumC4_C22 = sumC6_C22+C5+C4;
        C27 = sumC6_C22/17;
        C28 = sumC4_C22/19;
        C29 = (C23+C24+C25)/3;

        D26 = C26*7;
        D27 = C27*7;
        D28 = C28*7;
        D29 = C29*7;

        E26 = C26*30;
        E27 = C27*30;
        E28 = C28*30;
        E29 = C29*30;

        G26 = (F4+F5)*C26;
        G27 = sumF6_F22*C27;
        G28 = G26+G27;
        G29 = (F23+F24+F25)*C29;
        G30 = (G28+G29);

        H26 = (F4+F5)*D26;
        H27 = sumF6_F22*D27;
        H28 = H26+H27;
        H29 = (F23+F24+F25)*D29;
        H30 = H28+H29;

        I26 =(F4+F5)*E26;
        I27 = sumF6_F22*E27;
        I28 = I26+I27;
        I29 = (F23+F24+F25)*E29;
        I30 = I28+I29;

        rb21.setText(hc.df1((G30/1000)));
        RC21.setText(hc.df1((H30/1000)));
        RD21.setText(hc.df1((I30/1000)));

        rb22.setText(hc.df1((G28/1000)));
        RC22.setText(hc.df1((H28/1000)));
        RD22.setText(hc.df1((I28/1000)));

        rb23.setText(hc.df1(C28));
        RC23.setText(hc.df1(D28));
        RD23.setText(hc.df1(E28));

        rb24.setText(hc.df1((G26/1000)));
        RC24.setText(hc.df1((H26/1000)));
        RD24.setText(hc.df1((I26/1000)));

        rb25.setText(hc.df1(C26));
        RC25.setText(hc.df1(D26));
        RD25.setText(hc.df1(E26));

        rb26.setText(hc.df1((G27/1000)));
        RC26.setText(hc.df1((H27/1000)));
        RD26.setText(hc.df1((I27/1000)));

        rb27.setText(hc.df1(C27));
        RC27.setText(hc.df1(D27));
        RD27.setText(hc.df1(E27));

        rb28.setText(hc.df1((G29/1000)));
        RC28.setText(hc.df1((H29/1000)));
        RD28.setText(hc.df1((I29/1000)));

        rb29.setText(hc.df1(C29));
        RC29.setText(hc.df1(D29));
        RD29.setText(hc.df1(E29));


        //getTotalDrugCost
        totalDrugCost();
        Double TotalCost = 0.0, TotalCostMonth = 0.0, TotalCostSow = 0.0 ,TotalCostWeek = 0.0;
        for (int i=1; i<=DrugIdList.size();i++) {
            final int position = i-1;
            SowDrugCostPerSowFragment  PerSow = new SowDrugCostPerSowFragment();
            ArrayList<String> drugList = new ArrayList<String>();
            drugList.clear();
            drugList = PerSow.getDrug(Long.valueOf(DrugIdList.get(position)), this.db);

            Double costSow = (hc.string2double9df(TotalSow.get(position))*hc.string2double(drugList.get(1)));//total*price
            TotalCostSow = TotalCostSow + costSow;

            Double cost = (hc.string2double9df(Total.get(position))*hc.string2double(drugList.get(1)));//total*price
            TotalCost = TotalCost+cost;

            Double costMonth = (hc.string2double9df(TotalMonth.get(position))*hc.string2double(drugList.get(1)));//total*price
            TotalCostMonth = TotalCostMonth+costMonth;
        }
        RC30.setText(hc.formatPrice((TotalCost)));

        RD30.setText(hc.formatPrice((TotalCostMonth)));

        rb31.setText(hc.formatPrice(TotalCostSow));




        //Injection
        totalInjectionCost();
        Double TotalInjectionCost = 0.00, TotalInjectionPigletCost = 0.00;
        for (int i=1; i<=InjectionIdList.size();i++) {
            final int position = i-1;
            InjectionCostPerWeekFragment  PerWeek = new InjectionCostPerWeekFragment();
            ArrayList<String> drugList = new ArrayList<String>();
            drugList.clear();
            drugList = PerWeek.getDrug(Long.valueOf(InjectionIdList.get(position)), this.db);

            Double cost = (hc.string2double3df(InjectionTotal.get(position))*hc.string2double1df(drugList.get(1)));//total*price
            TotalInjectionCost = TotalInjectionCost+cost;

            Double costpiglet = (hc.string2double3df(InjectionPigletTotal.get(position))*hc.string2double1df(drugList.get(1)));//total*price
            TotalInjectionPigletCost = TotalInjectionPigletCost+costpiglet;

        }

        Double valrc64 = (TotalInjectionCost) + (TotalInjectionPigletCost);
        RC64.setText(hc.formatPrice((valrc64)));
        Double rd64 = (valrc64)*4.285;
        RD64.setText(hc.formatPrice(rd64));

        RC32.setText(hc.formatPrice((TotalInjectionCost)));
        RD32.setText(hc.formatPrice((TotalInjectionCost)*4.285));
        rb33.setText(hc.formatPrice((TotalInjectionCost/1000)*22*1000/pB3));

        Double valrc58 = TotalInjectionPigletCost;
        RC58.setText(hc.formatPrice(valrc58));
        RD58.setText(hc.formatPrice(valrc58*4.285));
        rb59.setText(hc.formatPrice(valrc58*25/(pB30+pB36+pB44)));

        //Vaccine
        //Injection
        totalVaccineCost();
        Double TotalVaccineCost = 0.0, TotalVaccienPiglet = 0.0, TotalVaccineCostMonth;
        for (int i=1; i<=VaccineIdList.size();i++) {
            final int position = i-1;
           VaccineCostPerWeekFragment PerWeek = new VaccineCostPerWeekFragment();
            ArrayList<String> drugList = new ArrayList<String>();
            drugList.clear();
            drugList = PerWeek.getDrug(Long.valueOf(VaccineIdList.get(position)), this.db);
            Double cost = (hc.string2double3df(VaccineTotal.get(position))*hc.string2double1df(drugList.get(1)));//total*price
            TotalVaccineCost = TotalVaccineCost+cost;

            Double costPiglet = (hc.string2double3df(VaccinePiglietTotal.get(position))*hc.string2double1df(drugList.get(1)));//total*price
            TotalVaccienPiglet = TotalVaccienPiglet+costPiglet;
        }

        Double valrc65 = (TotalVaccineCost) + (TotalVaccienPiglet);
        RC65.setText(hc.formatPrice(valrc65));
        Double rd65 = valrc65*4.285;
        RD65.setText(hc.formatPrice(rd65));

        RC34.setText(hc.formatPrice((TotalVaccineCost)));
        Double valrd34 = (TotalVaccineCost)*4.285;
        RD34.setText(hc.formatPrice(valrd34));
        rb35.setText(hc.formatPrice((TotalVaccineCost/1000)*22*1000/pB3));

        Double valrc60 = TotalVaccienPiglet;
        RC60.setText(hc.formatPrice(valrc60));
        RD60.setText(hc.formatPrice(valrc60*4.285));
        rb61.setText(hc.formatPrice(valrc60*25/(pB30+pB36+pB44)));


        RC37.setText(hc.df1(pB28));
        RC38.setText(hc.df1(pB29));
        RC39.setText(hc.df1(pB30));
        RC40.setText(hc.df1(pB34));
        RC41.setText(hc.df1(pB36));
        RC42.setText(hc.df1(pB44));

        RD37.setText(hc.df1(pB28*4.285));
        RD38.setText(hc.df1(pB29*4.285));
        RD39.setText(hc.df1(pB30*4.285));
        RD40.setText(hc.df1(pB34*4.285));
        RD41.setText(hc.df1(pB36*4.285));
        RD42.setText(hc.df1(pB44*4.285));




        getFeedPig();



        //pig drug cost
        getPigDrugCost();
        Double TotalPigDrugCost = 0.0, TotalPigDrugCostWeek = 0.0, TotalPigDrugHead = 0.0;
        for (int i=1; i<=pigDrugIdList.size();i++){
            final int position = i-1;


            PigDrugCostPerHeadFragment  PerPig = new PigDrugCostPerHeadFragment();
            ArrayList<String> drugList = new ArrayList<String>();
            drugList.clear();
            drugList = PerPig.getDrug(Long.valueOf(pigDrugIdList.get(position)), this.db);

            Double cost = (hc.string2double9df(pigDrugTotal.get(position))*hc.string2double(drugList.get(1)));//total*price
            TotalPigDrugCost = TotalPigDrugCost+cost;

            Double costweek = (hc.string2double9df(pigDrugWeekTotal.get(position))*hc.string2double(drugList.get(1)));//total*price
            TotalPigDrugCostWeek = TotalPigDrugCostWeek+costweek;

            Double costhead = (hc.string2double9df(pigDrugHeadTotal.get(position))*hc.string2double(drugList.get(1)));//total*price
            TotalPigDrugHead = TotalPigDrugHead+costhead;
        }
        RC56.setText(hc.formatPrice(TotalPigDrugCostWeek));
        RD56.setText(hc.formatPrice(TotalPigDrugCost));
        rb57.setText(hc.formatPrice(TotalPigDrugHead));

        RC63.setText(hc.formatPrice((TotalCost)+(TotalPigDrugCostWeek)));
        RD63.setText(hc.formatPrice((TotalCostMonth)+(TotalPigDrugCost)));
    }
    public void getPopB(){
        ArrayList ar = pop.getB(this.db);
        pB3 = Double.valueOf(ar.get(2).toString());
        pB4 = Double.valueOf(ar.get(3).toString());
        pB5 = Double.valueOf(ar.get(4).toString());
        pB6 = Double.valueOf(ar.get(5).toString());
        pB7 = Double.valueOf(ar.get(6).toString());
        pB8 = Double.valueOf(ar.get(7).toString());
        pB9 = Double.valueOf(ar.get(8).toString());
        pB10 = Double.valueOf(ar.get(9).toString());
        pB11 = Double.valueOf(ar.get(10).toString());
        pB12 = Double.valueOf(ar.get(11).toString());
        pB13 = Double.valueOf(ar.get(12).toString());
        pB14 = Double.valueOf(ar.get(13).toString());
        pB15 = Double.valueOf(ar.get(14).toString());
        pB16 = Double.valueOf(ar.get(15).toString());
        pB17 = Double.valueOf(ar.get(16).toString());
        pB18 = Double.valueOf(ar.get(17).toString());
        pB19 = Double.valueOf(ar.get(18).toString());
        pB20 = Double.valueOf(ar.get(19).toString());
        pB21 = Double.valueOf(ar.get(20).toString());
        pB22 = Double.valueOf(ar.get(21).toString());
        pB23 = Double.valueOf(ar.get(22).toString());
        pB24 = Double.valueOf(ar.get(23).toString());
        pB25 = Double.valueOf(ar.get(24).toString());
        pB26 = Double.valueOf(ar.get(25).toString());
        pB27 = Double.valueOf(ar.get(26).toString());
        pB28 = Double.valueOf(ar.get(27).toString());
        pB29 = Double.valueOf(ar.get(28).toString());
        pB30 = Double.valueOf(ar.get(29).toString());
        pB31 = Double.valueOf(ar.get(30).toString());
        pB32 = Double.valueOf(ar.get(31).toString());
        pB33 = Double.valueOf(ar.get(32).toString());
        pB34 = Double.valueOf(ar.get(33).toString());
        pB35 = Double.valueOf(ar.get(34).toString());
        pB36 = Double.valueOf(ar.get(35).toString());
        pB37 = Double.valueOf(ar.get(36).toString());
        pB38 = Double.valueOf(ar.get(37).toString());
        pB39 = Double.valueOf(ar.get(38).toString());
        pB40 = Double.valueOf(ar.get(39).toString());
        pB41 = Double.valueOf(ar.get(40).toString());
        pB42 = Double.valueOf(ar.get(41).toString());
        pB43 = Double.valueOf(ar.get(42).toString());
        pB44 = Double.valueOf(ar.get(43).toString());
        pB45 = Double.valueOf(ar.get(44).toString());
        pB46 = Double.valueOf(ar.get(45).toString());
        pB47 = Double.valueOf(ar.get(46).toString());
        pB48 = Double.valueOf(ar.get(47).toString());
        pB49 = Double.valueOf(ar.get(48).toString());
        pB50 = Double.valueOf(ar.get(49).toString());
        pB51 = Double.valueOf(ar.get(50).toString());
        pB52 = Double.valueOf(ar.get(51).toString());
        pB53 = Double.valueOf(ar.get(52).toString());
        pB54 = Double.valueOf(ar.get(53).toString());
        pB55 = Double.valueOf(ar.get(54).toString());
        pB56 = Double.valueOf(ar.get(55).toString());
        pB57 = Double.valueOf(ar.get(56).toString());
        pB58 = Double.valueOf(ar.get(57).toString());
        pB59 = Double.valueOf(ar.get(58).toString());
        pB60 = Double.valueOf(ar.get(59).toString());
    }


    public void getFDSOW(){
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
        }else{
            ShowDialog(getActivity(),"Not complete data!","You must input performance data.", true);
        }
        cursor.close();
        db.close();
    }

    public  void totalDrugCost() {

        db.open();
        Cursor cursor;
        cursor = db.getAll(db.DRUG_SOW_PERSOW_TABLE, "asc");
        cursor.requery();
        DrugIdList.clear();
        Total.clear();
        TotalMonth.clear();
        TotalSow.clear();
        if(cursor.moveToFirst()){
            do{
                DrugIdList.add(String.valueOf(cursor.getString(1)));
                TotalSow.add(String.valueOf(cursor.getString(5)));
                Total.add(getTotal(cursor.getString(3), Double.valueOf(cursor.getString(2))).toString());
                TotalMonth.add(getTotalMonth(cursor.getString(3), Double.valueOf(cursor.getString(2))).toString());
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    public void getFCH(Double usage){

        sumVal.set(0,usage*((C4*7)*pB9)/1000);
        sumVal.set(1,usage*((C5*7)*pB10)/1000);
        sumVal.set(2,usage*((C6*7)*pB11)/1000);
        sumVal.set(3,usage*((C7*7)*pB12)/1000);
        sumVal.set(4,usage*((C8*7)*pB13)/1000);
        sumVal.set(5,usage*((C9*7)*pB14)/1000);
        sumVal.set(6,usage*((C10*7)*pB15)/1000);
        sumVal.set(7,usage*((C11*7)*pB16)/1000);
        sumVal.set(8,usage*((C12*7)*pB17)/1000);
        sumVal.set(9,usage*((C13*7)*pB18)/1000);
        sumVal.set(10,usage*((C14*7)*pB19)/1000);
        sumVal.set(11,usage*((C15*7)*pB20)/1000);
        sumVal.set(12,usage*((C16*7)*pB21)/1000);
        sumVal.set(13,usage*((C17*7)*pB22)/1000);
        sumVal.set(14,usage*((C18*7)*pB23)/1000);
        sumVal.set(15,usage*((C19*7)*pB24)/1000);
        sumVal.set(16,usage*((C20*7)*pB25)/1000);
        sumVal.set(17,usage*((C21*7)*pB26)/1000);
        sumVal.set(18,usage*((C22*7)*pB26)/1000);
        sumVal.set(19,usage*((C23*7)*pB5)/1000);
        sumVal.set(20,usage*((C24*7)*pB5)/1000);
        sumVal.set(21,usage*((C25*7)*pB5)/1000);
    }
    public void getFCHMONTH(Double usage){

        sumValMonth.set(0,usage*((C4*30)*pB9)/1000);
        sumValMonth.set(1,usage*((C5*30)*pB10)/1000);
        sumValMonth.set(2,usage*((C6*30)*pB11)/1000);
        sumValMonth.set(3,usage*((C7*30)*pB12)/1000);
        sumValMonth.set(4,usage*((C8*30)*pB13)/1000);
        sumValMonth.set(5,usage*((C9*30)*pB14)/1000);
        sumValMonth.set(6,usage*((C10*30)*pB15)/1000);
        sumValMonth.set(7,usage*((C11*30)*pB16)/1000);
        sumValMonth.set(8,usage*((C12*30)*pB17)/1000);
        sumValMonth.set(9,usage*((C13*30)*pB18)/1000);
        sumValMonth.set(10,usage*((C14*30)*pB19)/1000);
        sumValMonth.set(11,usage*((C15*30)*pB20)/1000);
        sumValMonth.set(12,usage*((C16*30)*pB21)/1000);
        sumValMonth.set(13,usage*((C17*30)*pB22)/1000);
        sumValMonth.set(14,usage*((C18*30)*pB23)/1000);
        sumValMonth.set(15,usage*((C19*30)*pB24)/1000);
        sumValMonth.set(16,usage*((C20*30)*pB25)/1000);
        sumValMonth.set(17,usage*((C21*30)*pB26)/1000);
        sumValMonth.set(18,usage*((C22*30)*pB26)/1000);
        sumValMonth.set(19,usage*((C23*30)*pB5)/1000);
        sumValMonth.set(20,usage*((C24*30)*pB5)/1000);
        sumValMonth.set(21,usage*((C25*30)*pB5)/1000);
    }
    public void getFCHPIGDRUGweek(Double usage){

        sumValPigDrug.set(0,usage*((M4*7)*pB37)/1000);
        sumValPigDrug.set(1,usage*((M5*7)*pB38)/1000);
        sumValPigDrug.set(2,usage*((M6*7)*pB39)/1000);
        sumValPigDrug.set(3,usage*((M7*7)*pB40)/1000);
        sumValPigDrug.set(4,usage*((M8*7)*pB41)/1000);
        sumValPigDrug.set(5,usage*((M9*7)*pB42)/1000);
        sumValPigDrug.set(6,usage*((M10*7)*pB43)/1000);
        sumValPigDrug.set(7,usage*((M11*7)*pB44)/1000);
        sumValPigDrug.set(8,usage*((M12*7)*pB45)/1000);
        sumValPigDrug.set(9,usage*((M13*7)*pB46)/1000);
        sumValPigDrug.set(10,usage*((M14*7)*pB47)/1000);
        sumValPigDrug.set(11,usage*((M15*7)*pB48)/1000);
        sumValPigDrug.set(12,usage*((M16*7)*pB49)/1000);
        sumValPigDrug.set(13,usage*((M17*7)*pB50)/1000);
        sumValPigDrug.set(14,usage*((M18*7)*pB51)/1000);
        sumValPigDrug.set(15,usage*((M19*7)*pB52)/1000);
        sumValPigDrug.set(16,usage*((M20*7)*pB53)/1000);
        sumValPigDrug.set(17,usage*((M21*7)*pB54)/1000);
        sumValPigDrug.set(18,usage*((M22*7)*pB55)/1000);
        sumValPigDrug.set(19,usage*((M23*7)*pB56)/1000);
        sumValPigDrug.set(20,usage*((M24*7)*pB57)/1000);
        sumValPigDrug.set(21,usage*((M25*7)*pB58)/1000);
    }

    public void getFCHPIGDRUG(Double usage){

        sumValPigDrug.set(0,usage*((M4*30)*pB37)/1000);
        sumValPigDrug.set(1,usage*((M5*30)*pB38)/1000);
        sumValPigDrug.set(2,usage*((M6*30)*pB39)/1000);
        sumValPigDrug.set(3,usage*((M7*30)*pB40)/1000);
        sumValPigDrug.set(4,usage*((M8*30)*pB41)/1000);
        sumValPigDrug.set(5,usage*((M9*30)*pB42)/1000);
        sumValPigDrug.set(6,usage*((M10*30)*pB43)/1000);
        sumValPigDrug.set(7,usage*((M11*30)*pB44)/1000);
        sumValPigDrug.set(8,usage*((M12*30)*pB45)/1000);
        sumValPigDrug.set(9,usage*((M13*30)*pB46)/1000);
        sumValPigDrug.set(10,usage*((M14*30)*pB47)/1000);
        sumValPigDrug.set(11,usage*((M15*30)*pB48)/1000);
        sumValPigDrug.set(12,usage*((M16*30)*pB49)/1000);
        sumValPigDrug.set(13,usage*((M17*30)*pB50)/1000);
        sumValPigDrug.set(14,usage*((M18*30)*pB51)/1000);
        sumValPigDrug.set(15,usage*((M19*30)*pB52)/1000);
        sumValPigDrug.set(16,usage*((M20*30)*pB53)/1000);
        sumValPigDrug.set(17,usage*((M21*30)*pB54)/1000);
        sumValPigDrug.set(18,usage*((M22*30)*pB55)/1000);
        sumValPigDrug.set(19,usage*((M23*30)*pB56)/1000);
        sumValPigDrug.set(20,usage*((M24*30)*pB57)/1000);
        sumValPigDrug.set(21,usage*((M25*30)*pB58)/1000);
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
                //Log.v("TAG", sum+"");
            }else{
                sum = sum+0;
            }
        }
        //Toast.makeText(getActivity(), P4.toString(), Toast.LENGTH_LONG).show();
        String total = hc.df9(sum);
        sum = hc.string2double9df(total);
        //Log.v("TAG", sum + "");
        sumVal.clear();
        return sum;

    }

    public Double getTotalMonth(String string, Double usage) {
        Double sum = 0.000000000;
        sumValMonth.clear();

        for (int i=1; i<=string.length(); i++){
            sumValMonth.add(0.0);
        }

        getFCHMONTH(usage);

        //StringBuilder opt = new StringBuilder();
        for (int i=1; i<=string.length(); i++){
            String data = String.valueOf(string.charAt(i-1));
            if(data.equals("1")){
                sum = sum+hc.string2double9df(hc.df9(sumValMonth.get(i-1)));
                //opt.append(sumVal.get(i-1).toString()+"|");
                //Log.v("TAG", sum+"");
            }else{
                sum = sum+0;
            }
        }
        //Toast.makeText(getActivity(), P4.toString(), Toast.LENGTH_LONG).show();
        String total = hc.df9(sum);
        sum = hc.string2double9df(total);
        //Log.v("TAG", sum + "");
        sumValMonth.clear();
        return sum;

    }


    public  void totalInjectionCost() {

        db.open();
        Cursor cursor;
        cursor = db.getAll(db.INJECTION_COST_TABLE, "asc");
        cursor.requery();
        InjectionIdList.clear();
        InjectionTotal.clear();
        InjectionPigletTotal.clear();
        InjectionTotalMonth.clear();
        if(cursor.moveToFirst()){
            do{
                InjectionIdList.add(String.valueOf(cursor.getString(1)));
                InjectionTotal.add(String.valueOf(cursor.getString(5)));
                InjectionPigletTotal.add(String.valueOf(cursor.getString(6)));
                InjectionTotalMonth.add(String.valueOf(cursor.getString(5)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

    }

    public  void totalVaccineCost() {

        db.open();
        Cursor cursor;
        cursor = db.getAll(db.VACCINE_COST_TABLE, "asc");
        cursor.requery();
        VaccineIdList.clear();
        VaccineTotal.clear();
        VaccinePiglietTotal.clear();
        VaccineTotalMonth.clear();
        if(cursor.moveToFirst()){
            do{
                VaccineIdList.add(String.valueOf(cursor.getString(1)));
                VaccineTotal.add(String.valueOf(cursor.getString(5)));
                VaccinePiglietTotal.add(String.valueOf(cursor.getString(6)));
                VaccineTotalMonth.add(String.valueOf(cursor.getString(5)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    public  void getPigDrugCost() {


        db.open();
        Cursor cursor;
        cursor = db.getAll(db.DRUG_PIG_TABLE, "asc");
        cursor.requery();
        pigDrugIdList.clear();
        pigDrugTotal.clear();
        pigDrugWeekTotal.clear();
        pigDrugHeadTotal.clear();
        if(cursor.moveToFirst()){
            do{
                pigDrugIdList.add(String.valueOf(cursor.getString(1)));
                pigDrugTotal.add(getTotalPigDrugCost(cursor.getString(3), Double.valueOf(cursor.getString(2))).toString());
                pigDrugWeekTotal.add(getTotalPigDrugCostWeek(cursor.getString(3), Double.valueOf(cursor.getString(2))).toString());
                pigDrugHeadTotal.add(String.valueOf(cursor.getString(5)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

    }
    private Double getTotalPigDrugCostWeek(String string, Double usage) {
        Double sum = 0.000000000;
        sumValPigDrug.clear();

        for (int i=1; i<=string.length(); i++){
            sumValPigDrug.add(0.0);
        }
        getFCHPIGDRUGweek(usage);
        //StringBuilder opt = new StringBuilder();
        for (int i=1; i<=string.length(); i++){
            String data = String.valueOf(string.charAt(i-1));
            if(data.equals("1")){
                sum = sum+hc.string2double9df(hc.df9(sumValPigDrug.get(i-1)));
                //opt.append(sumVal.get(i-1).toString()+"|");
            }else{
                sum = sum+0;
            }
        }
        //Toast.makeText(getActivity(), P4.toString(), Toast.LENGTH_LONG).show();
        String total = hc.df9(sum);
        sum = hc.string2double9df(total);
        sumValPigDrug.clear();
        return sum;

    }
    private Double getTotalPigDrugCost(String string, Double usage) {
        Double sum = 0.000000000;
        sumValPigDrug.clear();

        for (int i=1; i<=string.length(); i++){
            sumValPigDrug.add(0.0);
        }
        getFCHPIGDRUG(usage);
        //StringBuilder opt = new StringBuilder();
        for (int i=1; i<=string.length(); i++){
            String data = String.valueOf(string.charAt(i-1));
            if(data.equals("1")){
                sum = sum+hc.string2double9df(hc.df9(sumValPigDrug.get(i-1)));
                //opt.append(sumVal.get(i-1).toString()+"|");
            }else{
                sum = sum+0;
            }
        }
        //Toast.makeText(getActivity(), P4.toString(), Toast.LENGTH_LONG).show();
        String total = hc.df9(sum);
        sum = hc.string2double9df(total);
        sumValPigDrug.clear();
        return sum;

    }
    public void getFeedPig(){
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
        }else{
            ShowDialog(getActivity(),"Not complete data!","You must input performance data.", true);
        }
        cursor.close();
        db.close();


        M26 =  (M4+M5+M6)/3;
        double sumM6_M22 = (M6+M7+M8+M9+M10+M11+M12+M13+M14+M15+M16+M17+M18+M19+M20+M21+M22);
        double sumM4_M25 = sumM6_M22+M5+M4+M23+M24+M25;
        M27 = (M7+M8+M9)/3;
        M28 = (M4+M5+M6+M7+M8+M9)/6;
        M29 = (M10+M11+M12+M13+M14+M15)/6;
        M30 = (M16+M17+M18+M19+M20)/5;
        M31 = (M21+M22+M23+M24+M25)/5;
        M32 = sumM4_M25/22;

        N4 = M4*7;
        N5 = M5*7;
        N6 = M6*7;
        N7 = M7*7;
        N8 = M8*7;
        N9 = M9*7;
        N10 = M10*7;
        N11 = M11*7;
        N12 = M12*7;
        N13 = M13*7;
        N14 = M14*7;
        N15 = M15*7;
        N16 = M16*7;
        N17 = M17*7;
        N18 = M18*7;
        N19 = M19*7;
        N20 = M20*7;
        N21 = M21*7;
        N22 = M22*7;
        N23 = M23*7;
        N24 = M24*7;
        N25 = M25*7;

        N26 = (N4+N5+N6)/3;
        N27 = (N7+N8+N9)/3;
        N28 = (N4+N5+N6+N7+N8+N9)/6;
        N29 = (N10+N11+N12+N13+N14+N15)/6;
        N30 = (N16+N17+N18+N19+N20)/5;
        N31 = (N21+N22+N23+N24+N25)/5;
        N32 = M32*7;

        O4 = M4*30;
        O5 = M5*30;
        O6 = M6*30;
        O7 = M7*30;
        O8 = M8*30;
        O9 = M9*30;
        O10 = M10*30;
        O11 = M11*30;
        O12 = M12*30;
        O13 = M13*30;
        O14 = M14*30;
        O15 = M15*30;
        O16 = M16*30;
        O17 = M17*30;
        O18 = M18*30;
        O19 = M19*30;
        O20 = M20*30;
        O21 = M21*30;
        O22 = M22*30;
        O23 = M23*30;
        O24 = M24*30;
        O25 = M25*30;

        O26  = (O4+O5+O6)/3;
        O27  = (O7+O8+O9)/3;
        O28  = ((O26+O27)*3)/6;
        O29  = (O10+O11+O12+O13+O14+O15)/6;
        O30  = (O16+O17+O18+O19+O20)/5;
        O31  = (O21+O22+O23+O24+O25)/5;
        O32  = ((O28*6)+(O29*6)+(O30*5)+(O31*5))/22;

        Q4 = pB37*M4;
        Q5 = pB38*M5;
        Q6 = pB39*M6;
        Q7 = pB40*M7;
        Q8 = pB41*M8;
        Q9 = pB42*M9;
        Q10 = pB45*M10;
        Q11 = pB46*M11;
        Q12 = pB47*M12;
        Q13 = pB48*M13;
        Q14 = pB49*M14;
        Q15 = pB50*M15;
        Q16 = pB51*M16;
        Q17 = pB52*M17;
        Q18 = pB53*M18;
        Q19 = pB54*M19;
        Q20 = pB55*M20;
        Q21 = pB56*M21;
        Q22 = pB57*M22;
        Q23 = pB58*M23;
        Q24 = pB59*M24;
        Q25 = pB60*M25;

        Q26 = Q4+Q5+Q6;
        Q27 = Q7+Q8+Q9;
        Q28 = Q26+Q27;
        Q29 = Q10+Q11+Q12+Q13+Q14+Q15;
        Q30 = Q16+Q17+Q18+Q19+Q20;
        Q31 = Q21+Q22+Q23+Q24+Q25;
        Q32 = Q28+Q29+Q30+Q31;

        R4 = pB37*(7*M4);
        R5 = pB38*(7*M5);
        R6 = pB39*(7*M6);
        R7 = pB40*(7*M7);
        R8 = pB41*(7*M8);
        R9 = pB42*(7*M9);
        R10 = pB45*(7*M10);
        R11 = pB46*(7*M11);
        R12 = pB47*(7*M12);
        R13 = pB48*(7*M13);
        R14 = pB49*(7*M14);
        R15 = pB50*(7*M15);
        R16 = pB51*(7*M16);
        R17 = pB52*(7*M17);
        R18 = pB53*(7*M18);
        R19 = pB54*(7*M19);
        R20 = pB55*(7*M20);
        R21 = pB56*(7*M21);
        R22 = pB57*(7*M22);
        R23 = pB58*(7*M23);
        R24 = pB59*(7*M24);
        R25 = pB60*(7*M25);

        R26 = R4+R5+R6;
        R27 = R7+R8+R9;
        R28 = R26+R27;
        R29 = R10+R11+R12+R13+R14+R15;
        R30 = R16+R17+R18+R19+R20;
        R31 = R21+R22+R23+R24+R25;
        R32 = R28+R29+R30+R31;

        S4 = pB37*(30*M4);
        S5 = pB38*(30*M5);
        S6 = pB39*(30*M6);
        S7 = pB40*(30*M7);
        S8 = pB41*(30*M8);
        S9 = pB42*(30*M9);
        S10 = pB45*(30*M10);
        S11 = pB46*(30*M11);
        S12 = pB47*(30*M12);
        S13 = pB48*(30*M13);
        S14 = pB49*(30*M14);
        S15 = pB50*(30*M15);
        S16 = pB51*(30*M16);
        S17 = pB52*(30*M17);
        S18 = pB53*(30*M18);
        S19 = pB54*(30*M19);
        S20 = pB55*(30*M20);
        S21 = pB56*(30*M21);
        S22 = pB57*(30*M22);
        S23 = pB58*(30*M23);
        S24 = pB59*(30*M24);
        S25 = pB60*(30*M25);

        S26 = S4+S5+S6;
        S27 = S7+S8+S9;
        S28 = S26+S27;
        S29 = S10+S11+S12+S13+S14+S15;
        S30 = S16+S17+S18+S19+S20;
        S31 = S21+S22+S23+S24+S25;
        S32 = S28+S29+S30+S31;

        rb43.setText(hc.df1((Q32/1000)));
        RC43.setText(hc.df1((R32/1000)));
        RD43.setText(hc.df1((S32/1000)));

        rb44.setText(hc.df1((Q28/1000)));
        RC44.setText(hc.df1((R28/1000)));
        RD44.setText(hc.df1((S28/1000)));

        rb45.setText(hc.df1(M28));
        RC45.setText(hc.df1(N28));
        RD45.setText(hc.df1(O28));

        rb46.setText(hc.df1((Q26/1000)));
        RC46.setText(hc.df1((R26/1000)));
        RD46.setText(hc.df1((S26/1000)));

        rb47.setText(hc.df1(M26));
        RC47.setText(hc.df1(N26));
        RD47.setText(hc.df1(O26));

        rb48.setText(hc.df1((Q27/1000)));
        RC48.setText(hc.df1((R27/1000)));
        RD48.setText(hc.df1((S27/1000)));

        rb49.setText(hc.df1(M27));
        RC49.setText(hc.df1(N27));
        RD49.setText(hc.df1(O27));

        rb50.setText(hc.df1((Q29/1000)));
        RC50.setText(hc.df1((R29/1000)));
        RD50.setText(hc.df1((S29/1000)));

        rb51.setText(hc.df1(M29));
        RC51.setText(hc.df1(N29));
        RD51.setText(hc.df1(O29));

        rb52.setText(hc.df1((Q30/1000)));
        RC52.setText(hc.df1((R30/1000)));
        RD52.setText(hc.df1((S30/1000)));

        rb53.setText(hc.df1(M30));
        RC53.setText(hc.df1(N30));
        RD53.setText(hc.df1(O30));

        rb54.setText(hc.df1((Q31/1000)));
        RC54.setText(hc.df1((R31/1000)));
        RD54.setText(hc.df1((S31/1000)));

        rb55.setText(hc.df1(M31));
        RC55.setText(hc.df1(N31));
        RD55.setText(hc.df1(O31));
    }

    public void ShowDialog(final Context _context, String title, String message, final Boolean status){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(_context).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        //alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                ((MainActivity) getActivity()).displayView(0);
            }
        });
        alertDialog.show();
    }

}
