package com.example.game.services.scoreboard;

import com.example.game.data.GameData;

import java.io.File;

public class ScoreboardRepositoryFactory {
    public ScoreboardRepository build(ScoreboardRepository.Game game){
        File filesDir = new File(GameData.filesDirPath);
        File highscoreFile = new File(filesDir, path(game));

        ScoreboardFileManager repository = new ScoreboardFileManager();
        repository.setFile(highscoreFile);

        return repository;
    }

    private String path(ScoreboardRepository.Game game){
        switch(game){
            case BLACKJACK:
                return "blackjack_highscores";
            case COWS_AND_BULLS:
                return "cows_and_bulls_highscores";
            case GUESS_THE_NUMBER:
                return "guess_the_number_highscores";
            default:
                return "";
        }
    }
}

