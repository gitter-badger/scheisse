package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.state.game.inventory.Inventory;

import javax.swing.table.AbstractTableModel;

import static org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableColumnFilterOld.*;

/**
 * Created by dedda on 11/18/14.
 */
public class InventoryTableModelOld extends AbstractTableModel{

    private Inventory inventory;
    private InventoryTableColumnFilterOld columnFilter;

    public InventoryTableModelOld(Inventory inventory) {
        this.inventory = inventory;
        columnFilter = new InventoryTableColumnFilterOld(COLUMNS);
    }

    public int getRowCount() {
        return inventory.getSize();
    }

    public int getColumnCount() {
        return columnFilter.getColumns().length;
    }

    public Object getValueAt(int i, int i1) {
        return null;
    }
}
