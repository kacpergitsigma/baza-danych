package com.example.projekt;

import androidx.room3.Dao;
import androidx.room3.Delete;
import androidx.room3.Insert;
import androidx.room3.Query;
import androidx.room3.Update;

import java.util.List;

@Dao
public interface GameDAO {
    @Insert
    public void insertGame(Game game);
    @Insert
    public void insertGames(Game ... game);
    @Delete
    public void deleteGame(Game game);
    @Update
    public void updateGame(Game game);
    @Query("SELECT * FROM game")
    public List<Game> getAllGames();
    @Query("SELECT name FROM game WHERE minPlayers = :value")
    public String getGameNameByMinPlayers();
}
