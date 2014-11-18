package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.filter.ItemFilter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by dedda on 10/7/14.
 */
public class ItemTable extends JTable {

    public static final int ITEM_ID = 0;
    public static final int ITEM_NAME = 1;
    public static final int ITEM_VALUE = 2;
    public static final int ITEM_NUMBER = 3;
    public static final int WEAPON_DAMAGE = 4;
    public static final int ARMOR = 5;

    private HashMap<Item, Integer> itemMap;
    private TableModel tableModel;
    private int visibleColumns[];
    private Vector dataVector = new Vector();
    private Vector headerVector = new Vector();
    private ItemFilter itemFilter = null;

    public ItemTable(final HashMap<Item, Integer> itemMap, final int columns[]) {
        this.itemMap = itemMap;
        this.visibleColumns = columns;
    }

    public ItemTable(final int columns[]) {
        itemMap = new HashMap<Item, Integer>();
        this.visibleColumns = columns;
    }

    public void rerender() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        headerVector.setSize(visibleColumns.length);
        for (int i = 0; i < visibleColumns.length; i++) {
            if (visibleColumns[i] == ITEM_ID) {
                headerVector.addElement("ID");
            } else if (visibleColumns[i] == ITEM_NAME) {
                headerVector.addElement("Name");
            } else if (visibleColumns[i] == ITEM_VALUE) {
                headerVector.addElement("Value");
            } else if (visibleColumns[i] == ITEM_NUMBER) {
                headerVector.addElement("Number");
            } else if (visibleColumns[i] == WEAPON_DAMAGE) {
                headerVector.addElement("Damage");
            } else if (visibleColumns[i] == ARMOR) {
                headerVector.addElement("Armor");
            }
        }
    }

    public void setItemMap(final HashMap<Item, Integer> itemMap) {
        this.itemMap = itemMap;
        rerender();
    }

    public void setVisibleColumns(final int[] visibleColumns) {
        this.visibleColumns = visibleColumns;
    }

    public void setItemFilter(final ItemFilter itemFilter) {
        this.itemFilter = itemFilter;
    }

    public void setDataVector(final Vector dataVector) {
        this.dataVector = dataVector;
    }

}
