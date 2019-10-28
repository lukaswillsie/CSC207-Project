package com.example.game.level1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;

public class BlackjackStartActivity extends AppCompatActivity {
    public static String tag = "com.example.game.level1.activities";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.black_jack_start);
        ((TextView) findViewById(R.id.blackjackBlurb)).setMovementMethod(LinkMovementMethod.getInstance());

        Log.i("Directory", getDir("users", 0).toString());
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, BlackjackPlayActivity.class);
        intent.putExtra(tag + ".score", 500);
        startActivity(intent);
    }
}
