package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * @author dedda
 */
public class ItemValueFilterTest {

    private ArrayList<Item> items;
    private ItemValueFilter filter;

    @Before
    public void setUp() throws Exception {
        items = new ArrayList<Item>();
        items.add(new Item(0, "", 0, Item.TYPE_OTHER, null));
        items.add(new Item(1, "", 1, Item.TYPE_OTHER, null));
        items.add(new Item(2, "", 2, Item.TYPE_OTHER, null));
        items.add(new Item(3, "", 3, Item.TYPE_OTHER, null));
        items.add(new Item(4, "", 4, Item.TYPE_OTHER, null));
    }

    @Test
    public void testModeBelow() throws Exception {
        long testValue = 3;
        filter = new ItemValueFilter(testValue, ItemValueFilter.MODE_BELOW);
        ArrayList<Item> filtered = filter.filter(items);
        for (Item item : filtered) {
            assertTrue(item.getPrice() <= testValue);
        }
    }

    @Test
    public void testModeExact() throws Exception {
        long testValue = 3;
        filter = new ItemValueFilter(testValue, ItemValueFilter.MODE_EXACT);
        ArrayList<Item> filtered = filter.filter(items);
        for (Item item : filtered) {
            assertTrue(item.getPrice() == testValue);
        }
    }

    @Test
    public void testModeAbove() throws Exception {
        long testValue = 3;
        filter = new ItemValueFilter(testValue, ItemValueFilter.MODE_ABOVE);
        ArrayList<Item> filtered = filter.filter(items);
        for (Item item : filtered) {
            assertTrue(item.getPrice() >= testValue);
        }
    }
}
