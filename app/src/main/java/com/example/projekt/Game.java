package com.example.projekt;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    @Override
    public String toString() {
        return  "name: " + name+
                "\nminPlayers: " + minPlayers +
                "\nmaxPlayers: " + maxPlayers +
                "\nageCategory: " + ageCategory +
                "\ncategory: " + category;
    }
}