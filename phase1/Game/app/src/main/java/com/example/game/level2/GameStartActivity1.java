package com.example.game.level2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.MainActivity;
import com.example.game.R;

public class GameStartActivity1 extends AppCompatActivity {
    GameManager gameManager = GameStartActivity.gameManager;
    static int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Game currentGame = gameManager.getCurrentGame();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start_activity1);
        ((TextView) findViewById(R.id.pointsFinishId)).setText(String.valueOf(currentGame.getPoints()));
        ((TextView) findViewById(R.id.guessesId)).setText(String.valueOf(currentGame.getNumOfGuess()));
    }

    /**
     * Assuming that a user inserted a number.
     * @return
     */
    private int getGuess() {
        return Integer.valueOf(((TextView) findViewById(R.id.guessInput)).getText().toString());
    }

    public void submitGuess(View view) {
        try {
            guess = getGuess();
            Game currentGame = gameManager.getCurrentGame();
            ((TextView) findViewById(R.id.guessInput)).setText("");

            if (currentGame.checkTheRightGuess(guess)) {
                currentGame.finishTheGame(guess);
                gameManager.checkRounds();
                Intent intent = new Intent(this, GameFinishActivity.class);
                startActivity(intent);
            } else {
                if (currentGame.checkGuess(guess)) {
                    //((TextView)findViewById(R.id.textView)).setVisibility(View.INVISIBLE);
                    this.highGuess();
                } else {
                    this.lowGuess();
                }
                this.updateScore();
            }
        }
        catch(Exception e){
                this.BadNumber();
        }
    }

    public void pauseExit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void highGuess(){
        ((TextView) findViewById(R.id.textView)).setText("Your guess is too high, try again.");
    }
    public void lowGuess(){
        ((TextView) findViewById(R.id.textView)).setText("Your guess is too low, try again.");
    }
    public void BadNumber(){
        ((TextView) findViewById(R.id.textView)).setText("You either did not enter the number or your number is too big, please try again");
    }
    public void updateScore(){
        Game currentGame = gameManager.getCurrentGame();
        ((TextView) findViewById(R.id.pointsFinishId)).setText(String.valueOf(currentGame.getPoints()));
        ((TextView) findViewById(R.id.guessesId)).setText(String.valueOf(currentGame.getNumOfGuess()));
    }


}
