package org.dedda.games.scheisse.gui.resource;

/**
 * Created by dedda on 11.01.15.
 */
public class SoilPack extends SpritePack {

    public static final int LENGTH = 0;

    public SoilPack(final ResourcePack pack) {
        super(pack, SOIL);
    }

    @Override
    protected Sprite[] loadSprites(final ResourcePack pack) {
        return new Sprite[0];
    }

    @Override
    protected Animation[] loadAnimations(final ResourcePack pack) {
        return new Animation[0];
    }
}
