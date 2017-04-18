package com.madn.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.madn.game.multiplayer.Client;

import java.util.regex.Pattern;

/**
 * Created by Philipp on 15.04.2017.
 */

public class MultiplayerJoinState extends State {

    private Skin skin;
    private Stage stage;
    private Table table;
    private TextField addressInput;
    private TextField playerName;
    private TextButton connectBtn;
    private Label errorLabel;
    private Client client;
    private Pattern ipPattern;

    public MultiplayerJoinState(GameStateManager gsm) {
        super(gsm);

        final GameStateManager gsmDup = gsm;

        skin = new Skin(Gdx.files.internal("ui/default/uiskin.json"));
        skin.getFont("default-font").getData().setScale(3f);
        stage = new Stage(new StretchViewport(720, 1280), batch);
        Gdx.input.setInputProcessor(this.stage);

        table = new Table(skin);
        table.setFillParent(true);
        table.defaults().width(500).pad(15);

        addressInput = new TextField("", skin);
        playerName = new TextField("player" + (int) (Math.random()*100), skin);
        errorLabel = new Label("", skin);

        connectBtn = new TextButton("Connect", skin);
        connectBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (addressInput.getText() != "" && playerName.getText() != "") {
                    String address = addressInput.getText();
                    ipPattern = Pattern.compile("(([0-9]{1,3}\\.){3})[0-9]{1,3}:[0-9]{1,5}$");
                    if (ipPattern.matcher(address).matches()) {
                        String ipPort[] = address.split(":");
                        client = new Client(ipPort[0], Integer.parseInt(ipPort[1]));
                        if(client.isConnected()) {
                            gsmDup.set(new MultiplayerClientLobbyState(client, gsmDup));
                        }
                    }

                } else {
                    errorLabel.setColor(Color.RED);
                    errorLabel.setText("Please enter valid data");
                }

            }
        });

        table.add(addressInput);
        table.row();
        table.add(playerName);
        table.row();
        table.add(connectBtn);
        table.row();
        table.add(errorLabel);
        stage.addActor(table);
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {
        this.stage.act(dt);
    }

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void dispose() {

    }
}
