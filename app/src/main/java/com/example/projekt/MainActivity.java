package com.example.projekt;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.RoomDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addGameButton;
    private EditText gameName;
    private EditText minPlayers;
    private EditText maxPlayers;
    private EditText ageCategory;
    private Spinner categorySpinner;
    private ListView gameListView;
    private List<Game> gameList;
    private ArrayAdapter<Game> arrayAdapter;

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
        addGameButton = findViewById(R.id.addGameButton);
        gameName = findViewById(R.id.gameName);
        minPlayers = findViewById(R.id.minPlayers);
        maxPlayers = findViewById(R.id.maxPlayers);
        ageCategory = findViewById(R.id.ageCategory);
        categorySpinner = findViewById(R.id.categorySpinner);
        gameListView = findViewById(R.id.gameListView);

        GameDatabase gameDatabase = new RoomDatabase.Builder<>(
                getApplicationContext(),
                GameDatabase.class,
                "game_db"
        ).allowMainThreadQueries().build();

        gameList = gameDatabase.getGameDao().getAllGames();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gameList);
        gameListView.setAdapter(arrayAdapter);

        gameListView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        gameDatabase.getGameDao().deleteGame(gameList.get(i));
                        gameList.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );

        gameListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        );

        addGameButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        var game = new Game(
                                gameName.getText().toString(),
                                Integer.parseInt(minPlayers.getText().toString()),
                                Integer.parseInt(maxPlayers.getText().toString()),
                                Integer.parseInt(ageCategory.getText().toString()),
                                categorySpinner.getSelectedItem().toString()
                        );
                        gameDatabase.getGameDao().insertGame(game);
                        gameList.add(game);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
}