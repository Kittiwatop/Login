package com.example.login.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by ON-ONE on 12/18/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "myuser";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    private static final String SQL_CRATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_USERNAME + " TEXT, "
                    + COL_PASSWORD + " TEXT"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android Studio");
        cv.put(COL_USERNAME, "android");
        cv.put(COL_PASSWORD, "123456");
        db.insert(TABLE_NAME, null, cv);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRATE_TABLE);
        insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}