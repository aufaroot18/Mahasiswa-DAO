package com.example.aufa18.praktikumsembilan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aufa18 on 13/01/18.
 */

// membuat kelas DBHelper, untuk inisialisasi awal database
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "kampus.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_MAHASISWA = "mahasiswa";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_JURUSAN = "jurusan";

    public DBHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query_create = "CREATE TABLE " + TABLE_MAHASISWA + "(" + COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, " + COLUMN_NIM + " text, " + COLUMN_NAMA + " text, " + COLUMN_JURUSAN + " text);";
        sqLiteDatabase.execSQL(query_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query_drop = "DROP TABLE IF EXISTS " + TABLE_MAHASISWA;
        sqLiteDatabase.execSQL(query_drop);
        onCreate(sqLiteDatabase);
    }
}
