package com.example.game;

import com.example.game.services.AccountManager;

public class NewAccountActivityPresenter {
    private AccountManager accountManager;
    private NewUserPage callingPage;

    NewAccountActivityPresenter(AccountManager accountManager, NewUserPage callingPage) {
        this.accountManager = accountManager;
        this.callingPage = callingPage;
    }

    public void registerNewUser(String username, String password) {
        if (accountManager.usernameExists(username)) {
            callingPage.accountCreationError("That username already exists!");
        } else {
            accountManager.createNewUser(username, password);
            callingPage.login();
        }
    }
}
