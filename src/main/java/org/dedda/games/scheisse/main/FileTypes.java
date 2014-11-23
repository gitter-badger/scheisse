package org.dedda.games.scheisse.main;

import org.dedda.games.scheisse.io.FileInput;

import java.io.File;
import java.util.HashMap;

/**
 * Created by dedda on 11/23/14.
 */
public abstract class FileTypes {

    private static HashMap<String, String> extension_map;

    static {
    init();
    }

    public static void init(){
        File file = new File("src/test/test_files/file_extensions.conf");
        extension_map = new FileInput().getMap(file, true);
        for (String key : extension_map.keySet()) {
            extension_map.put(key, "." + extension_map.get(key).trim());
        }
    }

    public static String getExtension(String file_type) {
        return extension_map.get(file_type);
    }

}
