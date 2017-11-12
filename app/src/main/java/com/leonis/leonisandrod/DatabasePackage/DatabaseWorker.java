package com.leonis.leonisandrod.DatabasePackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.leonis.leonisandrod.MessagePackage.ChatMessage;

import java.util.ArrayList;

/**
 * Created by Floglor on 12.11.2017.
 */

public class DatabaseWorker extends SQLiteOpenHelper {

    private static final String DBName = "LeonisAppDatabase.db"; //название бд
    private static final int VERSION = 1; //версия бд
    private static final String TABLE_MESSAGES = "messages";
    private static final String COLUMN_MESSAGE = "message";
    private static final String COLUMN_SENDER_ID = "sender_id";
    private static final String COLUMN_MESSAGE_TIME = "message_time";


    public DatabaseWorker(Context context) {
        super(context, DBName, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_MESSAGES + " ("
                + COLUMN_MESSAGE
                + " TEXT, "
                + COLUMN_SENDER_ID
                + " INTEGER, "
                + COLUMN_MESSAGE_TIME
                + " LONG);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
    }

    public ArrayList<ChatMessage> getMessagesByID(int id) {
        ArrayList<ChatMessage> messages = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery;
        Cursor cursor;

        selectQuery = "SELECT * FROM " + TABLE_MESSAGES + " WHERE " + COLUMN_SENDER_ID + "= " + id;
        cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ChatMessage chatMessage = new ChatMessage(cursor.getString(0), cursor.getString(2), cursor.getInt(1));
                messages.add(chatMessage);
            } while (cursor.moveToNext());
        }
        return messages;
    }

    public boolean addMessageToDB (ChatMessage message) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("INSERT INTO " + TABLE_MESSAGES + "("
                    + COLUMN_SENDER_ID
                    + ", "
                    + COLUMN_MESSAGE
                    + ", "
                    + COLUMN_MESSAGE_TIME
                    + ")" + " VALUES (" + message.getUserID() + ", " + message.getMessageText() + ", " + message.getMessageTime() + ");");
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

}
