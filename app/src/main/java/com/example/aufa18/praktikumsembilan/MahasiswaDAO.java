package com.example.aufa18.praktikumsembilan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aufa18 on 13/01/18.
 */

public class MahasiswaDAO {
    private DBHelper dbHelper;
    private String TABLE_NAME = DBHelper.TABLE_MAHASISWA;

    public MahasiswaDAO(Context c) {
        dbHelper = new DBHelper(c);
    }

    public boolean checkDB() {
        if (dbHelper.getWritableDatabase()==null) {
            return false;
        }
        else {
            return true;
        }
    }

    public long insert(Mahasiswa m) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_NIM, m.getNim());
        contentValues.put(DBHelper.COLUMN_NAMA, m.getNama());
        contentValues.put(DBHelper.COLUMN_JURUSAN, m.getJurusan());
        long id = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return id;
    }

    public int update(Mahasiswa m) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_NIM, m.getNim());
        contentValues.put(DBHelper.COLUMN_NAMA, m.getNama());
        contentValues.put(DBHelper.COLUMN_JURUSAN, m.getJurusan());

        return db.update(
                DBHelper.TABLE_MAHASISWA,
                contentValues,
                DBHelper.COLUMN_ID + " = ?",
                new String[] {
                        m.getId()
                }
        );
    }

    public int delete(Mahasiswa m) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete(
                DBHelper.TABLE_MAHASISWA,
                DBHelper.COLUMN_ID + " =?",
                new String[] {
                        m.getId()
                }
        );
    }

    public List<Mahasiswa> getAllData() {
        String sql = "select * from " + DBHelper.TABLE_MAHASISWA;
        return executeQeury(sql);
    }

    private List<Mahasiswa> executeQeury(String sql) {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery(sql, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            mahasiswaList.add(
                    new Mahasiswa(
                            res.getString(res.getColumnIndex(DBHelper.COLUMN_ID)),
                            res.getString(res.getColumnIndex(DBHelper.COLUMN_NIM)),
                            res.getString(res.getColumnIndex(DBHelper.COLUMN_NAMA)),
                            res.getString(res.getColumnIndex(DBHelper.COLUMN_JURUSAN))
                    )
            );
            res.moveToNext();
        }
        return mahasiswaList;
    }
}
