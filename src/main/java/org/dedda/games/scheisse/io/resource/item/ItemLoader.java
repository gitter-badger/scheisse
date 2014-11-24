package org.dedda.games.scheisse.io.resource.item;

import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.main.FileTypes;
import org.dedda.games.scheisse.main.Main;
import org.dedda.games.scheisse.state.game.item.*;
import org.dedda.games.scheisse.tool.Parse;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;

import static org.dedda.games.scheisse.main.FileTypes.ITEM;

/**
 * Created by dedda on 5/24/14.
 */
public class ItemLoader extends FileInput{

    public Item loadItem(final File file) {
        Item item = null;
        HashMap<String, String> dataMap = getMap(file);
        String id = dataMap.get(ItemWords.ID);
        String type = dataMap.get(ItemWords.TYPE);
        String name = dataMap.get(ItemWords.NAME);
        long value = Parse.toLong(dataMap.get(ItemWords.VALUE));
        String imgSrc = dataMap.get(ItemWords.SPRITE);
        Image image = Toolkit.getDefaultToolkit().getImage(Main.INSTALLATION_FOLDER + "image/" + imgSrc);
        if (type.equals(ItemWords.WEAPON)) {
            long attack = Parse.toLong(dataMap.get(ItemWords.ATTACK));
            item = new Weapon(id, name, value, attack);
        } else if (type.equals(ItemWords.ARMOR)) {
            long armor = Parse.toLong(dataMap.get(ItemWords.ARMOR));
            item = new Armor(id, name, value, armor, ItemType.CLOTHING);
        } else if (type.equals(ItemWords.SHIELD)) {
            long armor = Parse.toLong(dataMap.get(ItemWords.ARMOR));
            item = new Shield(id, name, value, armor);
        }
        item.setSprite(image);
        return item;
    }

    public ArrayList<Item> loadAll(final File folder) {
        ArrayList<Item> items = new ArrayList<Item>();
        File files[] = folder.listFiles(new FileFilter() {
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
