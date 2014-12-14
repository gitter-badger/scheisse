package org.dedda.games.scheisse.state.game.map.soil;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.main.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by dedda on 4/20/14.
 */
public class  Soil {

    public enum Type {
        GRASS, DIRT, ROCK, WATER;
    }

    private static HashMap<Type, Image> imageMap;
    private static HashMap<Type, Texture> textureMap;

    private synchronized static HashMap<Type, Image> initImageMap() {
        HashMap<Type, Image> imageMap = new HashMap<Type, Image>();
        for (Type soilType : Type.values()) {
            Image image = null;
            String fileName = Main.INSTALLATION_FOLDER + "data/image/map_" + String.valueOf(soilType).toLowerCase() + ".png";
            SystemPrinter.debugln("loaded image: " + fileName);
            image = Toolkit.getDefaultToolkit().getImage(fileName);
            imageMap.put(soilType, image);
        }
        return imageMap;
    }

    private synchronized static HashMap<Type, Texture> initTextureMap() {
        HashMap<Type, Texture> textureMap = new HashMap<Type, Texture>();
        for (Type type : Type.values()) {
            String fileName = Main.INSTALLATION_FOLDER + "data/image/map_" + String.valueOf(type).toLowerCase() + ".png";
            Texture texture = null;
            try {
                texture = TextureIO.newTexture(new File(fileName), true);
            } catch (IOException e) {e.printStackTrace();}
            SystemPrinter.debugln("loaded texture: " + fileName);
            textureMap.put(type, texture);
        }
        return textureMap;
    }

    public static void loadImages() {
        imageMap = initImageMap();
    }

    public static void loadTextures() {
        textureMap = initTextureMap();
    }

    public static void init() {
        loadImages();
        loadTextures();
    }

    public static HashMap<Type, Image> getImageMap() {
        return imageMap;
    }

    public static Image getImage(final Type soilType) {
        return imageMap.get(soilType);
    }

    public static HashMap<Type, Texture> getTextureMap() {
        return textureMap;
    }

    public static Texture getTexture(final Type type) {
        return textureMap.get(type);
    }
}
