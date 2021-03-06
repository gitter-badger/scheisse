package org.dedda.games.scheisse.npc.behavior;

import org.dedda.games.scheisse.npc.behavior.NPCScript;
import org.dedda.games.scheisse.npc.behavior.NPCWalkToDestination;
import org.dedda.games.scheisse.npc.npc.NPC;
import org.dedda.games.scheisse.tool.Distances;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NPCWalkToDestinationTest {

    private NPCWalkToDestination npcWalkToDestination;
    private NPCScript npcScript;
    private NPC npc;

    @Before
    public void setUp() throws Exception {
        npc = new NPC(new Point2D.Double(0d, 0d));
        npc.setMaxSpeed(3d);
        npcScript = new NPCScript(npc);
        npcWalkToDestination = new NPCWalkToDestination(npcScript);
        npcWalkToDestination.setDestination(new Point2D.Double(3d, 4d));
    }

    @Test
    public void testNextStep() throws Exception {
        npcWalkToDestination.nextStep();
        assertTrue(npc.getLocation().getX() > 0);
        assertTrue(npc.getLocation().getY() > 0);
        assertTrue(npc.getDirection() == Distances.getDirectionTo(
                new Point2D.Double(0d, 0d), new Point2D.Double(3d, 4d))
        );
    }

    @Test
    public void testHasNextStep() throws Exception {
        while (npcWalkToDestination.hasNextStep()) {
            npcWalkToDestination.nextStep();
        }
        assertFalse(npcWalkToDestination.hasNextStep());
        assertEquals(npc.getLocation(), new Point2D.Double(3d, 4d));
    }
}
