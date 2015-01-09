package org.dedda.games.scheisse.state.game.item;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.io.resource.item.ItemLoader;
import org.dedda.games.scheisse.state.game.level.Level;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

/**
 * Created by dedda on 4/18/14.
 */
public abstract class Item implements Stackable {

    protected static HashMap<Long, Item> itemMap;

    protected final ItemCategory category;
    protected final ItemType type;
    protected final long value;
    protected final String name;
    protected final long id;
    protected final Image sprite;
    protected long minXp = 0;

    static {
        itemMap = new HashMap<Long, Item>();
        itemMap.put(0L, new NullItem());
        new ItemLoader().loadAll(
                new File(
                        "src/test/test_files/classes/org/dedda/games/scheisse/io/resource/item/ItemLoader"
                )
        );
    }

    /**
     *
     * @param name String - item name
     * @param value long - item value
     */
    public Item(final long id, final String name, final long value, final ItemCategory category, final ItemType type, final Image sprite) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.category = category;
        this.type = type;
        this.sprite = sprite;
        if (!itemMap.containsKey(id)) {
            itemMap.put(id, this);
            SystemPrinter.debugln("registered item '" + name + "' with id: " + id);
        }
    }

    /**
     *
     * @return long
     */
    public long getValue() {
        return value;
    }

    /**
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Item) {
            Item item = (Item)object;
            return item.name.equals(this.name)
                    && item.value == this.value;
        }
        return false;
    }

    public static void printMap() {
        SystemPrinter.debugln("All items:");
        for (long key : itemMap.keySet()) {
            SystemPrinter.debugln("ID: " + key + " NAME: " + itemMap.get(key).getName());
        }
    }

    public Image getSprite() {
        return sprite;
    }

    public static Item forId(final long id) {
        return itemMap.get(id);
    }

    public long getId() {
        return id;
    }

    public static HashMap<Long, Item> getItemMap() {
        return itemMap;
    }

    public static void setItemMap(final HashMap<Long, Item> itemMap) {
        Item.itemMap = itemMap;
    }

    public long getMinXp() {
        return minXp;
    }

    public void setMinXp(final long minXp) {
        this.minXp = minXp;
    }

    public long getMinLevel() {
        return Level.getLevel(minXp);
    }

    public ItemType getType() {
        return type;
    }

    public ItemCategory getCategory() {
        return category;
    }
}
