package org.dedda.games.scheisse.gui.resource;

/**
 * Created by dedda on 11.01.15.
 */
public class PlayerPack extends SpritePack {

    public static final int LENGTH = 0;

    public PlayerPack(ResourcePack pack) {
        super(pack, PLAYER);
    }

    @Override
    protected Sprite[] loadSprites(ResourcePack pack) {
        return new Sprite[0];
    }

    @Override
    protected Animation[] loadAnimations(ResourcePack pack) {
        return new Animation[0];
    }
}
