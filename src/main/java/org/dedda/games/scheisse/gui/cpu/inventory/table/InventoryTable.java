package org.dedda.games.scheisse.gui.cpu.inventory.table;

import org.dedda.games.scheisse.state.game.inventory.Inventory;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

/**
 * Created by dedda on 11/29/14.
 */
public class InventoryTable extends JScrollPane {

    private Inventory inventory;
    private JTable table;
    private InventoryTableModel model;

    public InventoryTable(final Inventory inventory) {
        this.inventory = inventory;
        model = new InventoryTableModel(inventory);
        table = new JTable() {
            @Override
            public void tableChanged(TableModelEvent event) {
                super.tableChanged(event);
                if (model.getShownCategories().contains(InventoryTableModel.SYMBOL)) {
                    TableColumnModel columnModel = getColumnModel();
                    int columnIndex = model.findColumn(InventoryTableModel.HEADER_SYMBOL);
                    TableColumn column = columnModel.getColumn(columnIndex);
                    column.setCellRenderer(new ItemIconCellRenderer());
                }
            }
        };
        model.enableCategory(InventoryTableModel.ID);
        model.enableCategory(InventoryTableModel.SYMBOL);
        model.enableCategory(InventoryTableModel.NAME);
        model.enableCategory(InventoryTableModel.NUMBER);
        table.setModel(model);
        viewport.setLayout(new BorderLayout());
        viewport.add(table, BorderLayout.CENTER);
        model.fireTableDataChanged();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public JTable getTable() {
        return table;
    }

    public InventoryTableModel getModel() {
        return model;
    }

    public void addListSelectionListener(final ListSelectionListener inventorySelectionListener) {
        table.getSelectionModel().addListSelectionListener(inventorySelectionListener);
    }
}
