package org.dedda.games.scheisse.fsloaders.resource.world;

import org.dedda.games.scheisse.fsloaders.resource.FileInput;
import org.dedda.games.scheisse.fsloaders.resource.exception.NoWorldDirectoryException;
import org.dedda.games.scheisse.npc.npc.NPC;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by dedda on 11/2/14.
 *
 * @author dedda
 */
public class WorldLoader extends FileInput {

    private File directory;

    public WorldLoader(final File directory) throws NoWorldDirectoryException {
        if (!WorldDirectoryFilter.isWorldDirectory(directory)) {
            throw new NoWorldDirectoryException();
        }
        this.directory = directory;
    }

    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<NPC>();
        String npcDirectoryPath = directory.getAbsolutePath();
        npcDirectoryPath += npcDirectoryPath.endsWith("/") ? "" : "/";
        npcDirectoryPath += "npc/";
        File npcDirectory = new File(npcDirectoryPath);

        return npcs;
    }

}
