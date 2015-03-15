package org.dedda.games.scheisse.gui.cpu.shop.table;

import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.InventoryChangeListener;
import org.dedda.games.scheisse.state.game.item.Armor;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.Weapon;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dedda on 12/1/14.
 */
public class ShopTableModel extends AbstractTableModel implements InventoryChangeListener {

    public static final int ID = 0;
    public static final int SYMBOL = 1;
    public static final int NAME = 2;
    public static final int VALUE = 3;
    public static final int ATTACK = 4;
    public static final int ARMOR = 5;
    public static final int STOCK = 6;
    public static final int IN_INVENTORY = 7;
    public static final String HEADER_ID = "ID";
    public static final String HEADER_SYMBOL = "Icon";
    public static final String HEADER_NAME = "Name";
    public static final String HEADER_VALUE = "Value";
    public static final String HEADER_ATTACK = "Attack";
    public static final String HEADER_ARMOR = "Armor";
    public static final String HEADER_STOCK = "Stock";
    public static final String HEADER_IN_INVENTORY = "Owned";
    public static final int[] CATEGORIES = new int[]{
            ID,
            SYMBOL,
            NAME,
            VALUE,
            ATTACK,
            ARMOR,
            STOCK,
            IN_INVENTORY
    };
    public static final String[] HEADERS = new String[]{
            HEADER_ID,
            HEADER_SYMBOL,
            HEADER_NAME,
            HEADER_VALUE,
            HEADER_ATTACK,
            HEADER_ARMOR,
            HEADER_STOCK,
            HEADER_IN_INVENTORY
    };

    private Inventory inventory;
    private ShopTable shopTable;
    private List<Integer> shownCategories;

    public ShopTableModel(ShopTable shopTable) {
        this.shopTable = shopTable;
        this.inventory = shopTable.getInventory();
        inventory.addInventoryChangeListener(this);
        this.shownCategories = new ArrayList<>();
    }

    public int getRowCount() {
        return shopTable.getOffers().size();
    }

    public int getColumnCount() {
        return shownCategories.size();
    }

    public Object getValueAt(int row, int col) {
        long id = shopTable.getOffers().get(row).itemId;
        Item item = Item.itemForId(id);
        long stock = shopTable.getOffers().get(row).amountAvailable;
        long in_inventory = inventory.getSlotWithItemId(id).getNumberOfItems();
        int category = shownCategories.get(col);
        switch (category) {
            case ID: return id;
            case SYMBOL: return item.getId();
            case NAME: return item.getName();
            case VALUE: return item.getValue();
            case ATTACK: return item instanceof Weapon ? ((Weapon) item).getAttack() : 0;
            case ARMOR: return item instanceof Armor ? ((Armor) item).getArmor() : 0;
            case STOCK: return stock;
            case IN_INVENTORY: return in_inventory;
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(final int row, final int col) {
        return false;
    }

    @Override
    public Class getColumnClass(final int columnIndex) {
        int category = shownCategories.get(columnIndex);
        switch (category) {
            case ID: return Long.class;
            case SYMBOL: return Long.class;
            case NAME: return String.class;
            case VALUE: return Long.class;
            case ATTACK: return Long.class;
            case ARMOR: return Long.class;
            case STOCK: return Long.class;
            case IN_INVENTORY: return Long.class;
            default: return String.class;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        int category = shownCategories.get(columnIndex);
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
