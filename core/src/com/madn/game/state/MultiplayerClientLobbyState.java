package com.madn.game.state;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.madn.game.multiplayer.Client;
import com.madn.game.multiplayer.Server;

/**
 * Created by Philipp on 15.04.17.
 */

public class MultiplayerClientLobbyState extends MultiplayerLobbyState {

    private Client client;

    public MultiplayerClientLobbyState(Client c, final GameStateManager gsm) {
        super(gsm);
        client = c;

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
