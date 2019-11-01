package com.example.game;

import com.example.game.services.AccountManager;

public class OldAccountActivityPresenter {
    private AccountManager manager;
    private OldUserPage callingPage;

    OldAccountActivityPresenter(AccountManager manager, OldUserPage callingPage) {
        this.manager = manager;
        this.callingPage = callingPage;
    }

    public void loginNewUser(String username, String password) {
        if (manager.validCredentials(username, password)) {
            callingPage.login();
        } else {
            callingPage.loginError("Your login information is incorrect");
        }
    }
}
