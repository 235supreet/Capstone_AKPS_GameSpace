package com.example.akps_capstone_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "game.db";
    public static final String CUSTOMER_ID = "game";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    public static final String SCORE = "score";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + CUSTOMER_ID + " (" + NAME + " TEXT PRIMARY KEY , "+ EMAIL + " TEXT, "+ PHONE + " TEXT, " + PASSWORD + " TEXT, " + SCORE + " INTEGER )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE " + CUSTOMER_ID;
        db.execSQL(query);
    }

    public boolean insert(String name,String email,String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(PHONE, phone);
        contentValues.put(PASSWORD, password);
        return db.insert(CUSTOMER_ID, null, contentValues) != -1;
    }

    public Cursor getAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + CUSTOMER_ID, null);
    }

    public int update(String name, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(SCORE, score);
        return db.update(CUSTOMER_ID, contentValues, "NAME = ?", new String[] {name});
    }
}

