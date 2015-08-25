package org.dedda.games.scheisse.fsloaders.resource.savegame;

import org.dedda.games.scheisse.fsloaders.resource.JsonLoader;
import org.dedda.games.scheisse.fsloaders.resource.world.WorldLoader;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;
import org.dedda.games.scheisse.savegame.SaveGame;
import org.dedda.games.scheisse.tool.Parse;
import org.dedda.games.scheisse.world.World;

import javax.json.*;
import java.io.File;
import java.io.FileNotFoundException;

import static org.dedda.games.scheisse.fsloaders.resource.savegame.SaveGameWords.*;

/**
 * Created by dedda on 4/21/14.
 *
 * @author dedda
 */
public class SaveGameLoader extends JsonLoader {

    private final File file;
    private final String folderPath;
    private final WorldLoader worldLoader;

    /**
     * @param file File - save game file
     */
    public SaveGameLoader(final File file) {
        this.file = file;
        String parent = file.getParent();
        this.folderPath = parent + (parent.endsWith("/") ? "" : "/");
        this.worldLoader = new WorldLoader();
    }

    /**
     * @param fileName String - path to save game file
     */
    public SaveGameLoader(final String fileName) {
        this(new File(fileName));
    }

    public SaveGame loadSavegame() throws FileNotFoundException {
        SaveGame saveGame = new SaveGame();
        JsonObject root = readRoot(file);
        JsonObject playerJson = root.getJsonObject(PLAYER);
        Player player = createPlayer(playerJson);
        JsonObject inventoryJson = root.getJsonObject(INVENTORY);
        Inventory inventory = createInventory(inventoryJson);
        player.setInventory(inventory);
        saveGame.setPlayer(player);
        String worldFileName = root.getString("world");
        File worldFile = new File(folderPath + worldFileName);
        World world = worldLoader.load(worldFile);
        saveGame.setWorld(world);
        return saveGame;
    }

    private Player createPlayer(final JsonObject playerJson) {
        Player player = new Player(true);
        player.setName(playerJson.getString(NAME));
        player.setExperience(playerJson.getInt(EXPERIENCE));
        player.setMap(Parse.toPoint(playerJson.getString(MAP)));
        player.setLocation(Parse.toPoint2DDouble(playerJson.getString(LOCATION)));
        player.setMoney(playerJson.getInt(MONEY));
        return player;
    }

    private Inventory createInventory(final JsonObject inventoryJson) {
        int size = inventoryJson.getInt(INVENTORY_SIZE);
        Inventory inventory = new Inventory(size);
        JsonArray itemsJson = inventoryJson.getJsonArray(INVENTORY_ITEMS);
        int itemNumber = itemsJson.size();
        for (int i = 0; i < itemNumber; i++) {
            JsonObject itemJson = itemsJson.getJsonObject(i);
            int itemId = itemJson.getInt(ITEM_ID);
            int count = itemJson.getInt(ITEM_COUNT);
            Slot slot = new Slot(itemId, inventory);
            slot.setNumberOfItems(count);
            inventory.setSlot(i, slot);
        }
        return inventory;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof SaveGameLoader) {
            SaveGameLoader sgl = (SaveGameLoader) object;
            return sgl.file.equals(this.file);
        }
        return false;
    }

}
