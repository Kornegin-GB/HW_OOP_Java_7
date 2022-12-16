package com.unit.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(5);
        config.setWindowedMode(1360, 768);
        config.setResizable(false);
        new Lwjgl3Application(new GdxUnitGame(), config);
    }
}
