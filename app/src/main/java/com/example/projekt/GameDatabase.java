package com.example.projekt;

import androidx.room3.Database;
import androidx.room3.RoomDatabase;

@Database(entities = {Game.class}, version = 1)
public abstract class GameDatabase extends RoomDatabase {
    public abstract GameDAO getGameDao();
}
