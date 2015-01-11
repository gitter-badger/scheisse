package org.dedda.games.scheisse.gui.resource;

import java.awt.*;
import java.io.File;

/**
 * Created by dedda on 11.01.15.
 */
public abstract class SpritePack {

    public static final int DECORATION = 0;
    public static final int MENU = 1;
    public static final int SOIL = 2;
    public static final int PLAYER = 3;
    public static final int NPC = 4;

    public final ResourcePack pack;
    public final int packType;
    protected Sprite[] sprites;
    protected Animation[] animations;

    public SpritePack(
            final ResourcePack pack,
            final int packType) {
        this.pack = pack;
        this.packType = packType;
        this.sprites = loadSprites(pack);
        this.animations = loadAnimations(pack);
    }

    public void update(final float dt) {
        for (Animation animation : animations) {
            animation.update(dt);
        }
    }

    public Sprite get(int key) {
        if (key < sprites.length) {
            return sprites[key];
        } else if (key < sprites.length + animations.length) {
            return animations[key - sprites.length];
        }
        throw new NullPointerException("No sprite for key " + key);
    }

    protected Sprite[] loadSprites(File[] files, Dimension[] sizes) {
        Sprite[][] sprites = new Sprite[files.length][];
        int length = 0;
        for (int i = 0; i < files.length; i++) {
            sprites[i] = loadSprites(files[i], sizes[i]);
            length += sprites[i].length;
        }
        Sprite[] ret = new Sprite[length];
        for (int i = 0; i < length; i++) {
            //TODO: rearrange sprites to new array for return
        }
        return ret;
    }

    protected Sprite[] loadSprites(File file, Dimension size) {
        return null;
    }

    protected Animation loadAnimation(File file, Dimension size) {
        return null;
    }

    protected abstract Sprite[] loadSprites(ResourcePack pack);

    protected abstract Animation[] loadAnimations(ResourcePack pack);

}
