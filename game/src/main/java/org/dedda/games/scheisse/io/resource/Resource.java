
package org.dedda.games.scheisse.io.resource;

import org.dedda.games.scheisse.main.Main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by dedda on 5/24/14.
 */
public abstract class Resource {

    public static final String INSTALLATION_FOLDER =
            System.getProperty("user.home") + "/.scheisse/";
    public static final String SAVEGAME_FOLDER =
            INSTALLATION_FOLDER + "savegame/";
    public static final String DATA_FOLDER = INSTALLATION_FOLDER + "data/";
    //public static final String ITEM_FOLDER = DATA_FOLDER + "item/";
    public static final String ITEM_FOLDER = "src/test/test_files/classes/org/dedda/games/scheisse/io/resource/item/ItemLoader";
    public static final String IMAGE_FOLDER = DATA_FOLDER + "image/";
    public static final String TEMP_FOLDER = INSTALLATION_FOLDER + "temp/";
    public static final String ITEM_ZIP = "item.zip";
    public static final String IMAGE_ZIP = "image.zip";

    private static URL ITEM_URL;
    private static URL IMAGE_URL;

    public static HashMap<URL, String> getDownloadList() {
        HashMap<URL, String> map = new HashMap<URL, String>();
        map.put(ITEM_URL, ITEM_FOLDER);
        map.put(IMAGE_URL, IMAGE_FOLDER);
        return map;
    }

    public static URL getIMAGE_URL() {
        return IMAGE_URL;
    }

    public static URL getITEM_URL() {
        return ITEM_URL;
    }
}
