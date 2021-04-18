package com.krishapps.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = String.valueOf("CREATE TABLE myStudents (sno Integer PRIMARY KEY, name TEXT, increment TEXT)");
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"myStudents"});
        onCreate(db);
    }

    public void addStudent(Student s){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", s.getName());
        values.put("increment", s.getIncrement());
        long k = db.insert("myStudents", null, values);
        Log.d("krishlog", Long.toString(k));
        db.close();
    }

    public void getStudent(int sno){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("myStudents", new String[]{"sno", "name", "increment"}, "sno=?", new String[]{String.valueOf(sno)}, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("krishlog", cursor.getString(1));
            Log.d("krishlog", cursor.getString(2));
        }
        else{
            Log.d("krishlog", "getStudent: Some error Occured");
        }
    }


}
