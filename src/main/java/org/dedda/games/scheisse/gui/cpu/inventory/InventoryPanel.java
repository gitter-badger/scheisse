package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTable;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.state.game.inventory.Inventory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by dedda on 11/29/14.
 */
public class InventoryPanel extends JPanel{

    private TabbedGamePane tabbedGamePane;
    private InventoryTable inventoryTable;
    private InventoryTable actionTable;
    private Inventory actionInventory;
    private InventoryActionPanel actionPanel;

    public InventoryPanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        Game game = tabbedGamePane.getGui().getGame();
        Inventory inventory = game.getPlayer().getInventory();
        inventoryTable = new InventoryTable(inventory);
        inventoryTable.addListSelectionListener(getInventorySelectionListener());
        actionInventory = new Inventory();
        actionTable = new InventoryTable(actionInventory);
        actionTable.addListSelectionListener(getActionInventorySelectionListener());
        actionPanel = new InventoryActionPanel(this);
        initLayout();
    }

    private void initLayout() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.LINE_AXIS);
        setLayout(layout);
        add(inventoryTable);
        add(actionPanel);
        add(actionTable);
        inventoryTable.getInventory().triggerChangeEvent();
        actionTable.getInventory().triggerChangeEvent();
        setBackground(Color.LIGHT_GRAY);
    }

    private ListSelectionListener getInventorySelectionListener() {
        return new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                actionPanel.inventorySelectionChanged(listSelectionEvent);
            }
        };
    }

    private ListSelectionListener getActionInventorySelectionListener() {
        return new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                actionPanel.actionInventorySelectionChanged(listSelectionEvent);
            }
        };
    }

    public InventoryTable getInventoryTable() {
        return inventoryTable;
    }

    public InventoryTable getActionTable() {
        return actionTable;
    }

    public InventoryActionPanel getActionPanel() {
        return actionPanel;
    }

    public TabbedGamePane getTabbedGamePane() {
        return tabbedGamePane;
    }
}
