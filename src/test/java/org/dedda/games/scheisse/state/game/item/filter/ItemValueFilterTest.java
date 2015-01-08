package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemCategory;
import org.dedda.games.scheisse.state.game.item.ItemType;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemValueFilterTest {

    private ArrayList<Item> items;
    private ItemValueFilter filter;

    @Before
    public void setUp() throws Exception {
        items = new ArrayList<Item>();
        items.add(new Item(0, "", 0, ItemCategory.OTHER, ItemType.NULL, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(1, "", 1, ItemCategory.OTHER, ItemType.NULL, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(2, "", 2, ItemCategory.OTHER, ItemType.NULL, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(3, "", 3, ItemCategory.OTHER, ItemType.NULL, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
        items.add(new Item(4, "", 4, ItemCategory.OTHER, ItemType.NULL, null) {
            public int maxStackNumber() {
                return 0;
            }
        });
    }

    @Test
    public void testModeBelow() throws Exception {
        long testValue = 3;
        filter = new ItemValueFilter(testValue, ItemValueFilter.MODE_BELOW);
        ArrayList<Item> filtered = filter.filter(items);
        for (Item item : filtered) {
            assertTrue(item.getValue() <= testValue);
        }
    }

    @Test
    public void testModeExact() throws Exception {
        long testValue = 3;
        filter = new ItemValueFilter(testValue, ItemValueFilter.MODE_EXACT);
        ArrayList<Item> filtered = filter.filter(items);
        for (Item item : filtered) {
            assertTrue(item.getValue() == testValue);
        }
    }

    @Test
    public void testModeAbove() throws Exception {
        long testValue = 3;
        filter = new ItemValueFilter(testValue, ItemValueFilter.MODE_ABOVE);
        ArrayList<Item> filtered = filter.filter(items);
        for (Item item : filtered) {
            assertTrue(item.getValue() >= testValue);
        }
    }
}