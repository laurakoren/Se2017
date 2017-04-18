package com.madn.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Philipp on 06.04.17.
 */

public class MainMultiplayerState extends State {

    private Skin skin;
    private Stage stage;
    private Table table;
    private TextButton hostServerBtn;
    private TextButton joinGameBtn;

    public MainMultiplayerState(GameStateManager gsm) {
        super(gsm);

        final GameStateManager gsmDup = gsm;
        skin = new Skin(Gdx.files.internal("ui/default/uiskin.json"));
        skin.getFont("default-font").getData().setScale(3f);

        stage = new Stage(new StretchViewport(720, 1280), batch);
        Gdx.input.setInputProcessor(this.stage);

        table = new Table(skin);
        table.setFillParent(true);
        table.defaults().width(500).pad(15);

        hostServerBtn = new TextButton("Host Game", skin);
        hostServerBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                gsmDup.set(new MultiplayerServerLobbyState(gsmDup));

            }
        });


        joinGameBtn = new TextButton("Join Game", skin);
        joinGameBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                gsmDup.set(new MultiplayerJoinState(gsmDup));
            }
        });

        table.add(hostServerBtn);
        table.row();
        table.add(joinGameBtn);


        stage.addActor(table);
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
