package com.example.prasanna.mytestproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Student";
    private static final String colm1 = "studentName";
    private static final String colm2 = "sRollNo";
    private static final String colm3 = "Specialization";

    public DatabaseHelper(Context context) {
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+TABLE_NAME+"("+colm1+" TEXT,"+colm2+" TEXT,"+colm3+" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String sName,String RollNo, String Spec){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvs = new ContentValues();
        Log.d("check","hello");
        cvs.put(colm1,sName);
        cvs.put(colm2,RollNo);
        cvs.put(colm3,Spec);

        long result = db.insert(TABLE_NAME,null,cvs);
        // if data not inserted value will be -1
        if(result==-1){
            return false;
        }
        return true;
    }

    public void deleteRow(String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME+ " WHERE "+colm2+"='"+value+"'");
        db.close();
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
