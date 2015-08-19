package org.dedda.games.scheisse.savegame;

import org.dedda.games.scheisse.npc.npc.NPC;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dedda on 8/19/15.
 *
 * @author dedda
 */
public class SaveGameTest {

    private SaveGame instance;

    @Before
    public void setUp() throws Exception {
        this.instance = new SaveGame();
    }

    @Test
    public void testPlaceNPC() throws Exception {
        NPC npc0 = new NPC(0, new Point2D.Double(0, 0), 0, false);
        npc0.setMap(new Point(0, 0));
        NPC npc1 = new NPC(1, new Point2D.Double(0, 0), 0, false);
        npc1.setMap(new Point(0, 0));
        NPC npc2 = new NPC(1, new Point2D.Double(0, 0), 0, false);
        npc2.setMap(new Point(0, 0));
        NPC npc3 = new NPC(2, new Point2D.Double(0, 0), 0, false);
        npc3.setMap(new Point(0, 0));
        List<NPC> npcList = new ArrayList<>();
        npcList.add(npc0);
        npcList.add(npc1);
        this.instance.setNpcs(npcList);
        this.instance.placeNPC(npc2, new Point(2, 2), new Point2D.Double(1, 1));
        this.instance.placeNPC(npc3, new Point(3, 3), new Point2D.Double(4, 4));
        npcList = this.instance.getNpcs();
        assertEquals(1, npcList.stream().filter(npc -> npc.getId() == 1).count());
        npc1 = npcList.stream().filter(npc -> npc.getId() == 1).findFirst().get();
        assertEquals(new Point2D.Double(1, 1), npc1.getLocation());
        assertEquals(new Point(2, 2), npc1.getMap());
        assertEquals(1, npcList.stream().filter(npc -> npc.getId() == 2).count());
        npc2 = npcList.stream().filter(npc -> npc.getId() == 2).findFirst().get();
        assertEquals(new Point2D.Double(4, 4), npc2.getLocation());
        assertEquals(new Point(3, 3), npc2.getMap());
        npcList.stream().filter(npc -> (npc.getId() != 1) && (npc.getId() != 2)).forEach(npc -> assertNotEquals(new Point2D.Double(1, 1), npc.getLocation()));
    }
}
