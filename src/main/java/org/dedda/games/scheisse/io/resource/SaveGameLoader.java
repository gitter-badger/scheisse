package org.dedda.games.scheisse.io.resource;

import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.Slot;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.NullItem;
import org.dedda.games.scheisse.tool.Parse;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dedda on 4/21/14.
 */
public class SaveGameLoader extends FileInput {

    private File file;

    /**
     *
     * @param file File - save game file
     */
    public SaveGameLoader(final File file) {
        this.file = file;
    }

    /**
     *
     * @param fileName String - path to save game file
     */
    public SaveGameLoader(final String fileName) {
        this.file = new File(fileName);
    }

    /**
     *
     * @return GuiPlayer - player instance from save game
     */
    public Player load() {
        Player player = null;
        Inventory inventory = null;
        Point map;
        Point2D.Double location;
        int inventorySize;
        ArrayList<Slot> inventorySlots = new ArrayList<Slot>();
        HashMap<String, String> dataMap = getMap(file);
        //build player:
        player = new Player(false);
        player.setName(dataMap.get(SaveGameWords.NAME));
        player.setExperience(Parse.toLong(dataMap.get(SaveGameWords.EXPERIENCE)));
        player.setMap(Parse.toPoint(dataMap.get(SaveGameWords.MAP)));
        player.setLocation(Parse.toPoint2DDouble(dataMap.get(SaveGameWords.LOCATION)));
        player.setInventory(readInventory(dataMap.get(SaveGameWords.INVENTORY)));
        return player;
    }

    private Inventory readInventory(String line) {
        Inventory inventory = null;
        int slotNumber = 0;
        for (char currentChar : line.toCharArray()) {
            if (currentChar == ';')
                slotNumber++;
        }
        inventory = new Inventory();
        ArrayList<Slot> slots = new ArrayList<Slot>();
        for (int i = 0; i < slotNumber; i++){
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
            line = line.substring(line.indexOf(';')+1);
            slots.add(slot);
        }
        inventory.setSlots(slots);
        return inventory;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof SaveGameLoader) {
            SaveGameLoader sgl = (SaveGameLoader)object;
            return sgl.file.equals(this.file);
        }
        return false;
    }

}
