package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;

/**
 * Created by dedda on 10/7/14.
 */
public class ItemTypeFilter extends ItemFilter {

    public final String[] itemTypes;

    public ItemTypeFilter(final String[] itemTypes) {
        this.itemTypes = itemTypes;
    }

    @Override
    public boolean accept(final Item item) {
        for (String current : itemTypes) {
            if (item.getType().equals(current)) {
                return true;
            }
        }
        return false;
    }
}
