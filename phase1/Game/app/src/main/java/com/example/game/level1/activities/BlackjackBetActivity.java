package com.example.game.level1.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.game.R;

public class BlackjackBetActivity extends AppCompatActivity {
    public static String tag = "com.example.game.level1.activities.BlackjackBetActivity";
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_bet);
        score = getIntent().getIntExtra(BlackJackStartActivity.tag + ".score", 0);
        String scoreText = "Your Score: " + score;
        ((TextView) findViewById(R.id.betScore)).setText(scoreText);
    }

    public void bet(View view) {
        String userBet = ((TextView) findViewById(R.id.betText)).getText().toString();
        if (!userBet.equals("")) {
            int bet = Integer.parseInt((userBet));
            if (bet <= score) {
                Intent intent = new Intent(this, BlackjackPlayActivity.class);
                intent.putExtra(tag + ".bet", bet);
                intent.putExtra(tag + ".score", score - bet);
                startActivity(intent);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You can't bet more than your score").setPositiveButton(R.string.okay_button, null).create().show();
            }
        }

    }

    private class IllegalBetDialogFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("You can't bet more than your score").setPositiveButton(R.string.okay_button, null);
            return builder.create();
        }
    }
}
