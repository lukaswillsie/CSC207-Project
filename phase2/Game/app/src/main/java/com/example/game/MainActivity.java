package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.game.data.Setting;
import com.example.game.BlackjackGame.activities.BlackjackStartActivity;
import com.example.game.GuessTheNumber.activities.GameStartActivity;
import com.example.game.CowsBullsGame.activities.CowsBullsStartActivity;
import com.example.game.data.GameData;
import com.example.game.services.MultiplayerDataManager;
import com.example.game.services.MultiplayerDataManagerFactory;
import com.example.game.services.SettingsManager;
import com.example.game.services.SettingsManagerBuilder;
import com.example.game.services.TestMultiplayerDataManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String username = GameData.USERNAME;
        String name = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();
        String welcomeText = "Welcome, " + name + "!";
        ((TextView) findViewById(R.id.welcomeText)).setText(welcomeText);

        if(GameData.MULTIPLAYER){
            hideMultiplayerButton();
        }

        //DarkMode Setting
        SettingsManager manager = new SettingsManagerBuilder().build(this, username);
        int temp = manager.getSetting(Setting.DARK_MODE);
        if (temp == 1) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void hideMultiplayerButton() {
        findViewById(R.id.multiplayerButton).setVisibility(View.INVISIBLE);
    }

    public void playBlackjack(View view) {
        Intent intent = new Intent(this, BlackjackStartActivity.class);
        startActivity(intent);
    }

    public void playCowsAndBulls(View view) {
        Intent intent = new Intent(this, CowsBullsStartActivity.class);
        startActivity(intent);
    }

    public void chooseTheNum(View view) {
        Intent intent = new Intent(this, GameStartActivity.class);
        startActivity(intent);
    }

    public void setting(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void stats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

    public void multiplayer(View view){
        Intent intent = new Intent(this, StartActivity.class);
        GameData.setMultiplayer(true);

        // Initialize the MultiplayerDataManager and record the username of player 1
        MultiplayerDataManager multiplayerDataManager = new MultiplayerDataManagerFactory().build();
        multiplayerDataManager.setPlayer1Username(GameData.USERNAME);

        startActivity(intent);
    }

    /**
     * Override the default onBackPressed method to do nothing
     *
     * This prevents undesired behaviour from occurring. For example, if the player finishes a game
     * of blackjack and then goes to the main menu, they can press back multiple times to go back to
     * the game screen
     */
    @Override
    public void onBackPressed(){}
}
