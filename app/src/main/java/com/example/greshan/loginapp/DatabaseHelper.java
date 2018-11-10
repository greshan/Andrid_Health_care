package com.example.greshan.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Registration_db";

    /*Table for sinup*/
    public static final String TABLE_NAME = "Sinup_table";
    public static final String COL_1 = "Id";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "User_Name";
    public static final String COL_4 = "Password";

    //Table for patient information
    public static final String TABLE_NAME1 = "Info_table";
    public static final String Info_COL_1 = "FName";
    public static final String Info_COL_2 = "SName";
    public static final String Info_COL_3 = "Height";
    public static final String Info_COL_4 = "Weight";
    public static final String Info_COL_5 = "Gender";
    public static final String Info_COL_6 = "Age";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        //SQLiteDatabase db =this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT NOT NULL, User_Name TEXT NOT NULL,  Password TEXT NOT NULL)");
        db.execSQL("create table " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FName TEXT NOT NULL, SName TEXT NOT NULL, Height  TEXT NOT NULL,  Weight TEXT NOT NULL,  Gender TEXT NOT NULL, Age TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

    }

    public boolean inserData(String name, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1, Id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, username);
        contentValues.put(COL_4, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean inserIntoData(String fname, String sname, String height, String weight, String age, String Gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Info_COL_1, fname);
        contentValues.put(Info_COL_2, sname);
        contentValues.put(Info_COL_3, height);
        contentValues.put(Info_COL_4, weight);
        contentValues.put(Info_COL_5, age);
        contentValues.put(Info_COL_6, Gender);

        long result = db.insert(TABLE_NAME1, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select User_Name,Password from " + TABLE_NAME, null);
        return res;

    }
/*
    public Cursor checkid() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select FName from " + TABLE_NAME1, null);
        return res;

    }
*/
//    public Cursor display(){
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+TABLE_NAME1,null);
//        return res;
//
//    }
/*
    public Cursor getid(String id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME1 + " where " + Info_COL_1 + "="+id+"", null);
        return res;

    }
}
*/

    public String[] getid(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME1 + " WHERE " + Info_COL_1 + " = '" + id+"'" ;
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String[] name = new String[10];
            name[0] = cursor.getString(cursor.getColumnIndex("FName"));
            name[1] = cursor.getString(cursor.getColumnIndex("SName"));
            name[2] = cursor.getString(cursor.getColumnIndex("Height"));
            name[3] = cursor.getString(cursor.getColumnIndex("Weight"));
            name[4] = cursor.getString(cursor.getColumnIndex("Gender"));
            name[5] = cursor.getString(cursor.getColumnIndex("Age"));
            cursor.close();
            return name;
        } else {
            cursor.close();
            return null;
        }
    }}
