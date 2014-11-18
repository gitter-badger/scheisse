package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.state.game.inventory.Inventory;

import javax.swing.table.AbstractTableModel;
import static org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableColumnFilter.*;

/**
 * Created by dedda on 11/18/14.
 */
public class InventoryTableModel extends AbstractTableModel{

    private Inventory inventory;
    private InventoryTableColumnFilter columnFilter;

    public InventoryTableModel(Inventory inventory) {
        this.inventory = inventory;
        columnFilter = new InventoryTableColumnFilter(COLUMNS);
    }

    public int getRowCount() {
        return 0;
    }

    public int getColumnCount() {
        return 0;
    }

    public Object getValueAt(int i, int i1) {
        return null;
    }
}
