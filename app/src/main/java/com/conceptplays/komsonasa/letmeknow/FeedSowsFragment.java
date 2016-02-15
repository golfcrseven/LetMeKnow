package com.conceptplays.komsonasa.letmeknow;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.conceptplays.komsonasa.letmeknow.Class.HelperClass;
import com.conceptplays.komsonasa.letmeknow.DB.DataBaseAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedSowsFragment extends  android.support.v4.app.Fragment {

    DataBaseAdapter db;
    HelperClass hp;

    public  TextView c26,c27,c28,c29,d26,d27,d28,d29,e26,e27,e28,e29;
    public  TextView g26,g27,g28,g29,g30,h26,h27,h28,h29,h30,i26,i27,i28,i29,i30;

    public Float C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22,C23,C24,C25,C26,C27,C28,C29;
    public Float D4,D5,D6,D7,D8,D9,D10,D11,D12,D13,D14,D15,D16,D17,D18,D19,D20,D21,D22,D23,D24,D25,D26,D27,D28,D29;
    public Float E4,E5,E6,E7,E8,E9,E10,E11,E12,E13,E14,E15,E16,E17,E18,E19,E20,E21,E22,E23,E24,E25,E26,E27,E28,E29;
    public Float F4,F5,F6,F7,F8,F9,F10,F11,F12,F13,F14,F15,F16,F17,F18,F19,F20,F21,F22,F23,F24,F25;
    public Float G4,G5,G6,G7,G8,G9,G10,G11,G12,G13,G14,G15,G16,G17,G18,G19,G20,G21,G22,G23,G24,G25,G26,G27,G28,G29,G30;
    public Float H4,H5,H6,H7,H8,H9,H10,H11,H12,H13,H14,H15,H16,H17,H18,H19,H20,H21,H22,H23,H24,H25,H26,H27,H28,H29,H30;
    public Float I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22,I23,I24,I25,I26,I27,I28,I29,I30;

    private Float num1, num2, num3,num4, num5,num6, num7;
    private Float B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22,B23,B24,B25,B26,B27,SUMB10_B27;
    private  Float B28,B29,B30,B31,B32,B33,B34,B35,SUM_B11_B27,B36,B37,B38,B39,B40,B41,B42,B43;
    private  Float B44,B45, B46,B47,B48,B49,B50,B51,B52,B53,B54,B55,B56,B57,B58,B59,B60,B61;


    public FeedSowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        db = new DataBaseAdapter(getActivity());
        hp = new HelperClass();

        // Inflate the layout for this fragment
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_AppCompat_Light);
        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);

        View v =  inflater.inflate(R.layout.fragment_feed_sows, container, false);



        //Hide Scrollview Bar
        final ScrollView sView = (ScrollView) v.findViewById(R.id.scrollViewID);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);


        c26 = (TextView) v.findViewById(R.id.m26);
        c27 = (TextView) v.findViewById(R.id.c27);
        c28 = (TextView) v.findViewById(R.id.c28);
        c29 = (TextView) v.findViewById(R.id.c29);

        d26 = (TextView) v.findViewById(R.id.d26);
        d27 = (TextView) v.findViewById(R.id.d27);
        d28 = (TextView) v.findViewById(R.id.d28);
        d29 = (TextView) v.findViewById(R.id.d29);

        e26 = (TextView) v.findViewById(R.id.e26);
        e27 = (TextView) v.findViewById(R.id.e27);
        e28 = (TextView) v.findViewById(R.id.e28);
        e29 = (TextView) v.findViewById(R.id.e29);

        g26 = (TextView) v.findViewById(R.id.g26);
        g27 = (TextView) v.findViewById(R.id.g27);
        g28 = (TextView) v.findViewById(R.id.g28);
        g29 = (TextView) v.findViewById(R.id.g29);
        g30 = (TextView) v.findViewById(R.id.g30);

        h26 = (TextView) v.findViewById(R.id.h26);
        h27 = (TextView) v.findViewById(R.id.h27);
        h28 = (TextView) v.findViewById(R.id.h28);
        h29 = (TextView) v.findViewById(R.id.h29);
        h30 = (TextView) v.findViewById(R.id.h30);

        i26 = (TextView) v.findViewById(R.id.i26);
        i27 = (TextView) v.findViewById(R.id.i27);
        i28 = (TextView) v.findViewById(R.id.i28);
        i29 = (TextView) v.findViewById(R.id.i29);
        i30 = (TextView) v.findViewById(R.id.i30);


        Button btn = (Button) v.findViewById(R.id.btnChngVal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goto_feed();
            }
        });

        getData();



        return  v;
    }

    private void goto_feed(){
        Intent intent;
        intent = new Intent(getActivity(), FeedSowsPerDayActivity.class);
        startActivity(intent);
    }
    public void getData(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.FDSOW_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                C4 = Float.valueOf(cursor.getString(1));
                C5 = Float.valueOf(cursor.getString(2));
                C6 = Float.valueOf(cursor.getString(3));
                C7 = Float.valueOf(cursor.getString(4));
                C8 = Float.valueOf(cursor.getString(5));
                C9 = Float.valueOf(cursor.getString(6));
                C10 = Float.valueOf(cursor.getString(7));
                C11 = Float.valueOf(cursor.getString(8));
                C12 = Float.valueOf(cursor.getString(9));
                C13 = Float.valueOf(cursor.getString(10));
                C14 = Float.valueOf(cursor.getString(11));
                C15 = Float.valueOf(cursor.getString(12));
                C16 = Float.valueOf(cursor.getString(13));
                C17 = Float.valueOf(cursor.getString(14));
                C18 = Float.valueOf(cursor.getString(15));
                C19 = Float.valueOf(cursor.getString(16));
                C20 = Float.valueOf(cursor.getString(17));
                C21 = Float.valueOf(cursor.getString(18));
                C22 = Float.valueOf(cursor.getString(19));
                C23 = Float.valueOf(cursor.getString(20));
                C24 = Float.valueOf(cursor.getString(21));
                C25 = Float.valueOf(cursor.getString(22));



            }while(cursor.moveToNext());
        }else{
            ShowDialog(getActivity(),"Not complete data!","You must input performance data.", true);
        }
        cursor.close();
        db.close();

        setData();
    }

    public void setData() {
        DecimalFormat df = new DecimalFormat("#,###,###.#");
        DecimalFormat df0 = new DecimalFormat("#,###,###");

        C26 = (Float) ((C4+C5)/2);
        Float sumC6_C22 = (C6+C7+C8+C9+C10+C11+C12+C13+C14+C15+C16+C17+C18+C19+C20+C21+C22);
        Float sumC4_C22 = sumC6_C22+C5+C4;
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

        getDataPopulation();

        F4 = B9;
        F5 = B10;
        F6 = B11;
        F7 = B12;
        F8 = B13;
        F9 = B14;
        F10 = B15;
        F11 = B16;
        F12 = B17;
        F13 = B18;
        F14 = B19;
        F15 = B20;
        F16 = B21;
        F17 = B22;
        F18 = B23;
        F19 = B24;
        F20 = B25;
        F21 = B26;
        F22 = B27;
        F23 = B5;
        F24 = F23;
        F25 = F23;

        Float sumF6_F22 = (F6+F7+F8+F9+F10+F11+F12+F13+F14+F15+F16+F17+F18+F19+F20+F21+F22);

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

        c26.setText(df.format(C26)+"");
        c27.setText(df.format(C27)+"");
        c28.setText(df.format(C28)+"");
        c29.setText(df.format(C29)+"");

        d26.setText(df.format(D26)+"");
        d27.setText(df.format(D27)+"");
        d28.setText(df.format(D28)+"");
        d29.setText(df.format(D29)+"");

        e26.setText(df.format(E26)+"");
        e27.setText(df.format(E27)+"");
        e28.setText(df.format(E28)+"");
        e29.setText(df.format(E29)+"");

        g26.setText(df0.format(G26)+"");
        g27.setText(df0.format(G27)+"");
        g28.setText(df0.format(G28)+"");
        g29.setText(df0.format(G29)+"");
        g30.setText(df0.format(G30)+"");

        h26.setText(df0.format(H26)+"");
        h27.setText(df0.format(H27)+"");
        h28.setText(df0.format(H28)+"");
        h29.setText(df0.format(H29)+"");
        h30.setText(df0.format(H30)+"");

        i26.setText(df0.format(I26)+"");
        i27.setText(df0.format(I27)+"");
        i28.setText(df0.format(I28)+"");
        i29.setText(df0.format(I29)+"");
        i30.setText(df0.format(I30)+"");


    }

    public  void getDataPopulation(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.INDEX_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                num1 = Float.valueOf(cursor.getString(1));
                num2 = Float.valueOf(cursor.getString(2));
                num3 = Float.valueOf(cursor.getString(3));
                num4 = Float.valueOf(cursor.getString(4));
                num5 = Float.valueOf(cursor.getString(5));
                num6 = Float.valueOf(cursor.getString(6));
                num7 = Float.valueOf(cursor.getString(7));

                setPopData();

            }while(cursor.moveToNext());
        }else{
           //
        }
        cursor.close();
        db.close();
    }

    public  void setPopData(){

        float dataB5 = num1;
        float dataB6 = num2;//(float) ((num2/(dataB5/18))*100.0);
        float dataB7 = num3;//(float) (100.0*(num3*12)/dataB5);
        float dataB9 = num5;
        Integer dataB8 = (int) Math.ceil(num4); //(int) Math.ceil(num4*100/(100-dataB9));
        float dataB10 = num6;
        float dataB11 = num7;

        B3 = dataB5;
        B5 = (Float) (B3/(16/(dataB6/100)+3));
        B4 = (Float) (B5/(dataB6/100));
        B6 = (Float) (B3*(dataB7/100)/52);
        B7 = B5*3;
        B8 = B3-B6-B7;

        B11 = B4;
        B12 = (dataB6>89?B5:B11);
        B13 = (dataB6>86?B5:B11);
        B14 = (dataB6>83?B5:B11);
        B15 = (dataB6>80?B5:B11);
        B16 = (dataB6>77?B5:B11);
        B17 = B5;
        B18 = B17; B19 = B17; B20 = B17; B21 = B17; B22 = B17; B23 = B17; B24 = B17; B25 = B17; B26 = B17; B27 = B17;
        SUM_B11_B27 = (B11+B12+B13+B14+B15+B16+B17+B18+B19+B20+B21+B22+B23+B24+B25+B26+B27);

        if((B3-(SUM_B11_B27+B7))<B11){
            B10 = B3-(SUM_B11_B27+B7);
            SUMB10_B27 = SUM_B11_B27+B10;
            B9 = B3-B7-SUMB10_B27;
        }else{
            B10 = B11;
            SUMB10_B27 = SUM_B11_B27+B10;
            B9 = B3-B7-SUMB10_B27;
        }

        B28 = B5;
        B29 = B28*dataB8;
        B30 = (Float) (B29*3*(1-dataB9/2/100));
        B31 = B29;
        B32 = (Float) (B29*(1-dataB9/2/100));
        B33 = (Float) (B29*(1-dataB9/100));
        B34 = (Float) (B28*dataB8*(1-dataB9/100));
        B35 = B34/B28;


        B36 = (Float) (B34*6*(1-dataB10/2/100));
        B37 = B34;
        B38 = (float) (dataB10<0.6?(B37*(1-dataB10/1.2/100)):(B37*(1-dataB10/7.4/100)));
        B39 = (float) (dataB10>0.5?(B37*(1-dataB10/3.7/100)):(B37*(1-dataB10/100)));
        B40 = (float) (dataB10>0.9?(B37*(1-dataB10/1.8/100)):(B37*(1-dataB10/100)));
        B41 = (Float) (B37*(1-(dataB10/100)));
        B42 = B41;
        B43 = (Float) (B34*(1-dataB10/100));


        B44 = B43*16*(1-dataB11/2/100);
        B45 = B42;
        B46 = dataB11<0.6? (float) (B45 * (1 - dataB11 / 1.2 / 100)) :B45*(1-(dataB11/30/100));
        B47 = dataB11>0.5? (float) (B45 * (1 - dataB11 / 14.9 / 100)) :B45*(1-dataB11/100);
        B48 = B47;
        B49 = dataB11>0.5? (float) (B45 * (1 - (dataB11 / 7.4 / 100))) :B45*(1-dataB11/100);
        B50 = B49;
        B51 = B49;
        B52 = dataB11>0.9? (float) (B45 * (1 - (dataB11 / 3.4 / 100))) :B45*(1-dataB11/100);
        B53 = dataB11>0.9? (float) (B45 * (1 - (dataB11 / 1.8 / 100))) :B45*(1-dataB11/100);
        B54 = B53;
        B55 = B45*(1-(dataB11/100));
        B56 = B45*(1-(dataB11/100));
        B57 = B56;
        B58 = B56;
        B59 = B56;
        B60 = B56;
        B61 = B43*(1-dataB11/100);

    }

    public ArrayList getB(DataBaseAdapter db){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.INDEX_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                num1 = Float.valueOf(cursor.getString(1));
                num2 = Float.valueOf(cursor.getString(2));
                num3 = Float.valueOf(cursor.getString(3));
                num4 = Float.valueOf(cursor.getString(4));
                num5 = Float.valueOf(cursor.getString(5));
                num6 = Float.valueOf(cursor.getString(6));
                num7 = Float.valueOf(cursor.getString(7));

            }while(cursor.moveToNext());
        }else{
            //
        }
        cursor.close();
        db.close();

        float dataB5 = num1;
        float dataB6 = num2;//(float) ((num2/(dataB5/18))*100.0);
        float dataB7 = num3;//(float) (100.0*(num3*12)/dataB5);
        float dataB9 = num5;
        Integer dataB8 = (int) Math.ceil(num4); //(int) Math.ceil(num4*100/(100-dataB9));
        float dataB10 = num6;
        float dataB11 = num7;

        B3 = dataB5;
        B5 = (float) (B3/(16/(dataB6/100)+3));
        B4 = (float) (B5/(dataB6/100));
        B6 = (float) (B3*(dataB7/100)/52);
        B7 = B5*3;
        B8 = B3-B6-B7;

        B11 = B4;
        B12 = (dataB6>89?B5:B11);
        B13 = (dataB6>86?B5:B11);
        B14 = (dataB6>83?B5:B11);
        B15 = (dataB6>80?B5:B11);
        B16 = (dataB6>77?B5:B11);
        B17 = B5;
        B18 = B17; B19 = B17; B20 = B17; B21 = B17; B22 = B17; B23 = B17; B24 = B17; B25 = B17; B26 = B17; B27 = B17;
        SUM_B11_B27 = (B11+B12+B13+B14+B15+B16+B17+B18+B19+B20+B21+B22+B23+B24+B25+B26+B27);

        if((B3-(SUM_B11_B27+B7))<B11){
            B10 = B3-(SUM_B11_B27+B7);
            SUMB10_B27 = SUM_B11_B27+B10;
            B9 = B3-B7-SUMB10_B27;
        }else{
            B10 = B11;
            SUMB10_B27 = SUM_B11_B27+B10;
            B9 = B3-B7-SUMB10_B27;
        }

        B28 = B5;
        B29 = B28*dataB8;
        B30 = (float) (B29*3*(1-dataB9/2/100));
        B31 = B29;
        B32 = (float) (B29*(1-dataB9/2/100));
        B33 = (float) (B29*(1-dataB9/100));
        B34 = (float) (B28*dataB8*(1-dataB9/100));
        B35 = B34/B28;


        B36 = (float) (B34*6*(1-dataB10/2/100));
        B37 = B34;
        B38 = (float) (dataB10<0.6?(B37*(1-dataB10/1.2/100)):(B37*(1-dataB10/7.4/100)));
        B39 = (float) (dataB10>0.5?(B37*(1-dataB10/3.7/100)):(B37*(1-dataB10/100)));
        B40 = (float) (dataB10>0.9?(B37*(1-dataB10/1.8/100)):(B37*(1-dataB10/100)));
        B41 = (float) (B37*(1-(dataB10/100)));
        B42 = B41;
        B43 = (float) (B34*(1-dataB10/100));


        B44 = (float) B43*16*(1-dataB11/2/100);
        B45 = B42;
        B46 = dataB11<0.6? (float) (B45 * (1 - dataB11 / 1.2 / 100)) :B45*(1-(dataB11/30/100));
        B47 = dataB11>0.5? (float) (B45 * (1 - dataB11 / 14.9 / 100)) :B45*(1-dataB11/100);
        B48 = B47;
        B49 = dataB11>0.5? (float) (B45 * (1 - (dataB11 / 7.4 / 100))) :B45*(1-dataB11/100);
        B50 = B49;
        B51 = B49;
        B52 = dataB11>0.9? (float) (B45 * (1 - (dataB11 / 3.4 / 100))) :B45*(1-dataB11/100);
        B53 = dataB11>0.9? (float) (B45 * (1 - (dataB11 / 1.8 / 100))) :B45*(1-dataB11/100);
        B54 = B53;
        B55 = B45*(1-(dataB11/100));
        B56 = B45*(1-(dataB11/100));
        B57 = B56;
        B58 = B56;
        B59 = B56;
        B60 = B56;
        B61 = B43*(1-dataB11/100);

        DecimalFormat df = new DecimalFormat("#,###,###.#########");

        ArrayList<Float> arrayList = new ArrayList<Float>();
        arrayList.add((float) 1);
        arrayList.add((float) 2);
        arrayList.add(Float.valueOf(B3));
        arrayList.add(Float.valueOf(B4));
        arrayList.add(Float.valueOf(B5));
        arrayList.add(Float.valueOf(B6));
        arrayList.add(Float.valueOf(B7));
        arrayList.add(Float.valueOf(B8));
        arrayList.add(Float.valueOf(B9));
        arrayList.add(Float.valueOf(B10));
        arrayList.add(Float.valueOf(B11));
        arrayList.add(Float.valueOf(B12));
        arrayList.add(Float.valueOf(B13));
        arrayList.add(Float.valueOf(B14));
        arrayList.add(Float.valueOf(B15));
        arrayList.add(Float.valueOf(B16));
        arrayList.add(Float.valueOf(B17));
        arrayList.add(Float.valueOf(B18));
        arrayList.add(Float.valueOf(B19));
        arrayList.add(Float.valueOf(B20));
        arrayList.add(Float.valueOf(B21));
        arrayList.add(Float.valueOf(B22));
        arrayList.add(Float.valueOf(B23));
        arrayList.add(Float.valueOf(B24));
        arrayList.add(Float.valueOf(B25));
        arrayList.add(Float.valueOf(B26));
        arrayList.add(Float.valueOf(B27));
        arrayList.add(Float.valueOf(B28));
        arrayList.add(Float.valueOf(B29));
        arrayList.add(Float.valueOf(B30));
        arrayList.add(Float.valueOf(B31));
        arrayList.add(Float.valueOf(B32));
        arrayList.add(Float.valueOf(B33));
        arrayList.add(Float.valueOf(B34));
        arrayList.add(Float.valueOf(B35));
        arrayList.add(Float.valueOf(B36));
        arrayList.add(Float.valueOf(B37));
        arrayList.add(Float.valueOf(B38));
        arrayList.add(Float.valueOf(B39));
        arrayList.add(Float.valueOf(B40));
        arrayList.add(Float.valueOf(B41));
        arrayList.add(Float.valueOf(B42));
        arrayList.add(Float.valueOf(B43));
        arrayList.add(Float.valueOf(B44));
        arrayList.add(Float.valueOf(B45));
        arrayList.add(Float.valueOf(B46));
        arrayList.add(Float.valueOf(B47));
        arrayList.add(Float.valueOf(B48));
        arrayList.add(Float.valueOf(B49));
        arrayList.add(Float.valueOf(B50));
        arrayList.add(Float.valueOf(B51));
        arrayList.add(Float.valueOf(B52));
        arrayList.add(Float.valueOf(B53));
        arrayList.add(Float.valueOf(B54));
        arrayList.add(Float.valueOf(B55));
        arrayList.add(Float.valueOf(B56));
        arrayList.add(Float.valueOf(B57));
        arrayList.add(Float.valueOf(B58));
        arrayList.add(Float.valueOf(B59));
        arrayList.add(Float.valueOf(B60));
        arrayList.add(Float.valueOf(B61));

        return arrayList;
    }

    public void ShowDialog(final Context _context, String title, String message, final Boolean status){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(_context).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        //alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                goto_feed();
            }
        });
        alertDialog.show();
    }


    @Override
    public void onResume(){
        super.onResume();

        getData();
    }
}
