package com.example.game.level3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.MainActivity;
import com.example.game.R;
import com.example.game.StartActivity;
import com.example.game.data.Statistic;
import com.example.game.services.GameData;
import com.example.game.services.StatsManager;
import com.example.game.services.StatsManagerBuilder;

public class CowsBullsFinishActivity extends AppCompatActivity {

    TextView time;
    TextView numGuesses;
    StatsManager statsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        statsManager = new StatsManagerBuilder().build(this, GameData.USERNAME);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls_finish);

        time = findViewById(R.id.time);
        time.setText(((Integer) statsManager.getStat(Statistic.TIME_TAKEN)).toString() + " seconds");

        numGuesses = findViewById(R.id.numGuesses);
        numGuesses.setText(((Integer)statsManager.getStat(Statistic.NUMBER_OF_GUESSES)).toString());
    }

    public void menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
