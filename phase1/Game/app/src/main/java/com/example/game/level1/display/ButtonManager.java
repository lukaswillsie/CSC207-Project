package com.example.game.level1.display;

import android.view.View;
import android.widget.Button;

import java.util.List;

public class ButtonManager {
    private List<Button> buttons;

    public ButtonManager(List<Button> buttons){
        this.buttons = buttons;
    }

    public void disableButton(int id){
        for(Button button : buttons){
            if(button.getId() == id){
                button.setClickable(false);
            }
        }
    }

    public void enableButton(int id){
        for(Button button : buttons){
            if(button.getId() == id){
                button.setClickable(true);
            }
        }
    }

    public void makeButtonInvisible(int id){
        for(Button button : buttons){
            if(button.getId() == id){
                button.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void makeVisible(int id){
        for(Button button : buttons){
            if(button.getId() == id){
                button.setVisibility(View.VISIBLE);
            }
        }
    }
}
