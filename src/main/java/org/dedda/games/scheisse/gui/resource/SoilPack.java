package org.dedda.games.scheisse.gui.resource;

/**
 * Created by dedda on 11.01.15.
 */
public class SoilPack extends SpritePack {

    public SoilPack(ResourcePack pack) {
        super(pack, SOIL);
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
