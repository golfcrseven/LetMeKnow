package com.conceptplays.komsonasa.letmeknow;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.conceptplays.komsonasa.letmeknow.DB.DataBaseAdapter;


public class FeedSowsPerDayActivity extends Activity {
    DataBaseAdapter db;

    EditText edtC4,edtC5,edtC6,edtC7,edtC8,edtC9,edtC10,edtC11,edtC12,edtC13,edtC14,edtC15,edtC16;
    EditText edtC17,edtC18,edtC19,edtC20,edtC21,edtC22,edtC23,edtC24,edtC25;
    Boolean haveData = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_feed_sows_per_day);

        //Hide keyboard on lunch
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //Hide Scrollview Bar
        final ScrollView sView = (ScrollView)findViewById(R.id.scrollViewID);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        db = new DataBaseAdapter(this);

        edtC4 = (EditText)findViewById(R.id.c4);
        edtC5 = (EditText)findViewById(R.id.c5);
        edtC6 = (EditText)findViewById(R.id.c6);
        edtC7 = (EditText)findViewById(R.id.c7);
        edtC8 = (EditText)findViewById(R.id.c8);
        edtC9 = (EditText)findViewById(R.id.c9);
        edtC10 = (EditText)findViewById(R.id.c10);
        edtC11 = (EditText)findViewById(R.id.c11);
        edtC12 = (EditText)findViewById(R.id.c12);
        edtC13 = (EditText)findViewById(R.id.c13);
        edtC14 = (EditText)findViewById(R.id.c14);
        edtC15 = (EditText)findViewById(R.id.c15);
        edtC16 = (EditText)findViewById(R.id.c16);
        edtC17 = (EditText)findViewById(R.id.c17);
        edtC18 = (EditText)findViewById(R.id.c18);
        edtC19 = (EditText)findViewById(R.id.c19);
        edtC20 = (EditText)findViewById(R.id.c20);
        edtC21 = (EditText)findViewById(R.id.c21);
        edtC22 = (EditText)findViewById(R.id.c22);
        edtC23 = (EditText)findViewById(R.id.c23);
        edtC24 = (EditText)findViewById(R.id.c24);
        edtC25 = (EditText)findViewById(R.id.c25);

        setData();

        Button btnConfrm = (Button)findViewById(R.id.btnSave);
        btnConfrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkData();
            }

        });

    }

    private  void chkData(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
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

    private  void insertData(){
        ContentValues cv = new ContentValues();
        cv.clear();

        cv.put(db.FD_C4, Double.valueOf(edtC4.getText().toString()));
        cv.put(db.FD_C5, Double.valueOf(edtC5.getText().toString()));
        cv.put(db.FD_C6, Double.valueOf(edtC6.getText().toString()));
        cv.put(db.FD_C7, Double.valueOf(edtC7.getText().toString()));
        cv.put(db.FD_C8, Double.valueOf(edtC8.getText().toString()));
        cv.put(db.FD_C9, Double.valueOf(edtC9.getText().toString()));
        cv.put(db.FD_C10, Double.valueOf(edtC10.getText().toString()));
        cv.put(db.FD_C11, Double.valueOf(edtC11.getText().toString()));
        cv.put(db.FD_C12, Double.valueOf(edtC12.getText().toString()));
        cv.put(db.FD_C13, Double.valueOf(edtC13.getText().toString()));
        cv.put(db.FD_C14, Double.valueOf(edtC14.getText().toString()));
        cv.put(db.FD_C15, Double.valueOf(edtC15.getText().toString()));
        cv.put(db.FD_C16, Double.valueOf(edtC16.getText().toString()));
        cv.put(db.FD_C17, Double.valueOf(edtC17.getText().toString()));
        cv.put(db.FD_C18, Double.valueOf(edtC18.getText().toString()));
        cv.put(db.FD_C19, Double.valueOf(edtC19.getText().toString()));
        cv.put(db.FD_C20, Double.valueOf(edtC20.getText().toString()));
        cv.put(db.FD_C21, Double.valueOf(edtC21.getText().toString()));
        cv.put(db.FD_C22, Double.valueOf(edtC22.getText().toString()));
        cv.put(db.FD_C23, Double.valueOf(edtC23.getText().toString()));
        cv.put(db.FD_C24, Double.valueOf(edtC24.getText().toString()));
        cv.put(db.FD_C25, Double.valueOf(edtC25.getText().toString()));

        db.open();
        long id;
        if(haveData==true){
            id = db.updateRow(db.FDSOW_TABLE, cv, 1);
        }else{
            id = db.insertRow(db.FDSOW_TABLE, cv);
        }

        if(id>0){
            ShowDialog(this, "COMPLETE", "Save data completed.", true);
        }
        db.close();
    }


    private void setData(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.FDSOW_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                edtC4.setText(cursor.getString(1));
                edtC5.setText(cursor.getString(2));
                edtC6.setText(cursor.getString(3));
                edtC7.setText(cursor.getString(4));
                edtC8.setText(cursor.getString(5));
                edtC9.setText(cursor.getString(6));
                edtC10.setText(cursor.getString(7));
                edtC11.setText(cursor.getString(8));
                edtC12.setText(cursor.getString(9));
                edtC13.setText(cursor.getString(10));
                edtC14.setText(cursor.getString(11));
                edtC15.setText(cursor.getString(12));
                edtC16.setText(cursor.getString(13));
                edtC17.setText(cursor.getString(14));
                edtC18.setText(cursor.getString(15));
                edtC19.setText(cursor.getString(16));
                edtC20.setText(cursor.getString(17));
                edtC21.setText(cursor.getString(18));
                edtC22.setText(cursor.getString(19));
                edtC23.setText(cursor.getString(20));
                edtC24.setText(cursor.getString(21));
                edtC25.setText(cursor.getString(22));
                haveData = true;
            }while(cursor.moveToNext());
        }else{
            haveData = false;
        }
        cursor.close();
        db.close();
    }

    public void ShowDialog(final Context _context, String title, String message, final Boolean status){
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(_context).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        //alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                finish();
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
