package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.testInstances.TestItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;

public class SlotTest {

    static Inventory inventory;
    static Slot slot;

    @BeforeClass
    public static void setUp() throws Exception {
        inventory = Mockito.mock(Inventory.class);
        slot = new Slot(inventory);
    }

    @Test
    public void testSetAndGetDummy() throws Exception {
        TestItem dummy = new TestItem();
        slot.setDummy(dummy);
        assertEquals(dummy, slot.getDummy());
    }

    @Test
    public void testRemove() throws Exception {
        while (slot.getNumberOfItems() > 1) {
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