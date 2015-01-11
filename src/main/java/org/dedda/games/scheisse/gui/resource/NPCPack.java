package org.dedda.games.scheisse.gui.resource;

/**
 * Created by dedda on 11.01.15.
 */
public class NPCPack extends SpritePack {

    public NPCPack(ResourcePack pack) {
        super(pack, NPC);
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
