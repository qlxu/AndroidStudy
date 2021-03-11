package com.jerry.androidstudy.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
public abstract class JerryDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    private static JerryDataBase mInstance;

    public static JerryDataBase getInstance(Context context){
        if(null == mInstance){
            mInstance = Room.databaseBuilder(context,JerryDataBase.class,"jerryData.db").build();
        }
        return mInstance;
    }
}
