package org.dedda.games.scheisse.entity;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by dedda on 21.07.15.
 *
 * @author dedda
 */
public class InventoryTest {

    private Inventory inventory;
    private Item item1;
    private Item item2;
    private Item item3;

    @Before
    public void setUp() throws Exception {
        this.item1 = new Item(1, "test item", 10, Item.TYPES_CLOTHING, null);
        this.item1.setMaxStackAmount(3);
        this.item2 = new Item(2, "test item 2", 20, Item.TYPE_OTHER, null);
        this.item2.setMaxStackAmount(2);
        this.item3 = new Item(3, "test item 3", 30, Item.TYPE_ARMOR, null);
        this.item3.setMaxStackAmount(1);
        this.inventory = new Inventory();
        this.inventory.setSize(4);
        ArrayList<Slot> slots = new ArrayList<>();
        slots.add(new Slot());
        slots.get(0).setId(1);
        slots.get(0).setAmount(2);
        slots.get(0).setItem(item1);
        slots.get(0).setInventory(this.inventory);
        slots.add(new Slot());
        slots.get(1).setId(2);
        slots.get(1).setInventory(this.inventory);
        slots.add(new Slot());
        slots.get(2).setId(3);
        slots.get(2).setAmount(2);
        slots.get(2).setItem(item2);
        slots.add(new Slot());
        slots.get(3).setId(4);
        slots.get(3).setAmount(3);
        slots.get(3).setItem(item1);
        this.inventory.setSlots(slots);
    }

    @Test
    public void testCanAdd() throws Exception {
        assertTrue(this.inventory.canAdd(item1, 4));
        assertFalse(this.inventory.canAdd(item1, 5));
        assertTrue(this.inventory.canAdd(item2, 2));
        assertFalse(this.inventory.canAdd(item2, 3));
    }

    @Test
    public void testAdd() throws Exception {
        this.inventory.add(item1, 2);
        assertEquals(7, this.inventory.contains(item1));
    }

    @Test
    public void testContains() throws Exception {
        assertEquals(5, this.inventory.contains(item1));
        assertEquals(2, this.inventory.contains(item2));
        assertEquals(0, this.inventory.contains(item3));
    }

    @Test
    public void testRemove() throws Exception {
        this.inventory.remove(item1, 2);
        assertEquals(3, this.inventory.contains(item1));
    }
}
