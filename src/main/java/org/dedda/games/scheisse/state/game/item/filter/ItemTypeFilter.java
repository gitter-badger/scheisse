package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemType;

/**
 * Created by dedda on 10/7/14.
 */
public class ItemTypeFilter extends ItemFilter {

    private ItemType itemTypes[];

    public ItemTypeFilter(final ItemType itemTypes[]) {
        this.itemTypes = itemTypes;
    }

    @Override
    public boolean accept(final Item item) {
        for (ItemType current : itemTypes) {
            if (item.getType() == current) {
                return true;
            }
        }
        return false;
    }
}
