package com.conceptplays.komsonasa.elancopro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.conceptplays.komsonasa.elancopro.Class.HelperClass;
import com.conceptplays.komsonasa.elancopro.DB.DataBaseAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class InjectionPerWeekActivity extends Activity {
    DataBaseAdapter db;
    HelperClass hc;
    FeedSowsFragment pop;

    String Option = null, drugName,title,module;
    String drugPrice;
    Long ListID;
    CheckBox chkD5,chkD6,chkD7,chkD8,chkD9,chkD10,chkD11,chkD12,chkD13,chkD14,chkD15,chkD16,chkD17;
    CheckBox chkD18,chkD19,chkD20,chkD21,chkD22,chkD23,chkD24,chkD25,chkD26,chkD27,chkD28,chkD29,chkD30;
    CheckBox chkD31,chkD32,chkD33,chkD34,chkD35,chkD36,chkD37,chkD38,chkD39,chkD40,chkD41,chkD42,chkD43;
    CheckBox chkD44,chkD45,chkD46,chkD47,chkD48,chkD49,chkD50,chkD51,chkD52,chkD53,chkD54,chkD55,chkD56;
    CheckBox chkD57,chkD58,chkD59;

    Double   M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22,M23,M24,M25;
    Double   PSD5,PSD6,PSD7,PSD8,PSD9,PSD10,PSD11,PSD12,PSD13,PSD14,PSD15,PSD16,PSD17,PSD18,PSD19,PSD20,PSD21,PSD22,PSD23,PSD24,PSD25,PSD26;
    Double   CONST5,CONST6,CONST7,CONST8,CONST9,CONST10,CONST11,CONST12,CONST13,CONST14,CONST15,CONST16,CONST17,CONST18,CONST19;
    Double   CONST20,CONST21,CONST22,CONST23,CONST24,CONST25,CONST26,CONST27,CONST28,CONST29,CONST30,CONST31,CONST32,CONST33,CONST34;
    Double   CONST35,CONST36,CONST37,CONST38,CONST39,CONST40,CONST41,CONST42,CONST43,CONST44,CONST45,CONST46,CONST47,CONST48,CONST49;
    Double   CONST50,CONST51,CONST52,CONST53,CONST54,CONST55,CONST56,CONST57,CONST58,CONST59;

    ArrayList<Boolean> checked = new ArrayList<Boolean>();
    ArrayList<Double> sumVal = new ArrayList<Double>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hide keyboard on lunch
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        setContentView(R.layout.activity_injection_per_week);

        ListID  = getIntent().getExtras().getLong("listID");
        Option = getIntent().getExtras().getString("option");
        drugName = getIntent().getExtras().getString("drugName");
        drugPrice = getIntent().getExtras().getString("drugPrice");
        title = getIntent().getExtras().getString("title");
        module = getIntent().getExtras().getString("module");

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
        pop = new FeedSowsFragment();

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
        chkD27 = (CheckBox)findViewById(R.id.chkD27);
        chkD28 = (CheckBox)findViewById(R.id.chkD28);
        chkD29 = (CheckBox)findViewById(R.id.chkD29);
        chkD30 = (CheckBox)findViewById(R.id.chkD30);
        chkD31 = (CheckBox)findViewById(R.id.chkD31);
        chkD32 = (CheckBox)findViewById(R.id.chkD32);
        chkD33 = (CheckBox)findViewById(R.id.chkD33);
        chkD34 = (CheckBox)findViewById(R.id.chkD34); // END SOWS
        chkD35 = (CheckBox)findViewById(R.id.chkD35);
        chkD36 = (CheckBox)findViewById(R.id.chkD36);
        chkD37 = (CheckBox)findViewById(R.id.chkD37);
        chkD38 = (CheckBox)findViewById(R.id.chkD38);
        chkD39 = (CheckBox)findViewById(R.id.chkD39);
        chkD40 = (CheckBox)findViewById(R.id.chkD40);
        chkD41 = (CheckBox)findViewById(R.id.chkD41);
        chkD42 = (CheckBox)findViewById(R.id.chkD42);
        chkD43 = (CheckBox)findViewById(R.id.chkD43);
        chkD44 = (CheckBox)findViewById(R.id.chkD44);
        chkD45 = (CheckBox)findViewById(R.id.chkD45);
        chkD46 = (CheckBox)findViewById(R.id.chkD46);
        chkD47 = (CheckBox)findViewById(R.id.chkD47);
        chkD48 = (CheckBox)findViewById(R.id.chkD48);
        chkD49 = (CheckBox)findViewById(R.id.chkD49);
        chkD50 = (CheckBox)findViewById(R.id.chkD50);
        chkD51 = (CheckBox)findViewById(R.id.chkD51);
        chkD52 = (CheckBox)findViewById(R.id.chkD52);
        chkD53 = (CheckBox)findViewById(R.id.chkD53);
        chkD54 = (CheckBox)findViewById(R.id.chkD54);
        chkD55 = (CheckBox)findViewById(R.id.chkD55);
        chkD56 = (CheckBox)findViewById(R.id.chkD56);
        chkD57 = (CheckBox)findViewById(R.id.chkD57);
        chkD58 = (CheckBox)findViewById(R.id.chkD58);
        chkD59 = (CheckBox)findViewById(R.id.chkD59);

        getData();
        getPopB();
        setData();

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
        getPopB();
        Double sum = 0.000000000, cost,costPiglet,price = 0.0000000, sumOfPiglet = 0.000000000;
        StringBuilder opt = new StringBuilder();

        for (int i=1; i<=checked.size(); i++){
            if(checked.get(i-1)==true){
                opt.append("1");
                sum = sum+sumVal.get(i-1);
                if(i<=30){
                    sumOfPiglet = sumOfPiglet+sumVal.get(i-1);
                }
            }else{
                opt.append("0");
            }

        }
        String totalPiglet = hc.df9(sumOfPiglet);
        sumOfPiglet = hc.string2double9df(totalPiglet);


        String total = hc.df9(sum);
        sum = hc.string2double9df(total);
        price = hc.string2double(drugPrice);
        cost = sum*price;
        String Cost = hc.df2(cost);
        cost = hc.string2double(Cost);

        ContentValues cv = new ContentValues();
        cv.clear();

        cv.put(db.DRUG_SOW_PERSOW_OPTION, opt.toString());
        cv.put(db.DRUG_SOW_PERSOW_COST, cost);
        cv.put(db.DRUG_SOW_PERSOW_TOTAL, sum);
        cv.put("piglet_total", sumOfPiglet);

        db.open();
        long id;
        if(module.equals("vaccine")){
            id = db.updateRow(db.VACCINE_COST_TABLE, cv, ListID);
        }else {
            id = db.updateRow(db.INJECTION_COST_TABLE, cv, ListID);
        }
        db.close();
        if(id>0) {
            finish();
        }

    }

    private void getData() {
        db.open();
        Cursor cursor;
        if(module.equals("vaccine")) {
            cursor = db.getRow(db.VACCINE_COST_TABLE, Long.valueOf(ListID));
        }else{
            cursor = db.getRow(db.INJECTION_COST_TABLE, Long.valueOf(ListID));
        }
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                Option = String.valueOf(cursor.getString(3));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    public void getPopB(){
        ArrayList ar = pop.getB(this.db);
        CONST5 = Double.valueOf(ar.get(5).toString()); //Population(B6)
        //chkD5.setText(hc.df9(CONST5));
        CONST6 = Double.valueOf(ar.get(5).toString());
        CONST7 = Double.valueOf(ar.get(5).toString());
        CONST8 = Double.valueOf(ar.get(5).toString());
        CONST9 = Double.valueOf(ar.get(5).toString());
        CONST10 = Double.valueOf(ar.get(5).toString());
        CONST11 = Double.valueOf(ar.get(5).toString());
        CONST12 = Double.valueOf(ar.get(5).toString());

        CONST13 = Double.valueOf(ar.get(10).toString()); //Population(B11)
        CONST14 = Double.valueOf(ar.get(11).toString());
        CONST15 = Double.valueOf(ar.get(12).toString());
        CONST16 = Double.valueOf(ar.get(13).toString());
        CONST17 = Double.valueOf(ar.get(14).toString());
        CONST18 = Double.valueOf(ar.get(15).toString());
        CONST19 = Double.valueOf(ar.get(16).toString());
        CONST20 = Double.valueOf(ar.get(17).toString());
        CONST21 = Double.valueOf(ar.get(18).toString());
        CONST22 = Double.valueOf(ar.get(19).toString());
        CONST23 = Double.valueOf(ar.get(20).toString());
        CONST24 = Double.valueOf(ar.get(21).toString());
        CONST25 = Double.valueOf(ar.get(22).toString());
        CONST26 = Double.valueOf(ar.get(23).toString());
        CONST27 = Double.valueOf(ar.get(24).toString());
        CONST28 = Double.valueOf(ar.get(25).toString());
        CONST29 = Double.valueOf(ar.get(26).toString());

        CONST30 = Double.valueOf(ar.get(4).toString()); //Population(B5) = FeedConsumption(F23)
        CONST31 = Double.valueOf(ar.get(5).toString());
        CONST32 = Double.valueOf(ar.get(6).toString());

        CONST33 = Double.valueOf(ar.get(8).toString()); //Population(B9) = FeedConsumption(F4)
        CONST34 = Double.valueOf(ar.get(9).toString());


        CONST35 = Double.valueOf(ar.get(30).toString()); //Population(B31)
        CONST36 = Double.valueOf(ar.get(31).toString());
        CONST37 = Double.valueOf(ar.get(32).toString());

        CONST38 = Double.valueOf(ar.get(36).toString()); //Population(B37)
        CONST39 = Double.valueOf(ar.get(37).toString());
        CONST40 = Double.valueOf(ar.get(38).toString());
        CONST41 = Double.valueOf(ar.get(39).toString());
        CONST42 = Double.valueOf(ar.get(40).toString());
        CONST43 = Double.valueOf(ar.get(41).toString());

        CONST44 = Double.valueOf(ar.get(44).toString()); //Population(B45)
        CONST45 = Double.valueOf(ar.get(45).toString());
        CONST46 = Double.valueOf(ar.get(46).toString());
        CONST47 = Double.valueOf(ar.get(47).toString());
        CONST48 = Double.valueOf(ar.get(48).toString());
        CONST49 = Double.valueOf(ar.get(49).toString());
        CONST50 = Double.valueOf(ar.get(50).toString());
        CONST51 = Double.valueOf(ar.get(51).toString());
        CONST52 = Double.valueOf(ar.get(52).toString());
        CONST53 = Double.valueOf(ar.get(53).toString());
        CONST54 = Double.valueOf(ar.get(54).toString());
        CONST55 = Double.valueOf(ar.get(55).toString());
        CONST56 = Double.valueOf(ar.get(56).toString());
        CONST57 = Double.valueOf(ar.get(57).toString());
        CONST58 = Double.valueOf(ar.get(58).toString());
        CONST59 = Double.valueOf(ar.get(59).toString());

        sumVal.set(0,CONST5);
        sumVal.set(1,CONST6);
        sumVal.set(2,CONST7);
        sumVal.set(3,CONST8);
        sumVal.set(4,CONST9);
        sumVal.set(5,CONST10);
        sumVal.set(6,CONST11);
        sumVal.set(7,CONST12);
        sumVal.set(8,CONST13);
        sumVal.set(9,CONST14);
        sumVal.set(10,CONST15);
        sumVal.set(11,CONST16);
        sumVal.set(12,CONST17);
        sumVal.set(13,CONST18);
        sumVal.set(14,CONST19);
        sumVal.set(15,CONST20);
        sumVal.set(16,CONST21);
        sumVal.set(17,CONST22);
        sumVal.set(18,CONST23);
        sumVal.set(19,CONST24);
        sumVal.set(20,CONST25);
        sumVal.set(21,CONST26);
        sumVal.set(22,CONST27);
        sumVal.set(23,CONST28);
        sumVal.set(24,CONST29);
        sumVal.set(25,CONST30);
        sumVal.set(26,CONST31);
        sumVal.set(27,CONST32);
        sumVal.set(28,CONST33);
        sumVal.set(29,CONST34);
        sumVal.set(30,CONST35);
        sumVal.set(31,CONST36);
        sumVal.set(32,CONST37);
        sumVal.set(33,CONST38);
        sumVal.set(34,CONST39);
        sumVal.set(35,CONST40);
        sumVal.set(36,CONST41);
        sumVal.set(37,CONST42);
        sumVal.set(38,CONST43);
        sumVal.set(39,CONST44);
        sumVal.set(40,CONST45);
        sumVal.set(41,CONST46);
        sumVal.set(42,CONST47);
        sumVal.set(43,CONST48);
        sumVal.set(44,CONST49);
        sumVal.set(45,CONST50);
        sumVal.set(46,CONST51);
        sumVal.set(47,CONST52);
        sumVal.set(48,CONST53);
        sumVal.set(49,CONST54);
        sumVal.set(50,CONST55);
        sumVal.set(51,CONST56);
        sumVal.set(52,CONST57);
        sumVal.set(53,CONST58);
        sumVal.set(54,CONST59);

    }

    private void setData(){
        final DecimalFormat df2 = new DecimalFormat("#,###,###.###");

        chkD5.setChecked(checked.get(0));
        chkD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD5.isChecked()){
                    checked.set(0,true);
                }else{
                    checked.set(0,false);
                }
            }
        });

        chkD6.setChecked(checked.get(1));
        chkD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD6.isChecked()){
                    checked.set(1,true);
                }else{
                    checked.set(1,false);
                }
            }
        });


        chkD7.setChecked(checked.get(2));
        chkD7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD7.isChecked()){
                    checked.set(2,true);
                }else{
                    checked.set(2,false);
                }
            }
        });

        chkD8.setChecked(checked.get(3));
        chkD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD8.isChecked()){
                    checked.set(3,true);
                }else{
                    checked.set(3,false);
                }
            }
        });

        chkD9.setChecked(checked.get(4));
        chkD9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD9.isChecked()){
                    checked.set(4,true);
                }else{
                    checked.set(4,false);
                }
            }
        });
        chkD10.setChecked(checked.get(5));
        chkD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD10.isChecked()){
                    checked.set(5,true);
                }else{
                    checked.set(5,false);
                }
            }
        });
        chkD11.setChecked(checked.get(6));
        chkD11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD11.isChecked()){
                    checked.set(6,true);
                }else{
                    checked.set(6,false);
                }
            }
        });
        chkD12.setChecked(checked.get(7));
        chkD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD12.isChecked()){
                    checked.set(7,true);
                }else{
                    checked.set(7,false);
                }
            }
        });
        chkD13.setChecked(checked.get(8));
        chkD13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD13.isChecked()){
                    checked.set(8,true);
                }else{
                    checked.set(8,false);
                }
            }
        });
        chkD14.setChecked(checked.get(9));
        chkD14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD14.isChecked()){
                    checked.set(9,true);
                }else{
                    checked.set(9,false);
                }
            }
        });
        chkD15.setChecked(checked.get(10));
        chkD15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD15.isChecked()){
                    checked.set(10,true);
                }else{
                    checked.set(10,false);
                }
            }
        });
        chkD16.setChecked(checked.get(11));
        chkD16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD16.isChecked()){
                    checked.set(11,true);
                }else{
                    checked.set(11,false);
                }
            }
        });
        chkD17.setChecked(checked.get(12));
        chkD17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD17.isChecked()){
                    checked.set(12,true);
                }else{
                    checked.set(12,false);
                }
            }
        });
        chkD18.setChecked(checked.get(13));
        chkD18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD18.isChecked()){
                    checked.set(13,true);
                }else{
                    checked.set(13,false);
                }
            }
        });
        chkD19.setChecked(checked.get(14));
        chkD19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD19.isChecked()){
                    checked.set(14,true);
                }else{
                    checked.set(14,false);
                }
            }
        });
        chkD20.setChecked(checked.get(15));
        chkD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD20.isChecked()){
                    checked.set(15,true);
                }else{
                    checked.set(15,false);
                }
            }
        });
        chkD21.setChecked(checked.get(16));
        chkD21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD21.isChecked()){
                    checked.set(16,true);
                }else{
                    checked.set(16,false);
                }
            }
        });
        chkD22.setChecked(checked.get(17));
        chkD22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD22.isChecked()){
                    checked.set(17,true);
                }else{
                    checked.set(17,false);
                }
            }
        });
        chkD23.setChecked(checked.get(18));
        chkD23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD23.isChecked()){
                    checked.set(18,true);
                }else{
                    checked.set(18,false);
                }
            }
        });
        chkD24.setChecked(checked.get(19));
        chkD24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD24.isChecked()){
                    checked.set(19,true);
                }else{
                    checked.set(19,false);
                }
            }
        });
        chkD25.setChecked(checked.get(20));
        chkD25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD25.isChecked()){
                    checked.set(20,true);
                }else{
                    checked.set(20,false);
                }
            }
        });

        chkD26.setChecked(checked.get(21));
        chkD26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD26.isChecked()){
                    checked.set(21,true);
                }else{
                    checked.set(21,false);
                }
            }
        });

        chkD27.setChecked(checked.get(22));
        chkD27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD27.isChecked()){
                    checked.set(22,true);
                }else{
                    checked.set(22,false);
                }
            }
        });
        chkD28.setChecked(checked.get(23));
        chkD28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD28.isChecked()){
                    checked.set(23,true);
                }else{
                    checked.set(23,false);
                }
            }
        });

        chkD29.setChecked(checked.get(24));
        chkD29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD29.isChecked()){
                    checked.set(24,true);
                }else{
                    checked.set(24,false);
                }
            }
        });

        chkD30.setChecked(checked.get(25));
        chkD30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD30.isChecked()){
                    checked.set(25,true);
                }else{
                    checked.set(25,false);
                }
            }
        });
        chkD31.setChecked(checked.get(26));
        chkD31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD31.isChecked()){
                    checked.set(26,true);
                }else{
                    checked.set(26,false);
                }
            }
        });
        chkD32.setChecked(checked.get(1+26));
        chkD32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD32.isChecked()){
                    checked.set(1+26,true);
                }else{
                    checked.set(1+26,false);
                }
            }
        });
        chkD33.setChecked(checked.get(1+27));
        chkD33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD33.isChecked()){
                    checked.set(1+27,true);
                }else{
                    checked.set(1+27,false);
                }
            }
        });
        chkD34.setChecked(checked.get(1+28));
        chkD34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD34.isChecked()){
                    checked.set(1+28,true);
                }else{
                    checked.set(1+28,false);
                }
            }
        });
        chkD35.setChecked(checked.get(1+29));
        chkD35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD35.isChecked()){
                    checked.set(1+29,true);
                }else{
                    checked.set(1+29,false);
                }
            }
        });
        chkD36.setChecked(checked.get(1+30));
        chkD36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD36.isChecked()){
                    checked.set(1+30,true);
                }else{
                    checked.set(1+30,false);
                }
            }
        });
        chkD37.setChecked(checked.get(1+31));
        chkD37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD37.isChecked()){
                    checked.set(1+31,true);
                }else{
                    checked.set(1+31,false);
                }
            }
        });
        chkD38.setChecked(checked.get(1+32));
        chkD38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD38.isChecked()){
                    checked.set(1+32,true);
                }else{
                    checked.set(1+32,false);
                }
            }
        });
        chkD39.setChecked(checked.get(1+33));
        chkD39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD39.isChecked()){
                    checked.set(1+33,true);
                }else{
                    checked.set(1+33,false);
                }
            }
        });
        chkD40.setChecked(checked.get(1+34));
        chkD40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD40.isChecked()){
                    checked.set(1+34,true);
                }else{
                    checked.set(1+34,false);
                }
            }
        });
        chkD41.setChecked(checked.get(1+35));
        chkD41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD41.isChecked()){
                    checked.set(1+35,true);
                }else{
                    checked.set(1+35,false);
                }
            }
        });
        chkD42.setChecked(checked.get(1+36));
        chkD42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD42.isChecked()){
                    checked.set(1+36,true);
                }else{
                    checked.set(1+36,false);
                }
            }
        });
        chkD43.setChecked(checked.get(1+37));
        chkD43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD43.isChecked()){
                    checked.set(1+37,true);
                }else{
                    checked.set(1+37,false);
                }
            }
        });
        chkD44.setChecked(checked.get(1+38));
        chkD44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD44.isChecked()){
                    checked.set(1+38,true);
                }else{
                    checked.set(1+38,false);
                }
            }
        });
        chkD45.setChecked(checked.get(1+39));
        chkD45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD45.isChecked()){
                    checked.set(1+39,true);
                }else{
                    checked.set(1+39,false);
                }
            }
        });
        chkD46.setChecked(checked.get(1+40));
        chkD46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD46.isChecked()){
                    checked.set(1+40,true);
                }else{
                    checked.set(1+40,false);
                }
            }
        });
        chkD47.setChecked(checked.get(1+41));
        chkD47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD47.isChecked()){
                    checked.set(1+41,true);
                }else{
                    checked.set(1+41,false);
                }
            }
        });
        chkD48.setChecked(checked.get(1+42));
        chkD48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD48.isChecked()){
                    checked.set(1+42,true);
                }else{
                    checked.set(1+42,false);
                }
            }
        });
        chkD49.setChecked(checked.get(1+43));
        chkD49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD49.isChecked()){
                    checked.set(1+43,true);
                }else{
                    checked.set(1+43,false);
                }
            }
        });
        chkD50.setChecked(checked.get(1+44));
        chkD50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD50.isChecked()){
                    checked.set(1+44,true);
                }else{
                    checked.set(1+44,false);
                }
            }
        });
        chkD51.setChecked(checked.get(1+45));
        chkD51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD51.isChecked()){
                    checked.set(1+45,true);
                }else{
                    checked.set(1+45,false);
                }
            }
        });
        chkD52.setChecked(checked.get(1+46));
        chkD52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD52.isChecked()){
                    checked.set(1+46,true);
                }else{
                    checked.set(1+46,false);
                }
            }
        });
        chkD53.setChecked(checked.get(1+47));
        chkD53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD53.isChecked()){
                    checked.set(1+47,true);
                }else{
                    checked.set(1+47,false);
                }
            }
        });
        chkD54.setChecked(checked.get(1+48));
        chkD54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD54.isChecked()){
                    checked.set(1+48,true);
                }else{
                    checked.set(1+48,false);
                }
            }
        });
        chkD55.setChecked(checked.get(1+49));
        chkD55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD55.isChecked()){
                    checked.set(1+49,true);
                }else{
                    checked.set(1+49,false);
                }
            }
        });
        chkD56.setChecked(checked.get(1+50));
        chkD56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD56.isChecked()){
                    checked.set(1+50,true);
                }else{
                    checked.set(1+50,false);
                }
            }
        });
        chkD57.setChecked(checked.get(1+51));
        chkD57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD57.isChecked()){
                    checked.set(1+51,true);
                }else{
                    checked.set(1+51,false);
                }
            }
        });
        chkD58.setChecked(checked.get(1+52));
        chkD58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD58.isChecked()){
                    checked.set(1+52,true);
                }else{
                    checked.set(1+52,false);
                }
            }
        });
        chkD59.setChecked(checked.get(1+53));
        chkD59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkD59.isChecked()){
                    checked.set(1+52,true);
                }else{
                    checked.set(1+52,false);
                }
            }
        });



    }

}
