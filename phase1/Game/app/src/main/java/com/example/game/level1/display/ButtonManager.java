package com.example.game.level1.display;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ButtonManager {
    private static List<Button> buttons;

    public static void setup(Activity activity) {
        buttons = new ArrayList<>();

        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        populateButtons(viewGroup);
    }

    /**
     * Get all the buttons from the given ViewGroup and add them to buttons
     * <p>
     * This code setup courtesy of Gopal Gopi on StackOverflow
     *
     * @param viewGroup - the ViewGroup to get all the buttons from
     */
    private static void populateButtons(ViewGroup viewGroup) {
        for (int i = 0, n = viewGroup.getChildCount(); i < n; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                populateButtons((ViewGroup) view);
            } else if (view instanceof Button) {
                buttons.add((Button) view);
            }
        }
    }

    public static void disableButton(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setEnabled(false);
                break;
            }
        }
    }

    public static void enableButton(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setEnabled(true);
                break;
            }
        }
    }

    public static void makeButtonInvisible(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }

    public static void makeVisible(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setVisibility(View.VISIBLE);
                break;
            }
        }
    }
}
