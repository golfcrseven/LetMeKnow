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


public class FeedPigsPerDayActivity extends Activity {
    DataBaseAdapter db;

    EditText edtM4,edtM5,edtM6,edtM7,edtM8,edtM9,edtM10,edtM11,edtM12,edtM13,edtM14,edtM15,edtM16;
    EditText edtM17,edtM18,edtM19,edtM20,edtM21,edtM22,edtM23,edtM24,edtM25;
    Boolean haveData = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_feed_pigs_per_day);

        //Hide keyboard on lunch
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //Hide Scrollview Bar
        final ScrollView sView = (ScrollView)findViewById(R.id.scrollViewID);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

        db = new DataBaseAdapter(this);

        edtM4 = (EditText)findViewById(R.id.m4);
        edtM5 = (EditText)findViewById(R.id.m5);
        edtM6 = (EditText)findViewById(R.id.m6);
        edtM7 = (EditText)findViewById(R.id.m7);
        edtM8 = (EditText)findViewById(R.id.m8);
        edtM9 = (EditText)findViewById(R.id.m9);
        edtM10 = (EditText)findViewById(R.id.m10);
        edtM11 = (EditText)findViewById(R.id.m11);
        edtM12 = (EditText)findViewById(R.id.m12);
        edtM13 = (EditText)findViewById(R.id.m13);
        edtM14 = (EditText)findViewById(R.id.m14);
        edtM15 = (EditText)findViewById(R.id.m15);
        edtM16 = (EditText)findViewById(R.id.m16);
        edtM17 = (EditText)findViewById(R.id.m17);
        edtM18 = (EditText)findViewById(R.id.m18);
        edtM19 = (EditText)findViewById(R.id.m19);
        edtM20 = (EditText)findViewById(R.id.m20);
        edtM21 = (EditText)findViewById(R.id.m21);
        edtM22 = (EditText)findViewById(R.id.m22);
        edtM23 = (EditText)findViewById(R.id.m23);
        edtM24 = (EditText)findViewById(R.id.m24);
        edtM25 = (EditText)findViewById(R.id.m25);

        setData();

        Button btnmonfrm = (Button)findViewById(R.id.btnSave);
        btnmonfrm.setOnClickListener(new View.OnClickListener() {
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

        cv.put(db.FD_M4, Double.valueOf(edtM4.getText().toString()));
        cv.put(db.FD_M5, Double.valueOf(edtM5.getText().toString()));
        cv.put(db.FD_M6, Double.valueOf(edtM6.getText().toString()));
        cv.put(db.FD_M7, Double.valueOf(edtM7.getText().toString()));
        cv.put(db.FD_M8, Double.valueOf(edtM8.getText().toString()));
        cv.put(db.FD_M9, Double.valueOf(edtM9.getText().toString()));
        cv.put(db.FD_M10, Double.valueOf(edtM10.getText().toString()));
        cv.put(db.FD_M11, Double.valueOf(edtM11.getText().toString()));
        cv.put(db.FD_M12, Double.valueOf(edtM12.getText().toString()));
        cv.put(db.FD_M13, Double.valueOf(edtM13.getText().toString()));
        cv.put(db.FD_M14, Double.valueOf(edtM14.getText().toString()));
        cv.put(db.FD_M15, Double.valueOf(edtM15.getText().toString()));
        cv.put(db.FD_M16, Double.valueOf(edtM16.getText().toString()));
        cv.put(db.FD_M17, Double.valueOf(edtM17.getText().toString()));
        cv.put(db.FD_M18, Double.valueOf(edtM18.getText().toString()));
        cv.put(db.FD_M19, Double.valueOf(edtM19.getText().toString()));
        cv.put(db.FD_M20, Double.valueOf(edtM20.getText().toString()));
        cv.put(db.FD_M21, Double.valueOf(edtM21.getText().toString()));
        cv.put(db.FD_M22, Double.valueOf(edtM22.getText().toString()));
        cv.put(db.FD_M23, Double.valueOf(edtM23.getText().toString()));
        cv.put(db.FD_M24, Double.valueOf(edtM24.getText().toString()));
        cv.put(db.FD_M25, Double.valueOf(edtM25.getText().toString()));

        db.open();
        long id;
        if(haveData==true){
            id = db.updateRow(db.FDPIG_TABLE, cv, 1);
        }else{
            id = db.insertRow(db.FDPIG_TABLE, cv);
        }

        if(id>0){
            ShowDialog(this, "COMPLETE", "Save data completed.", true);
        }
        db.close();
    }


    private void setData(){
        db.open();
        Cursor cursor;
        cursor = db.getRow(db.FDPIG_TABLE, Long.valueOf(1));
        cursor.requery();

        if(cursor.moveToFirst()){
            do{
                edtM4.setText(cursor.getString(1));
                edtM5.setText(cursor.getString(2));
                edtM6.setText(cursor.getString(3));
                edtM7.setText(cursor.getString(4));
                edtM8.setText(cursor.getString(5));
                edtM9.setText(cursor.getString(6));
                edtM10.setText(cursor.getString(7));
                edtM11.setText(cursor.getString(8));
                edtM12.setText(cursor.getString(9));
                edtM13.setText(cursor.getString(10));
                edtM14.setText(cursor.getString(11));
                edtM15.setText(cursor.getString(12));
                edtM16.setText(cursor.getString(13));
                edtM17.setText(cursor.getString(14));
                edtM18.setText(cursor.getString(15));
                edtM19.setText(cursor.getString(16));
                edtM20.setText(cursor.getString(17));
                edtM21.setText(cursor.getString(18));
                edtM22.setText(cursor.getString(19));
                edtM23.setText(cursor.getString(20));
                edtM24.setText(cursor.getString(21));
                edtM25.setText(cursor.getString(22));
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
}
