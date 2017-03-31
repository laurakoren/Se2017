package com.madn.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.madn.game.madnGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = madnGame.WIDTH;
        config.height = madnGame.HEIGHT;
        new LwjglApplication(new madnGame(), config);
    }
}
