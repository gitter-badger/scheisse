package org.dedda.games.scheisse.entity.item;

import org.dedda.games.scheisse.tool.SystemPrinter;

import java.util.HashMap;

/**
 * Created by dedda on 4/18/14.
 *
 * @author dedda
 */
public abstract class ItemStore {

    protected static HashMap<Long, Item> itemMap;

    static {
        itemMap = new HashMap<Long, Item>();
        itemMap.put(0L, new NullItem());
    }

    public static void printMap() {
        SystemPrinter.debugln("All items:");
        for (long key : itemMap.keySet()) {
            SystemPrinter.debugln(
                "ID: " + key + " NAME: " + itemMap.get(key).getName()
            );
        }
    }

    public static Item forId(final long id) {
        return itemMap.get(id);
    }

    public static HashMap<Long, Item> getItemMap() {
        return itemMap;
    }

    public static void setItemMap(final HashMap<Long, Item> itemMap) {
        ItemStore.itemMap = itemMap;
    }

    public static Item itemForId(final long id) {
        return itemMap.get(id);
    }
}
