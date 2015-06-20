package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author dedda
 */
public class ItemNameFilterTest {

    private ArrayList<Item> items;
    private ItemNameFilter filter;

    @Before
    public void setUp() {
        items = new ArrayList<Item>();
        items.add(new Item(0, "ABC", 0, Item.TYPE_OTHER, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(1, "abc", 1, Item.TYPE_OTHER, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(2, "ABCD", 2, Item.TYPE_OTHER, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(3, "bcd", 3, Item.TYPE_OTHER, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(4, "abcd", 4, Item.TYPE_OTHER, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
    }

    @Test
    public void testModeContainsSensitive() throws Exception {
        filter = new ItemNameFilter("abc", ItemNameFilter.MODE_CONTAINS, ItemNameFilter.CASE_SENSITIVE);
        ArrayList<Item> filtered = filter.filter(items);
        assertFalse(filtered.contains(items.get(0)));
        assertTrue(filtered.contains(items.get(1)));
        assertFalse(filtered.contains(items.get(2)));
        assertFalse(filtered.contains(items.get(3)));
        assertTrue(filtered.contains(items.get(4)));
    }

    @Test
    public void testModeContainsInsensitive() throws Exception {
        filter = new ItemNameFilter("bcd", ItemNameFilter.MODE_CONTAINS, ItemNameFilter.CASE_INSENSITIVE);
        ArrayList<Item> filtered = filter.filter(items);
        assertFalse(filtered.contains(items.get(0)));
        assertFalse(filtered.contains(items.get(1)));
        assertTrue(filtered.contains(items.get(2)));
        assertTrue(filtered.contains(items.get(3)));
        assertTrue(filtered.contains(items.get(4)));
    }

    @Test
    public void testModeCompleteSensitive() throws Exception {
        filter = new ItemNameFilter("abc", ItemNameFilter.MODE_COMPLETE, ItemNameFilter.CASE_SENSITIVE);
        ArrayList<Item> filtered = filter.filter(items);
        assertFalse(filtered.contains(items.get(0)));
        assertTrue(filtered.contains(items.get(1)));
        assertFalse(filtered.contains(items.get(2)));
        assertFalse(filtered.contains(items.get(3)));
        assertFalse(filtered.contains(items.get(4)));
    }

    @Test
    public void testModeCompleteInsensitive() throws Exception {
        filter = new ItemNameFilter("abcd", ItemNameFilter.MODE_COMPLETE, ItemNameFilter.CASE_INSENSITIVE);
        ArrayList<Item> filtered = filter.filter(items);
        assertFalse(filtered.contains(items.get(0)));
        assertFalse(filtered.contains(items.get(1)));
        assertTrue(filtered.contains(items.get(2)));
        assertFalse(filtered.contains(items.get(3)));
        assertTrue(filtered.contains(items.get(4)));
    }
}
