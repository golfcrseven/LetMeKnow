package com.conceptplays.komsonasa.elancopro.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by komsonasa on 5/18/15 AD.
 */
public class DataBaseAdapter {
    private static final String TAG = "DabtabaseAdapter";
    //Database
    private  static final String DB_NAME = "lmk_db"; //Database Name
    private static final int DATABASE_VERSION = 2;

    //Table Name
    public static final String INDEX_TABLE = "data_index";
    public static final String FDSOW_TABLE = "feed_sow";
    public static final String FDPIG_TABLE = "feed_pig";
    public static final String DRUG_TABLE = "drug";
    public static final String INJECTION_TABLE = "injection";
    public static final String VACCINE_TABLE = "vaccine";
    public static final String DRUG_SOW_PERSOW_TABLE = "drug_sow_persow";
    public static final String DRUG_PIG_TABLE = "drug_pig";
    public static final String INJECTION_COST_TABLE = "injection_cost";
    public static final String VACCINE_COST_TABLE = "vaccine_cost";


    //Field of INDEX_TABLE
    public static final String DATAID = "_id";
    public static final String DATA_G5 = "data_g5";
    public static final String DATA_G6 = "data_g6";
    public static final String DATA_G7 = "data_g7";
    public static final String DATA_G8 = "data_g8";
    public static final String DATA_G9 = "data_g9";
    public static final String DATA_G10 = "data_g10";
    public static final String DATA_G11 = "data_g11";

    //Field of FDSOW_TABLE
    public static final String FDSOWID = "_id";
    public static final String FD_C4 = "fd_c4";
    public static final String FD_C5 = "fd_c5";
    public static final String FD_C6 = "fd_c6";
    public static final String FD_C7 = "fd_c7";
    public static final String FD_C8 = "fd_c8";
    public static final String FD_C9 = "fd_c9";
    public static final String FD_C10 = "fd_c10";
    public static final String FD_C11 = "fd_c11";
    public static final String FD_C12 = "fd_c12";
    public static final String FD_C13 = "fd_c13";
    public static final String FD_C14 = "fd_c14";
    public static final String FD_C15 = "fd_c15";
    public static final String FD_C16 = "fd_c16";
    public static final String FD_C17 = "fd_c17";
    public static final String FD_C18 = "fd_c18";
    public static final String FD_C19 = "fd_c19";
    public static final String FD_C20 = "fd_c20";
    public static final String FD_C21 = "fd_c21";
    public static final String FD_C22 = "fd_c22";
    public static final String FD_C23 = "fd_c23";
    public static final String FD_C24 = "fd_c24";
    public static final String FD_C25 = "fd_c25";

    //Field of FDPIG_TABLE
    public static final String FDPIGID = "_id";
    public static final String FD_M4 = "fd_m4";
    public static final String FD_M5 = "fd_m5";
    public static final String FD_M6 = "fd_m6";
    public static final String FD_M7 = "fd_m7";
    public static final String FD_M8 = "fd_m8";
    public static final String FD_M9 = "fd_m9";
    public static final String FD_M10 = "fd_m10";
    public static final String FD_M11 = "fd_m11";
    public static final String FD_M12 = "fd_m12";
    public static final String FD_M13 = "fd_m13";
    public static final String FD_M14 = "fd_m14";
    public static final String FD_M15 = "fd_m15";
    public static final String FD_M16 = "fd_m16";
    public static final String FD_M17 = "fd_m17";
    public static final String FD_M18 = "fd_m18";
    public static final String FD_M19 = "fd_m19";
    public static final String FD_M20 = "fd_m20";
    public static final String FD_M21 = "fd_m21";
    public static final String FD_M22 = "fd_m22";
    public static final String FD_M23 = "fd_m23";
    public static final String FD_M24 = "fd_m24";
    public static final String FD_M25 = "fd_m25";

    //Field of DRUG_TABLE
    public static final String DRUGID = "_id";
    public static final String DRUG_NAME = "drug_name";
    public static final String DRUG_PRICE = "drug_price";

    //Field of INJECTION_TABLE
    public static final String INJECIONID = "_id";
    public static final String INJECTION_NAME = "injection_name";
    public static final String INJECTION_PRICE = "injection_price";

    //Field of VACCINE_TABLE
    public static final String VACCINEID = "_id";
    public static final String VACCINE_NAME = "vaccine_name";
    public static final String VACCINE_PRICE = "vaccine_price";


    //Field of DRUG_SOW_PERSOW_TABLE
    public static final String SOW_PERSOW_ID = "_id";
    public static final String DRUG_ID = "drug_id";
    public static final String DRUG_SOW_PERSOW_USAGE = "drug_sow_persow_usage";
    public static final String DRUG_SOW_PERSOW_OPTION = "drug_sow_persow_option";
    public static final String DRUG_SOW_PERSOW_TOTAL = "persow_total";
    public static final String DRUG_SOW_PERSOW_COST = "persow_cost";


    //Create TABLE INDEX_TABLE
    private static final String DB_CREATE ="create table "+INDEX_TABLE
            + "(_id integer primary key autoincrement,"
            + "data_g5 double,data_g6 double,data_g7 double,data_g8 double,data_g9 double,data_g10 double,data_g11 double);";

    //Create TABLE FDSOW_TABLE
    private static final String DB_FD_SOW_CREATE ="create table "+FDSOW_TABLE
            + "(_id integer primary key autoincrement,"
            + "fd_c4 double,fd_c5 double,fd_c6 double,fd_c7 double,fd_c8 double,fd_c9 double,fd_c10 double,"
            + "fd_c11 double,fd_c12 double,fd_c13 double,fd_c14 double,fd_c15 double,fd_c16 double,fd_c17 double,"
            + "fd_c18 double,fd_c19 double,fd_c20 double,fd_c21 double,fd_c22 double,fd_c23 double,fd_c24 double,fd_c25 double);";

    //Create TABLE FDSOW_TABLE
    private static final String DB_FD_PIG_CREATE ="create table "+FDPIG_TABLE
            + "(_id integer primary key autoincrement,"
            + "fd_m4 double,fd_m5 double,fd_m6 double,fd_m7 double,fd_m8 double,fd_m9 double,fd_m10 double,"
            + "fd_m11 double,fd_m12 double,fd_m13 double,fd_m14 double,fd_m15 double,fd_m16 double,fd_m17 double,"
            + "fd_m18 double,fd_m19 double,fd_m20 double,fd_m21 double,fd_m22 double,fd_m23 double,fd_m24 double,fd_m25 double);";

    //Create TABLE DRUG_TABLE
    private static final String DB_DRUG_CREATE ="create table "+DRUG_TABLE
            + "(_id integer primary key autoincrement,"
            + "drug_name text,drug_price double);";

    //Create TABLE INJECTION_TABLE
    private static final String DB_INJECTION_CREATE ="create table "+INJECTION_TABLE
            + "(_id integer primary key autoincrement,"
            + "injection_name text,injection_price double);";

    //Create TABLE VACCINE_TABLE
    private static final String DB_VACCINE_CREATE ="create table "+VACCINE_TABLE
            + "(_id integer primary key autoincrement,"
            + "vaccine_name text,vaccine_price double);";

    //Create TABLE DRUG_SOW_PERSOW_TABLE
    private static final String DB_DRUG_SOW_PERSOW_TABLE_CREATE ="create table "+DRUG_SOW_PERSOW_TABLE
            + "(_id integer primary key autoincrement,"
            + "drug_id integer,drug_sow_persow_usage double, drug_sow_persow_option text,persow_cost double,persow_total double);";

    //Create TABLE DRUG_PIG_TABLE
    private static final String DB_DRUG_PIG_TABLE_CREATE ="create table "+DRUG_PIG_TABLE
            + "(_id integer primary key autoincrement,"
            + "drug_id integer,drug_sow_persow_usage double, drug_sow_persow_option text,persow_cost double,persow_total double);";

    //Create TABLE INJECTION_COST_TABLE
    private static final String DB_INJECTION_COST_TABLE_CREATE ="create table "+INJECTION_COST_TABLE
            + "(_id integer primary key autoincrement,"
            + "drug_id integer,drug_sow_persow_usage double, drug_sow_persow_option text,persow_cost double,persow_total double,piglet_total double);";

    //Create TABLE VACCINE_COST_TABLE
    private static final String DB_VACCINE_COST_TABLE_CREATE ="create table "+VACCINE_COST_TABLE
            + "(_id integer primary key autoincrement,"
            + "drug_id integer,drug_sow_persow_usage double, drug_sow_persow_option text,persow_cost double,persow_total double,piglet_total double);";


    private Context context = null;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DataBaseAdapter(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    public DataBaseAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;

    }

    public void close(){
        DBHelper.close();
    }


    //insert
    public long insertRow(String table, ContentValues cv){
        return db.insert(table, null, cv);
    }

    public long updateRow(String table, ContentValues cv, long rowID){
        return  db.update(table,cv, "_id = "+ rowID, null);
    }


    public boolean deleteRow(String table, Long rowID){
        return db.delete(table, "_id = "+ rowID, null) > 0;
    }


    public Cursor getAll(String table, String order){
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+table+" ORDER BY _id "+order, null);
        return cursor;
    }

    public Cursor getRow(String table, long rows){
        return db.rawQuery("select * from "+table+" where _id = '"+rows+"'" ,null);
    }



    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context){
            super(context, DB_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DB_CREATE);
            db.execSQL(DB_FD_SOW_CREATE);
            db.execSQL(DB_FD_PIG_CREATE);
            db.execSQL(DB_DRUG_CREATE);
            db.execSQL(DB_INJECTION_CREATE);
            db.execSQL(DB_VACCINE_CREATE);
            db.execSQL(DB_DRUG_SOW_PERSOW_TABLE_CREATE);
            db.execSQL(DB_DRUG_PIG_TABLE_CREATE);
            db.execSQL(DB_INJECTION_COST_TABLE_CREATE);
            db.execSQL(DB_VACCINE_COST_TABLE_CREATE);

            db.execSQL("insert into " +INDEX_TABLE+" (_id,data_g5,data_g6,data_g7,data_g8,data_g9,data_g10,data_g11) values ("+
            "1,800,85,20,10,5,3,2)");

            db.execSQL("insert into " +FDSOW_TABLE+" (_id,fd_c4,fd_c5,fd_c6,fd_c7,fd_c8,fd_c9,fd_c10,fd_c11,fd_c12,fd_c13,fd_c14,fd_c15,"+
            "fd_c16,fd_c17,fd_c18,fd_c19,fd_c20,fd_c21,fd_c22,fd_c23,fd_c24,fd_c25) values ("+
            "1,3,3,2,1.80,1.80,1.80,1.80,1.80,2.00,2.20,2.40,2.60,2.80,3.00,3.20,3.40,3.40,3.40,3.40,4.7,6,6)");

            db.execSQL("insert into " +FDPIG_TABLE+" (_id,fd_m4,fd_m5,fd_m6,fd_m7,fd_m8,fd_m9,fd_m10,fd_m11,fd_m12,fd_m13,fd_m14,fd_m15,"+
                    "fd_m16,fd_m17,fd_m18,fd_m19,fd_m20,fd_m21,fd_m22,fd_m23,fd_m24,fd_m25) values ("+
                    "1,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0,1.1,1.2,1.3,1.4,1.6,1.8,2.0,2.0,2.2,2.2,2.2,2.2,2.2,2.2)");

            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (1,'Tiamulin 10%',800)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (2,'Tylosin+Sulfa',350)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (3,'Linco 10%',1100)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (4,'Pleumotil 10%',1900)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (5,'Aivolosin 5%',900)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (6,'Amoxy 100%',1550)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (7,'CTC 15%',60)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (8,'Quixalud 60%',920)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (9,'Toxin Binder',280)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (10,'Denagard  10% Non Coated ',340)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (11,'Amoxy 50%',620)");
            db.execSQL("insert into " +DRUG_TABLE+" (_id,drug_name,drug_price) values (12,'CotinGard 40%',350)");

            db.execSQL("insert into " +INJECTION_TABLE+" (injection_name,injection_price) values ('Tiamutin 10 c.c.',65)");
            db.execSQL("insert into " +INJECTION_TABLE+" (injection_name,injection_price) values ('OTC 10 c.c.',40)");
            db.execSQL("insert into " +INJECTION_TABLE+" (injection_name,injection_price) values ('Ivermec 8 c.c.',16)");
            db.execSQL("insert into " +INJECTION_TABLE+" (injection_name,injection_price) values ('Ivermec 0.5 c.c.',1)");
            db.execSQL("insert into " +INJECTION_TABLE+" (injection_name,injection_price) values ('Tiamulin 0.5 c.c.',4)");

            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('Swine fever',5)");
            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('FMD',30)");
            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('ADL',8)");
            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('Parvo',27)");
            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('AR',40)");
            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('Myco',19)");
            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('APP',25)");
            db.execSQL("insert into " +VACCINE_TABLE+" (vaccine_name,vaccine_price) values ('PRRS',30)");

            db.execSQL("insert into " +DRUG_SOW_PERSOW_TABLE+" (drug_id,drug_sow_persow_usage,drug_sow_persow_option,"+
                    "persow_cost,persow_total) values (10,1.50,'1100000000000000000111',81.04,0.238)");
            db.execSQL("insert into " +DRUG_SOW_PERSOW_TABLE+" (drug_id,drug_sow_persow_usage,drug_sow_persow_option,"+
                    "persow_cost,persow_total) values (11,0.5,'0000000000000000000111',36.24,0.058)");

            db.execSQL("insert into " +DRUG_PIG_TABLE+" (drug_id,drug_sow_persow_usage,drug_sow_persow_option,"+
                    "persow_total) values (10,1.50,'1111111000000000000000',0.044)");
            db.execSQL("insert into " +DRUG_PIG_TABLE+" (drug_id,drug_sow_persow_usage,drug_sow_persow_option,"+
                    "persow_total) values (11,0.50,'1111111000000000000000',0.015)");
            db.execSQL("insert into " +DRUG_PIG_TABLE+" (drug_id,drug_sow_persow_usage,drug_sow_persow_option,"+
                    "persow_total) values (8,0.40,'1111111000000000000000',0.012)");

            db.execSQL("insert into " +INJECTION_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (1,'1100000000000000000000000000000000000000000000000000000',6.461538462,6.461538462)");
            db.execSQL("insert into " +INJECTION_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (2,'0000000000000000000000001000000000000000000000000000000',15.85903084,15.85903084)");
            db.execSQL("insert into " +INJECTION_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (3,'1000000000000000000000100000000000000000000000000000000',19.08980007,19.08980007)");
            db.execSQL("insert into " +INJECTION_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (4,'0000000000000000000000000000000001000000000000000000000',158.7488987,0)");
            db.execSQL("insert into " +INJECTION_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (5,'0000000000000000000000000000000001100000000000000000000',316.8542207,0)");

            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (1,'0100000000000000000001000000000010100000000000000000000',335.9440208,19.08980007)");
            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (2,'0010000000000000000000000001000000001000000000000000000',175.1928838,19.08980007)");
            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (3,'0001000000000000000000100000000001000100000000000000000',330.5379772,19.08980007)");
            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (4,'0000101000000000000000000010000000000000000000000000000',22.3205693,22.3205693)");
            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (5,'0000000000000000000010000000000000000000000000000000000',15.85903084,15.85903084)");
            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (6,'0000000000000000000000000000000000100000000000000000000',158.1053221,0)");
            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (7,'0000000000000000000000000000000000000010100000000000000',307.7162194,0)");
            db.execSQL("insert into " +VACCINE_COST_TABLE+" (drug_id,drug_sow_persow_option,"+
                    "persow_total,piglet_total) values (8,'0000010100000000000000000000000000000000000000000000000',6.461538462,6.461538462)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            Log.w(TAG, "Upgrading database from version"
                    + oldVersion + "to" + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS" + INDEX_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + FDSOW_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + FDPIG_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + DRUG_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + INJECTION_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + VACCINE_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + DRUG_SOW_PERSOW_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + DRUG_PIG_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + INJECTION_COST_TABLE);
            db.execSQL("DROP TABLE IF EXISTS" + VACCINE_COST_TABLE);
            onCreate(db);
        }
    }
}
