package com.example.game.level3;

import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;

public class CowsBullsActivity extends AppCompatActivity {
    private TextView timer;
    private Chronometer chronometer;
    private long elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls);

        chronometer = findViewById(R.id.timer);
        chronometer.start();
    }
}
