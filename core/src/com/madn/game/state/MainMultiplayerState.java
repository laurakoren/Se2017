package com.madn.game.state;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.madn.game.multiplayer.Server;

/**
 * Created by Philipp on 06.04.17.
 */

public class MainMultiplayerState extends State {

    private Button btn = new Button();
    private Stage stage = new Stage();
    private TextureAtlas t = new TextureAtlas();
    private Server server;

    public MainMultiplayerState(GameStateManager gsm) {
        super(gsm);
        btn.setPosition(100, 100);
        btn.setColor(Color.BLACK);
        server = Server.getInstance();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        stage.act(dt);
    }

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void dispose() {

    }
}
