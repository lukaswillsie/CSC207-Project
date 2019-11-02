package com.example.game.level3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.game.R;
import com.example.game.StartActivity;

public class CowsBullsStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cows_bulls_start);
    }


    /**
     * Method for button toGame to proceed to CowsBullsActivity
     */
    public void toGame(View view){
        Intent intent = new Intent(this, CowsBullsActivity.class);
        startActivity(intent);
    }
}
