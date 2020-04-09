package com.example.mydash.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

    //table name
    public static final String TABLE_NAME = "DAILY_SAVE";
    //table columns
    public static final String ID = "id";
    public static final String MOOD = "mood";
    public static final String NOTES = "notes";
    public static final String DATE = "Date";
    //query
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + MOOD + " TEXT NOT NULL,"
            + NOTES + " TEXT,"
            + DATE + " DATETIME);";

    public static long insertRow(SQLiteDatabase db, String mood, String notes) {
        ContentValues values = new ContentValues();
        values.put(MOOD, mood);
        values.put(NOTES, notes);
        values.put(DATE, System.currentTimeMillis());

       long rowInserted= db.insert(TABLE_NAME, null, values);

       return rowInserted;
    }

    public static List<Mood> getMoods(SQLiteDatabase db) {
        ArrayList<Mood> results = new ArrayList<>();
        String[] columns = {MOOD, NOTES, DATE};
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" ORDER BY id DESC",null);

        while (cursor.moveToNext()) {
            int iMood = cursor.getColumnIndex(MOOD);
            int iNotes = cursor.getColumnIndex(NOTES);
            int iDate = cursor.getColumnIndex(DATE);
            String mood = cursor.getString(iMood);
            String notes = cursor.getString(iNotes);
            long date = cursor.getLong(iDate);
            results.add(new Mood(mood, notes, new Date(date)));
        }
        cursor.close();

        return results;
    }

    public static boolean clearTable(SQLiteDatabase db){
        db.delete(TABLE_NAME,null, null);
        db.close();
        return true;
    }

}
