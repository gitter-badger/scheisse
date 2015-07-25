package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;

/**
 * Created by dedda on 08.01.15.
 *
 * @author dedda
 */
public class ItemArmorFilter extends ItemFilter {

    public static final int MODE_BELOW = 0;
    public static final int MODE_EXACT = 1;
    public static final int MODE_ABOVE = 2;

    public final long armor;
    public final int mode;
    public final ItemTypeFilter itemTypeFilter;

    public ItemArmorFilter(final long armor, final int mode) {
        this.armor = armor;
        this.mode = mode;
        itemTypeFilter = new ItemTypeFilter(
            // TODO: find correct Strings and save in some class constants.
            new int[]{
                Item.TYPES_CLOTHING,
                Item.TYPE_SHIELD,
                Item.TYPE_ARMOR
            },
            ItemTypeFilter.STRATEGY_SOME
        );
    }

    @Override
    public final boolean accept(final Item item) {
        if (!itemTypeFilter.accept(item)) {
            return false;
        }
        switch (mode) {
            case MODE_BELOW:
                return this.armor > item.getArmor();
            case MODE_EXACT:
                return this.armor == item.getArmor();
            case MODE_ABOVE:
                return this.armor < item.getArmor();
            default:
                return false;
        }
    }
}
