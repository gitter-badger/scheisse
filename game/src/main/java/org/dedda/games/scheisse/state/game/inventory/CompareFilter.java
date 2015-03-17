package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.filter.ItemFilter;

/**
 * Created by dedda on 10/11/14.
 */
public class CompareFilter extends ItemFilter {

    public static final int MODE_BELOW = 0;
    public static final int MODE_EXACT = 1;
    public static final int MODE_ABOVE = 2;

    public static final int CATEGORY_NAME = 0;
    public static final int CATEGORY_VALUE = 1;
    public static final int CATEGORY_MIN_XP = 2;
    public static final int CATEGORY_DAMAGE = 3;
    public static final int CATEGORY_ARMOR = 4;

    public final int category;
    public final Item target;
    public final int mode;

    public CompareFilter(
            final int category,
            final Item target,
            final int mode) {
        this.category = category;
        this.target = target;
        this.mode = mode;
    }

    @Override
    public boolean accept(final Item item) {

        return false;
    }
}
