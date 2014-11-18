package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.testInstances.TestItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.*;

public class SlotTest {

    static Inventory inventory;
    static Slot slot;

    @BeforeClass
    public static void setUp() throws Exception {
        inventory = Mockito.mock(Inventory.class);
        slot = new Slot(inventory);
    }

    @Test
    public void testSetAndGetDummyClass() throws Exception {
        slot.setDummyClass(TestItem.class);
        assertEquals(TestItem.class, slot.getDummyClass());
    }

    @Test
    public void testSetAndGetDummy() throws Exception {
        TestItem dummy = new TestItem();
        slot.setDummy(dummy);
        assertEquals(dummy, slot.getDummy());
    }

    @Test
    public void testAdd() throws Exception {
        slot.setDummyClass(TestItem.class);
        int slotHeight = slot.getNumberOfItems();
        slot.add(new TestItem());
        assertEquals(slotHeight+1, slot.getNumberOfItems());
    }

    @Test
    public void testCanAdd() throws Exception {
        slot.setDummyClass(TestItem.class);
        while(slot.getNumberOfItems() < TestItem.MAX_STACK-1){
            slot.add(new TestItem());
        }
        assertTrue(slot.canAdd());
        slot.add(new TestItem());
        assertFalse(slot.canAdd());
    }


    @Test
    public void testRemove() throws Exception {
        while(slot.getNumberOfItems() > 1){
            slot.remove();
        }
        assertEquals(1, slot.getNumberOfItems());
        slot.remove();
        slot.remove();
        assertEquals(0, slot.getNumberOfItems());
    }

    @Test
    public void testSetNumberOfItems() throws Exception {
        int number = 10;
        slot.setNumberOfItems(number);
        assertEquals(number, slot.getNumberOfItems());
    }

}