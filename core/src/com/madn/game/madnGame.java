package com.madn.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.madn.game.state.GameStateManager;
import com.madn.game.state.RollDiceState;
import com.madn.game.state.TestState;

public class madnGame extends ApplicationAdapter {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    private SpriteBatch batch;

    private GameStateManager gsm;


    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager(batch);
        Gdx.gl.glClearColor(1, 1, 1, 1);

        Gdx.input.setCatchBackKey(true);
        gsm.push(new TestState(gsm));
        //gsm.push(new RollDiceState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gsm.update(Gdx.graphics.getDeltaTime());

        gsm.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
