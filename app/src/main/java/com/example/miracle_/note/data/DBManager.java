package com.example.miracle_.note.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import com.example.miracle_.note.Model.Ghichu;

/**
 * Created by MIRACLE- on 04/12/2017.
 */

public class DBManager extends SQLiteOpenHelper {
    private  final String TAG = "DBManager";
    private static final String DATABASE_NAME = "ghichu_manager";
    private static final String TABLE_NAME = "ghichu";
    private static final String ID = "id";
    private static final String TIEUDE = "tieude";
    private static final String NOIDUNG = "noidung";
    private static final String NGAY = "ngay";
    private static final String GIO = "gio";
    private static final int VERSION = 1;

    //Câu truy vấn tạo bảng
    private String SQLQuery = "CREATE TABLLE " + TABLE_NAME + "( " +
            ID + "integer primary key, " +
            TIEUDE + "TEXT, " +
            NOIDUNG + "TEXT, " +
            NGAY + "TEXT " +
            GIO + "TEXT )";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addGhichu (Ghichu ghichu){
        //Tạo hoặc ghi đối tượng ghichu xuống database
        SQLiteDatabase db = this.getWritableDatabase();
        //Tạo contentvalues để chứa các values của đối tượng ghichu
        ContentValues values = new ContentValues();
        values.put(TIEUDE,ghichu.getmTieude());
        values.put(NOIDUNG,ghichu.getmNoidung());
        values.put(NGAY, String.valueOf(ghichu.getmNgay()));
        values.put(GIO,ghichu.getmGio());
        //Thêm đối tượng ghichu
        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.d(TAG,"Add ghi chú thành công");
    }
}
