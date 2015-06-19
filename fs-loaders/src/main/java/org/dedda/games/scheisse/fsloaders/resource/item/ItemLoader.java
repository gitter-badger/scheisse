package org.dedda.games.scheisse.fsloaders.resource.item;

import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.main.FileTypes;
import org.dedda.games.scheisse.main.Main;
import org.dedda.games.scheisse.state.game.item.Armor;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemType;
import org.dedda.games.scheisse.state.game.item.Shield;
import org.dedda.games.scheisse.state.game.item.Weapon;
import org.dedda.games.scheisse.tool.Parse;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;

import static org.dedda.games.scheisse.main.FileTypes.ITEM;

/**
 * Created by dedda on 5/24/14.
 */
public class ItemLoader extends FileInput {

    public Item loadItem(final File file) {
        Item item = null;
        HashMap<String, String> dataMap = getMap(file);
        long id = Long.parseLong(dataMap.get(ItemWords.ID));
        String type = dataMap.get(ItemWords.TYPE);
        String name = dataMap.get(ItemWords.NAME);
        long value = Parse.toLong(dataMap.get(ItemWords.VALUE));
        String imgName = dataMap.get(ItemWords.SPRITE);
        String imageFile = Main.INSTALLATION_FOLDER + "data/image/" + imgName;
        Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
        if (type.equals(ItemWords.WEAPON)) {
            long attack = Parse.toLong(dataMap.get(ItemWords.ATTACK));
            item = Weapon.register(id, name, value, attack, image);
        } else if (type.equals(ItemWords.ARMOR)) {
            long armor = Parse.toLong(dataMap.get(ItemWords.ARMOR));
            item = Armor.register(id, name, value, armor, ItemType.CLOTHING, image);
        } else if (type.equals(ItemWords.SHIELD)) {
            long armor = Parse.toLong(dataMap.get(ItemWords.ARMOR));
            item = Shield.register(id, name, value, armor, image);
        }
        return item;
    }

    public ArrayList<Item> loadAll(final File folder) {
        ArrayList<Item> items = new ArrayList<Item>();
        File[] files = folder.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(FileTypes.getExtension(ITEM));
            }
        });
        for (File file : files) {
            items.add(loadItem(file));
        }
        return items;
    }

}
