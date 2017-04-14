package com.madn.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.madn.game.madnGame;

/**
 * Created by max on 31.03.2017.
 */

public class MenuState extends State {

    private Texture background;
    private Texture button;

    public MenuState(com.madn.game.state.GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, madnGame.WIDTH / 2, madnGame.HEIGHT / 2);
        background = new Texture("badlogic.jpg");
        button = new Texture("btn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new TestState(gsm));
            this.dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0, cam.viewportWidth, cam.viewportHeight);
        sb.draw(button, cam.position.x - button.getWidth() / 2, cam.position.y - button.getHeight() / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        button.dispose();
    }
}
