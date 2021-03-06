package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.Gui;
import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTable;
import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableModel;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by dedda on 11/30/14.
 */
public class InventoryActionPanel extends JPanel {

    private InventoryTablePanel inventoryTablePanel;
    private JButton addButton;
    private JButton removeButton;
    private JButton okButton;
    private JSpinner numberSpinner;
    private InventoryActionComboBox actionComboBox;
    private ArrayList<InventoryTransactionListener> listeners;

    public InventoryActionPanel(
        final InventoryTablePanel inventoryTablePanel
    ) {
        this.inventoryTablePanel = inventoryTablePanel;
        numberSpinner = new JSpinner();
        SpinnerNumberModel spinnerNumberModel =
            new SpinnerNumberModel(1, 1, 100, 1);
        numberSpinner.setModel(spinnerNumberModel);
        numberSpinner.setMaximumSize(numberSpinner.getPreferredSize());
        numberSpinner.setAlignmentX(CENTER_ALIGNMENT);
        addButton = new JButton(">>");
        addButton.setAlignmentX(CENTER_ALIGNMENT);
        removeButton = new JButton("<<");
        removeButton.setAlignmentX(CENTER_ALIGNMENT);
        actionComboBox = new InventoryActionComboBox();
        actionComboBox.setAlignmentX(CENTER_ALIGNMENT);
        okButton = new JButton("OK");
        okButton.setAlignmentX(CENTER_ALIGNMENT);
        initLayout();
        initListeners();
    }

    private void initLayout() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(numberSpinner);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(addButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(removeButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(actionComboBox);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(okButton);
        add(Box.createVerticalGlue());
    }

    private void initListeners() {
        listeners = new ArrayList<>();
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                add();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                remove();
            }
        });
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                ok();
            }
        });
    }

    private void add() {
        InventoryTable inventoryTable =
            inventoryTablePanel.getInventoryTable();
        InventoryTable actionTable = inventoryTablePanel.getActionTable();
        double amountDouble = (Double) numberSpinner.getModel().getValue();
        int amount = (int) amountDouble;
        int[] rows = inventoryTable.getTable().getSelectedRows();
        long[] ids = new long[rows.length];
        InventoryTableModel model = inventoryTable.getModel();
        for (int i = 0; i < ids.length; i++) {
            ids[i] = model.getSlotInRow(rows[i]).getDummy().getId();
        }
        Inventory inventory = inventoryTable.getInventory();
        Inventory actionInventory = actionTable.getInventory();
        for (long id : ids) {
            actionInventory.addItems(id, amount);
            inventory.removeItems(id, amount);
            inventory.triggerChangeEvent();
            actionInventory.triggerChangeEvent();
        }
    }

    private void remove() {
        InventoryTable inventoryTable =
            inventoryTablePanel.getInventoryTable();
        InventoryTable actionTable = inventoryTablePanel.getActionTable();
        double amountDouble = (Double) numberSpinner.getModel().getValue();
        int amount = (int) amountDouble;
        int[] rows = actionTable.getTable().getSelectedRows();
        long[] ids = new long[rows.length];
        InventoryTableModel model = actionTable.getModel();
        for (int i = 0; i < ids.length; i++) {
            ids[i] = model.getSlotInRow(rows[i]).getDummy().getId();
        }
        Inventory inventory = inventoryTable.getInventory();
        Inventory actionInventory = actionTable.getInventory();
        for (long id : ids) {
            inventory.addItems(id, amount);
            actionInventory.removeItems(id, amount);
            inventory.triggerChangeEvent();
            actionInventory.triggerChangeEvent();
        }
    }

    private void ok() {
        InventoryTable actionTable = inventoryTablePanel.getActionTable();
        Gui gui = inventoryTablePanel.getTabbedGamePane().getGui();
        Inventory actionInventory = actionTable.getInventory();
        Object selected = actionComboBox.getModel().getSelectedItem();
        if (selected.equals(InventoryActionComboBox.SELL)) {
            Player player = gui.getGame().getPlayer();
            for (Slot slot : actionInventory.getSlots()) {
                long sellValue = slot.getDummy().getPrice();
                long amount = slot.getNumberOfItems();
                long money = player.getMoney() + amount * sellValue;
                player.setMoney(money);
            }
        }
        actionInventory.getSlots().clear();
        actionInventory.triggerChangeEvent();
        transactionPerformed(InventoryTransactionEvent.GENERAL);
    }

    public void inventorySelectionChanged(
        final ListSelectionEvent listSelectionEvent
    ) {
        InventoryTable inventoryTable =
            inventoryTablePanel.getInventoryTable();
        int[] selectedRows = inventoryTable.getTable().getSelectedRows();
        long minAmount = 1;
        for (int row : selectedRows) {
            InventoryTableModel model = inventoryTable.getModel();
            long amount = model.getSlotInRow(row).getNumberOfItems();
            if (minAmount == 1 || minAmount > amount) {
                minAmount = amount;
            }
        }
        SpinnerNumberModel spinnerNumberModel =
            new SpinnerNumberModel(1, 1, minAmount, 1);
        numberSpinner.setModel(spinnerNumberModel);
    }

    public void actionInventorySelectionChanged(
        final ListSelectionEvent listSelectionEvent
    ) {
        InventoryTable actionTable = inventoryTablePanel.getActionTable();
        int[] selectedRows = actionTable.getTable().getSelectedRows();
        long minAmount = 1;
        for (int row : selectedRows) {
            InventoryTableModel model;
            model = inventoryTablePanel.getActionTable().getModel();
            long amount = model.getSlotInRow(row).getNumberOfItems();
            if (minAmount == 1 || minAmount > amount) {
                minAmount = amount;
            }
        }
        SpinnerNumberModel spinnerNumberModel =
            new SpinnerNumberModel(1, 1, minAmount, 1);
        numberSpinner.setModel(spinnerNumberModel);
    }

    public void transactionPerformed(final int type) {
        InventoryTransactionEvent event = new InventoryTransactionEvent() {
            @Override
            public int getEventType() {
                return type;
            }
        };
        transactionPerformed(event);
    }

    public void transactionPerformed(final InventoryTransactionEvent event) {
        for (InventoryTransactionListener listener : listeners) {
            listener.transactionPerformed(event);
        }
    }

    public void cancelTransaction() {
        InventoryTable actionTable = inventoryTablePanel.getActionTable();
        Inventory actionInventory = actionTable.getInventory();
        InventoryTable inventoryTable =
            inventoryTablePanel.getInventoryTable();
        Inventory inventory = inventoryTable.getInventory();
        while (actionInventory.getSize() > 0) {
            Slot slot = actionInventory.getSlots().get(0);
            long id = slot.getDummy().getId();
            long amount = slot.getNumberOfItems();
            inventory.addItems(id, amount);
            actionInventory.getSlots().remove(slot);
        }
    }

    public void removeInventoryTransactionListener(
        final InventoryTransactionListener listener
    ) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public void addInventoryTransactionListener(
        final InventoryTransactionListener listener
    ) {
        listeners.add(listener);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JSpinner getNumberSpinner() {
        return numberSpinner;
    }

    public InventoryActionComboBox getActionComboBox() {
        return actionComboBox;
    }

    public InventoryTablePanel getInventoryTablePanel() {
        return inventoryTablePanel;
    }
}
