package org.dedda.games.scheisse.fsloaders.resource.savegame;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.fsloaders.resource.JsonLoader;
import org.dedda.games.scheisse.npc.npc.NPC;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;
import org.dedda.games.scheisse.quest.Quest;
import org.dedda.games.scheisse.savegame.SaveGame;
import org.dedda.games.scheisse.tool.Parse;
import org.dedda.games.scheisse.world.building.Building;

import javax.json.*;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import static org.dedda.games.scheisse.fsloaders.resource.savegame.SaveGameWords.*;

/**
 * Created by dedda on 4/21/14.
 *
 * @author dedda
 */
public class SaveGameLoader extends JsonLoader {

    private File file;

    private SaveGame saveGame;

    /**
     * @param file File - save game file
     */
    public SaveGameLoader(final File file) {
        this.file = file;
        this.saveGame = new SaveGame();
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
        JsonObject worldJson = root.getJsonObject(WORLD);
        JsonArray npcsJson = worldJson.getJsonArray(NPCS);
        List<NPC> npcs = createNPCInfo(npcsJson);
        saveGame.setNpcs(npcs);
        JsonArray buildingsJson = worldJson.getJsonArray(BUILDINGS);
        List<Building> buildings = createBuildings(buildingsJson);
        saveGame.setBuildings(buildings);
        JsonArray questsJson = worldJson.getJsonArray(QUESTS);
        List<Quest> quests = createQuests(questsJson);
        saveGame.setQuests(quests);
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

    private List<Quest> createQuests(final JsonArray questsJson) {
        List<Quest> quests = new ArrayList<>();
        return quests;
    }

    private List<NPC> createNPCInfo(final JsonArray npcsJson) {
        List<NPC> npcs = new ArrayList<>();
        return npcs;
    }

    private List<Building> createBuildings(final JsonArray buildingsJson) {
        List<Building> buildings = new ArrayList<>();
        return buildings;
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
