package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 10/7/14.
 *
 * @author dedda
 */
public class ItemTypeFilter extends ItemFilter {

    public static final int STRATEGY_ALL = 1;
    public static final int STRATEGY_SOME = 2;
    public static final int STRATEGY_NONE = 3;

    public final int[] itemTypes;
    public final int strategy;

    public ItemTypeFilter(final int[] itemTypes, final int strategy) {
        this.itemTypes = itemTypes;
        this.strategy = strategy;
    }

    @Override
    public final boolean accept(final Item item) {
        if (strategy == STRATEGY_ALL) {
            return accept_all(item);
        } else if (strategy == STRATEGY_SOME) {
            return accept_some(item);
        } else if (strategy == STRATEGY_NONE) {
            return accept_none(item);
        }
        return false;
    }

    private boolean accept_all(final Item item) {
        for (int currentType : itemTypes) {
            if (!item.isType(currentType)) {
                return false;
            }
        }
        return true;
    }

    private boolean accept_some(final Item item) {
        for (int currentType : itemTypes) {
            if (item.isType(currentType)) {
                return true;
            }
        }
        return false;
    }

    private boolean accept_none(final Item item) {
        for (int currentType : itemTypes) {
            if (item.isType(currentType)) {
                return false;
            }
        }
        return true;
    }

    public final List<Item> filter(final List<Item> items) {
        List<Item> accepted = new ArrayList<>();
        for (Item item : items) {
            if (accept(item)) {
                accepted.add(item);
            }
        }
        return accepted;
    }

}
