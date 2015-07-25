package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;

import java.util.HashMap;
import java.util.Map;

import static org.dedda.games.scheisse.events.item.ItemStoreEvent.CODE_ITEM_REGISTERED;
import static org.dedda.games.scheisse.events.item.ItemStoreEvent.CODE_ITEM_UNREGISTERED;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
public class ItemStore {

    private Map<Long, Item> itemMap;
    private long idCounter = 0;

    public ItemStore() {
        this.itemMap = new HashMap<>();
    }

    public Item getItem(final long id) {
        if (itemMap.containsKey(id)) {
            return itemMap.get(id);
        }
        return null;
    }

    public long getKey(final Item item) {
        for (Map.Entry<Long, Item> e : itemMap.entrySet()) {
            if (e.getValue().equals(item)) {
                return e.getKey();
            }
        }
        return -1;
    }

    public long register(final Item item) {
        long key = getKey(item);
        if (key > -1) {
            return key;
        }
        itemMap.put(idCounter++, item);
        GameSession.itemStoreEvent(new ItemStoreEvent(CODE_ITEM_REGISTERED, item));
        return idCounter;
    }

    public void unregister(final Item item) {
        long key = getKey(item);
        if (key > -1) {
            itemMap.remove(key);
            GameSession.itemStoreEvent(new ItemStoreEvent(CODE_ITEM_UNREGISTERED, item));
        }
    }

}
