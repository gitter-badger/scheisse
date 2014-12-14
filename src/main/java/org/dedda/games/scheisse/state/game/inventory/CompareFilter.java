package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.filter.ItemFilter;

/**
 * Created by dedda on 10/11/14.
 */
public class CompareFilter extends ItemFilter {

    public static final int MORE = 0;
    public static final int EQUAL = 1;
    public static final int LESS = 2;

    public static final int ITEM_NAME = 0;
    public static final int ITEM_VALUE = 1;
    public static final int ITEM_MIN_XP = 2;
    public static final int ITEM_DAMAGE = 3;
    public static final int ITEM_ARMOR = 4;

    private int category;
    private Item target;
    private int direction;

    public CompareFilter(final int category, final Item target, final int direction) {
        this.category = category;
        this.target = target;
        this.direction = direction;
    }

    @Override
    public boolean accept(final Item item) {

        return false;
    }
}
