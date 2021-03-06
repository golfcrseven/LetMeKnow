package com.conceptplays.komsonasa.letmeknow;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.conceptplays.komsonasa.letmeknow.DB.DataBaseAdapter;


public class DataFragment extends DialogFragment {
	
	public DataFragment(){}

    DataBaseAdapter db;

    Boolean haveData = false;
    EditText edtNumSow ;
    EditText edtFarrowSow ;
    EditText edtReplc;
    EditText edtPigsWeanedLitter;
    EditText edtPreWeaned;
    EditText edtGrower;
    EditText edtWeanling;

    String numSow;
    String farrowSow;
    String replc;
    String pigsWeanedListter;
    String preWeaned;
    String weanLing;
    String grower;

	@Override
    public View onCreateView(LayoutInflater inflater,final ViewGroup container,
            Bundle savedInstanceState) {

        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme);
        LayoutInflater inflater1 = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);
        View v = inflater1.inflate(R.layout.fragment_data, null, false);

        final Button btnAdd = (Button) getActivity().findViewById(R.id.btnAddMedicine);
        btnAdd.setVisibility(View.VISIBLE);
        btnAdd.setText("Done");
        btnAdd.setTextSize(15);

        //Hide keyboard on lunch
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //Hide Scrollview Bar
        final ScrollView sView = (ScrollView)v.findViewById(R.id.scrollViewID);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        db = new DataBaseAdapter(getActivity());

        edtNumSow = (EditText)v.findViewById(R.id.edtNumSow);
        edtFarrowSow = (EditText)v.findViewById(R.id.edtFarrowSow);
        edtReplc = (EditText)v.findViewById(R.id.edtReplc);
        edtPigsWeanedLitter = (EditText)v.findViewById(R.id.edtPigsWeanedLitter);
        edtPreWeaned = (EditText)v.findViewById(R.id.edtPreWeaned);
        edtGrower = (EditText)v.findViewById(R.id.edtGrower);
        edtWeanling = (EditText)v.findViewById(R.id.edtWeanling);

        setData();

        Button btnConfrm = (Button)v.findViewById(R.id.btnConfirm);
        btnConfrm.setVisibility(View.GONE);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkData();
            }

        });

        return v;
    }
    private  void chkData(){
        Boolean error = false;
        numSow =  edtNumSow.getText().toString();
        farrowSow =  edtFarrowSow.getText().toString();
        replc =  edtReplc.getText().toString();
        pigsWeanedListter =  edtPigsWeanedLitter.getText().toString();
        preWeaned =  edtPreWeaned.getText().toString();
        weanLing =  edtWeanling.getText().toString();
        grower =  edtGrower.getText().toString();

        if(numSow.isEmpty()){
            error = true;
            edtNumSow.requestFocus();
        }else if(error == false && farrowSow.isEmpty()){
            error = true;
            edtFarrowSow.requestFocus();
        }else if(error == false && replc.isEmpty()){
            error = true;
            edtReplc.requestFocus();
        }else if(error == false && pigsWeanedListter.isEmpty()){
            error = true;
            edtPigsWeanedLitter.requestFocus();
        }else if(error == false && preWeaned.isEmpty()){
            error = true;
            edtPreWeaned.requestFocus();
        }else if(error == false && weanLing.isEmpty()){
            error = true;
            edtWeanling.requestFocus();
        }else if(error == false && grower.isEmpty()){
            error = true;
            edtGrower.requestFocus();
        }else{
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setMessage("Are you confirm to save data?");
            dialog.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    insertData();
                }
            });
            dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    // TODO Auto-generated method stub
                }
            });
            dialog.show();

        }

        if(error){
            ShowAlert(getActivity(), "Warning!", "Data is not complete!", true);
        }
    }
    private  void insertData(){
        ContentValues cv = new ContentValues();
        cv.clear();

        cv.put(db.DATA_G5, Double.valueOf(numSow));
        cv.put(db.DATA_G6, Double.valueOf(farrowSow));
        cv.put(db.DATA_G7, Double.valueOf(replc));
        cv.put(db.DATA_G8, Double.valueOf(pigsWeanedListter));
        cv.put(db.DATA_G9, Double.valueOf(preWeaned));
        cv.put(db.DATA_G10, Double.valueOf(weanLing));
        cv.put(db.DATA_G11, Double.valueOf(grower));

        db.open();
        long id;
        if(haveData==true){
            id = db.updateRow(db.INDEX_TABLE, cv, 1);
        }else{
            id = db.insertRow(db.INDEX_TABLE, cv);
        }

        if(id>0){
            ShowDialog(getActivity(), "COMPLETE", "Save data completed.", true);
        }
        db.close();
    }

    private void setData(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.INDEX_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                edtNumSow.setText(cursor.getString(1));
                edtFarrowSow.setText(cursor.getString(2));
                edtReplc.setText(cursor.getString(3));
                edtPigsWeanedLitter.setText(cursor.getString(4));
                edtPreWeaned.setText(cursor.getString(5));
                edtWeanling.setText(cursor.getString(6));
                edtGrower.setText(cursor.getString(7));
                haveData = true;
            }while(cursor.moveToNext());
        }else{
            haveData = false;
        }
        cursor.close();
        db.close();
    }

    private  void gotoPopulation(){
        ((MainActivity) getActivity()).displayView(10);
    }

    public void ShowDialog(final Context _context, String title, String message, final Boolean status){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(_context).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        //alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                gotoPopulation();
            }
        });
        alertDialog.show();
    }

    public void ShowAlert(final Context _context, String title, String message, final Boolean status){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(_context).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                return;
            }
        });
        alertDialog.show();
    }
}
