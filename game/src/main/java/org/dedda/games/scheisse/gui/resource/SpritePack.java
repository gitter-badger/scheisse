package org.dedda.games.scheisse.gui.resource;

import java.awt.Dimension;
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
    public static final int ITEM = 5;

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

    public Sprite get(final int key) {
        if (key < sprites.length) {
            return sprites[key];
        } else if (key < sprites.length + animations.length) {
            return animations[key - sprites.length];
        }
        throw new NullPointerException("No sprite for key " + key);
    }

    protected Sprite[] loadSprites(
        final File[] files,
        final Dimension[] sizes
    ) {
        Sprite[][] sprites = new Sprite[files.length][];
        int length = 0;
        for (int i = 0; i < files.length; i++) {
            sprites[i] = loadSprites(files[i], sizes[i]);
            length += sprites[i].length;
        }
        Sprite[] ret = new Sprite[length];
        int i = 0;
        for (int x = 0; x < sprites.length; x++) {
            for (int y = 0; y < sprites[x].length; y++, i++) {
                ret[i] = sprites[x][y];
            }
        }
        return ret;
    }

    protected Sprite[] loadSprites(final File file, final Dimension size) {
        return null;
    }

    protected Animation loadAnimation(final File file, final Dimension size) {
        return null;
    }

    protected abstract Sprite[] loadSprites(final ResourcePack pack);

    protected abstract Animation[] loadAnimations(final ResourcePack pack);

}
