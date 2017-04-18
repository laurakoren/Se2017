package com.madn.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Philipp on 15.04.17.
 */

public abstract class MultiplayerLobbyState extends State {

    public Skin skin;
    public Stage stage;
    public Table table;
    public TextButton cancelBtn;
    private Label serverIpTxt;

    public MultiplayerLobbyState(final GameStateManager gsm) {
        super(gsm);
        final GameStateManager gsmDup = gsm;
        skin = new Skin(Gdx.files.internal("ui/default/uiskin.json"));
        skin.getFont("default-font").getData().setScale(3f);

        stage = new Stage(new StretchViewport(720, 1280), batch);
        Gdx.input.setInputProcessor(this.stage);

        serverIpTxt = new Label("", skin);


        cancelBtn = new TextButton("Cancel", skin);



        table = new Table(skin);
        table.setFillParent(true);
        table.defaults().width(500).pad(15);


        table.add(cancelBtn);
        table.row();
        table.add(serverIpTxt);
        table.row();



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

    public void setServerIpText(String ip){
        serverIpTxt.setText("IP: "+ip);
    }
}
