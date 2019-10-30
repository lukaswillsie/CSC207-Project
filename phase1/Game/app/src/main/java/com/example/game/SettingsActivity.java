package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.game.data.Setting;
import com.example.game.services.GameData;
import com.example.game.services.SettingsManager;
import com.example.game.services.SettingsManagerBuilder;

public class SettingsActivity extends AppCompatActivity {
    private SettingsManager settingsManager;
    private String username;
    private SeekBar numHandsBar;
    private SeekBar numRoundsBar;
    private Switch darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        username = GameData.USERNAME;
        settingsManager = new SettingsManagerBuilder().build(this, username);

        numHandsBar = findViewById(R.id.numHandsSeekBar);
        // Read user's setting for number of hands and set it as progress on the seek bar
        numHandsBar.setProgress(settingsManager.getSetting(Setting.NUM_HANDS));

        String progressText = "" + settingsManager.getSetting(Setting.NUM_HANDS);
        ((TextView)findViewById(R.id.numHandsLabel)).setText(progressText);

        numRoundsBar = findViewById(R.id.numRoundsSeekBar);
        // Read user's setting for number of rounds and set it as progress on the seek bar
        numRoundsBar.setProgress(settingsManager.getSetting(Setting.NUM_ROUNDS));

        progressText = "" + settingsManager.getSetting(Setting.NUM_ROUNDS);
        ((TextView)findViewById(R.id.numRoundsLabel)).setText(progressText);

        numHandsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String progressString = "" + progress;
                ((TextView)findViewById(R.id.numHandsLabel)).setText(progressString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        numRoundsBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String progressString = "" + progress;
                ((TextView)findViewById(R.id.numRoundsLabel)).setText(progressString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        darkMode = findViewById(R.id.darkModeSwitch);
        darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (!b){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                }
//                else{
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                }
//            }
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b){
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            else{
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }
        });

    }

    @Override
    protected void onStop(){
        super.onStop();
        settingsManager.updateSetting(Setting.NUM_HANDS, numHandsBar.getProgress());
        settingsManager.updateSetting(Setting.NUM_ROUNDS, numRoundsBar.getProgress());
        settingsManager.updateSetting(Setting.DARK_MODE, darkMode.isChecked() ? 1: 0);
    }
}
