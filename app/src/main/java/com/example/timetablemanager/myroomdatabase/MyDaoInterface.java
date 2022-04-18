package com.example.timetablemanager.myroomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface  MyDaoInterface {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ToDoTaskTable toDoTaskTable);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(ToDoTaskTable toDoTaskTable);

    @Delete()
    void delete(ToDoTaskTable toDoTaskTable);

    @Query("select * from to_do_table")
    List<ToDoTaskTable> collectList();
}
