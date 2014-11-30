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

/**
 * Created by dedda on 11/30/14.
 */
public class InventoryActionPanel extends JPanel {

    private InventoryPanel inventoryPanel;
    private JButton addButton;
    private JButton removeButton;
    private JButton okButton;
    private JSpinner numberSpinner;
    private InventoryActionComboBox actionComboBox;

    public InventoryActionPanel(InventoryPanel inventoryPanel) {
        this.inventoryPanel = inventoryPanel;
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
        int rows[] = inventoryPanel.getInventoryTable().getTable().getSelectedRows();
        Inventory inventory = inventoryPanel.getInventoryTable().getInventory();
        Inventory actionInventory = inventoryPanel.getActionTable().getInventory();
        for (int row : rows) {
            long id = inventoryPanel.getInventoryTable().getModel().getSlotInRow(row).getDummy().getId();
            actionInventory.addItems(id, amount);
            inventory.removeItems(id, amount);
            inventory.triggerChangeEvent();
            actionInventory.triggerChangeEvent();
        }
    }

    private void remove() {
        double amountDouble = (Double)numberSpinner.getModel().getValue();
        int amount = (int)amountDouble;
        int rows[] = inventoryPanel.getActionTable().getTable().getSelectedRows();
        Inventory inventory = inventoryPanel.getInventoryTable().getInventory();
        Inventory actionInventory = inventoryPanel.getActionTable().getInventory();
        for (int row : rows) {
            long id = inventoryPanel.getActionTable().getModel().getSlotInRow(row).getDummy().getId();
            inventory.addItems(id, amount);
            actionInventory.removeItems(id, amount);
            inventory.triggerChangeEvent();
            actionInventory.triggerChangeEvent();
        }
    }

    private void ok() {
        Inventory actionInventory = inventoryPanel.getActionTable().getInventory();
        if (actionComboBox.getModel().getSelectedItem().equals(InventoryActionComboBox.SELL)) {
            Player player = inventoryPanel.getTabbedGamePane().getGui().getGame().getPlayer();
            for (Slot slot : actionInventory.getSlots()) {
                player.setMoney(player.getMoney() + slot.getNumberOfItems() * slot.getDummy().getValue());
            }
        }
        actionInventory.getSlots().clear();
        actionInventory.triggerChangeEvent();
    }

    public void inventorySelectionChanged(ListSelectionEvent listSelectionEvent) {
        int selectedRows[] = inventoryPanel.getInventoryTable().getTable().getSelectedRows();
        long minAmount = 1;
        for (int row : selectedRows) {
            InventoryTableModel model;
            model = inventoryPanel.getInventoryTable().getModel();
            long amount = model.getSlotInRow(row).getNumberOfItems();
            if (minAmount == 1 || minAmount > amount) {
                minAmount = amount;
            }
        }
        SpinnerNumberModel spinnerNumberModel =
                new SpinnerNumberModel(1, 1, minAmount, 1);
        numberSpinner.setModel(spinnerNumberModel);
    }

    public void actionInventorySelectionChanged(ListSelectionEvent listSelectionEvent) {
        int selectedRows[] = inventoryPanel.getInventoryTable().getTable().getSelectedRows();
        long minAmount = 1;
        for (int row : selectedRows) {
            InventoryTableModel model;
            model = inventoryPanel.getActionTable().getModel();
            long amount = model.getSlotInRow(row).getNumberOfItems();
            if (minAmount == 1 || minAmount > amount) {
                minAmount = amount;
            }
        }
        SpinnerNumberModel spinnerNumberModel =
                new SpinnerNumberModel(1, 1, minAmount, 1);
        numberSpinner.setModel(spinnerNumberModel);
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

    public InventoryPanel getInventoryPanel() {
        return inventoryPanel;
    }
}
