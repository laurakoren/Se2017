package com.madn.game.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by max on 31.03.2017.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
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
     *
     * @param sb the SpriteBatch to draw in
     */
    public abstract void render(SpriteBatch sb);

    /**
     * Frees memory and unload unnecessary textures.
     */
    public abstract void dispose();
}
