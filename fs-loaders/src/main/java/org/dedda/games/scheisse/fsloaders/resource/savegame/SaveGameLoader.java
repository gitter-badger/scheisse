package org.dedda.games.scheisse.fsloaders.resource.savegame;

import org.dedda.games.scheisse.fsloaders.resource.JsonLoader;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;
import org.dedda.games.scheisse.savegame.SaveGame;
import org.dedda.games.scheisse.tool.Parse;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

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
        player.setName(dataMap.get(SaveGameWords.NAME));
        String experience = dataMap.get(SaveGameWords.EXPERIENCE);
        player.setExperience(Parse.toLong(experience));
        player.setMap(Parse.toPoint(dataMap.get(SaveGameWords.MAP)));
        String location = dataMap.get(SaveGameWords.LOCATION);
        player.setLocation(Parse.toPoint2DDouble(location));
        String inventory = dataMap.get(SaveGameWords.INVENTORY);
        player.setInventory(readInventory(inventory));
        return player;
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
