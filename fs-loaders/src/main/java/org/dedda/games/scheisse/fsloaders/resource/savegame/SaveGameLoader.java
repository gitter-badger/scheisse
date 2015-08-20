package org.dedda.games.scheisse.fsloaders.resource.savegame;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.fsloaders.resource.JsonLoader;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;
import org.dedda.games.scheisse.savegame.SaveGame;
import org.dedda.games.scheisse.tool.Parse;

import javax.json.*;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

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

    /**
     * @return GuiPlayer - player instance from save game
     */
    public Player load() {
        Player player = null;
        Point map;
        int inventorySize;
        ArrayList<Slot> inventorySlots = new ArrayList<Slot>();
        HashMap<String, String> dataMap = getMap(file);
        //build player:
        player = new Player(false);
        player.setName(dataMap.get(NAME));
        String experience = dataMap.get(EXPERIENCE);
        player.setExperience(Parse.toLong(experience));
        player.setMap(Parse.toPoint(dataMap.get(MAP)));
        String location = dataMap.get(LOCATION);
        player.setLocation(Parse.toPoint2DDouble(location));
        String inventory = dataMap.get(INVENTORY);
        player.setInventory(readInventory(inventory));
        return player;
    }

    public SaveGame loadSavegame(final File file) throws FileNotFoundException {
        SaveGame saveGame = new SaveGame();
        JsonObject root = readRoot(file);
        JsonObject playerJson = root.getJsonObject("player");
        Player player = createPlayer(playerJson);
        JsonObject inventoryJson = root.getJsonObject("inventory");
        Inventory inventory = createInventory(inventoryJson);
        player.setInventory(inventory);
        saveGame.setPlayer(player);
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
        int size = inventoryJson.getInt("size");
        Inventory inventory = new Inventory(size);
        JsonArray itemsJson = inventoryJson.getJsonArray("items");
        int itemNumber = itemsJson.size();
        for (int i = 0; i < itemNumber; i++) {
            JsonObject itemJson = itemsJson.getJsonObject(i);
            int itemId = itemJson.getInt("id");
            int count = itemJson.getInt("count");
            Slot slot = new Slot(itemId, inventory);
            slot.setNumberOfItems(count);
            inventory.setSlot(i, slot);
        }
        return inventory;
    }

    private Inventory readInventory(String line) {
        Inventory inventory = null;
        int slotNumber = 0;
        for (char currentChar : line.toCharArray()) {
            if (currentChar == ';') {
                slotNumber++;
            }
        }
        inventory = new Inventory();
        ArrayList<Slot> slots = new ArrayList<Slot>();
        for (int i = 0; i < slotNumber; i++) {
            String slotString = line.substring(0, line.indexOf(';'));
            Slot slot = null;
            if (slotString.equals("0")) {
                slot = new Slot(0, inventory);
                slot.setNumberOfItems(1);
            } else {
                Point currentSlot = Parse.toPoint(slotString);
                slot = new Slot(currentSlot.x, inventory);
                slot.setNumberOfItems(currentSlot.y);
            }
            line = line.substring(line.indexOf(';') + 1);
            slots.add(slot);
        }
        inventory.setSlots(slots);
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
