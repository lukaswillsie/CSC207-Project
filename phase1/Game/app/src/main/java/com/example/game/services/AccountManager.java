package com.example.game.services;

public interface AccountManager {
    boolean usernameExists(String username);

    boolean validCredentials(String username, String password);

    void createNewUser(String username, String password);
}
