package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.*;
import org.dedda.games.scheisse.state.game.item.filter.ItemTypeFilter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemTypeFilterTest {

    private ItemTypeFilter itemTypeFilter;

    @Test
    public void testAccept() throws Exception {
        itemTypeFilter = new ItemTypeFilter(
                new ItemType[]{ItemType.WEAPON, ItemType.CLOTHING}
        );
        assertTrue(itemTypeFilter.accept(new Weapon(0, "", 0, 0, null)));
        assertTrue(itemTypeFilter.accept(
                new Armor(0, "", 0, 0, ItemType.CLOTHING, null))
        );
        assertFalse(itemTypeFilter.accept(new NullItem()));
    }

    @Test
    public void testFilter() throws Exception {
        itemTypeFilter = new ItemTypeFilter(
                new ItemType[]{ItemType.WEAPON, ItemType.NULL}
        );
        ArrayList<Item> items = new ArrayList<Item>();
        Weapon weapon1 = new Weapon(1, "1", 0, 0, null);
        Armor armor1 = new Armor(2, "2", 0, 0, ItemType.CLOTHING, null);
        Weapon weapon2 = new Weapon(3, "3", 0, 0, null);
        NullItem nullItem1 = new NullItem();
        items.add(weapon1);
        items.add(armor1);
        items.add(weapon2);
        items.add(nullItem1);
        ArrayList<Item> filtered = itemTypeFilter.filter(items);
        assertTrue(filtered.size() == 3);
        assertTrue(filtered.get(0).equals(weapon1));
        assertTrue(filtered.get(1).equals(weapon2));
        assertTrue(filtered.get(2).equals(nullItem1));
    }
}
