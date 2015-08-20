package org.dedda.games.scheisse.fsloaders.resource;

import junit.framework.Assert;
import org.dedda.games.scheisse.entity.item.ItemStore;
import org.dedda.games.scheisse.fsloaders.resource.item.ItemLoader;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;

import static org.dedda.games.scheisse.fsloaders.resource.TestFiles.ITEM_LOADER_FOLDER;
import static org.dedda.games.scheisse.fsloaders.resource.TestFiles.SAVEGAME_LOADER_FILE;

public class SaveGameLoaderTest {

    @Before
    public void setUp() {
        ItemStore.clear();
    }

    @Test
    public void testLoad() throws Exception {
        new ItemLoader().loadAll(
            new File(ITEM_LOADER_FOLDER)
        );
        SaveGameLoader sgl = new SaveGameLoader(
            new File(SAVEGAME_LOADER_FILE)
        );
        Player instance = new Player(false);
        instance.setName("Test user");
        instance.setMap(new Point(1, 2));
        instance.setLocation(new Point2D.Double(3.4, 5.6));
        instance.setExperience(789L);
        Inventory inventory = new Inventory();
        ArrayList<Slot> slots = new ArrayList<>();
        Slot slot = new Slot(1, inventory);
        slot.setNumberOfItems(1);
        slots.add(slot);
        slot = new Slot(2, inventory);
        slot.setNumberOfItems(3);
        slots.add(slot);
        slot = new Slot(3, inventory);
        slot.setNumberOfItems(10);
        slots.add(slot);
        inventory.setSlots(slots);
        instance.setInventory(inventory);
        Player loaded = sgl.load();
        Assert.assertTrue(instance.equals(loaded));
    }
}
