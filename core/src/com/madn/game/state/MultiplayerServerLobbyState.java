package com.madn.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.madn.game.multiplayer.Server;

/**
 * Created by Philipp on 15.04.17.
 */

public class MultiplayerServerLobbyState extends MultiplayerLobbyState {

    private Server server;
    private Label playerOneLabel;
    private Label playerTwoLabel;
    private Label playerThreeLabel;
    private Label playersJoinedLabel;

    public MultiplayerServerLobbyState(final GameStateManager gsm) {
        super(gsm);
        server = Server.getInstance();

        setServerIpText(server.getIp()+":"+server.getPort());

        cancelBtn.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                server.shutdown();
                gsm.set(new MainMultiplayerState(gsm));
            }
        });

        playerOneLabel = new Label("", skin);
        playerTwoLabel = new Label("", skin);
        playerThreeLabel = new Label("", skin);
        playersJoinedLabel = new Label("1/4 Players joined", skin);

        table.add(playerOneLabel);
        table.row();
        table.add(playerTwoLabel);
        table.row();
        table.add(playerThreeLabel);
        table.row();
        table.add(playersJoinedLabel);
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {
        stage.act(dt);
        try{
            playerOneLabel.setText(server.getClient(0).getPlayerName());
            playerTwoLabel.setText(server.getClient(1).getPlayerName());
            playerThreeLabel.setText(server.getClient(2).getPlayerName());
            playersJoinedLabel.setText("All Players joined!");
        }catch (NullPointerException e){
            playersJoinedLabel.setText(server.getJoinedPlayers()+"/4 Players joined");
        }
    }

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void dispose() {

    }


}
