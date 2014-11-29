package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.io.resource.item.ItemLoader;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.Slot;
import org.dedda.games.scheisse.state.game.item.Armor;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.Weapon;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class InventoryTableModelTest {

    private ArrayList<Slot> slots;
    private Inventory inventory;
    private InventoryTableModel model;
    private LinkedList<Integer> categories;

    @Before
    public void setUp() throws Exception {
        new ItemLoader().loadAll(new File("src/test/test_files/data/item"));
        inventory = new Inventory(3);
        slots = new ArrayList<Slot>();
        slots.add(new Slot(1, inventory));
        slots.add(new Slot(2, inventory));
        slots.add(new Slot(3, inventory));
        slots.get(0).setNumberOfItems(10);
        slots.get(1).setNumberOfItems(20);
        slots.get(2).setNumberOfItems(30);
        inventory.setSlots(slots);
        model = new InventoryTableModel(inventory);
        categories = new LinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            categories.add(i);
        }
        model.setShownCategories(categories);
    }

    @Test
    public void testGetRowCount() throws Exception {
        assertEquals(inventory.getSize(), model.getRowCount());
    }

    @Test
    public void testGetColumnCount() throws Exception {
        assertEquals(categories.size(), model.getColumnCount());
    }

    @Test
    public void testGetValueAt() throws Exception {
        for (int i = 0; i < slots.size(); i++) {
            Item item = slots.get(i).getDummy();
            assertEquals(item.getId(), model.getValueAt(i, 0));
            assertEquals(item.getId(), model.getValueAt(i, 1));
            assertEquals(item.getName(), model.getValueAt(i, 2));
            assertEquals((long)slots.get(i).getNumberOfItems(), model.getValueAt(i, 3));
            assertEquals(item.getValue(), model.getValueAt(i, 4));
            if (item instanceof Weapon) {
                assertEquals(((Weapon)item).getAttack(), model.getValueAt(i, 5));
            }
        }
    }

    @Test
    public void testGetShownCategories() throws Exception {
        assertEquals(categories, model.getShownCategories());
    }

    @Test
    public void testEnableCategory() throws Exception {
        categories.add(6);
        model.enableCategory(6);
        assertEquals(categories, model.getShownCategories());
    }

    @Test
    public void testDisableCategory() throws Exception {
        categories.add(0);
        model.disableCategory(0);
        assertEquals(categories, model.getShownCategories());
    }
}