package com.example.mydash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
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
            + ID + "INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + MOOD + "TEXT NOT NULL,"
            + NOTES + "TEXT,"
            + DATE + "DATETIME);";

    public static void insertRow(SQLiteDatabase db, String mood, String notes) {
        ContentValues values = new ContentValues();
        values.put(MOOD, mood);
        values.put(NOTES, notes);
        values.put(DATE, System.currentTimeMillis());
        db.insert(TABLE_NAME, null, values);
    }

    public static List<Mood> getMoods(SQLiteDatabase db) {
        ArrayList<Mood> results = new ArrayList<>();
        String[] columns = {MOOD, NOTES, DATE};
        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);

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
}
