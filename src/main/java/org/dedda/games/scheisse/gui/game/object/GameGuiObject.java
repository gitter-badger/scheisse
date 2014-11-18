package org.dedda.games.scheisse.gui.game.object;

import org.dedda.games.scheisse.gui.Drawable;
import org.dedda.games.scheisse.gui.game.map.MapFrontend;
import org.dedda.games.scheisse.gui.sprite.Sprite;
import org.dedda.games.scheisse.io.resource.SpriteLoader;
import org.dedda.games.scheisse.state.game.object.GameObject;

import java.awt.image.ImageObserver;
import java.io.File;

/**
 * Created by dedda on 7/18/14.
 */
public abstract class GameGuiObject implements Drawable {

    private Sprite sprites[];
    private GameObject gameObject;
    private ImageObserver imageObserver;
    private MapFrontend mapFrontend;

    public GameGuiObject(
            final Sprite sprites[],
            final GameObject gameObject,
            final ImageObserver imageObserver,
            final MapFrontend mapFrontend) {
        this.sprites = sprites;
        this.gameObject = gameObject;
        this.imageObserver = imageObserver;
        this.mapFrontend = mapFrontend;
    }

    public GameGuiObject(
            final File ressourceFolder,
            final GameObject gameObject,
            final ImageObserver imageObserver,
            final MapFrontend mapFrontend) {
        SpriteLoader spriteLoader = new SpriteLoader();
        File spriteFolder = new File(ressourceFolder.getAbsolutePath() + "/sprites");
        setSprites(spriteLoader.getSprites(spriteFolder));
        this.gameObject = gameObject;
        this.imageObserver = imageObserver;
        this.mapFrontend = mapFrontend;
    }

    public Sprite[] getSprites() {
        return sprites;
    }

    public void setSprites(final Sprite sprites[]) {
        this.sprites = sprites;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(final GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public ImageObserver getImageObserver() {
        return imageObserver;
    }

    public void setImageObserver(final ImageObserver imageObserver) {
        this.imageObserver = imageObserver;
    }

    public MapFrontend getMapFrontend() {
        return mapFrontend;
    }

    public void setMapFrontend(final MapFrontend mapFrontend) {
        this.mapFrontend = mapFrontend;
    }
}
