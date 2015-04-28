package org.dedda.games.scheisse.io.resource.npc;

import org.dedda.games.scheisse.io.resource.world.npc.NPCScriptLoader;
import org.dedda.games.scheisse.state.game.object.behavior.NPCJumpIfTrue;
import org.dedda.games.scheisse.state.game.object.behavior.NPCScript;
import org.dedda.games.scheisse.state.game.object.behavior.NPCScriptAction;
import org.dedda.games.scheisse.state.game.object.behavior.NPCWalk;
import org.dedda.games.scheisse.state.game.object.behavior.NPCWalkToDestination;
import org.dedda.games.scheisse.state.game.object.npc.NPC;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.io.File;

import static org.junit.Assert.assertTrue;

public class NPCScriptLoaderTest {

    private NPCScriptLoader npcScriptLoader;
    private File scriptFile;
    private NPC npc;

    @Before
    public void setUp() throws Exception {
        scriptFile = new File(
            "src/test/test_files/classes/" +
                "org/dedda/games/scheisse/io/resource/npc/NPCScriptLoader");
        npcScriptLoader = new NPCScriptLoader();
        npc = new NPC(new Point2D.Double(0d, 0d));
        npc.setMaxSpeed(3d);
    }

    @Test
    public void testLoadNPCScript() throws Exception {
        NPCScript npcScript = new NPCScript(npc);
        NPCScriptAction npcScriptAction[] = new NPCScriptAction[5];
        NPCWalkToDestination action0 = new NPCWalkToDestination(npcScript);
        action0.setDestination(new Point2D.Double(3d, 4d));
        NPCWalk action1 = new NPCWalk(npcScript);
        action1.setAmount(20d);
        action1.setDirection(0d);
        NPCWalk action2 = new NPCWalk(npcScript);
        action2.setAmount(15d);
        action2.setDirection(1.570796327d);
        NPCJumpIfTrue action3 = new NPCJumpIfTrue(npcScript);
        action3.setExpression("npc.location.x<50");
        action3.setJumpPoint(1);
        NPCWalkToDestination action4 = new NPCWalkToDestination(npcScript);
        action4.setDestination(new Point2D.Double(-100d, 10d));
        npcScriptAction[0] = action0;
        npcScriptAction[1] = action1;
        npcScriptAction[2] = action2;
        npcScriptAction[3] = action3;
        npcScriptAction[4] = action4;
        npcScript.setAction(npcScriptAction);
        NPCScript loadedSkript = npcScriptLoader.loadNPCScript(scriptFile, npc);
        assertTrue(action0.equals(loadedSkript.getAction()[0]));
        assertTrue(action1.equals(loadedSkript.getAction()[1]));
        assertTrue(action2.equals(loadedSkript.getAction()[2]));
        assertTrue(action3.equals(loadedSkript.getAction()[3]));
        assertTrue(action4.equals(loadedSkript.getAction()[4]));
        assertTrue(npcScript.equals(loadedSkript));
    }
}
