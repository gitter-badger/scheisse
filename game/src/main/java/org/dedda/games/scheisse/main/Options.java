package org.dedda.games.scheisse.main;

import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.io.FileOutput;
import org.dedda.games.scheisse.tool.Parse;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;

/**
 * Created by dedda on 6/1/14.
 */
public class Options {

    public static final File OPTIONS_FILE =
        new File(System.getProperty("user.home") + "/.scheisse.conf");

    public static int KEY_MENU_UP = KeyEvent.VK_UP;
    public static int KEY_MENU_DOWN = KeyEvent.VK_DOWN;
    public static int KEY_MENU_LEFT = KeyEvent.VK_LEFT;
    public static int KEY_MENU_RIGHT = KeyEvent.VK_RIGHT;
    public static int KEY_PAUSE_GAME = KeyEvent.VK_ESCAPE;
    public static int KEY_MENU_BACK = KeyEvent.VK_ESCAPE;

    private static boolean checkInternetConnection = true;
    private static Dimension resolution;

    static {
        initDefault();
    }

    public static void initDefault() {
        if (!OPTIONS_FILE.exists()) {
            checkInternetConnection = true;
            resolution = new Dimension(600, 400);
            save();
        } else {
            load();
        }
    }

    public static void load() {
        HashMap<String, String> fileMap = new FileInput().getMap(OPTIONS_FILE);
        for (String key : fileMap.keySet()) {
            if (key.equals("check net")) {
                checkInternetConnection = Parse.toBoolean(fileMap.get(key));
            } else if (key.equals("res")) {
                resolution = Parse.toDimension(fileMap.get(key));
            }
        }
    }

    public static void save() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("check net", checkInternetConnection ? "1" : "0");
        map.put("res", resolution.width + "," + resolution.height);
        File file =
            new File(System.getProperty("user.home") + "/.scheisse.conf");
        FileOutput output = new FileOutput(file);
        output.writeHashMap(map);
        output.close();
    }

    public static void set(final HashMap<String, String> map) {
        if (map.containsKey("res")) {
            resolution = Parse.toDimension(map.get("res"));
        }
        if (map.containsKey("check net")) {
            checkInternetConnection = Parse.toBoolean(map.get("check net"));
        }
    }

    public static void set(final String key, final Object value) {
        if (key.equals("res")) {
            resolution = (Dimension) value;
        } else if (key.equals("check net")) {
            checkInternetConnection = (Boolean) value;
        }
    }

    public static boolean isCheckInternetConnection() {
        return checkInternetConnection;
    }

    public static void setCheckInternetConnection(
        final boolean checkInternetConnection
    ) {
        Options.checkInternetConnection = checkInternetConnection;
    }

    public static Dimension getResolution() {
        return resolution;
    }

    public static void setResolution(final Dimension resolution) {
        Options.resolution = resolution;
    }
}
