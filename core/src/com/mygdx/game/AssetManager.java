package com.mygdx.game;

/**
 * Created by Daniel on 22/04/2017.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {

    // Sprite Sheet
    public static Texture sheet;


    // fons
    public static TextureRegion background;

    // Font
    public static BitmapFont font;



    public static void load() {
        // Carreguem les textures i li apliquem el mètode d'escalat 'nearest'
        sheet = new Texture(Gdx.files.internal("C:\\Users\\Daniel\\Desktop\\Superkoalio\\android\\assets\\data\\maps\\tiled\\super-koalio\\superFondo.jpg"));
        sheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        // Fons de pantalla
        background = new TextureRegion(sheet);
        background.flip(false, true);

        // Font space
        FileHandle fontFile = Gdx.files.internal("C:\\Users\\Daniel\\Desktop\\Superkoalio\\android\\assets\\data\\maps\\tiled\\super-koalio\\space.fnt");
        font = new BitmapFont(fontFile, true);
        font.getData().setScale(0.4f);
    }

    public static void dispose() {

        // Descrtem els recursos
        sheet.dispose();


    }
}
