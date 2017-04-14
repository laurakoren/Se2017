package com.madn.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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

    Skin skin;

    public RollDiceState(GameStateManager gsm){
       super(gsm);
        cam.setToOrtho(false, madnGame.WIDTH / 2, madnGame.HEIGHT / 2);

        st = new Stage();

        skin = new Skin(Gdx.files.internal("btn.png"));

        roll_button = new TextButton("Würfeln", skin);
        roll_button.setPosition(300,300);
        roll_button.setSize(100,100);

        roll_button.addListener(new ClickListener(){
                @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                    rolledNumber = randomNumber.nextInt(6) + 1; //nextInt(6) gibt Zahlen von 0 bis 5 -> daher + 1
                    doAnimationAndSound();
                }
        });
        st.addActor(roll_button);

        //Schummelbutton mit Schummelfunktion
        cheat_button = new TextButton("Schummeln", skin);
        cheat_button.setPosition(500,500);
        cheat_button.setSize(100,100);

        cheat_button.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button){
                //Popup mit möglichen Zahlen die man würfeln kann; skin muss geändert werden
               d = new Dialog("Welche Zahl möchtest du würfeln?", skin);
                d.button("Eins");
                d.button("Zwei");
            }
        });

        st.addActor(cheat_button);
        Gdx.input.setInputProcessor(st);

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
       // sb.setProjectionMatrix(cam.combined);
        //sb.begin();
       //sb.draw(background, 0, 0, cam.viewportWidth, cam.viewportHeight);
       // sb.draw(bt1, cam.position.x - bt1.getWidth() / 2, cam.position.y - bt1.getHeight() / 2);
        //sb.end();


    }


    @Override
    public void dispose() {


    }

    private void doAnimationAndSound(){
        changePicture(rolledNumber);
        //spielt Sound ab
        sound.play(1.0f);
    }

    //Methode die das Bild ändert anhand der gewürfelten Zahl
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
