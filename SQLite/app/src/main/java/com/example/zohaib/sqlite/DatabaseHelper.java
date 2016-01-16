package com.example.zohaib.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zohaib on 12/7/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE = "BooksDB";

    public String TABLE = "Books";

    public final String COL1 = "ID";

    public final String COL2 = "BookName";

    public SQLiteDatabase myDbObj;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory , int version){
        super(context , DATABASE , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COL2 + " STRING)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        this.onCreate(db);
    }

    public void AddBook(Book bk)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2 , bk.getBookname());
        db.insert(TABLE, null, cv);
        db.close();
    }

    public boolean deleteProduct(String bookname)
    {
        boolean result = false;
        String query = "Select * FROM " + TABLE + " WHERE " + COL2 + " =  \"" + bookname + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Book bk = new Book();

        if(cursor.moveToFirst())
        {
            bk.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE, COL1 + " = ?" , new String[] { String.valueOf(bk.getID())});
            cursor.close();
            result = true;
        }

        db.close();
        return result;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor resultCursor = db.rawQuery("SELECT * FROM " + TABLE , null);
        return resultCursor;
    }

    public Cursor getDesiredBook(String bookname)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor resultCursor = db.rawQuery("SELECT * FROM " + TABLE + " WHERE " + COL2 + " LIKE '%" + bookname + "%'" , null);
        return resultCursor;
    }

    public void updateRowForBook(Book bk , String newValue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c  = this.getDesiredBook(bk.getBookname());
        while (c.moveToNext()) {
            String id = c.getString(0);
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL2, newValue);
            db.update(TABLE, contentValues, "ID = ?", new String[]{id});
        }
        //"UPDATE " + TABLE + " SET " + COL1 + " = " + newValue + " WHERE ID = " + rowID;

    }
}
