package org.dedda.games.scheisse.gui.cpu.inventory;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dedda on 10/5/14.
 */
public class InventoryActionPanel extends JPanel {

    private InventoryPanel inventoryPanel;
    private InventoryTable inventoryTable;
    private InventoryActionTable inventoryActionTable;
    private JButton addButton;
    private JButton removeButton;
    private JButton okButton;
    private JSpinner numberSpinner;
    private InventoryActionComboBox inventoryActionComboBox;

    public InventoryActionPanel(final InventoryPanel inventoryPanel) {
        this.inventoryPanel = inventoryPanel;
        this.inventoryTable = inventoryPanel.getInventoryTable();
        this.inventoryActionTable = inventoryPanel.getInventoryActionTable();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);

        setLayout(boxLayout);
        numberSpinner = new JSpinner();
        SpinnerNumberModel spinnerNumberModel =
                new SpinnerNumberModel(1, 1, 100, 1);
        numberSpinner.setModel(spinnerNumberModel);
        numberSpinner.setMaximumSize(numberSpinner.getPreferredSize());
        numberSpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(numberSpinner);
        add(Box.createRigidArea(new Dimension(0, 10)));
        addButton = new JButton(">>");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(addButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        removeButton = new JButton("<<");
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(removeButton);
        add(Box.createRigidArea(new Dimension(0, 10)));
        inventoryActionComboBox = new InventoryActionComboBox();
        inventoryActionComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(inventoryActionComboBox);
        add(Box.createRigidArea(new Dimension(0, 10)));
        okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(okButton);

        initListeners();
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
        String rows[] = inventoryTable.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            inventoryActionTable.addToTable(row, (Integer) numberSpinner.getValue());
            inventoryTable.removeFromTable(row, (Integer) numberSpinner.getValue());
        }
    }

    private void remove() {
        String rows[] = inventoryActionTable.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            inventoryTable.addToTable(row, (Integer) numberSpinner.getValue());
            inventoryActionTable.removeFromTable(row, (Integer) numberSpinner.getValue());
        }
    }

    private void ok() {

    }

    private void inventoryListSelectionChanged() {
        if (inventoryTable.getSelectedRows().length == 0) {
            return;
        }
        inventoryActionTable.getTable().clearSelection();
        System.out.println(inventoryTable.getMinSelectedNumber());
        SpinnerNumberModel spinnerNumberModel =
                new SpinnerNumberModel(1, 1, inventoryTable.getMinSelectedNumber(), 1);
        numberSpinner.setModel(spinnerNumberModel);
    }

    private void inventoryActionListSelectionChanged() {
        if (inventoryActionTable.getSelectedRows().length == 0) {
            return;
        }
        inventoryTable.getTable().clearSelection();
        System.out.println(inventoryActionTable.getMinSelectedNumber());
        SpinnerNumberModel spinnerNumberModel =
                new SpinnerNumberModel(1, 1, inventoryActionTable.getMinSelectedNumber(), 1);
        numberSpinner.setModel(spinnerNumberModel);
    }

    public ListSelectionListener getInventoryListSelectionListener() {
        return new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                inventoryListSelectionChanged();
            }
        };
    }

    public ListSelectionListener getInventoryActionListSelectionListener() {
        return new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                inventoryActionListSelectionChanged();
            }
        };
    }

}
