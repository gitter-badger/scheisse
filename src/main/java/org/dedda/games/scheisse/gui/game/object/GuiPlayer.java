package org.dedda.games.scheisse.gui.game.object;

import org.dedda.games.scheisse.gui.game.map.MapFrontend;
import org.dedda.games.scheisse.gui.sprite.Sprite;
import org.dedda.games.scheisse.state.game.object.GameObject;
import org.dedda.games.scheisse.state.game.object.PlayerObject;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;

/**
 * Created by dedda on 7/18/14.
 */
public class GuiPlayer extends GameGuiObject {

    public static final int SPRITE_STARRING_UP = 0;
    public static final int SPRITE_STARRING_DOWN = 1;
    public static final int SPRITE_STARRING_LEFT = 2;
    public static final int SPRITE_STARRING_RIGHT = 3;
    public static final int SPRITE_WALKING_UP = 4;
    public static final int SPRITE_WALKING_DOWN = 5;
    public static final int SPRITE_WALKING_LEFT = 6;
    public static final int SPRITE_WALKING_RIGHT = 7;

    public GuiPlayer(
            final Sprite[] sprites,
            final GameObject gameObject,
            final ImageObserver imageObserver,
            final MapFrontend mapFrontend) {
        super(sprites, gameObject, imageObserver, mapFrontend);
    }

    public GuiPlayer(
            final File ressourceFolder,
            final PlayerObject playerObject,
            final ImageObserver imageObserver) {
        super(ressourceFolder, playerObject, imageObserver, null);
    }

    public void render(final Graphics2D g2d) {

    }
}
