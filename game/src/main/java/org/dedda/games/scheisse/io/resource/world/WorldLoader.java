package org.dedda.games.scheisse.io.resource.world;

import org.dedda.games.scheisse.exception.io.world.NoWorldDirectoryException;
import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.state.game.object.npc.NPC;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by dedda on 11/2/14.
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
