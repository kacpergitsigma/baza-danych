package com.example.projekt;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room3.RoomDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GameDatabase gameDatabase = new RoomDatabase.Builder<>(
                getApplicationContext(),
                GameDatabase.class,
                "game_db"
        ).allowMainThreadQueries().build();

        gameDatabase.getGameDao().insertGame(new Game("Uno", 2, 10, 6, "Card Game"));
        System.out.println(gameDatabase.getGameDao().getAllGames().get(0).name);
    }
}