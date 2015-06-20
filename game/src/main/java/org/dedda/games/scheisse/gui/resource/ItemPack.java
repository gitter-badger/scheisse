package org.dedda.games.scheisse.gui.resource;

import org.dedda.games.scheisse.entity.item.ItemStore;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by dedda on 11.01.15.
 */
public class ItemPack extends SpritePack {

    public static final int LENGTH = ItemStore.getItemMap().size();

    private HashMap<Long, Integer> idMap;

    public ItemPack(final ResourcePack pack) {
        super(pack, ITEM);
        idMap = new HashMap<Long, Integer>();
        Iterator<Long> itemIdIterator = ItemStore.getItemMap().keySet().iterator();
        int i = 0;
        while (itemIdIterator.hasNext()) {
            long id = itemIdIterator.next();
            idMap.put(id, i++);
        }
    }

    public Sprite getForItemId(final long id) {
        int index = idMap.get(id);
        return get(index);
    }

    @Override
    protected Sprite[] loadSprites(final ResourcePack pack) {
        return new Sprite[0];
    }

    @Override
    protected Animation[] loadAnimations(final ResourcePack pack) {
        return new Animation[0];
    }
}
