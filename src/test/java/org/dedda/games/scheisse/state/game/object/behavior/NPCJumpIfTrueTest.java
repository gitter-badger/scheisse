package org.dedda.games.scheisse.state.game.object.behavior;

import org.dedda.games.scheisse.state.game.object.npc.NPC;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertTrue;

public class NPCJumpIfTrueTest {

    private NPCJumpIfTrue npcJumpIfTrue;
    private NPCScript npcScript;
    private NPC npc;

    @Before
    public void setUp() throws Exception {
        npc = new NPC(new Point2D.Double(3d, 4d));
        npcScript = new NPCScript(npc);
        npcJumpIfTrue = new NPCJumpIfTrue(npcScript);
        NPCScriptAction npcScriptAction[] = new NPCScriptAction[4];
        npcScriptAction[0] = new NPCWalk(npcScript);
        npcScriptAction[1] = new NPCWalk(npcScript);
        npcScriptAction[2] = npcJumpIfTrue;
        npcScriptAction[3] = new NPCWalk(npcScript);
        npcScript.setAction(npcScriptAction);
        npcJumpIfTrue.setJumpPoint(1);
    }

    @Test
    public void testHasNextStep() throws Exception {
        assertTrue(npcJumpIfTrue.hasNextStep());
    }

    @Test
    public void testNextStep() throws Exception {
        npcScript.jump(2);
        npcJumpIfTrue.setExpression("npc.location.y/2==2");
        npcJumpIfTrue.nextStep();
        assertTrue(npcScript.getCurrentIndex() == 1);
        npcScript.jump(2);
        npcJumpIfTrue.setExpression("npc.location.y/4!=1");
        npcJumpIfTrue.nextStep();
        assertTrue(npcScript.getCurrentIndex() != 1);
    }

}