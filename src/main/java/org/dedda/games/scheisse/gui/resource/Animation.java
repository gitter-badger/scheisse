package org.dedda.games.scheisse.gui.resource;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by dedda on 11.01.15.
 */
public class Animation extends Sprite {

    private Texture[] textures;
    private int currentFrame = 0;
    private float updateTime;
    private final float defaultUpdateTime;
    private float updateTimeCounter = 0;
    private long updated = 0;
    private long cycles = 0;

    public Animation(Texture[] textures, float updateTime, ResourcePack pack) {
        super(textures[0], pack);
        this.textures = textures;
        this.defaultUpdateTime = updateTime;
        this.updateTime = updateTime;
    }

    public void update(final float dt) {
        updateTimeCounter += dt;
        if (updateTimeCounter > updateTime) {
            updateTimeCounter -= updateTime;
            updated++;
            currentFrame++;
            if (currentFrame >= textures.length) {
                currentFrame = 0;
                cycles++;
            }
            texture = textures[currentFrame];
        }
    }

}
