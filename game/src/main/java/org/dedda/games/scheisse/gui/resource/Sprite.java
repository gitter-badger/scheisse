package org.dedda.games.scheisse.gui.resource;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by dedda on 11.01.15.
 */
public class Sprite {

    protected Texture texture;
    public final ResourcePack pack;

    public Sprite(final Texture texture, final ResourcePack pack) {
        this.texture = texture;
        this.pack = pack;
    }

    public Texture getTexture() {
        return texture;
    }
}
