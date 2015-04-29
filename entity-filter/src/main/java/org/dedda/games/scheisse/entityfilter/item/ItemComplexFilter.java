package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;

/**
 * Created by dedda on 08.01.15.
 */
public class ItemComplexFilter extends ItemFilter {

    public static final int MODE_NONE = 0;
    public static final int MODE_ONE = 1;
    public static final int MODE_ONE_OR_MORE = 2;
    public static final int MODE_ALL = 3;

    public final ItemFilter[] itemFilters;
    public final int mode;

    public ItemComplexFilter(final ItemFilter[] itemFilters, final int mode) {
        this.itemFilters = itemFilters;
        this.mode = mode;
    }

    private boolean acceptModeNone(final Item item) {
        for (ItemFilter filter : itemFilters) {
            if (filter.accept(item)) {
                return false;
            }
        }
        return true;
    }

    private boolean acceptModeOne(final Item item) {
        boolean accepted = false;
        for (ItemFilter filter : itemFilters) {
            if (filter.accept(item)) {
                if (accepted) {
                    return false;
                }
                accepted = true;
            }
        }
        return accepted;
    }

    private boolean acceptModeOneOrMore(final Item item) {
        for (ItemFilter filter : itemFilters) {
            if (filter.accept(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean acceptModeAll(final Item item) {
        for (ItemFilter filter : itemFilters) {
            if (!filter.accept(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean accept(final Item item) {
        if (itemFilters.length == 0) {
            return true;
        }
        switch (mode) {
            case MODE_NONE:
                return acceptModeNone(item);
            case MODE_ONE:
                return acceptModeOne(item);
            case MODE_ONE_OR_MORE:
                return acceptModeOneOrMore(item);
            case MODE_ALL:
                return acceptModeAll(item);
            default:
                return false;
        }
    }
}
