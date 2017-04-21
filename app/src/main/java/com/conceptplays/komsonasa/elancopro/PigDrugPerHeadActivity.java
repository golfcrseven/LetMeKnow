package com.conceptplays.komsonasa.elancopro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.conceptplays.komsonasa.elancopro.Class.HelperClass;
import com.conceptplays.komsonasa.elancopro.DB.DataBaseAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class PigDrugPerHeadActivity extends Activity {
    DataBaseAdapter db;
    HelperClass hc;
    String Option = null, drugName,title;
    Double usage = null;
    String drugPrice;
    Long ListID;
    CheckBox chkD5,chkD6,chkD7,chkD8,chkD9,chkD10,chkD11,chkD12,chkD13,chkD14,chkD15,chkD16,chkD17;
    CheckBox chkD18,chkD19,chkD20,chkD21,chkD22,chkD23,chkD24,chkD25,chkD26;
    EditText edtUsage,edtD5,edtD6,edtD7,edtD8,edtD9,edtD10,edtD11,edtD12,edtD13,edtD14,edtD15,edtD16,edtD17;
    EditText edtD18,edtD19,edtD20,edtD21,edtD22,edtD23,edtD24,edtD25,edtD26;
    Double   C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22,C23,C24,C25;
    Double   M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22,M23,M24,M25;
    Double   PSD5,PSD6,PSD7,PSD8,PSD9,PSD10,PSD11,PSD12,PSD13,PSD14,PSD15,PSD16,PSD17,PSD18,PSD19,PSD20,PSD21,PSD22,PSD23,PSD24,PSD25,PSD26;
    ArrayList<Boolean> checked = new ArrayList<Boolean>();
    ArrayList<Double> sumVal = new ArrayList<Double>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hide keyboard on lunch
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        setContentView(R.layout.activity_pig_drug_per_head);

        ListID  = getIntent().getExtras().getLong("listID");
        Option = getIntent().getExtras().getString("option");
        drugName = getIntent().getExtras().getString("drugName");
        drugPrice = getIntent().getExtras().getString("drugPrice");
        title = getIntent().getExtras().getString("title");

        checked.clear();
        sumVal.clear();

        for (int i=1; i<=Option.length(); i++){
            String data = String.valueOf(Option.charAt(i-1));
            if(data.equals("1")){
                checked.add(true);
            }else{
                checked.add(false);
            }
            sumVal.add(0.0);
        }

        db = new DataBaseAdapter(this);
        hc = new HelperClass();

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.list_background)));
        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.mytitle, null);

        ImageButton btnSlideMenu = (ImageButton)v.findViewById(R.id.btnSlideMenu);
        btnSlideMenu.setVisibility(View.GONE);

        ((TextView)v.findViewById(R.id.myTitleTxt)).setText(drugName+" - "+title);


        Button btnAdd = (Button)v.findViewById(R.id.btnAddMedicine);
        btnAdd.setVisibility(View.VISIBLE);
        btnAdd.setText("Done");
        btnAdd.setTextSize(15);

        //assign the view to the actionbar
        this.getActionBar().setCustomView(v);

        CheckBox chkAll = (CheckBox)this.findViewById(R.id.checkBox_Select_All);
        chkAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    for (int i = 1; i <= Option.length(); i++) {
                        checked.set(i-1, true);
                    }
                }else{
                    for (int i = 1; i <= Option.length(); i++) {
                        checked.set(i-1, false);
                    }

                }
                setData();
            }
        });

        chkD5 = (CheckBox)findViewById(R.id.chkD5);
        chkD6 = (CheckBox)findViewById(R.id.chkD6);
        chkD7 = (CheckBox)findViewById(R.id.chkD7);
        chkD8 = (CheckBox)findViewById(R.id.chkD8);
        chkD9 = (CheckBox)findViewById(R.id.chkD9);
        chkD10 = (CheckBox)findViewById(R.id.chkD10);
        chkD11 = (CheckBox)findViewById(R.id.chkD11);
        chkD12 = (CheckBox)findViewById(R.id.chkD12);
        chkD13 = (CheckBox)findViewById(R.id.chkD13);
        chkD14 = (CheckBox)findViewById(R.id.chkD14);
        chkD15 = (CheckBox)findViewById(R.id.chkD15);
        chkD16 = (CheckBox)findViewById(R.id.chkD16);
        chkD17 = (CheckBox)findViewById(R.id.chkD17);
        chkD18 = (CheckBox)findViewById(R.id.chkD18);
        chkD19 = (CheckBox)findViewById(R.id.chkD19);
        chkD20 = (CheckBox)findViewById(R.id.chkD20);
        chkD21 = (CheckBox)findViewById(R.id.chkD21);
        chkD22 = (CheckBox)findViewById(R.id.chkD22);
        chkD23 = (CheckBox)findViewById(R.id.chkD23);
        chkD24 = (CheckBox)findViewById(R.id.chkD24);
        chkD25 = (CheckBox)findViewById(R.id.chkD25);
        chkD26 = (CheckBox)findViewById(R.id.chkD26);

        edtUsage = (EditText)findViewById(R.id.edtUsage);
        edtD5 = (EditText)findViewById(R.id.edtD5);
        edtD6 = (EditText)findViewById(R.id.edtD6);
        edtD7 = (EditText)findViewById(R.id.edtD7);
        edtD8 = (EditText)findViewById(R.id.edtD8);
        edtD9 = (EditText)findViewById(R.id.edtD9);
        edtD10 = (EditText)findViewById(R.id.edtD10);
        edtD11 = (EditText)findViewById(R.id.edtD11);
        edtD12 = (EditText)findViewById(R.id.edtD12);
        edtD13 = (EditText)findViewById(R.id.edtD13);
        edtD14 = (EditText)findViewById(R.id.edtD14);
        edtD15 = (EditText)findViewById(R.id.edtD15);
        edtD16 = (EditText)findViewById(R.id.edtD16);
        edtD17 = (EditText)findViewById(R.id.edtD17);
        edtD18 = (EditText)findViewById(R.id.edtD18);
        edtD19 = (EditText)findViewById(R.id.edtD19);
        edtD20 = (EditText)findViewById(R.id.edtD20);
        edtD21 = (EditText)findViewById(R.id.edtD21);
        edtD22 = (EditText)findViewById(R.id.edtD22);
        edtD23 = (EditText)findViewById(R.id.edtD23);
        edtD24 = (EditText)findViewById(R.id.edtD24);
        edtD25 = (EditText)findViewById(R.id.edtD25);
        edtD26 = (EditText)findViewById(R.id.edtD26);

        getData();
        getFeedM();
        getPSD();
        setData();


        edtUsage.setText(usage.toString());
        edtUsage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
               if(charSequence.toString().equals("")){
                   usage = 0.0;
               }else{
                   if(charSequence.toString().equals(".")) {
                       usage = 0.0;
                   }else{
                       usage = Double.valueOf(String.valueOf(charSequence.toString()));
                   }

                   usage = usage*1.0;
               }
                getFeedM();
                getPSD();
                setData();

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkData();
            }
        });

    }
    private  void chkData(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you confirm to save data?");
        dialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {

            }
        });
        dialog.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                update();

            }
        });
        dialog.show();
    }

    private void update(){
        getFeedM();
        getPSD();
        Double sum = 0.000000000, cost,price = 0.0;
        StringBuilder opt = new StringBuilder();

        for (int i=1; i<=checked.size(); i++){
            if(checked.get(i-1)==true){
                opt.append("1");
                sum = sum+sumVal.get(i-1);
            }else{
                opt.append("0");
            }

        }
        //String total = hc.df9(sum);
        //sum = hc.string2double9df(sum.toString());
        Log.v("sum=>", sum+"");

        price = hc.string2double9df(drugPrice);
        cost = sum*price;

        ContentValues cv = new ContentValues();
        cv.clear();

        cv.put(db.DRUG_SOW_PERSOW_USAGE, usage);
        cv.put(db.DRUG_SOW_PERSOW_OPTION, opt.toString());
        cv.put(db.DRUG_SOW_PERSOW_COST, cost);
        cv.put(db.DRUG_SOW_PERSOW_TOTAL, sum);

        db.open();
        long id;
        id = db.updateRow(db.DRUG_PIG_TABLE, cv, ListID);
        db.close();
        if(id>0) {
            finish();
        }

    }

    private void getData() {
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.DRUG_PIG_TABLE, Long.valueOf(ListID));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                usage = Double.valueOf(cursor.getString(2));
                Option = String.valueOf(cursor.getString(3));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
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

    private void getPSD(){

        PSD5 = usage*((M4*7)/1000);
        PSD6 = usage*((M5*7)/1000);
        PSD7 = usage*((M6*7)/1000);
        PSD8 = usage*((M7*7)/1000);
        PSD9 = usage*((M8*7)/1000);
        PSD10 = usage*((M9*7)/1000);
        PSD11 = usage*((M10*7)/1000);
        PSD12 = usage*((M11*7)/1000);
        PSD13 = usage*((M12*7)/1000);
        PSD14 = usage*((M13*7)/1000);
        PSD15 = usage*((M14*7)/1000);
        PSD16 = usage*((M15*7)/1000);
        PSD17 = usage*((M16*7)/1000);
        PSD18 = usage*((M17*7)/1000);
        PSD19 = usage*((M18*7)/1000);
        PSD20 = usage*((M19*7)/1000);
        PSD21 = usage*((M20*7)/1000);
        PSD22 = usage*((M21*7)/1000);
        PSD23 = usage*((M22*7)/1000);
        PSD24 = usage*((M23*7)/1000);
        PSD25 = usage*((M24*7)/1000);
        PSD26 = usage*((M25*7)/1000);

        sumVal.set(0,PSD5);
        sumVal.set(1,PSD6);
        sumVal.set(2,PSD7);
        sumVal.set(3,PSD8);
        sumVal.set(4,PSD9);
        sumVal.set(5,PSD10);
        sumVal.set(6,PSD11);
        sumVal.set(7,PSD12);
        sumVal.set(8,PSD13);
        sumVal.set(9,PSD14);
        sumVal.set(10,PSD15);
        sumVal.set(11,PSD16);
        sumVal.set(12,PSD17);
        sumVal.set(13,PSD18);
        sumVal.set(14,PSD19);
        sumVal.set(15,PSD20);
        sumVal.set(16,PSD21);
        sumVal.set(17,PSD22);
        sumVal.set(18,PSD23);
        sumVal.set(19,PSD24);
        sumVal.set(20,PSD25);
        sumVal.set(21,PSD26);

    }

    private void setData(){
        final DecimalFormat df2 = new DecimalFormat("#,###,###.000");

        chkD5.setChecked(checked.get(0));
        edtD5.setText((chkD5.isChecked()?df2.format(PSD5):"0.000"));
        chkD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD5.isChecked()){
                    edtD5.setText(df2.format(PSD5));
                    checked.set(0,true);
                }else{
                    edtD5.setText("0.000");
                    checked.set(0,false);
                }
            }
        });

        chkD6.setChecked(checked.get(1));
        edtD6.setText((chkD6.isChecked()?df2.format(PSD6):"0.000"));
        chkD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD6.isChecked()){
                    edtD6.setText(df2.format(PSD6));
                    checked.set(1,true);
                }else{
                    edtD6.setText("0.000");
                    checked.set(1,false);
                }
            }
        });


        chkD7.setChecked(checked.get(2));
        edtD7.setText((chkD7.isChecked()?df2.format(PSD7):"0.000"));
        chkD7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD7.isChecked()){
                    edtD7.setText(df2.format(PSD7));
                    checked.set(2,true);
                }else{
                    edtD7.setText("0.000");
                    checked.set(2,false);
                }
            }
        });

        chkD8.setChecked(checked.get(3));
        edtD8.setText((chkD8.isChecked()?df2.format(PSD8):"0.000"));
        chkD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD8.isChecked()){
                    edtD8.setText(df2.format(PSD8));
                    checked.set(3,true);
                }else{
                    edtD8.setText("0.000");
                    checked.set(3,false);
                }
            }
        });

        chkD9.setChecked(checked.get(4));
        edtD9.setText((chkD9.isChecked()?df2.format(PSD9):"0.000"));
        chkD9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD9.isChecked()){
                    edtD9.setText(df2.format(PSD9));
                    checked.set(4,true);
                }else{
                    edtD9.setText("0.000");
                    checked.set(4,false);
                }
            }
        });
        chkD10.setChecked(checked.get(5));
        edtD10.setText((chkD10.isChecked()?df2.format(PSD10):"0.000"));
        chkD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD10.isChecked()){
                    edtD10.setText(df2.format(PSD10));
                    checked.set(5,true);
                }else{
                    edtD10.setText("0.000");
                    checked.set(5,false);
                }
            }
        });
        chkD11.setChecked(checked.get(6));
        edtD11.setText((chkD11.isChecked()?df2.format(PSD11):"0.000"));
        chkD11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD11.isChecked()){
                    edtD11.setText(df2.format(PSD11));
                    checked.set(6,true);
                }else{
                    edtD11.setText("0.000");
                    checked.set(6,false);
                }
            }
        });
        chkD12.setChecked(checked.get(7));
        edtD12.setText((chkD12.isChecked()?df2.format(PSD12):"0.000"));
        chkD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD12.isChecked()){
                    edtD12.setText(df2.format(PSD12));
                    checked.set(7,true);
                }else{
                    edtD12.setText("0.000");
                    checked.set(7,false);
                }
            }
        });
        chkD13.setChecked(checked.get(8));
        edtD13.setText((chkD13.isChecked()?df2.format(PSD13):"0.000"));
        chkD13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD13.isChecked()){
                    edtD13.setText(df2.format(PSD13));
                    checked.set(8,true);
                }else{
                    edtD13.setText("0.000");
                    checked.set(8,false);
                }
            }
        });
        chkD14.setChecked(checked.get(9));
        edtD14.setText((chkD14.isChecked()?df2.format(PSD14):"0.000"));
        chkD14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD14.isChecked()){
                    edtD14.setText(df2.format(PSD14));
                    checked.set(9,true);
                }else{
                    edtD14.setText("0.000");
                    checked.set(9,false);
                }
            }
        });
        chkD15.setChecked(checked.get(10));
        edtD15.setText((chkD15.isChecked()?df2.format(PSD15):"0.000"));
        chkD15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD15.isChecked()){
                    edtD15.setText(df2.format(PSD15));
                    checked.set(10,true);
                }else{
                    edtD15.setText("0.000");
                    checked.set(10,false);
                }
            }
        });
        chkD16.setChecked(checked.get(11));
        edtD16.setText((chkD16.isChecked()?df2.format(PSD16):"0.000"));
        chkD16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD16.isChecked()){
                    edtD16.setText(df2.format(PSD16));
                    checked.set(11,true);
                }else{
                    edtD16.setText("0.000");
                    checked.set(11,false);
                }
            }
        });
        chkD17.setChecked(checked.get(12));
        edtD17.setText((chkD17.isChecked()?df2.format(PSD17):"0.000"));
        chkD17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD17.isChecked()){
                    edtD17.setText(df2.format(PSD17));
                    checked.set(12,true);
                }else{
                    edtD17.setText("0.000");
                    checked.set(12,false);
                }
            }
        });
        chkD18.setChecked(checked.get(13));
        edtD18.setText((chkD18.isChecked()?df2.format(PSD18):"0.000"));
        chkD18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD18.isChecked()){
                    edtD18.setText(df2.format(PSD18));
                    checked.set(13,true);
                }else{
                    edtD18.setText("0.000");
                    checked.set(13,false);
                }
            }
        });
        chkD19.setChecked(checked.get(14));
        edtD19.setText((chkD19.isChecked()?df2.format(PSD19):"0.000"));
        chkD19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD19.isChecked()){
                    edtD19.setText(df2.format(PSD19));
                    checked.set(14,true);
                }else{
                    edtD19.setText("0.000");
                    checked.set(14,false);
                }
            }
        });
        chkD20.setChecked(checked.get(15));
        edtD20.setText((chkD20.isChecked()?df2.format(PSD20):"0.000"));
        chkD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD20.isChecked()){
                    edtD20.setText(df2.format(PSD20));
                    checked.set(15,true);
                }else{
                    edtD20.setText("0.000");
                    checked.set(15,false);
                }
            }
        });
        chkD21.setChecked(checked.get(16));
        edtD21.setText((chkD21.isChecked()?df2.format(PSD21):"0.000"));
        chkD21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD21.isChecked()){
                    edtD21.setText(df2.format(PSD21));
                    checked.set(16,true);
                }else{
                    edtD21.setText("0.000");
                    checked.set(16,false);
                }
            }
        });
        chkD22.setChecked(checked.get(17));
        edtD22.setText((chkD22.isChecked()?df2.format(PSD22):"0.000"));
        chkD22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD22.isChecked()){
                    edtD22.setText(df2.format(PSD22));
                    checked.set(17,true);
                }else{
                    edtD22.setText("0.000");
                    checked.set(17,false);
                }
            }
        });
        chkD23.setChecked(checked.get(18));
        edtD23.setText((chkD23.isChecked()?df2.format(PSD23):"0.000"));
        chkD23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD23.isChecked()){
                    edtD23.setText(df2.format(PSD23));
                    checked.set(18,true);
                }else{
                    edtD23.setText("0.000");
                    checked.set(18,false);
                }
            }
        });
        chkD24.setChecked(checked.get(19));
        edtD24.setText((chkD24.isChecked()?df2.format(PSD24):"0.000"));
        chkD24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD24.isChecked()){
                    edtD24.setText(df2.format(PSD24));
                    checked.set(19,true);
                }else{
                    edtD24.setText("0.000");
                    checked.set(19,false);
                }
            }
        });
        chkD25.setChecked(checked.get(20));
        edtD25.setText((chkD25.isChecked()?df2.format(PSD25):"0.000"));
        chkD25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD25.isChecked()){
                    edtD25.setText(df2.format(PSD25));
                    checked.set(20,true);
                }else{
                    edtD25.setText("0.000");
                    checked.set(20,false);
                }
            }
        });
        chkD26.setChecked(checked.get(21));
        edtD26.setText((chkD26.isChecked()?df2.format(PSD26):"0.000"));
        chkD26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD26.isChecked()){
                    edtD26.setText(df2.format(PSD26));
                    checked.set(21,true);
                }else{
                    edtD26.setText("0.000");
                    checked.set(21,false);
                }
            }
        });

    }

}
