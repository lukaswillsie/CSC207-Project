package com.example.game;

import com.example.game.data.GameData;
import com.example.game.services.accounts.AccountManager;
import com.example.game.services.multiplayer_data.MultiplayerDataManager;

/**
 * Registers new users for a NewUserPage
 */
class NewAccountActivityPresenter {
    /**
     * The account manager being used by this object to manage user accounts
     */
    private AccountManager accountManager;

    /**
     * The MultiplayerDataManager this object will use to access and update multiplayer data,
     * if necessary
     */
    private MultiplayerDataManager multiplayerDataManager;

    /**
     * The NewUserPage that created this object
     */
    private NewUserPage callingPage;

    /**
     * Create a new NewAccountActivityPresenter
     *
     * @param accountManager - the AccountManager this object will use to manage user accounts
     * @param callingPage    - the page that created this object
     */
    NewAccountActivityPresenter(AccountManager accountManager, NewUserPage callingPage) {
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
     * Register a new user with the given username and password
     * <p>
     * Calls callingPage.accountCreationError() if something is wrong with the given
     * credentials
     *
     * @param username - the username of the new user to be created
     * @param password - the password of the new user to be created
     */
    void registerNewUser(String username, String password) {
        if (accountManager.usernameExists(username)) {
            callingPage.accountCreationError("That username already exists!");
        } else {
            if (GameData.MULTIPLAYER) {
                multiplayerDataManager.setPlayer2Username(username);
            } else {
                GameData.setUsername(username);
            }
            accountManager.createNewUser(username, password);
            callingPage.login();
        }
    }
}
