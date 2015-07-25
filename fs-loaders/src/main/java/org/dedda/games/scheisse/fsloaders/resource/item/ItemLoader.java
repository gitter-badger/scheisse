package org.dedda.games.scheisse.fsloaders.resource.item;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemStore;
import org.dedda.games.scheisse.fsloaders.resource.FileInput;
import org.dedda.games.scheisse.fsloaders.resource.FileTypes;
import org.dedda.games.scheisse.fsloaders.resource.Resource;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static org.dedda.games.scheisse.fsloaders.resource.FileTypes.ITEM;

/**
 * Created by dedda on 5/24/14.
 *
 * @author dedda
 */
public class ItemLoader extends FileInput {

    public Item loadItem(final File file) {
        Item item = new Item();
        HashMap<String, String> dataMap = getMap(file);

        item.setId(parseLong(dataMap.get(ItemWords.ID)));
        item.setTypes(parseInt(dataMap.get(ItemWords.TYPES)));
        item.setName(dataMap.get(ItemWords.NAME));
        item.setPrice(parseLong(dataMap.get(ItemWords.VALUE)));
        String imgName = dataMap.get(ItemWords.SPRITE);
        String imageFile = Resource.INSTALLATION_FOLDER + "data/image/" + imgName;
        item.setSprite(Toolkit.getDefaultToolkit().getImage(imageFile));
        if (dataMap.containsKey(ItemWords.ATTACK)) {
            item.setAttack(parseLong(dataMap.get(ItemWords.ATTACK)));
        } else {
            item.setAttack(0);
        }
        if (dataMap.containsKey(ItemWords.ARMOR)) {
            item.setArmor(parseLong(dataMap.get(ItemWords.ARMOR)));
        } else {
            item.setArmor(0);
        }
        if (!ItemStore.put(item)) {
            throw new RuntimeException("Item with id " + item.getId() + " already existing!");
        }
        return item;
    }

    public ArrayList<Item> loadAll(final File folder) {
        ArrayList<Item> items = new ArrayList<Item>();
        File[] files = folder.listFiles(new FileFilter() {
            public boolean accept(final File file) {
                return file.getName().endsWith(FileTypes.getExtension(ITEM));
            }
        });
        for (File file : files) {
            items.add(loadItem(file));
        }
        return items;
    }

}
