package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Daniel on 22/04/2017.
 */

public class PrimeraPantalla implements Screen {

    private Stage stage;
    private PrimerSuperKoalio game;

    private Label.LabelStyle textStyle;
    private Label textLbl;
    private Label textLbl2;
    private Label textLbl3;
    private Container containerF, containerM, containerD;
    //private boolean modo = true;


    public PrimeraPantalla(final PrimerSuperKoalio game) {

        this.game = game;

        // Creem la càmera de les dimensions del joc
        OrthographicCamera camera = new OrthographicCamera(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        // Posant el paràmetre a true configurem la càmera per a
        // que faci servir el sistema de coordenades Y-Down
        camera.setToOrtho(true);

        // Creem el viewport amb les mateixes dimensions que la càmera
        StretchViewport viewport = new StretchViewport(Settings.GAME_WIDTH, Settings.GAME_HEIGHT, camera);

        // Creem l'stage i assginem el viewport
        stage = new Stage(viewport);

        // Afegim el fons
        stage.addActor(new Image(AssetManager.background));


        // Creem l'estil de l'etiqueta i l'etiqueta
        textStyle = new Label.LabelStyle(AssetManager.font, null);
        textLbl = new Label("Jugar!", textStyle);
        System.out.println(Superkoalio.modo);
        if(Superkoalio.modo == 3){
            textLbl2 = new Label("Has Ganado!", textStyle);
            textLbl3 = new Label("Tu puntuación es: " + Superkoalio.moneda, textStyle);
        // Tu puntuación es: " + Superkoalio.moneda
        }
            if (Superkoalio.modo == 1) {
                textLbl2 = new Label("SuperKoalio!", textStyle);

            }
            if (Superkoalio.modo == 2) {
                textLbl2 = new Label("Has Perdido", textStyle);

        }


        // Creem el contenidor necessari per aplicar-li les accions
        containerF = new Container(textLbl);
        containerM = new Container(textLbl2);
       containerD = new Container(textLbl3);

        containerF.setTransform(true);
        containerF.center();
        containerF.setPosition(Settings.GAME_WIDTH/2,50);

        containerM.setTransform(true);
        containerM.center();
        containerM.setPosition(Settings.GAME_WIDTH /2 ,20);

        containerD.setTransform(true);
        containerD.center();
        containerD.setPosition(Settings.GAME_WIDTH /2,80);

        containerF.setName("Facil");
        stage.addActor(containerF);

        stage.addActor(containerM);

       stage.addActor(containerD);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        stage.draw();
        stage.act(delta);
        Vector3 vector;

        // Si es fa clic en la pantalla, canviem la pantalla
        if (Gdx.input.isTouched()) {


            if(Gdx.input.getX() >= containerF.getRight()+50 && Gdx.input.getX()/2 <= containerF.getRight()+80 && Gdx.input.getY() >= containerF.getTop() &&Gdx.input.getY() <= containerF.getTop()+150){
                Gdx.app.log ("coordenada Facil has clickado en" + Float.toString (Gdx.input.getX()), Float.toString(containerF.getRight()));
                game.setScreen(new Superkoalio(game));
                dispose();
            }

        }


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}