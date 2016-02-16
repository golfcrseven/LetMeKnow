package com.conceptplays.komsonasa.elancopro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.conceptplays.komsonasa.elancopro.DB.DataBaseAdapter;
import com.conceptplays.komsonasa.letmeknow.R;

import java.util.ArrayList;
import java.util.List;

public class AddInjectionActivity extends Activity {
    DataBaseAdapter db;
    ListView Medicine;
    ArrayList Drug_value;
    TextView tvEmpty;
    String title;
    public class medicineChapter {
        Integer chapterID;
        String chapterName;
        String chapterPrice;
    }
    MedicineAdapter chapterListAdapter;

    checkBoxChapter chkListAdapter;
    ArrayList<checkBoxChapter> chkList = new ArrayList<checkBoxChapter>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drugs);
        Drug_value = getIntent().getExtras().getCharSequenceArrayList("listID");
        title = getIntent().getExtras().getString("title");

        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.list_background)));
        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.mytitle, null);

        ((TextView)v.findViewById(R.id.myTitleTxt)).setText(title);
        ImageButton btnSlideMenu = (ImageButton)v.findViewById(R.id.btnSlideMenu);
        btnSlideMenu.setVisibility(View.GONE);
        Button btnAdd = (Button)v.findViewById(R.id.btnAddMedicine);
        btnAdd.setVisibility(View.VISIBLE);
        btnAdd.setText("Done");
        btnAdd.setTextSize(15);

        //assign the view to the actionbar
        this.getActionBar().setCustomView(v);



        db = new DataBaseAdapter(this);
        chapterListAdapter = new MedicineAdapter();
        chkListAdapter = new checkBoxChapter(null,false);

        Medicine = (ListView)findViewById(R.id.listView2);
        tvEmpty = (TextView)findViewById(android.R.id.empty);
        tvEmpty.setVisibility(View.INVISIBLE);
        if(chapterListAdapter.getCount()==0){
            tvEmpty.setVisibility(View.VISIBLE);
        }

        Medicine.setAdapter(chapterListAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkData();
            }


        });


    }
    private  void chkData(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you confirm to add item?");
        dialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {

            }
        });
        dialog.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                insertData();

            }
        });
        dialog.show();
    }
    private void insertData(){

        StringBuffer responseText = new StringBuffer();
        db.open();
        for(int i=0;i<chapterListAdapter.medicineChapterList.size();i++){
            chkListAdapter = chkList.get(i);
            if(chkListAdapter.isSelected()){
                int DrugID = Integer.valueOf(chkListAdapter.getId());
                responseText.append(DrugID+"\n");
                addDrug(DrugID);
            }
        }
        db.close();
        //Toast.makeText(getApplicationContext(),responseText, Toast.LENGTH_LONG).show();
        finish();
    }

    private long addDrug(int drugID) {
        ContentValues cv = new ContentValues();
        cv.clear();

        cv.put(db.DRUG_ID, drugID);
        cv.put(db.DRUG_SOW_PERSOW_USAGE, 0.00);
        cv.put(db.DRUG_SOW_PERSOW_OPTION, "0000000000000000000000000000000000000000000000000000000");
        cv.put(db.DRUG_SOW_PERSOW_COST, 0.00);
        cv.put(db.DRUG_SOW_PERSOW_TOTAL, 0.00);


        long id;
        if(title.equals("Add Injection(Per Week)")) {
            id = db.insertRow(db.INJECTION_COST_TABLE, cv);
        }else{
            id = db.insertRow(db.VACCINE_COST_TABLE, cv);
        }
        if(id>0){
            return 1;
        }else{
            return 0;
        }

    }


    public class checkBoxChapter{
        boolean selected = false;
        Integer drugID = null;

        public checkBoxChapter(Integer drugID, boolean selected) {
            super();
            this.drugID = drugID;
            this.selected = selected;
        }
        public Integer getId() {
            return drugID;
        }
        public void setId(Integer drugID) {
            this.drugID = drugID;
        }

        public boolean isSelected() {
            return selected;
        }
        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    public class MedicineAdapter extends BaseAdapter {

        List<medicineChapter> medicineChapterList = getDataForListView();
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return medicineChapterList.size();
        }

        @Override
        public medicineChapter getItem(int arg0) {
            // TODO Auto-generated method stub
            return medicineChapterList.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        private class ViewHolder {
            CheckBox chkBox;
            LinearLayout layout;
        }
        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            ViewHolder holder = null;

            if(convertView==null)
            {

                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                convertView = inflater.inflate(R.layout.mylist2, parent,false);
            }

            TextView chapterName = (TextView)convertView.findViewById(R.id.medicineName);
            TextView chapterNo = (TextView)convertView.findViewById(R.id.medecine_no);

            final medicineChapter chapter = medicineChapterList.get(position);

            chapterName.setText(chapter.chapterName);
            chapterNo.setText((position + 1) + ")");
            if((position%2)==0)
                convertView.setBackgroundColor(Color.parseColor("#ebebeb"));

            holder = new ViewHolder();
            holder.chkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            holder.layout = (LinearLayout)convertView.findViewById(R.id.layout_list_2);
            convertView.setTag(holder);

            final checkBoxChapter chkChapter = chkList.get(position);

            final ViewHolder finalHolder = holder;
            holder.layout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if(finalHolder.chkBox.isChecked()){
                        finalHolder.chkBox.setChecked(false);
                        chkChapter.setSelected(false);
                    }else{
                        finalHolder.chkBox.setChecked(true);
                        chkChapter.setSelected(true);
                    }
                }
            });
            holder.chkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CheckBox cb = (CheckBox) view;
                    chkChapter.setSelected(cb.isChecked());

                }
            });

            return convertView;
        }

        public medicineChapter getMedicineChapter(int position)
        {
            return medicineChapterList.get(position);
        }

    }

    public List<medicineChapter> getDataForListView()
    {
        List<medicineChapter> medicineChaptersList = new ArrayList<medicineChapter>();

        db.open();
        Cursor cursor;
        if(title.equals("Add Injection(Per Week)")) {
            cursor = db.getAll(db.INJECTION_TABLE, "asc");
        }else{
            cursor = db.getAll(db.VACCINE_TABLE, "asc");
        }
        cursor.requery();

        if(cursor.moveToFirst()){
            do{

                medicineChapter chapter = new medicineChapter();
                checkBoxChapter chkChapter = new checkBoxChapter(null, false);

                if(Drug_value.contains(cursor.getString(0))){ //If don't have drug
                    //
                }else{
                    chkChapter.drugID = Integer.valueOf(cursor.getString(0));
                    chkChapter.setSelected(false);
                    chkList.add(chkChapter);

                    chapter.chapterID = Integer.valueOf(cursor.getString(0));
                    chapter.chapterName = cursor.getString(1);
                    chapter.chapterPrice = cursor.getString(2);
                    medicineChaptersList.add(chapter);

                }


            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return medicineChaptersList;

    }

}
