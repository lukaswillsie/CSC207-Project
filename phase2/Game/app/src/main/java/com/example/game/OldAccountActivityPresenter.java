package com.example.game;

import com.example.game.data.GameData;
import com.example.game.services.accounts.AccountManager;
import com.example.game.services.multiplayer_data.MultiplayerDataManager;

/**
 * Logs in existing users for a OldUserPage
 */
class OldAccountActivityPresenter {
    /**
     * The account accountManager being used by this object to manage user accounts
     */
    private AccountManager accountManager;

    /**
     * The MultiplayerDataManager this object will use to access and update multiplayer data,
     * if necessary
     */
    private MultiplayerDataManager multiplayerDataManager;

    /**
     * The OldUserPage that created this object
     */
    private OldUserPage callingPage;

    /**
     * Create a new OldAccountActivityPresenter
     *
     * @param accountManager - the AccountManager to be used by this object to manage user accounts
     * @param callingPage    - the OldUserPage that created this object
     */
    OldAccountActivityPresenter(AccountManager accountManager, OldUserPage callingPage) {
        this.accountManager = accountManager;
        this.callingPage = callingPage;
    }

    /**
     * Give this object an instance of MultiplayerDataManager to use
     * <p>
     * NOTE: This method must be called if the game is in multiplayer mode
     *
     * @param multiplayerDataManager - the new MultiplayerDataManager for this class to use
     */
    void setMultiplayerDataManager(MultiplayerDataManager multiplayerDataManager) {
        this.multiplayerDataManager = multiplayerDataManager;
    }

    /**
     * Log in an existing user with the given username and password
     * <p>
     * Calls callingPage.loginError() if the given username and password are invalid; i.e. if the
     * username doesn't exist or the password is wrong
     *
     * @param username - the user's username
     * @param password - the user's password
     */
    void loginOldUser(String username, String password) {
        if (accountManager.validCredentials(username, password)) {
            if (GameData.MULTIPLAYER) {
                if (!username.equals(multiplayerDataManager.getPlayer1Username())) {
                    multiplayerDataManager.setPlayer2Username(username);
                    callingPage.login();
                } else {
                    callingPage.loginError("You can't log " + multiplayerDataManager.getPlayer1Username() + " in twice!");
                }
            } else {
                GameData.setUsername(username);
                callingPage.login();
            }

        } else {
            callingPage.loginError("Your login information is incorrect");
        }
    }
}
