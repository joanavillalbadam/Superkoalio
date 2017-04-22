package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * Created by Daniel on 22/04/2017.
 */

public class PrimerSuperKoalio  extends Game {
    public static int puntos = 0;
    @Override
    public void create() {

        // A l'iniciar el joc carreguem els recursos
        AssetManager.load();
        // I definim la pantalla d'splash com a pantalla
        setScreen(new PrimeraPantalla(this));

    }

    // Cridem per descartar els recursos carregats.
    @Override
    public void dispose() {
        super.dispose();
        AssetManager.dispose();
    }

}