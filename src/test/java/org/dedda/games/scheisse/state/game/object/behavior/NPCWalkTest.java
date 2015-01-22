package org.dedda.games.scheisse.state.game.object.behavior;

import org.dedda.games.scheisse.state.game.object.npc.NPC;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NPCWalkTest {

    private NPCWalk npcWalk;
    private NPC npc;
    private NPCScript npcScript;

    @Before
    public void setUp() throws Exception {
        npc = new NPC(new Point2D.Double(0d, 0d));
        npc.setMaxSpeed(3d);
        npcScript = new NPCScript(npc);
        npcWalk = new NPCWalk(npcScript);
        npcWalk.setDirection(Math.PI/2);
        npcWalk.setAmount(50d);
    }

    @Test
    public void testNextStep() throws Exception {
        npcWalk.nextStep();
        assertTrue(npc.getLocation().getX() <
                0.1d && npc.getLocation().getX() > -0.1d);
        assertTrue(npc.getLocation().getY() <
                3.1d && npc.getLocation().getY() > 2.9d);
        assertTrue(npc.getDirection() == npcWalk.getDirection());
    }

    @Test
    public void testHasNextStep() throws Exception {
        while (npcWalk.getRestAmount() > 0) {
            npcWalk.nextStep();
        }
        assertFalse(npcWalk.hasNextStep());
    }
}