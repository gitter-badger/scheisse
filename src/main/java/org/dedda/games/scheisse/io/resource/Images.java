package org.dedda.games.scheisse.io.resource;

import java.awt.*;

import static org.dedda.games.scheisse.io.resource.Resource.IMAGE_FOLDER;

/**
 * Created by dedda on 6/9/14.
 */
public abstract class Images {

    public static final Image MAIN_MENU_START = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "main_menu_start.png");
    public static final Image MAIN_MENU_OPTIONS = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "main_menu_options.png");
    public static final Image MAIN_MENU_EXIT = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "main_menu_exit.png");
    public static final Image MAIN_MENU_CLOSE = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "main_menu_close.png");
    public static final Image MAIN_MENU_MINIMIZE = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "main_menu_minimize.png");

    public static final Image GAME_CLOSE = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "game_close.png");
    public static final Image GAME_MINIMIZE = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "game_minimize.png");
    public static final Image GAME_MAXIMIZE = Toolkit.getDefaultToolkit().getImage(IMAGE_FOLDER + "game_maximize.png");

}
