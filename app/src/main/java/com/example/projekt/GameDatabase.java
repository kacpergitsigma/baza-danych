package com.example.projekt;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class}, version = 2)
public abstract class GameDatabase extends RoomDatabase {
    public abstract GameDAO getGameDao();
}
