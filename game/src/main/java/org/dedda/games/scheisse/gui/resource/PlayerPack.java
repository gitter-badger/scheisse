package org.dedda.games.scheisse.gui.resource;

/**
 * Created by dedda on 11.01.15.
 */
public class PlayerPack extends SpritePack {

    public static final int LENGTH = 0;

    public PlayerPack(final ResourcePack pack) {
        super(pack, PLAYER);
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
