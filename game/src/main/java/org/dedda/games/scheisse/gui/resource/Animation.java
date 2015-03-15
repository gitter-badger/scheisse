package org.dedda.games.scheisse.gui.resource;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by dedda on 11.01.15.
 */
public class Animation extends Sprite {

    /**
     * textures to loop through.
     */
    private Texture[] textures;

    /**
     * counter for current frame.
     */
    private int currentFrame = 0;

    /**
     * time to wait for next frame.
     */
    private float updateTime;

    /**
     * time to wait between frames.
     */
    private final float defaultUpdateTime;

    /**
     * counter for time between updates.
     */
    private float updateTimeCounter = 0;

    /**
     * times updated.
     */
    private long updated = 0;

    /**
     * completed cycles.
     */
    private long cycles = 0;

    /**
     * default constructor for animations.
     *
     * @param textures
     * @param updateTime
     * @param pack
     */
    public Animation(
            final Texture[] textures,
            final float updateTime,
            final ResourcePack pack
    ) {
        super(textures[0], pack);
        this.textures = textures;
        this.defaultUpdateTime = updateTime;
        this.updateTime = updateTime;
    }

    /**
     * update routine between rendering cycles.
     *
     * @param dt time delta to last update
     */
    public final void update(final float dt) {
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

    /**
     * @return times updated
     */
    public final long getUpdated() {
        return updated;
    }

    /**
     * @return completed cycles
     */
    public final long getCycles() {
        return cycles;
    }
}
