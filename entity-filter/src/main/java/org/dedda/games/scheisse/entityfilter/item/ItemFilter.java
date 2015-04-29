package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;

import java.util.ArrayList;

/**
 * Created by dedda on 10/7/14.
 */
public abstract class ItemFilter {

    public abstract boolean accept(final Item item);

    public ArrayList<Item> filter(final ArrayList<Item> items) {
        ArrayList<Item> filtered = new ArrayList<Item>();
        for (Item item : items) {
            if (accept(item)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

}
