package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemCategory;
import org.dedda.games.scheisse.state.game.item.ItemType;
import org.dedda.games.scheisse.state.game.level.Level;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemLevelFilterTest {

    private ArrayList<Item> items;
    private ItemLevelFilter filter;

    @Before
    public void setUp() {
        items = new ArrayList<Item>();
        for (int i = 0; i < 5; i++) {
            items.add(new Item(i, "", i, ItemCategory.OTHER, ItemType.NULL, null) {
                public int maxStackNumber() {
                    return 0;
                }
            });
            items.get(i).setMinXp(Level.MIN_XP_FOR_LEVELS[i]);
        }
    }

    @Test
    public void testModeBelow() {
        filter = new ItemLevelFilter(2, ItemLevelFilter.MODE_BELOW);
        ArrayList<Item> filtered = filter.filter(items);
        assertTrue(filtered.contains(items.get(0)));
        assertTrue(filtered.contains(items.get(1)));
        assertTrue(filtered.contains(items.get(2)));
        assertFalse(filtered.contains(items.get(3)));
        assertFalse(filtered.contains(items.get(4)));
    }

    @Test
    public void testModeExact() {
        filter = new ItemLevelFilter(2, ItemLevelFilter.MODE_EXACT);
        ArrayList<Item> filtered = filter.filter(items);
        assertFalse(filtered.contains(items.get(0)));
        assertFalse(filtered.contains(items.get(1)));
        assertTrue(filtered.contains(items.get(2)));
        assertFalse(filtered.contains(items.get(3)));
        assertFalse(filtered.contains(items.get(4)));
    }

    @Test
    public void testModeAbove() {
        filter = new ItemLevelFilter(2, ItemLevelFilter.MODE_ABOVE);
        ArrayList<Item> filtered = filter.filter(items);
        assertFalse(filtered.contains(items.get(0)));
        assertFalse(filtered.contains(items.get(1)));
        assertTrue(filtered.contains(items.get(2)));
        assertTrue(filtered.contains(items.get(3)));
        assertTrue(filtered.contains(items.get(4)));
    }

}