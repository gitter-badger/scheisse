package org.dedda.games.scheisse.entity;

import org.dedda.games.scheisse.entity.item.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SlotTest {

    private Slot instance;
    private Item[] items;

    @Before
    public void setUp() throws Exception {
        instance = new Slot();
        items = new Item[2];
        Item item = new Item();
        item.setId(0);
        items[0] = item;
        items[0].setMaxStackAmount(3);
        item = new Item();
        item.setId(1);
        items[1] = item;
        items[1].setMaxStackAmount(3);
        instance.setItem(items[0]);
        instance.setAmount(1);
    }

    @Test
    public void testCanAdd() throws Exception {
        assertTrue(instance.canAdd(items[0], 1));
        assertTrue(instance.canAdd(items[0], 2));
        assertFalse(instance.canAdd(items[0], 3));
        assertFalse(instance.canAdd(items[1], 1));
    }

    @Test
    public void testMaxAddAmount() throws Exception {
        assertEquals(instance.maxAddAmount(items[0]), 2);
        assertEquals(instance.maxAddAmount(items[1]), 0);
    }

    @Test
    public void testRemove() throws Exception {
        instance.setAmount(2);
        assertEquals(instance.remove(items[0], 1), 1);
        assertEquals(instance.getAmount(), 1);
        assertEquals(instance.remove(items[1], 1), 0);
        assertEquals(instance.getAmount(), 1);
        assertEquals(instance.remove(items[0], 10), 1);
        assertEquals(instance.getAmount(), 0);
        assertNull(instance.getItem());
    }
}