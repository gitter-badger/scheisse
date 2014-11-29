package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTable;

import javax.swing.*;
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

    }

    private void remove() {

    }

    private void ok() {

    }

    public void inventorySelectionChanged() {

    }

    public void actionInventorySelectionChanged() {

    }

}
