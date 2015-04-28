package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;

/**
 * Created by dedda on 08.01.15.
 */
public class ItemValueFilter extends ItemFilter {

    public static final int MODE_BELOW = 0;
    public static final int MODE_EXACT = 1;
    public static final int MODE_ABOVE = 2;

    public final long value;
    public final int mode;

    public ItemValueFilter(final long value, final int mode) {
        this.value = value;
        this.mode = mode;
    }

    @Override
    public boolean accept(final Item item) {
        switch (mode) {
            case MODE_BELOW:
                return value >= item.getValue();
            case MODE_EXACT:
                return value == item.getValue();
            case MODE_ABOVE:
                return value <= item.getValue();
            default:
                return false;
        }
    }
}
