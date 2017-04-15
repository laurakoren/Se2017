package com.madn.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.madn.game.madnGame;

import java.util.Random;

/**
 * Created by Michi on 14.04.2017.
 */

public class RollDiceState extends State {

    private final Sound sound = Gdx.audio.newSound(Gdx.files.internal("data/mysound.mp3"));
    private TextButton roll_button;
    private Random randomNumber = new Random();
    private int rolledNumber;
    private Button cheat_button;
    private boolean cheated = false;
    private Stage st;
    private Dialog d;
    private Skin skin;
    private Table tbl;


    public RollDiceState(com.madn.game.state.GameStateManager gsm){
       super(gsm);

        skin = new Skin(Gdx.files.internal("ui/default/uiskin.json"));
        skin.getFont("default-font").getData().setScale(3f);

        st = new Stage(new StretchViewport(720, 1280), batch);
        Gdx.input.setInputProcessor(this.st);

        tbl = new Table(skin);
        tbl.setFillParent(true);
        tbl.defaults().width(500).pad(15);

        roll_button = new TextButton("Würfeln", skin);

        roll_button.addListener(new ClickListener(){
                @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                    rolledNumber = randomNumber.nextInt(6) + 1; //nextInt(6) gibt Zahlen von 0 bis 5 -> daher + 1
                    //doAnimationAndSound();
                }
        });
        tbl.add(roll_button);
        tbl.row();

        //Schummelbutton mit Schummelfunktion
        cheat_button = new TextButton("Schummeln", skin);

        cheat_button.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                //Popup mit möglichen Zahlen die man würfeln kann; skin muss geändert werden
              // d = new Dialog("Welche Zahl möchtest du würfeln?", skin);)   d.button("Eins");
              //  d.button("Zwei");
            }
        });
        tbl.add(cheat_button);

        st.addActor(tbl);


    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        this.st.act(dt);
    }

    @Override
    public void render() {
        st.draw();

    }


    @Override
    public void dispose() {
        st.dispose();

    }

    private void doAnimationAndSound(){
        //spielt Sound ab
        sound.play(1.0f);
        changePicture(rolledNumber);

    }

    //Methode die das Bild ändert anhand der gewürfelten Zahl; muss noch implementiert werden
    private void changePicture(int number){
        switch(number){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;

        }

    }

    public boolean getCheat(){

        return this.cheated;
    }
}
