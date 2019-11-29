package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.game.services.scoreboard.ScoreboardRepository;
import com.example.game.services.scoreboard.ScoreboardRepositoryFactory;
import com.example.game.services.scoreboard.ScoreboardUpdater;

import java.util.List;

public abstract class ScoreboardActivity extends AppCompatActivity implements ScoreboardUpdater {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
    }

    protected void initialize(ScoreboardRepository.Game game){
        ScoreboardRepository repo = new ScoreboardRepositoryFactory().build(game);

        TableLayout table = findViewById(R.id.highscoreTable);

        List<Pair<String, Integer>> highscores = repo.getHighScores(10);

        if(highscores.size() == 0){
            ((TextView)findViewById(R.id.highscoreTitle)).setText(R.string.noHighscoresMessage);
            return;
        }

        int rowIndex = 1;
        TableRow row;
        TextView rank, name, score;
        for(Pair<String, Integer> pair : highscores){
            // Get the next row of the table
            row = (TableRow) table.getChildAt(rowIndex);

            // Put the rank, name, and score of the current highscore pair into the proper TextViews
            rank = (TextView)row.getChildAt(0);
            name = (TextView)row.getChildAt(1);
            score = (TextView)row.getChildAt(2);

            String rankString = rowIndex+".";
            String scoreString = pair.second.toString();

            rank.setText(rankString);

            name.setText(pair.first);

            score.setText(scoreString);

            rowIndex++;
        }
    }

    @Override
    public void scoreboardStoreError() {
        // TODO: Implement this
    }
}
