package com.example.game.BlackjackGame.display;

import com.example.game.BlackjackGame.domain.Card;
import com.example.game.BlackjackGame.domain.Hand;
import com.example.game.BlackjackGame.domain.Player;
import com.example.game.BlackjackGame.domain.Rank;
import com.example.game.BlackjackGame.domain.Suit;

/**
 * Contains a Player object and converts the information contained in that player object to a String
 * for displaying on the interface
 */
public class PlayerInterpreter {
    /**
     * The player whose hand this PlayerInterpreter is relaying to the interface
     */
    private Player player;

    /**
     * The PlayerHandView that this PlayerInterpreter is using to
     * update the interface
     */
    private PlayerHandView view;

    /**
     * Create a new PlayerInterpreter with the given instance variables
     *
     * @param player - the player this PlayerInterpreter will be interpreting
     * @param view   - the PlayerHandView this PlayerInterpreter will be using to
     *               update the interface
     */
    public PlayerInterpreter(Player player, PlayerHandView view) {
        this.player = player;
        this.view = view;
    }

    /**
     * Gets called when the player's hand has changed and the interface needs to be updated
     * <p>
     * Generates the new String representing the player's hand and tells view to update
     * the interface accordingly
     */
    public void updatePlayerHand() {
        view.updateView(this.playerHandStringRep());
    }

    /**
     * Update the interface to display the string representation of the player's hand with the first
     * card hidden
     */
    public void updatePlayerHandHideFirstCard() {
        this.view.updateView(this.playerHandHideFirstCardStringRep());
    }

    /**
     * Create and return the string representation of the player's hand, hiding the first card
     * <p>
     * Is necessary because until the player has taken their cards, the dealer's first card
     * is supposed to be unknown to the player
     *
     * @return - a string representation of the player's hand, with the first card of their hand hidden
     */
    private String playerHandHideFirstCardStringRep() {
        boolean first = true;
        Hand hand = this.player.getHand();
        StringBuilder handString = new StringBuilder();
        for (Card card : hand) {
            if (first) {
                // Unicode for a black rectangle that kind of resembles a card back
                handString.append("\u2588");
                handString.append("   ");

                first = false;
            } else {
                handString.append(stringRep(card));
                handString.append("  ");
            }

        }

        return handString.toString();
    }

    /**
     * Create and return the string representation of the player's hand
     *
     * @return - a string representation of the player's hand
     */
    private String playerHandStringRep() {
        Hand hand = player.getHand();
        StringBuilder handString = new StringBuilder();
        for (Card card : hand) {
            handString.append(stringRep(card));
            handString.append("  ");
        }

        return handString.toString();
    }

    private String stringRep(Card card) {
        return stringRep(card.getRank()) + stringRep(card.getSuit());
    }

    private String stringRep(Suit suit) {
        switch (suit) {
            case SPADES:
                return "\u2660";
            case HEARTS:
                return "\u2665";
            case CLUBS:
                return "\u2663";
            case DIAMONDS:
                return "\u2666";
            default:
                return "";
        }
    }

    private String stringRep(Rank rank) {
        switch (rank) {
            case ACE:
                return "A";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
            case TEN:
                return "10";
            case JACK:
                return "J";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
            default:
                return "";
        }
    }
}
