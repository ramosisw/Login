package com.wayproyect.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ADMIN on 20/03/14.
 *
 * @author Julio C. Ramos
 */
public class LoginBD extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LoginBD.db";

    public LoginBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_users (" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "  user TEXT," +
                "  pass TEXT" +
                ");");
        db.execSQL("INSERT INTO tbl_users  VALUES" +
                "(null, 'user','12345');");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS tbl_users;");
        onCreate(db);
    }
}
