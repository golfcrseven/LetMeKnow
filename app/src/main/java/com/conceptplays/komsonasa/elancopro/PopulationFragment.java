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
import android.widget.ScrollView;
import android.widget.TextView;

import com.conceptplays.komsonasa.elancopro.DB.DataBaseAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

import java.text.DecimalFormat;

public class PopulationFragment extends Fragment {
	
	public PopulationFragment(){}

    android.os.Handler customHandler;
    DataBaseAdapter db;

    float num1, num2, num3,num4, num5,num6, num7;
    TextView n1, n2, n3, n4,n5,n6,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25;
    TextView b26,b27,b28,b29,b30,b31,b32,b33,b34,b35,b36,b37,b38,b39,b40,b41,b42,b43;
    TextView b44,b45,b46,b47,b48,b49,b50,b51,b52,b53,b54,b55,b56,b57,b58,b59,b60,b61;
    public float B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22,B23,B24,B25,B26,B27,SUMB10_B27;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {

        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_AppCompat_Light);
        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);
        View v = inflater.inflate(R.layout.fragment_population, container, false);

        //Hide Scrollview Bar
        final ScrollView sView = (ScrollView)v.findViewById(R.id.scrollViewID);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        //------------------------------------
        //set delay load
        //------------------------------------


        db = new DataBaseAdapter(getActivity());

        n1 = (TextView)v.findViewById(R.id.N1);
        n2 = (TextView)v.findViewById(R.id.RB7);
        n3 = (TextView)v.findViewById(R.id.RB8);
        n4 = (TextView)v.findViewById(R.id.RB9);
        n5 = (TextView)v.findViewById(R.id.RB12);
        n6 = (TextView)v.findViewById(R.id.RB112);
        b9 = (TextView)v.findViewById(R.id.b9);
        b10 = (TextView)v.findViewById(R.id.b10);
        b11 = (TextView)v.findViewById(R.id.b11);
        b12 = (TextView)v.findViewById(R.id.b12);
        b13 = (TextView)v.findViewById(R.id.b13);
        b14 = (TextView)v.findViewById(R.id.b14);
        b15 = (TextView)v.findViewById(R.id.b15);
        b16 = (TextView)v.findViewById(R.id.b16);
        b17 = (TextView)v.findViewById(R.id.b17);
        b18 = (TextView)v.findViewById(R.id.b18);
        b19 = (TextView)v.findViewById(R.id.b19);
        b20 = (TextView)v.findViewById(R.id.b20);
        b21 = (TextView)v.findViewById(R.id.b21);
        b22 = (TextView)v.findViewById(R.id.b22);
        b23 = (TextView)v.findViewById(R.id.b23);
        b24 = (TextView)v.findViewById(R.id.b24);
        b25 = (TextView)v.findViewById(R.id.b25);
        b26 = (TextView)v.findViewById(R.id.b26);
        b27 = (TextView)v.findViewById(R.id.b27);
        b28 = (TextView)v.findViewById(R.id.b28);
        b29 = (TextView)v.findViewById(R.id.b29);
        b30 = (TextView)v.findViewById(R.id.b30);
        b31 = (TextView)v.findViewById(R.id.b31);
        b32 = (TextView)v.findViewById(R.id.b32);
        b33 = (TextView)v.findViewById(R.id.b33);
        b34 = (TextView)v.findViewById(R.id.b34);
        b35 = (TextView)v.findViewById(R.id.b35);
        b36 = (TextView)v.findViewById(R.id.b36);
        b37 = (TextView)v.findViewById(R.id.b37);
        b38 = (TextView)v.findViewById(R.id.b38);
        b39 = (TextView)v.findViewById(R.id.b39);
        b40 = (TextView)v.findViewById(R.id.b40);
        b41 = (TextView)v.findViewById(R.id.b41);
        b42 = (TextView)v.findViewById(R.id.b42);
        b43 = (TextView)v.findViewById(R.id.b43);
        b44 = (TextView)v.findViewById(R.id.p17);
        b45 = (TextView)v.findViewById(R.id.p18);
        b46 = (TextView)v.findViewById(R.id.p19);
        b47 = (TextView)v.findViewById(R.id.p20);
        b48 = (TextView)v.findViewById(R.id.p21);
        b49 = (TextView)v.findViewById(R.id.p22);
        b50 = (TextView)v.findViewById(R.id.p23);
        b51 = (TextView)v.findViewById(R.id.p24);
        b52 = (TextView)v.findViewById(R.id.p25);
        b53 = (TextView)v.findViewById(R.id.p26);
        b54 = (TextView)v.findViewById(R.id.p27);
        b55 = (TextView)v.findViewById(R.id.p28);
        b56 = (TextView)v.findViewById(R.id.p29);
        b57 = (TextView)v.findViewById(R.id.p30);
        b58 = (TextView)v.findViewById(R.id.p31);
        b59 = (TextView)v.findViewById(R.id.p32);
        b60 = (TextView)v.findViewById(R.id.p33);
        b61 = (TextView)v.findViewById(R.id.p34);

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
                num1 = Float.valueOf(cursor.getString(1));
                num2 = Float.valueOf(cursor.getString(2));
                num3 = Float.valueOf(cursor.getString(3));
                num4 = Float.valueOf(cursor.getString(4));
                num5 = Float.valueOf(cursor.getString(5));
                num6 = Float.valueOf(cursor.getString(6));
                num7 = Float.valueOf(cursor.getString(7));

                setData();

            }while(cursor.moveToNext());
        }else{
            ShowDialog(getActivity(),"Not complete data!","You must input performance data.", true);
        }
        cursor.close();
        db.close();
    }

    public void setData(){
        DecimalFormat df = new DecimalFormat("#,###,###.#");
        DecimalFormat df0 = new DecimalFormat("#,###,###");

        float dataB5 = num1;
        float dataB6 = num2;//(float) ((num2/(dataB5/18))*100.0);
        float dataB7 = num3;//(float) (100.0*(num3*12)/dataB5);
        float dataB9 = num5;
        Integer dataB8 = (int) Math.ceil(num4); //(int) Math.ceil(num4*100/(100-dataB9));
        float dataB10 = num6;
        float dataB11 = num7;

         B3 = dataB5;
         B5 = (float) (B3/(16/(dataB6/100.0)+3));
         B4 = (float) (B5/(dataB6/100.0));
         B6 = (float) (B3*(dataB7/100.0)/52);
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
        final float SUM_B11_B27 = (B11+B12+B13+B14+B15+B16+B17+B18+B19+B20+B21+B22+B23+B24+B25+B26+B27);

        if((B3-(SUM_B11_B27+B7))<B11){
            B10 = B3-(SUM_B11_B27+B7);
            SUMB10_B27 = SUM_B11_B27+B10;
            B9 = B3-B7-SUMB10_B27;
            b9.setText(df.format(B9)+"");
            b10.setText(df.format(B10)+"");
        }else{
            B10 = B11;
            SUMB10_B27 = SUM_B11_B27+B10;
            B9 = B3-B7-SUMB10_B27;
            b9.setText(df.format(B9)+"");
            b10.setText(df.format(B10)+"");
        }

        n1.setText(df.format(B3)+"");
        n2.setText(df.format(B4)+"");
        n3.setText(df.format(B5)+"");
        n4.setText(df.format(B6)+"");
        n5.setText(df.format(B7)+"");
        n6.setText(df.format(B8)+"");
        b11.setText(df.format(B11)+"");
        b12.setText(df.format(B12)+"");
        b13.setText(df.format(B13)+"");
        b14.setText(df.format(B14)+"");
        b15.setText(df.format(B15)+"");
        b16.setText(df.format(B16)+"");
        b17.setText(df.format(B17)+"");
        b18.setText(df.format(B18)+"");
        b19.setText(df.format(B19)+"");
        b20.setText(df.format(B20)+"");
        b21.setText(df.format(B21)+"");
        b22.setText(df.format(B22)+"");
        b23.setText(df.format(B23)+"");
        b24.setText(df.format(B24)+"");
        b25.setText(df.format(B25)+"");
        b26.setText(df.format(B26)+"");
        b27.setText(df.format(B27)+"");

        float B28,B29,B30,B31,B32,B33,B34,B35;
        B28 = B5;
        B29 = B28*dataB8;
        B30 = (float) (B29*3*(1-dataB9/2/100.0));
        B31 = B29;
        B32 = (float) (B29*(1-dataB9/2/100.0));
        B33 = (float) (B29*(1-dataB9/100.0));
        B34 = (float) (B28*dataB8*(1-dataB9/100.0));
        B35 = B34/B28;

        b28.setText(df0.format(B28)+"");
        b29.setText(df.format(B29)+"");
        //b29.setText(dataB8+"");
        b30.setText(df.format(B30)+"");
        b31.setText(df.format(B31)+"");
        b32.setText(df.format(B32)+"");
        b33.setText(df.format(B33)+"");
        b34.setText(df.format(B34)+"");
        b35.setText(df.format(B35)+"");

        float B36,B37,B38,B39,B40,B41,B42,B43;

        B36 = (float) (B34*6.0*(1.0-dataB10/2.0/100.0));
        B37 = B34;
        B38 = (float) (dataB10<0.6?(B37*(1-dataB10/1.2/100.0)):(B37*(1-dataB10/7.4/100.0)));
        B39 = (float) (dataB10>0.5?(B37*(1-dataB10/3.7/100.0)):(B37*(1-dataB10/100.0)));
        B40 = (float) (dataB10>0.9?(B37*(1-dataB10/1.8/100.0)):(B37*(1-dataB10/100.0)));
        B41 = (float) (B37*(1-(dataB10/100.0)));
        B42 = B41;
        B43 = (float) (B34*(1-dataB10/100.0));

        b36.setText(df0.format(B36)+"");
        b37.setText(df.format(B37)+"");
        b38.setText(df.format(B38)+"");
        b39.setText(df.format(B39)+"");
        b40.setText(df.format(B40)+"");
        b41.setText(df.format(B41)+"");
        b42.setText(df.format(B42)+"");
        b43.setText(df.format(B43)+"");

        float B44,B45, B46,B47,B48,B49,B50,B51,B52,B53,B54,B55,B56,B57,B58,B59,B60,B61;

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

        b44.setText(df0.format(B44)+"");
        b45.setText(df.format(B45)+"");
        b46.setText(df.format(B46)+"");
        b47.setText(df.format(B47)+"");
        b48.setText(df.format(B48)+"");
        b49.setText(df.format(B49)+"");
        b50.setText(df.format(B50)+"");
        b51.setText(df.format(B51)+"");
        b52.setText(df.format(B52)+"");
        b53.setText(df.format(B53)+"");
        b54.setText(df.format(B54)+"");
        b55.setText(df.format(B55)+"");
        b56.setText(df.format(B56)+"");
        b57.setText(df.format(B57)+"");
        b58.setText(df.format(B58)+"");
        b59.setText(df.format(B59)+"");
        b60.setText(df.format(B60)+"");
        b61.setText(df.format(B61)+"");

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
