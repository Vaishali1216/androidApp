package com.example.vaish.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by twiganator on 4/11/17.
 */

public class AppDatabase extends SQLiteOpenHelper {

    private static final int DATA_VERSION= 1;
    private static final String DATABASE_NAME = "main.db";
    private static final String TABLE_NAME = "user_information";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;

    //query
    private static final String TABLE_CREATE = "create table user_information (id integer primary key not null , " +
            "username text not null, password text not null);";

    public AppDatabase(Context context){
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    /**
     * This function will only be called from the Register form
     * Inserting user's information into the database
     * @param info
     */
    public void insertInfo(UserInformation info){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

//        String query = "select * from " + TABLE_NAME;
//        Cursor cursor = db.rawQuery(query, null);
//        int idCount = cursor.getCount();
//        values.put(COLUMN_ID, idCount);

        values.put(COLUMN_USERNAME, info.getUsername());
        values.put(COLUMN_PASSWORD, info.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    /**
     * This function will only be called from the Login form
     * @param username
     * @return
     */
    public String searchPassword(String username){
        db = this.getReadableDatabase();
        String query = "select username, password from " + TABLE_NAME; //fetching the values
        Cursor cursor = db.rawQuery(query, null); //it allows to read and write from the database

        String getUsername;
        String getPassword = "Password not found";

        if(cursor.moveToFirst()){

            do{
                getUsername = cursor.getString(0);

                if(getUsername.equals(username)){
                    getPassword = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return getPassword;
    }
}
