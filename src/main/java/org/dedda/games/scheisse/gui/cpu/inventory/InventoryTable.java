package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.InventoryChangeListener;
import org.dedda.games.scheisse.state.game.inventory.Slot;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.Vector;

/**
 * Created by dedda on 10/5/14.
 */
public class InventoryTable extends JScrollPane implements InventoryChangeListener {

    private InventoryPanelOld inventoryPanelOld;
    private Inventory inventory;
    private Vector dataVector = new Vector();
    private Vector headerVector = new Vector(2);
    private DefaultTableModel tableModel;
    private JTable table;

    public InventoryTable(final InventoryPanelOld inventoryPanelOld) {
        this.inventoryPanelOld = inventoryPanelOld;
        this.inventory = inventoryPanelOld.getTabbedGamePane().getGui().getGame().getPlayer().getInventory();
        inventory.addInventoryChangeListener(this);
        headerVector.addElement("Item");
        headerVector.addElement("Number");
        tableModel = new DefaultTableModel(dataVector, headerVector) {
            @Override
            public boolean isCellEditable(int row, int column){
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
        dataVector.clear();
        for (final Slot slot : inventory.getSlots()) {
            if (slot.getDummy() != null) {
                Vector itemVector = new Vector(2);
                itemVector.addElement(slot.getDummy().getName());
                itemVector.addElement(slot.getNumberOfItems());
                dataVector.addElement(itemVector);
            }
        }
        int selected[] = table.getSelectedRows();
        table.setModel(tableModel);
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

    }

    public void removeFromTable(final String name, final int amount) {

    }

    public JTable getTable() {
        return table;
    }

    public InventoryPanelOld getInventoryPanelOld() {
        return inventoryPanelOld;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void inventoryChangeAction() {
        update();
    }
}
