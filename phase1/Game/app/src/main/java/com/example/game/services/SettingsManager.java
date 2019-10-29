package com.example.game.services;

import com.example.game.data.Setting;

public interface SettingsManager {
    void updateSetting(Setting setting, int newValue);

    int getSetting(Setting setting);
}
