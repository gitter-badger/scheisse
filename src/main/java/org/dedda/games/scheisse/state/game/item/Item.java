package org.dedda.games.scheisse.state.game.item;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.state.game.level.Level;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by dedda on 4/18/14.
 */
public abstract class Item implements Stackable{

    protected static HashMap<String, Item> itemMap;

    protected final ItemCategory category;
    protected final ItemType type;
    protected final long value;
    protected final String name;
    protected final String id;
    protected Image sprite;
    protected long minXp = 0;

    static {
        itemMap = new HashMap<String, Item>();
    }

    /**
     *
     * @param name String - item name
     * @param value long - item value
     */
    public Item(String id, String name, long value, ItemCategory category, ItemType type){
        this.id = id;
        this.name = name;
        this.value = value;
        this.category = category;
        this.type = type;
        if(!itemMap.containsKey(id)){
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
    public boolean equals(Object object){
        if(object instanceof Item){
            Item item = (Item)object;
            return item.name.equals(this.name)
                    && item.value == this.value;
        }
        return false;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public static Item itemForId(long id){
        return itemMap.get(id);
    }

    public String getId(){
        return id;
    }

    public static HashMap<String, Item> getItemMap() {
        return itemMap;
    }

    public static void setItemMap(HashMap<String, Item> itemMap) {
        Item.itemMap = itemMap;
    }

    public long getMinXp() {
        return minXp;
    }

    public void setMinXp(long minXp) {
        this.minXp = minXp;
    }

    public long getMinLevel(){
        return Level.getLevel(minXp);
    }

    public ItemType getType() {
        return type;
    }

    public ItemCategory getCategory() {
        return category;
    }
}
