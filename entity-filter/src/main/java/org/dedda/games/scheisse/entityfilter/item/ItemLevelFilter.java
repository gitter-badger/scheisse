package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;

/**
 * Created by dedda on 10/11/14.
 */
public class ItemLevelFilter extends ItemFilter {

    public static final int MODE_BELOW = 0;
    public static final int MODE_EXACT = 1;
    public static final int MODE_ABOVE = 2;

    public final long level;
    public final int mode;

    public ItemLevelFilter(final long level, final int mode) {
        this.level = level;
        this.mode = mode;
    }

    @Override
    public final boolean accept(final Item item) {
        switch (mode) {
            case MODE_BELOW:
                return item.getMinLevel() <= level;
            case MODE_EXACT:
                return item.getMinLevel() == level;
            case MODE_ABOVE:
                return item.getMinLevel() >= level;
            default:
                return false;
        }
    }

}
