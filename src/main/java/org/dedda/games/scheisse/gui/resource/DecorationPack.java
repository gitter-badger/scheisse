package org.dedda.games.scheisse.gui.resource;

/**
 * Created by dedda on 11.01.15.
 */
public class DecorationPack extends SpritePack {

    public DecorationPack(ResourcePack pack) {
        super(pack, DECORATION);
    }

    @Override
    protected Sprite[] loadSprites(ResourcePack pack) {
        Sprite[] sprites = new Sprite[]{};
        throw new UnsupportedOperationException();
        //return sprites;
    }

    @Override
    protected Animation[] loadAnimations(ResourcePack pack) {
        Animation[] animations = new Animation[]{};
        throw new UnsupportedOperationException();
        //return animations;
    }
}
