package com.madn.game.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.madn.game.madnGame;

/**
 * Created by max on 31.03.2017.
 */

public class TestState extends State {


    public TestState(com.madn.game.state.GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, madnGame.WIDTH / 2, madnGame.HEIGHT / 2);
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.end();
    }

    @Override
    public void dispose() {
    }
}
