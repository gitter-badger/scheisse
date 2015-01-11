package org.dedda.games.scheisse.gui.resource;

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

    protected abstract Sprite[] loadSprites(ResourcePack pack);

    protected abstract Animation[] loadAnimations(ResourcePack pack);

}
