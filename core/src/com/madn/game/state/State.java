package com.madn.game.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by max on 31.03.2017.
 */

@SuppressWarnings("WeakerAccess")
abstract class State {
    protected GameStateManager gsm;
    protected SpriteBatch batch;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        this.batch = gsm.getSpriteBatch();
    }

    /**
     * Handles input, needs to be called.
     */
    public abstract void handleInput();

    /**
     * Calculates all that is necessary for the next rendering.
     *
     * @param dt the time that has passed since the last update
     */
    public abstract void update(float dt);

    /**
     * Draws the contents of this state to the screen.
     */
    public abstract void render();

    /**
     * Frees memory and unloads unnecessary textures.
     */
    public abstract void dispose();
}
