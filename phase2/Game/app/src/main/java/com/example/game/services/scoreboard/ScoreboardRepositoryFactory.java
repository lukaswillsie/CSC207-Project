package com.example.game.services.scoreboard;

import com.example.game.data.GameConstants;
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
                return GameConstants.BLACKJACK_HIGHSCORE_FILE;
            case COWS_AND_BULLS:
                return GameConstants.COWS_AND_BULLS_HIGHSCORE_FILE;
            case GUESS_THE_NUMBER:
                return GameConstants.GUESS_THE_NUMBER_HIGHSCORE_FILE;
            default:
                return "";
        }
    }
}

