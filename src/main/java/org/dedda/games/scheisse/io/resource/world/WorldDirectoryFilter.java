package org.dedda.games.scheisse.io.resource.world;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by dedda on 11/18/14.
 */
public class WorldDirectoryFilter implements FileFilter {

    public boolean accept(final File file) {
        return isWorldDirectory(file);
    }

    public static boolean isWorldDirectory(final File directory) {
        if (!directory.isDirectory()) {
            return false;
        }
        String directoryName = directory.getAbsolutePath();
        directoryName += directoryName.endsWith("/") ? "" : "/";
        File contents[] = directory.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        boolean containsLevel = false;
        boolean containsNPC = false;
        for (File file : contents) {
            if (file.getName().equals("level")) {
                containsLevel = true;
            } else if (file.getName().equals("npc")) {
                containsNPC = true;
            }
        }
        if (!containsLevel || !containsNPC) {
            return false;
        }
        return true;
    }

}
