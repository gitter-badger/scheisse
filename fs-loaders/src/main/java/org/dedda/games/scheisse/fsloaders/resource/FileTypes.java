package org.dedda.games.scheisse.fsloaders.resource;

import org.dedda.games.scheisse.fsloaders.resource.FileInput;

import java.io.File;
import java.util.HashMap;

/**
 * Created by dedda on 11/23/14.
 *
 * @author dedda
 */
public abstract class FileTypes {

    public static final String PACKAGE = "dedda_package";
    public static final String SCRIPT = "dedda_script";
    public static final String ITEM = "dedda_item";
    public static final String MAP = "dedda_map";
    public static final String SAVEGAME = "dedda_savegame";

    private static HashMap<String, String> extension_map;

    static {
        init();
    }

    public static void init() {
        File file = new File("src/test/test_files/file_extensions.conf");
        extension_map = new FileInput().getMap(file, true);
        for (String key : extension_map.keySet()) {
            extension_map.put(key, "." + extension_map.get(key).trim());
        }
    }

    public static String getExtension(final String fileType) {
        return extension_map.get(fileType);
    }

}
