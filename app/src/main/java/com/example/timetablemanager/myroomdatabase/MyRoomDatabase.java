package com.example.timetablemanager.myroomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {ToDoTaskTable.class},version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {
    public abstract MyDaoInterface myDaoInterface();

    public static MyRoomDatabase mInstance;

    public static MyRoomDatabase getInstance(Context context){

        if (mInstance== null){
            mInstance= Room.databaseBuilder(context.getApplicationContext(),MyRoomDatabase.class,"DatabaseName")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return mInstance;

    }
}
