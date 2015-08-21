package org.dedda.games.scheisse.fsloaders.resource.savegame;

import org.dedda.games.scheisse.entity.item.ItemStore;
import org.dedda.games.scheisse.fsloaders.resource.item.ItemLoader;
import org.dedda.games.scheisse.npc.npc.NPC;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;
import org.dedda.games.scheisse.quest.Quest;
import org.dedda.games.scheisse.savegame.SaveGame;
import org.dedda.games.scheisse.world.building.Building;
import org.junit.Before;
import org.junit.Test;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SaveGameLoaderTest {

    @Before
    public void setUp() {
        ItemStore.clear();
        new ItemLoader().loadAll(
            new File(
              "src/test/test_files/classes/" +
                  "org/dedda/games/scheisse/io/resource/item/ItemLoader"
            )
        );
    }

    @Test
    public void testLoadSavegame() throws Exception {
        SaveGame expected = createExpectedSaveGame();
        SaveGameLoader instance = new SaveGameLoader(
            "src/test/test_files/classes/org/dedda/games/scheisse/io/resource/savegame/SaveGameLoader.json"
        );
        SaveGame actual = instance.loadSavegame();
        assertEquals(expected, actual);
    }

    private SaveGame createExpectedSaveGame() {
        SaveGame saveGame = new SaveGame();
        saveGame.setPlayer(createExpectedPlayer());
        saveGame.setWorld(null);
        return saveGame;
    }

    private Player createExpectedPlayer() {
        Player expectedPlayer = new Player(true);
        expectedPlayer.setName("Test user");
        expectedPlayer.setExperience(789);
        expectedPlayer.setMap(new Point(1, 2));
        expectedPlayer.setLocation(new Point2D.Double(3.4d, 5.6d));
        expectedPlayer.setMoney(10);
        expectedPlayer.setInventory(createExpectedInventory());
        return expectedPlayer;
    }

    private Inventory createExpectedInventory() {
        Inventory expectedInventory = new Inventory(3);
        Slot slot = new Slot(1, expectedInventory);
        slot.setNumberOfItems(1);
        expectedInventory.setSlot(0, slot);
        slot = new Slot(2, expectedInventory);
        slot.setNumberOfItems(3);
        expectedInventory.setSlot(1, slot);
        slot = new Slot(3, expectedInventory);
        slot.setNumberOfItems(10);
        expectedInventory.setSlot(2, slot);
        return expectedInventory;
    }

}
