package com.madn.game.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Manager for States, built as Stack of States where the top State is the one being rendered.
 *
 * @see State
 */
public class GameStateManager {
    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    /**
     * Puts a new State on top. (e.g. a pause menu)
     *
     * @param state the new top State
     */
    public void push(State state) {
        states.push(state);
    }

    /**
     * Removes the top State. (e.g. exiting a menu)
     */
    public void pop() {
        states.pop();
    }

    /**
     * Exchange current top State for a new one. (e.g. switching between views of the same layer)
     *
     * @param state the new top State
     */
    public void set(State state) {
        states.pop();
        states.push(state);
    }

    /**
     * Calls the render method of the top State.
     *
     * @param dt the time that has passed since the last update.
     * @see State
     */
    public void update(float dt) {
        states.peek().update(dt);
    }

    /**
     * Calls the render method of the top State.
     *
     * @param sb a SpriteBatch
     * @see State
     */
    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
