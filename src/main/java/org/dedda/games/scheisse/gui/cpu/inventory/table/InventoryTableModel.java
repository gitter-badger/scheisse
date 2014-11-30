package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.InventoryChangeListener;
import org.dedda.games.scheisse.state.game.inventory.Slot;
import org.dedda.games.scheisse.state.game.item.Armor;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.Weapon;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dedda on 11/26/14.
 */
public class InventoryTableModel extends AbstractTableModel implements InventoryChangeListener{

    public static final int ID = 0;
    public static final int SYMBOL = 1;
    public static final int NAME = 2;
    public static final int NUMBER = 3;
    public static final int VALUE = 4;
    public static final int ATTACK = 5;
    public static final int ARMOR = 6;
    public static final String HEADER_ID = "ID";
    public static final String HEADER_SYMBOL = "Icon";
    public static final String HEADER_NAME = "Name";
    public static final String HEADER_NUMBER = "Amount";
    public static final String HEADER_VALUE = "Value";
    public static final String HEADER_ATTACK = "Attack";
    public static final String HEADER_ARMOR = "Armor";
    public static final int[] CATEGORIES = new int[]{
            ID,
            SYMBOL,
            NAME,
            NUMBER,
            VALUE,
            ATTACK,
            ARMOR
    };
    public static final String[] HEADERS = new String[]{
            HEADER_ID,
            HEADER_SYMBOL,
            HEADER_NAME,
            HEADER_NUMBER,
            HEADER_VALUE,
            HEADER_ATTACK,
            HEADER_ARMOR
    };

    private Inventory inventory;
    private List<Integer> shownCategories;

    public InventoryTableModel(final Inventory inventory) {
        this.inventory = inventory;
        inventory.addInventoryChangeListener(this);
        this.shownCategories = new ArrayList<Integer>();
    }

    public int getRowCount() {
        return inventory.getSize();
    }

    public int getColumnCount() {
        return shownCategories.size();
    }

    public Object getValueAt(final int row, final int col) {
        Slot slot = inventory.getSlots().get(row);
        Item item = slot.getDummy();
        long number = inventory.getSlots().get(row).getNumberOfItems();
        int category = getShownCategories().get(col);
        switch (category) {
            case ID: return item.getId();
            case SYMBOL: return item.getId();
            case NAME: return item.getName();
            case NUMBER: return number;
            case VALUE: return item.getValue();
            case ATTACK: return item instanceof Weapon ? ((Weapon)item).getAttack() : 0;
            case ARMOR: return item instanceof Armor ? ((Armor)item).getArmor() : 0;
        }
        return null;
    }

    public Slot getSlotInRow(final int row) {
        return inventory.getSlots().get(row);
    }

    @Override
    public boolean isCellEditable(final int row, final int col) {
        return false;
    }

    @Override
    public Class getColumnClass(final int columnIndex) {
        int category = getShownCategories().get(columnIndex);
        switch (category) {
            case ID: return Long.class;
            case SYMBOL: return Long.class;
            case NAME: return String.class;
            case NUMBER: return Long.class;
            case VALUE: return Long.class;
            case ATTACK: return Long.class;
            case ARMOR: return Long.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        int category = getShownCategories().get(columnIndex);
        return HEADERS[category];
    }

    public List<Integer> getShownCategories() {
        return this.shownCategories;
    }

    public void setShownCategories(List<Integer> shownCategories) {
        this.shownCategories = shownCategories;
    }

    public void enableCategory(final int category) {
        if (!shownCategories.contains(category)) {
            shownCategories.add(category);
            Collections.sort(shownCategories);
            fireTableDataChanged();
            fireTableStructureChanged();
        }
    }

    public void disableCategory(final int category) {
        if (shownCategories.contains(new Integer(category))) {
            shownCategories.remove(new Integer(category));
            Collections.sort(shownCategories);
            fireTableDataChanged();
            fireTableStructureChanged();
        }
    }

    public void inventoryChangeAction() {
        fireTableDataChanged();
    }
}
