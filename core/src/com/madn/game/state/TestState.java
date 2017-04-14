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
 * Created by max on 31.03.2017.
 */

public class TestState extends State {

    private Skin skin;
    private Stage stage;
    private Table table;
    private TextButton btn1;
    private TextButton btn2;

    public TestState(GameStateManager gsm) {
        super(gsm);

        // for use in EventListeners
        final GameStateManager gsmDup = gsm;

        // init skin (default from libgdx/tests)
        skin = new Skin(Gdx.files.internal("ui/default/uiskin.json"));
        skin.getFont("default-font").getData().setScale(3f);

        // init stage (HD should be sufficient)
        stage = new Stage(new StretchViewport(720, 1280), batch);
        Gdx.input.setInputProcessor(this.stage);

        // init tableLayout and set to stretch across screen
        table = new Table(skin);
        table.setFillParent(true);

        // set width and padding for all table cells (i.e. for all buttons)
        table.defaults().width(500).pad(15);

        // create buttons
        btn1 = new TextButton("TestBtn", skin);
        btn1.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                // variables from outer scope must be declared final there
                gsmDup.set(new MenuState(gsmDup));
            }
        });
        table.add(btn1);
        table.row();

        btn2 = new TextButton("Btn2", skin);
        table.add(btn2);
        //table.row();

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
