package org.dedda.games.scheisse.fsloaders.resource;

import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;

import java.io.File;

/**
 * Created by dedda on 7/1/15.
 *
 * @author dedda
 */
public class SaveGameWriter {

    private final File file;

    public SaveGameWriter(File file) {
        this.file = file;
    }

    public SaveGameWriter(final String fileName) {
        this.file = new File(fileName);
    }

    public void write(final Player player) {
        final Inventory inventory = player.getInventory();
        final String convertedInventory = convertInventory(inventory);
        String savegameData = "";
        savegameData += "name:" + player.getName();

    }

    private String convertInventory(final Inventory inventory) {
        String converted = "inventory:";
        for (Slot slot : inventory.getSlots()) {
            if (slot.getNumberOfItems() == 0) {
                converted += "0;";
            } else {
                converted += slot.getDummy().getId() + "." + slot.getNumberOfItems() + ";";
            }
        }
        return converted;
    }

}
