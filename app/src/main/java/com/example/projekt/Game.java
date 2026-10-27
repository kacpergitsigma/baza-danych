package com.example.projekt;

import androidx.room3.Entity;
import androidx.room3.PrimaryKey;

@Entity(tableName = "Game")
public class Game {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int minPlayers;
    public int maxPlayers;
    public int ageCategory;
    public String category;

    public Game(String name, int minPlayers, int maxPlayers, int ageCategory, String category) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.ageCategory = ageCategory;
        this.category = category;
    }
    public Game() {}
}