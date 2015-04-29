package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.entity.item.Armor;
import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.NullItem;
import org.dedda.games.scheisse.entity.item.Weapon;
import org.dedda.games.scheisse.entityfilter.item.ItemTypeFilter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemTypeFilterTest {

    private ItemTypeFilter itemTypeFilter;

    @Test
    public void testAccept() throws Exception {
        itemTypeFilter = new ItemTypeFilter(
            new String[]{"weapon", "clothing"}
        );
        System.out.println("0000000000");
        assertTrue(itemTypeFilter.accept(Weapon.register(0, "", 0, 0, null)));
        System.out.println("111111");
        assertTrue(itemTypeFilter.accept(
                Armor.register(0, "", 0, 0, "clothing", null))
        );
        System.out.println("222222222");
        assertFalse(itemTypeFilter.accept(new NullItem()));
        System.out.println("333333333");
    }

    @Test
    public void testFilter() throws Exception {
        itemTypeFilter = new ItemTypeFilter(
            new String[]{"weapon", "null"}
        );
        ArrayList<Item> items = new ArrayList<Item>();
        Weapon weapon1 = Weapon.register(1, "1", 0, 0, null);
        Armor armor1 = Armor.register(2, "2", 0, 0, "clothing", null);
        Weapon weapon2 = Weapon.register(3, "3", 0, 0, null);
        NullItem nullItem1 = new NullItem();
        items.add(weapon1);
        items.add(armor1);
        items.add(weapon2);
        items.add(nullItem1);
        ArrayList<Item> filtered = itemTypeFilter.filter(items);
        System.out.println("=========================================");
        System.out.println(filtered.size());
        System.out.println("=========================================");
        assertTrue(filtered.size() == 3);
        assertTrue(filtered.contains(weapon1));
        assertTrue(filtered.contains(weapon2));
        assertTrue(filtered.contains(nullItem1));
    }
}
