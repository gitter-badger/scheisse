package org.dedda.games.scheisse.io.resource;

import java.awt.Image;
import java.awt.Toolkit;

import static org.dedda.games.scheisse.io.resource.Resource.IMAGE_FOLDER;

/**
 * Created by dedda on 6/9/14.
 */
public abstract class Images {

    private static Toolkit tk = Toolkit.getDefaultToolkit();

    public static final int MAIN_MENU_START = 0;
    public static final int MAIN_MENU_OPTIONS = 1;
    public static final int MAIN_MENU_EXIT = 2;
    public static final int MAIN_MENU_CLOSE = 3;
    public static final int MAIN_MENU_MINIMIZE = 4;

    public static final int GAME_CLOSE = 5;
    public static final int GAME_MINIMIZE = 6;
    public static final int GAME_MAXIMIZE = 7;

    private static final Image[] IMAGES = new Image[]{
        tk.getImage(IMAGE_FOLDER + "main_menu_start.png"),
        tk.getImage(IMAGE_FOLDER + "main_menu_options.png"),
        tk.getImage(IMAGE_FOLDER + "main_menu_exit.png"),
        tk.getImage(IMAGE_FOLDER + "main_menu_close.png"),
        tk.getImage(IMAGE_FOLDER + "main_menu_minimize.png"),

        tk.getImage(IMAGE_FOLDER + "game_close.png"),
        tk.getImage(IMAGE_FOLDER + "game_minimize.png"),
        tk.getImage(IMAGE_FOLDER + "game_maximize.png")
    };

    public static Image get(final int key) {
        return IMAGES[key];
    }

}
