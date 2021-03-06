package com.anu.dolist.db;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author: Limin (U6849956)
 * DAO for EventDatabase to implement queries.
 */

@Dao
public interface EventDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertOneEvent(Event newEvent);


    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updateOneEvent(Event event);


    @Delete
    void deleteOneEvent(Event event);


    @Query("SELECT * FROM event")
    List<Event> getAllEvents();


    @Query("SELECT * FROM event")
    Cursor getAllEventsCursor();


    @Query("SELECT * FROM event WHERE completed")
    List<Event> getAllCompletedEvents();


    @Query("SELECT * FROM event WHERE completed")
    Cursor getAllCompletedEventsCursor();


    @Query("SELECT * FROM event WHERE not completed")
    List<Event> getAllIncompletedEvents();

    @Query("SELECT * FROM event WHERE not completed")
    Cursor getAllIncompletedEventsCursor();


    @Query("SELECT * FROM event WHERE _id=:id")
    Event getEventById(int id);


    @Query("SELECT * FROM event WHERE title=:title AND time=:time AND date=:date")
    Event getEventByTitleTimeDate(String title, String time, String date);



    @Query("SELECT * FROM event WHERE title LIKE '%' || :keywords|| '%'")
    Cursor getEventByKeywords(String keywords);



    @Query("DELETE FROM event")
    void deleteAllEvents();

    @Query("UPDATE event SET completed=:completed WHERE _id=:id")
    void updateCompleted(int id, int completed);


}




