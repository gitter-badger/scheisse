package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Armor;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemType;

/**
 * Created by dedda on 08.01.15.
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
            new ItemType[]{
                ItemType.CLOTHING,
                ItemType.SHIELD
            }
        );
    }

    @Override
    public boolean accept(final Item item) {
        if (!itemTypeFilter.accept(item)) {
            return false;
        }
        Armor armor = (Armor) item;
        switch (mode) {
            case MODE_BELOW:
                return this.armor >= armor.getArmor();
            case MODE_EXACT:
                return this.armor == armor.getArmor();
            case MODE_ABOVE:
                return this.armor <= armor.getArmor();
            default:
                return false;
        }
    }
}
