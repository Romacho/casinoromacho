package com.example.ague.casinoromacho;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

/**
 * Created by ROMACHO
 */
public class BD extends SQLiteOpenHelper {


    public BD(Context context) {

        super(context, "dbagenda", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT,usuario TEXT ,pass TEXT); ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE usuario");
        db.execSQL("CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT,usuario TEXT ,pass TEXT ); ");
    }


    public void add(String user, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO contacto  VALUES(null," + "'" + user + "', '" + pass + "')");

    }


    public Vector<String> consultaruser(int id){

        Vector <String> result= new Vector <String>();
        SQLiteDatabase db= getReadableDatabase();

        Cursor cursor=db.rawQuery("SELECT user FROM usuarios WHERE id ="+id, null);
        while(cursor.moveToNext()){
            result.add(cursor.getString(0));
        }
        cursor.close();
        return result;
    }
    public Vector <String> consultartodo(){

        Vector <String> result= new Vector<String>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT id FROM contacto;", null);

        while(cursor.moveToNext()){
            result.add(cursor.getString(0));
        }
        cursor.close();
        return result;
    }


}
