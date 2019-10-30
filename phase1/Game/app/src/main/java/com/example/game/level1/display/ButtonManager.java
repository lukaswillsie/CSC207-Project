package com.example.game.level1.display;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ButtonManager {
    private static List<Button> buttons;

    /**
     * Setup the ButtonManager for use. Must be called each time a new activity
     * wants to use ButtonManager
     *
     * Gets all the buttons from the given activity and keeps them in a List
     * @param activity - the activity that wants the ButtonManager
     */
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

    /**
     * Disable the button with the given id - that is, make it unclickable
     * The button's visibility will remain unchanged
     *
     * Does nothing if no button has the given id
     * @param id - the id of the button to disable
     */
    public static void disableButton(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setEnabled(false);
                break;
            }
        }
    }

    /**
     * Enable the button with the given id - that is, make it clickable
     * The button's visibility will remain unchanged
     * @param id - the id of the button to enable
     */
    public static void enableButton(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setEnabled(true);
                break;
            }
        }
    }

    /**
     * Make the button with the given id invisible, or does nothing if it is already invisible
     *
     * @param id - the id of the button to make invisible
     */
    public static void makeButtonInvisible(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }

    /**
     * Make the button with the given id visible, or does nothing if it is already visible
     *
     * @param id - the id of the button to make visible
     */
    public static void makeVisible(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                button.setVisibility(View.VISIBLE);
                break;
            }
        }
    }
}
