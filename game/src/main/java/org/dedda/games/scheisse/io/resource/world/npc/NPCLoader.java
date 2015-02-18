package org.dedda.games.scheisse.io.resource.world.npc;

import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.state.game.object.npc.NPC;

import java.io.File;
import java.io.FileFilter;

/**
 * Class for loading {@link NPC}s from files.
 *
 * Created by dedda on 10/4/14.
 *
 * @author dedda
 */
public class NPCLoader extends FileInput {

    public static FileFilter getNPCFileFilter() {
        return new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(".dgm");
            }
        };
    }

}
