package org.dedda.games.scheisse.fsloaders.resource.npc;

import org.dedda.games.scheisse.fsloaders.resource.FileInput;
import org.dedda.games.scheisse.npc.behavior.NPCScript;
import org.dedda.games.scheisse.npc.npc.NPC;

import java.awt.geom.Point2D;
import java.io.File;

/**
 * Class for loading {@link NPC}s from files.
 *
 * Created by dedda on 10/4/14.
 *
 * @author dedda
 */
public class NPCLoader extends FileInput {

    private NPC npc = null;
    private NPCScript npcScript = null;
    private NPCScriptLoader scriptLoader;

    public NPCLoader(final String fileName) {
        this.scriptLoader = new NPCScriptLoader();
    }

    public void load() {
        this.npc = new NPC(new Point2D.Double(0, 0));
        this.npcScript = this.scriptLoader.loadNPCScript(new File(getScriptFileName()), this.npc);
    }

    private String getScriptFileName() {
        return "";
    }

    public NPCScript getNpcScript() {
        return npcScript;
    }

    public NPC getNpc() {
        return npc;
    }
}
