package com.conceptplays.komsonasa.elancopro;


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

import com.conceptplays.komsonasa.elancopro.DB.DataBaseAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FeedPigsFragment extends  android.support.v4.app.Fragment {
    DataBaseAdapter db;
    FeedSowsFragment pop;

    public TextView m26,m27,m28,m29,m30,m31,m32,n26,n27,n28,n29,n30,n31,n32,o26,o27,o28,o29,o30,o31,o32;
    public  TextView q26,q27,q28,q29,q30,q31,q32,r26,r27,r28,r29,r30,r31,r32,s26,s27,s28,s29,s30,s31,s32;

    public  Float M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22,M23,M24,M25,M26,M27,M28,M29,M30,M31,M32;
    public  Float N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22,N23,N24,N25,N26,N27,N28,N29,N30,N31,N32;
    public  Float O4,O5,O6,O7,O8,O9,O10,O11,O12,O13,O14,O15,O16,O17,O18,O19,O20,O21,O22,O23,O24,O25,O26,O27,O28,O29,O30,O31,O32;
    public  Float P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P15,P16,P17,P18,P19,P20,P21,P22,P23,P24,P25,P26,P27,P28,P29,P30,P31,P32;
    public  Float Q4,Q5,Q6,Q7,Q8,Q9,Q10,Q11,Q12,Q13,Q14,Q15,Q16,Q17,Q18,Q19,Q20,Q21,Q22,Q23,Q24,Q25,Q26,Q27,Q28,Q29,Q30,Q31,Q32;
    public  Float R4,R5,R6,R7,R8,R9,R10,R11,R12,R13,R14,R15,R16,R17,R18,R19,R20,R21,R22,R23,R24,R25,R26,R27,R28,R29,R30,R31,R32;
    public  Float S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21,S22,S23,S24,S25,S26,S27,S28,S29,S30,S31,S32;

    public FeedPigsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_AppCompat_Light);
        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);

        View v =  inflater.inflate(R.layout.fragment_feed_pigs, container, false);

        //Hide Scrollview Bar
        final ScrollView sView = (ScrollView)v.findViewById(R.id.scrollViewID);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        db = new DataBaseAdapter(getActivity());
        pop = new FeedSowsFragment();

        m26 = (TextView)v.findViewById(R.id.m26);
        m27 = (TextView)v.findViewById(R.id.m27);
        m28 = (TextView)v.findViewById(R.id.m28);
        m29 = (TextView)v.findViewById(R.id.m29);
        m30 = (TextView)v.findViewById(R.id.m30);
        m31 = (TextView)v.findViewById(R.id.m31);
        m32 = (TextView)v.findViewById(R.id.m32);

        n26 = (TextView)v.findViewById(R.id.n26);
        n27 = (TextView)v.findViewById(R.id.n27);
        n28 = (TextView)v.findViewById(R.id.n28);
        n29 = (TextView)v.findViewById(R.id.n29);
        n30 = (TextView)v.findViewById(R.id.n30);
        n31 = (TextView)v.findViewById(R.id.n31);
        n32 = (TextView)v.findViewById(R.id.n32);

        o26 = (TextView)v.findViewById(R.id.o26);
        o27 = (TextView)v.findViewById(R.id.o27);
        o28 = (TextView)v.findViewById(R.id.o28);
        o29 = (TextView)v.findViewById(R.id.o29);
        o30 = (TextView)v.findViewById(R.id.o30);
        o31 = (TextView)v.findViewById(R.id.o31);
        o32 = (TextView)v.findViewById(R.id.o32);

        q26 = (TextView)v.findViewById(R.id.q26);
        q27 = (TextView)v.findViewById(R.id.q27);
        q28 = (TextView)v.findViewById(R.id.q28);
        q29 = (TextView)v.findViewById(R.id.q29);
        q30 = (TextView)v.findViewById(R.id.q30);
        q31 = (TextView)v.findViewById(R.id.q31);
        q32 = (TextView)v.findViewById(R.id.q32);

        r26 = (TextView)v.findViewById(R.id.r26);
        r27 = (TextView)v.findViewById(R.id.r27);
        r28 = (TextView)v.findViewById(R.id.r28);
        r29 = (TextView)v.findViewById(R.id.r29);
        r30 = (TextView)v.findViewById(R.id.r30);
        r31 = (TextView)v.findViewById(R.id.r31);
        r32 = (TextView)v.findViewById(R.id.r32);

        s26 = (TextView)v.findViewById(R.id.s26);
        s27 = (TextView)v.findViewById(R.id.s27);
        s28 = (TextView)v.findViewById(R.id.s28);
        s29 = (TextView)v.findViewById(R.id.s29);
        s30 = (TextView)v.findViewById(R.id.s30);
        s31 = (TextView)v.findViewById(R.id.s31);
        s32 = (TextView)v.findViewById(R.id.s32);


        Button btn = (Button)v.findViewById(R.id.btnChngVal);
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
        intent = new Intent(getActivity(), FeedPigsPerDayActivity.class);
        startActivity(intent);
    }

    public void getData(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.FDPIG_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                M4 = Float.valueOf(cursor.getString(1));
                M5 = Float.valueOf(cursor.getString(2));
                M6 = Float.valueOf(cursor.getString(3));
                M7 = Float.valueOf(cursor.getString(4));
                M8 = Float.valueOf(cursor.getString(5));
                M9 = Float.valueOf(cursor.getString(6));
                M10 = Float.valueOf(cursor.getString(7));
                M11 = Float.valueOf(cursor.getString(8));
                M12 = Float.valueOf(cursor.getString(9));
                M13 = Float.valueOf(cursor.getString(10));
                M14 = Float.valueOf(cursor.getString(11));
                M15 = Float.valueOf(cursor.getString(12));
                M16 = Float.valueOf(cursor.getString(13));
                M17 = Float.valueOf(cursor.getString(14));
                M18 = Float.valueOf(cursor.getString(15));
                M19 = Float.valueOf(cursor.getString(16));
                M20 = Float.valueOf(cursor.getString(17));
                M21 = Float.valueOf(cursor.getString(18));
                M22 = Float.valueOf(cursor.getString(19));
                M23 = Float.valueOf(cursor.getString(20));
                M24 = Float.valueOf(cursor.getString(21));
                M25 = Float.valueOf(cursor.getString(22));

                setData();

            }while(cursor.moveToNext());
        }else{
            ShowDialog(getActivity(),"Not complete data!","You must input performance data.", true);
        }
        cursor.close();
        db.close();
    }

    public void setData() {
        DecimalFormat df = new DecimalFormat("#,###,###.#");
        DecimalFormat df2 = new DecimalFormat("#,###,###.##");
        DecimalFormat df0 = new DecimalFormat("#,###,###");

        M26 =  (M4+M5+M6)/3;
        float sumM6_M22 = (M6+M7+M8+M9+M10+M11+M12+M13+M14+M15+M16+M17+M18+M19+M20+M21+M22);
        float sumM4_M25 = sumM6_M22+M5+M4+M23+M24+M25;
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

        ArrayList ar = pop.getB(this.db);
        P4 = (Float) ar.get(37-1);
        P5 = (Float) ar.get(38-1);
        P6 = (Float) ar.get(39-1);
        P7 = (Float) ar.get(40-1);
        P8 = (Float) ar.get(41-1);
        P9 = (Float) ar.get(42-1);
        P10 = (Float) ar.get(45-1);
        P11 = (Float) ar.get(46-1);
        P12 = (Float) ar.get(47-1);
        P13 = (Float) ar.get(48-1);
        P14 = (Float) ar.get(49-1);
        P15 = (Float) ar.get(50-1);
        P16 = (Float) ar.get(51-1);
        P17 = (Float) ar.get(52-1);
        P18 = (Float) ar.get(53-1);
        P19 = (Float) ar.get(54-1);
        P20 = (Float) ar.get(55-1);
        P21 = (Float) ar.get(56-1);
        P22 = (Float) ar.get(57-1);
        P23 = (Float) ar.get(58-1);
        P24 = (Float) ar.get(59-1);
        P25 = (Float) ar.get(60-1);

        Q4 = P4*M4; Q4 = Float.valueOf((float) Math.round(Q4));
        Q5 = P5*M5; Q5 = Float.valueOf((float) Math.round(Q5));
        Q6 = P6*M6; Q6 = Float.valueOf((float) Math.round(Q6));
        Q7 = P7*M7; Q7 = Float.valueOf((float) Math.round(Q7));
        Q8 = P8*M8; Q8 = Float.valueOf((float) Math.round(Q8));
        Q9 = P9*M9; Q9 = Float.valueOf((float) Math.round(Q9));
        Q10 = P10*M10; Q10 = Float.valueOf((float) Math.round(Q10));
        Q11 = P11*M11; Q11 = Float.valueOf((float) Math.round(Q11));
        Q12 = P12*M12; Q12 = Float.valueOf((float) Math.round(Q12));
        Q13 = P13*M13; Q13 = Float.valueOf((float) Math.round(Q13));
        Q14 = P14*M14; Q14 = Float.valueOf((float) Math.round(Q14));
        Q15 = P15*M15; Q15 = Float.valueOf((float) Math.round(Q15));
        Q16 = P16*M16; Q16 = Float.valueOf((float) Math.round(Q16));
        Q17 = P17*M17; Q17 = Float.valueOf((float) Math.round(Q17));
        Q18 = P18*M18; Q18 = Float.valueOf((float) Math.round(Q18));
        Q19 = P19*M19; Q19 = Float.valueOf((float) Math.round(Q19));
        Q20 = P20*M20; Q20 = Float.valueOf((float) Math.round(Q20));
        Q21 = P21*M21; Q21 = Float.valueOf((float) Math.round(Q21));
        Q22 = P22*M22; Q22 = Float.valueOf((float) Math.round(Q22));
        Q23 = P23*M23; Q23 = Float.valueOf((float) Math.round(Q23));
        Q24 = P24*M24; Q24 = Float.valueOf((float) Math.round(Q24));
        Q25 = P25*M25; Q25 = Float.valueOf((float) Math.round(Q25));

        Q26 = Q4+Q5+Q6;
        Q27 = Q7+Q8+Q9;
        Q28 = Q26+Q27;
        Q29 = Q10+Q11+Q12+Q13+Q14+Q15;
        Q30 = Q16+Q17+Q18+Q19+Q20;
        Q31 = Q21+Q22+Q23+Q24+Q25;
        Q32 = Q28+Q29+Q30+Q31;

        R4 = P4*N4; R4 = Float.valueOf((float) Math.round(R4));
        R5 = P5*N5; R5 = Float.valueOf((float) Math.round(R5));
        R6 = P6*N6; R6 = Float.valueOf((float) Math.round(R6));
        R7 = P7*N7; R7 = Float.valueOf((float) Math.round(R7));
        R8 = P8*N8; R8 = Float.valueOf((float) Math.round(R8));
        R9 = P9*N9; R9 = Float.valueOf((float) Math.round(R9));
        R10 = P10*N10; R10 = Float.valueOf((float) Math.round(R10));
        R11 = P11*N11; R11 = Float.valueOf((float) Math.round(R11));
        R12 = P12*N12; R12 = Float.valueOf((float) Math.round(R12));
        R13 = P13*N13; R13 = Float.valueOf((float) Math.round(R13));
        R14 = P14*N14; R14 = Float.valueOf((float) Math.round(R14));
        R15 = P15*N15; R15 = Float.valueOf((float) Math.round(R15));
        R16 = P16*N16; R16 = Float.valueOf((float) Math.round(R16));
        R17 = P17*N17; R17 = Float.valueOf((float) Math.round(R17));
        R18 = P18*N18; R18 = Float.valueOf((float) Math.round(R18));
        R19 = P19*N19; R19 = Float.valueOf((float) Math.round(R19));
        R20 = P20*N20; R20 = Float.valueOf((float) Math.round(R20));
        R21 = P21*N21; R21 = Float.valueOf((float) Math.round(R21));
        R22 = P22*N22; R22 = Float.valueOf((float) Math.round(R22));
        R23 = P23*N23; R23 = Float.valueOf((float) Math.round(R23));
        R24 = P24*N24; R24 = Float.valueOf((float) Math.round(R24));
        R25 = P25*N25; R25 = Float.valueOf((float) Math.round(R25));

        R26 = R4+R5+R6;
        R27 = R7+R8+R9;
        R28 = R26+R27;
        R29 = R10+R11+R12+R13+R14+R15;
        R30 = R16+R17+R18+R19+R20;
        R31 = R21+R22+R23+R24+R25;
        R32 = R28+R29+R30+R31;

        S4 = P4*O4; S4 = Float.valueOf((float) Math.round(S4));
        S5 = P5*O5; S5 = Float.valueOf((float) Math.round(S5));
        S6 = P6*O6; S6 = Float.valueOf((float) Math.round(S6));
        S7 = P7*O7; S7 = Float.valueOf((float) Math.round(S7));
        S8 = P8*O8; S8 = Float.valueOf((float) Math.round(S8));
        S9 = P9*O9; S9 = Float.valueOf((float) Math.round(S9));
        S10 = P10*O10; S10 = Float.valueOf((float) Math.round(S10));
        S11 = P11*O11; S11 = Float.valueOf((float) Math.round(S11));
        S12 = P12*O12; S12 = Float.valueOf((float) Math.round(S12));
        S13 = P13*O13; S13 = Float.valueOf((float) Math.round(S13));
        S14 = P14*O14; S14 = Float.valueOf((float) Math.round(S14));
        S15 = P15*O15; S15 = Float.valueOf((float) Math.round(S15));
        S16 = P16*O16; S16 = Float.valueOf((float) Math.round(S16));
        S17 = P17*O17; S17 = Float.valueOf((float) Math.round(S17));
        S18 = P18*O18; S18 = Float.valueOf((float) Math.round(S18));
        S19 = P19*O19; S19 = Float.valueOf((float) Math.round(S19));
        S20 = P20*O20; S20 = Float.valueOf((float) Math.round(S20));
        S21 = P21*O21; S21 = Float.valueOf((float) Math.round(S21));
        S22 = P22*O22; S22 = Float.valueOf((float) Math.round(S22));
        S23 = P23*O23; S23 = Float.valueOf((float) Math.round(S23));
        S24 = P24*O24; S24 = Float.valueOf((float) Math.round(S24));
        S25 = P25*O25; S25 = Float.valueOf((float) Math.round(S25));

        S26 = S4+S5+S6; S26 = Float.valueOf((float) Math.round(S26));
        S27 = S7+S8+S9; S27 = Float.valueOf((float) Math.round(S27));
        S28 = S26+S27; S28 = Float.valueOf((float) Math.round(S28));
        S29 = S10+S11+S12+S13+S14+S15; S29 = Float.valueOf((float) Math.round(S29));
        S30 = S16+S17+S18+S19+S20; S30 = Float.valueOf((float) Math.round(S30));
        S31 = S21+S22+S23+S24+S25; S31 = Float.valueOf((float) Math.round(S31));
        S32 = S28+S29+S30+S31; S32 = Float.valueOf((float) Math.round(S32));

        m26.setText(df2.format(M26)+"");
        m27.setText(df2.format(M27)+"");
        m28.setText(df2.format(M28)+"");
        m29.setText(df2.format(M29)+"");
        m30.setText(df2.format(M30)+"");
        m31.setText(df2.format(M31)+"");
        m32.setText(df2.format(M32)+"");

        n26.setText(df2.format(N26)+"");
        n27.setText(df2.format(N27)+"");
        n28.setText(df2.format(N28)+"");
        n29.setText(df2.format(N29)+"");
        n30.setText(df2.format(N30)+"");
        n31.setText(df2.format(N31)+"");
        n32.setText(df2.format(N32)+"");

        o26.setText(df2.format(O26)+"");
        o27.setText(df2.format(O27)+"");
        o28.setText(df2.format(O28)+"");
        o29.setText(df2.format(O29)+"");
        o30.setText(df2.format(O30)+"");
        o31.setText(df2.format(O31)+"");
        o32.setText(df2.format(O32)+"");

        q26.setText(df0.format(Q26)+"");
        q27.setText(df0.format(Q27)+"");
        q28.setText(df0.format(Q28)+"");
        q29.setText(df0.format(Q29)+"");
        q30.setText(df0.format(Q30)+"");
        q31.setText(df0.format(Q31)+"");
        q32.setText(df0.format(Q32)+"");

        r26.setText(df0.format(R26)+"");
        r27.setText(df0.format(R27)+"");
        r28.setText(df0.format(R28)+"");
        r29.setText(df0.format(R29)+"");
        r30.setText(df0.format(R30)+"");
        r31.setText(df0.format(R31)+"");
        r32.setText(df0.format(R32)+"");

        s26.setText(df0.format(S26)+"");
        s27.setText(df0.format(S27)+"");
        s28.setText(df0.format(S28)+"");
        s29.setText(df0.format(S29)+"");
        s30.setText(df0.format(S30)+"");
        s31.setText(df0.format(S31)+"");
        s32.setText(df0.format(S32)+"");


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
