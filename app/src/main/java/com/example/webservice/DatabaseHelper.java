package com.example.webservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "DataMahasiswa";
    private final static String TABLES[] = {"nrp", "nama", "prodi"};
    private final static String NAMA_TABLE = "table_mahasiswa";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createMahasiswaTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE if not exists "+NAMA_TABLE
                +"(nrp TEXT PRIMARY KEY, nama TEXT, prodi TEXT);");
        Log.e("MSG : ", "success");
    }
    public void insertDataMahasiswa(SQLiteDatabase db, String nrp, String nama, String prodi) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nrp", nrp);
        contentValues.put("nama", nama);
        contentValues.put("prodi", prodi);
        db.insert(NAMA_TABLE, null, contentValues);
        Log.e("MSG : ", "success");
    }

    public void updateDataMahasiswa(SQLiteDatabase db, String nrp, String nama, String prodi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nrp", nrp);
        contentValues.put("nama", nama);
        contentValues.put("prodi", prodi);
        db.update(NAMA_TABLE, contentValues, "nrp = ?", new String[]{nrp});
        Log.e("MSG : ", "success");
    }
    public void deleteDataMahasiswa(SQLiteDatabase db, String nrp){
        db.delete(NAMA_TABLE, "nrp = ?", new String[] {nrp});
    }
    public Cursor getAll(SQLiteDatabase db){
        return db.query(NAMA_TABLE, TABLES, null , null,
                null, null, null);
    }

}
