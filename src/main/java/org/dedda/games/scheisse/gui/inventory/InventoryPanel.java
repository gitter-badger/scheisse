package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.state.game.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dedda on 10/5/14.
 */
public class InventoryPanel extends JPanel {

    private TabbedGamePane tabbedGamePane;
    private Player player;
    private Thread thread;
    private InventoryTable inventoryTable;
    private InventoryActionPanel inventoryActionPanel;
    private InventoryActionTable inventoryActionTable;

    public InventoryPanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        this.player = tabbedGamePane.getGui().getGame().getPlayer();
        inventoryTable = new InventoryTable(this);
        inventoryActionTable = new InventoryActionTable(this);
        inventoryActionPanel = new InventoryActionPanel(this);
        inventoryTable.addListSelectionListener(inventoryActionPanel.getInventoryListSelectionListener());
        inventoryActionTable.addListSelectionListener(inventoryActionPanel.getInventoryActionListSelectionListener());
        BoxLayout layout = new BoxLayout(this, BoxLayout.LINE_AXIS);

        setLayout(layout);
        //add(inventoryTable, BorderLayout.LINE_START);
        add(inventoryTable);
        add(inventoryActionPanel);
        //add(inventoryActionPanel, BorderLayout.CENTER);
        add(inventoryActionTable);
        //add(inventoryActionTable, BorderLayout.LINE_END);
        inventoryActionTable.update();
        inventoryTable.update();
        setBackground(Color.LIGHT_GRAY);
    }

    public TabbedGamePane getTabbedGamePane() {
        return tabbedGamePane;
    }

    public InventoryTable getInventoryTable() {
        return inventoryTable;
    }

    public InventoryActionTable getInventoryActionTable() {
        return inventoryActionTable;
    }
}
