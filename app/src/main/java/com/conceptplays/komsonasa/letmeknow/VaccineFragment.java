package com.conceptplays.komsonasa.letmeknow;


import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.conceptplays.komsonasa.letmeknow.DB.DataBaseAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class VaccineFragment extends android.support.v4.app.Fragment {
    DataBaseAdapter db;
    ListView Medicine;
    public class medicineChapter {
        Integer chapterID;
        String chapterName;
        String chapterPrice;
    }
    MedicineAdapter chapterListAdapter;

    public VaccineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_AppCompat_Light);
        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);
        View v =  inflater.inflate(R.layout.fragment_medicine, container, false);

        db = new DataBaseAdapter(getActivity());

        Button btnAdd = (Button) getActivity().findViewById(R.id.btnAddMedicine);
        btnAdd.setVisibility(View.VISIBLE);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddDialog();
            }
        });

        chapterListAdapter = new MedicineAdapter();
        Medicine = (ListView)v.findViewById(R.id.listView1);
        Medicine.setAdapter(chapterListAdapter);

        Medicine.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View convertView, int position,
                                    long id) {
                //View Action in getView (MedicineAdapter)
                //Toast.makeText(getActivity(), chapter.chapterName, Toast.LENGTH_LONG).show();

            }
        });

        return v;
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

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {

            if(convertView==null)
            {

                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                convertView = inflater.inflate(R.layout.mylist, parent,false);

            }

            TextView chapterName = (TextView)convertView.findViewById(R.id.medicineName);
            TextView chapterDesc = (TextView)convertView.findViewById(R.id.Price);

            medicineChapter chapter = medicineChapterList.get(position);

            chapterName.setText(chapter.chapterName);
            chapterDesc.setText(chapter.chapterPrice);


            convertView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                   for (int j = 0; j < parent.getChildCount(); j++) {
                      parent.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);
                   }
                   view.setBackgroundColor(Color.parseColor(String.valueOf("#1d569a")));

                   medicineChapter chapter = chapterListAdapter.getMedicineChapter(position);
                   show_menu(chapter);

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
        cursor = db.getAll(db.VACCINE_TABLE, "asc");
        cursor.requery();

        if(cursor.moveToFirst()){
            do{

                medicineChapter chapter = new medicineChapter();
                chapter.chapterID = Integer.valueOf(cursor.getString(0));
                chapter.chapterName = cursor.getString(1);
                chapter.chapterPrice = cursor.getString(2);
                medicineChaptersList.add(chapter);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return medicineChaptersList;

    }

    private  void reloadAllData(){
        chapterListAdapter.medicineChapterList.clear();
        chapterListAdapter.medicineChapterList = getDataForListView();
        chapterListAdapter.notifyDataSetChanged();
    }

    public void show_menu(final medicineChapter chapter){
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity());
        builderSingle.setTitle("Select option");
        final CharSequence[]items = {
                "Edit", "Delete"
        };
        builderSingle.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builderSingle.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    showInputDialog(chapter.chapterID, chapter.chapterName, chapter.chapterPrice);
                }else {
                    AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                    builderInner.setMessage("Are you sure you wish to " + items[i] + "?");
                    builderInner.setTitle("Confirmation");

                    builderInner.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    builderInner.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if(deleted(Long.valueOf(chapter.chapterID))==false){
                                ShowDialog(getActivity(), "Error", "Can't delete data.", true, dialogInterface);
                            }else{
                                reloadAllData();
                                dialogInterface.dismiss();
                            }
                            //Toast.makeText(getActivity(), chapter.chapterID+"", Toast.LENGTH_LONG).show();

                        }
                    });
                    builderInner.show();
                }
            }
        });

        builderSingle.show();
    }

    protected void showInputDialog(final Integer chapterID, String chapterName, String chapterPrice){
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View promptView = inflater.inflate(R.layout.edit_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);

        final EditText editTextName = (EditText)promptView.findViewById(R.id.edtMedicineName);
        final EditText editTextPrice = (EditText)promptView.findViewById(R.id.edtMedicinePrice);
        TextView txtName = (TextView)promptView.findViewById(R.id.txtInpName);
        txtName.setText("Vaccine Name");

        editTextName.setText(chapterName);
        editTextPrice.setText(chapterPrice);

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = editTextName.getText().toString();
                        String price = editTextPrice.getText().toString();
                        if( name.equals("") || price.equals("")){
                            ShowDialog(getActivity(), "Error", "Data is not complete.", true, dialogInterface);
                        }else{
                            if (updateData(chapterID, name, price) == false ) {
                                ShowDialog(getActivity(), "Error", "Can't save data.", true, dialogInterface);
                            } else {
                                reloadAllData();
                                dialogInterface.dismiss();

                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    protected void showAddDialog(){
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View promptView = inflater.inflate(R.layout.edit_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);

        final EditText editTextName = (EditText)promptView.findViewById(R.id.edtMedicineName);
        final EditText editTextPrice = (EditText)promptView.findViewById(R.id.edtMedicinePrice);
        TextView txtName = (TextView)promptView.findViewById(R.id.txtInpName);
        txtName.setText("Vaccine Name");

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = editTextName.getText().toString();
                        String price = editTextPrice.getText().toString();
                        if( name.equals("") || price.equals("")){
                            ShowDialog(getActivity(), "Error", "Data is not complete.", true, dialogInterface);
                        }else{
                            if (insertData(name, price) == false) {
                                ShowDialog(getActivity(), "Error", "Can't save data.", true, dialogInterface);
                            } else {
                                reloadAllData();
                                scrollMyListViewToBottom();
                                dialogInterface.dismiss();

                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    protected boolean updateData(Integer chapterID, String name, String price){
        ContentValues cv = new ContentValues();
        cv.clear();
        cv.put(db.VACCINE_NAME, name);
        cv.put(db.VACCINE_PRICE, Double.valueOf(price));

        db.open();
        long id;
        id = db.updateRow(db.VACCINE_TABLE, cv, chapterID);
        db.close();
        if(id>0){
            return  true;
        }else{
            return  false;
        }

    }

    protected boolean insertData(String name, String price){
        ContentValues cv = new ContentValues();
        cv.clear();
        cv.put(db.VACCINE_NAME, name);
        cv.put(db.VACCINE_PRICE, Double.valueOf(price));

        db.open();
        long id;
        id = db.insertRow(db.VACCINE_TABLE, cv);
        db.close();
        if(id>0){
            return  true;
        }else{
            return  false;
        }

    }

    private boolean deleted(Long id){
        db.open();
        boolean bool;
        bool =  db.deleteRow(db.VACCINE_TABLE, id);
        db.close();
        return bool;
    }


    public void ShowDialog(final Context _context, String title, String message, final Boolean status, final DialogInterface dialogInterface){
        AlertDialog alertDialog = new AlertDialog.Builder(_context).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        //alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }

    private void scrollMyListViewToBottom(){
        Medicine.post(new Runnable() {
            @Override
            public void run() {
                Medicine.setSelection(chapterListAdapter.getCount()-1);
            }
        });
    }

}
