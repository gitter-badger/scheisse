package org.dedda.games.scheisse.npc.behavior;

import org.dedda.games.scheisse.npc.behavior.NPCJumpIfEqual;
import org.dedda.games.scheisse.npc.behavior.NPCScript;
import org.dedda.games.scheisse.npc.behavior.NPCScriptAction;
import org.dedda.games.scheisse.npc.behavior.NPCWalk;
import org.dedda.games.scheisse.npc.npc.NPC;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertTrue;

public class NPCJumpIfEqualTest {

    private NPCJumpIfEqual npcJumpIfEqual;
    private NPCScript npcScript;
    private NPC npc;

    @Before
    public void setUp() throws Exception {
        npc = new NPC(new Point2D.Double(3d, 4d));
        npcScript = new NPCScript(npc);
        npcJumpIfEqual = new NPCJumpIfEqual(npcScript);
        NPCScriptAction npcScriptAction[] = new NPCScriptAction[4];
        npcScriptAction[0] = new NPCWalk(npcScript);
        npcScriptAction[1] = new NPCWalk(npcScript);
        npcScriptAction[2] = npcJumpIfEqual;
        npcScriptAction[3] = new NPCWalk(npcScript);
        npcScript.setAction(npcScriptAction);
        npcJumpIfEqual.setJumpPoint(1);
    }

    @Test
    public void testHasNextStep() throws Exception {
        assertTrue(npcJumpIfEqual.hasNextStep());
    }

    @Test
    public void testNextStep() throws Exception {
        npcScript.jump(2);
        npcJumpIfEqual.setActual("2");
        npcJumpIfEqual.setExpected("npc.location.y/2");
        npcJumpIfEqual.nextStep();
        assertTrue(npcScript.getCurrentIndex() == 1);
        npcScript.jump(2);
        npcJumpIfEqual.setActual("2");
        npcJumpIfEqual.setExpected("npc.location.y/3");
        npcJumpIfEqual.nextStep();
        assertTrue(npcScript.getCurrentIndex() != 1);
    }

}
