package org.dedda.games.scheisse.io.resource;

import junit.framework.Assert;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.Slot;
import org.dedda.games.scheisse.state.game.item.NullItem;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;

public class SaveGameLoaderTest {

    @Test
    public void testLoad() throws Exception {
        SaveGameLoader sgl = new SaveGameLoader(new File("src/test/test_files/savegame/savegame.dgm"));
        Player instance = new Player(false);
        instance.setName("Test user");
        instance.setMap(new Point(1, 2));
        instance.setLocation(new Point2D.Double(3.4, 5.6));
        instance.setExperience(789L);
        Inventory inventory = new Inventory();
        ArrayList<Slot> slots = new ArrayList<Slot>();
        Slot slot = new Slot(new NullItem(), inventory);
        slot.setNumberOfItems(1);
        slots.add(slot);
        slots.add(slot);
        slots.add(slot);
        inventory.setSlots(slots);
        instance.setInventory(inventory);
        Player loaded = sgl.load();
        Assert.assertTrue(instance.equals(loaded));
    }
}