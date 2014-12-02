package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableModel;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.Slot;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
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

    public InventoryActionPanel(InventoryTablePanel inventoryTablePanel) {
        this.inventoryTablePanel = inventoryTablePanel;
        numberSpinner = new JSpinner();
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1, 1, 100, 1);
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
        listeners = new ArrayList<InventoryTransactionListener>();
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                add();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                remove();
            }
        });
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                ok();
            }
        });
    }

    private void add() {
        double amountDouble = (Double)numberSpinner.getModel().getValue();
        int amount = (int)amountDouble;
        int rows[] = inventoryTablePanel.getInventoryTable().getTable().getSelectedRows();
        long ids[] = new long[rows.length];
        for (int row : rows) {
            ids[row] = inventoryTablePanel.getInventoryTable().getModel().getSlotInRow(row).getDummy().getId();
        }
        Inventory inventory = inventoryTablePanel.getInventoryTable().getInventory();
        Inventory actionInventory = inventoryTablePanel.getActionTable().getInventory();
        for (long id : ids) {
            actionInventory.addItems(id, amount);
            inventory.removeItems(id, amount);
            inventory.triggerChangeEvent();
            actionInventory.triggerChangeEvent();
        }
    }

    private void remove() {
        double amountDouble = (Double)numberSpinner.getModel().getValue();
        int amount = (int)amountDouble;
        int rows[] = inventoryTablePanel.getActionTable().getTable().getSelectedRows();
        long ids[] = new long[rows.length];
        for (int row : rows) {
            ids[row] = inventoryTablePanel.getActionTable().getModel().getSlotInRow(row).getDummy().getId();
        }
        Inventory inventory = inventoryTablePanel.getInventoryTable().getInventory();
        Inventory actionInventory = inventoryTablePanel.getActionTable().getInventory();
        for (long id : ids) {
            inventory.addItems(id, amount);
            actionInventory.removeItems(id, amount);
            inventory.triggerChangeEvent();
            actionInventory.triggerChangeEvent();
        }
    }

    private void ok() {
        Inventory actionInventory = inventoryTablePanel.getActionTable().getInventory();
        if (actionComboBox.getModel().getSelectedItem().equals(InventoryActionComboBox.SELL)) {
            Player player = inventoryTablePanel.getTabbedGamePane().getGui().getGame().getPlayer();
            for (Slot slot : actionInventory.getSlots()) {
                player.setMoney(player.getMoney() + slot.getNumberOfItems() * slot.getDummy().getValue());
            }
        }
        actionInventory.getSlots().clear();
        actionInventory.triggerChangeEvent();
        transactionPerformed(InventoryTransactionEvent.GENERAL);
    }

    public void inventorySelectionChanged(final ListSelectionEvent listSelectionEvent) {
        int selectedRows[] = inventoryTablePanel.getInventoryTable().getTable().getSelectedRows();
        long minAmount = 1;
        for (int row : selectedRows) {
            InventoryTableModel model;
            model = inventoryTablePanel.getInventoryTable().getModel();
            long amount = model.getSlotInRow(row).getNumberOfItems();
            if (minAmount == 1 || minAmount > amount) {
                minAmount = amount;
            }
        }
        SpinnerNumberModel spinnerNumberModel =
                new SpinnerNumberModel(1, 1, minAmount, 1);
        numberSpinner.setModel(spinnerNumberModel);
    }

    public void actionInventorySelectionChanged(final ListSelectionEvent listSelectionEvent) {
        int selectedRows[] = inventoryTablePanel.getActionTable().getTable().getSelectedRows();
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
        Inventory actionInventory = inventoryTablePanel.getActionTable().getInventory();
        Inventory inventory = inventoryTablePanel.getInventoryTable().getInventory();
        while (actionInventory.getSize() > 0) {
            Slot slot = actionInventory.getSlots().get(0);
            inventory.addItems(slot.getDummy().getId(), slot.getNumberOfItems());
            actionInventory.getSlots().remove(slot);
        }
    }

    public void removeInventoryTransactionListener(final InventoryTransactionListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public void addInventoryTransactionListener(final InventoryTransactionListener listener) {
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
