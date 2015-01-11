package org.dedda.games.scheisse.gui.resource;

import java.awt.*;
import java.io.File;

/**
 * Created by dedda on 11.01.15.
 */
public class DecorationPack extends SpritePack {

    public static final int LENGTH = 1;

    public static final int WINDOW_ICON = 0;
    public static final int TRAY_ICON = 1;

    public DecorationPack(ResourcePack pack) {
        super(pack, DECORATION);
    }

    @Override
    protected Sprite[] loadSprites(ResourcePack pack) {
        String folder = pack.baseDirectory.getAbsolutePath();
        folder += folder.endsWith("/") ? "" : "/";
        Sprite[] sprites = loadSprites(
                new File[]{
                        new File(folder + "windowIcon.png"),
                        new File(folder + "trayIcon.png")
                },
                new Dimension[]{
                        new Dimension(32, 32),
                        new Dimension(32, 32)
                }
        );
        throw new UnsupportedOperationException();
        //return sprites;
    }

    @Override
    protected Animation[] loadAnimations(ResourcePack pack) {
        String folder = pack.baseDirectory.getAbsolutePath();
        folder += folder.endsWith("/") ? "" : "/";
        Animation[] animations = new Animation[]{};
        throw new UnsupportedOperationException();
        //return animations;
    }
}
