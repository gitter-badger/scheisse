package org.dedda.games.scheisse.world.soil;

import com.jogamp.opengl.util.texture.Texture;

import java.awt.Image;
import java.util.HashMap;

/**
 * Created by dedda on 4/20/14.
 *
 * @author dedda
 */
public class Soil {

    public enum Type {
        GRASS, DIRT, ROCK, WATER;
    }

    private static HashMap<Type, Image> imageMap;
    private static HashMap<Type, Texture> textureMap;

    private synchronized static HashMap<Type, Image> initImageMap() {
        HashMap<Type, Image> imageMap = new HashMap<Type, Image>();
        return imageMap;
    }

    private synchronized static HashMap<Type, Texture> initTextureMap() {
        HashMap<Type, Texture> textureMap = new HashMap<Type, Texture>();
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

    private Soil() {}
}
