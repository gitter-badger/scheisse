package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.state.game.inventory.Inventory;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.Vector;

/**
 * Created by dedda on 10/5/14.
 */
public class InventoryActionTable extends JScrollPane {

    private InventoryPanel inventoryPanel;
    private Inventory inventory;
    private Vector dataVector = new Vector();
    private Vector headerVector = new Vector(2);
    private DefaultTableModel tableModel;
    private JTable table;

    public InventoryActionTable(final InventoryPanel inventoryPanel) {
        this.inventoryPanel = inventoryPanel;
        this.inventory = inventoryPanel.getTabbedGamePane().getGui().getGame().getPlayer().getInventory();
        headerVector.addElement("Item");
        headerVector.addElement("Number");
        tableModel = new DefaultTableModel(dataVector, headerVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(headerVector);
        table = new JTable();
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();
        viewport.setLayout(new BorderLayout());
        viewport.add(table, BorderLayout.CENTER);
    }

    public void update() {
        tableModel.fireTableDataChanged();
    }

    public void addListSelectionListener(final ListSelectionListener listSelectionListener) {
        table.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    public String[] getSelectedRows() {
        int rows[] = table.getSelectedRows();
        String rowContent[] = new String[rows.length];
        for (int i = 0; i < rows.length; i++) {
            rowContent[i] = (String)tableModel.getValueAt(rows[i], 0);
        }
        return rowContent;
    }

    public int getMinSelectedNumber() {
        int rows[] = table.getSelectedRows();
        int min = Integer.MAX_VALUE;
        for (int i : rows) {
            int number = (Integer) tableModel.getValueAt(i, 1);
            if (number < min) {
                min = number;
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }

    public void addToTable(final String name, final int amount) {
        for (int i = 0; i < dataVector.size(); i++) {
            Vector currentItem = (Vector) dataVector.get(i);
            if (currentItem.get(0).equals(name)) {
                currentItem.set(1, (Integer) currentItem.get(1) + amount);
                tableModel.fireTableDataChanged();
                return;
            }
        }
        Vector item = new Vector(2);
        item.addElement(name);
        item.addElement(amount);
        dataVector.add(item);
        tableModel.fireTableDataChanged();
    }

    public void removeFromTable(final String name, final int amount) {

    }

    public JTable getTable() {
        return table;
    }

    public InventoryPanel getInventoryPanel() {
        return inventoryPanel;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
