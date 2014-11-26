package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.InventoryChangeListener;
import org.dedda.games.scheisse.state.game.inventory.Slot;
import org.dedda.games.scheisse.state.game.item.Armor;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.Weapon;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
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
    public static final int[] CATEGORIES = new int[]{
            ID,
            SYMBOL,
            NAME,
            NUMBER,
            VALUE,
            ATTACK,
            ARMOR
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
        Item item = inventory.getSlots().get(row).getDummy();
        long number = inventory.getSlots().get(row).getNumberOfItems();
        int category = CATEGORIES[col];
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

    public List<Integer> getShownCategories() {
        return this.shownCategories;
    }

    public void enableCategory(final int category) {
        if (!shownCategories.contains(category)) {
            shownCategories.add(category);
        }
    }

    public void disableCategory(final int category) {
        if (shownCategories.contains(new Integer(category))) {
            shownCategories.remove(new Integer(category));
        }
    }

    public void inventoryChangeAction() {
        fireTableDataChanged();
    }
}
