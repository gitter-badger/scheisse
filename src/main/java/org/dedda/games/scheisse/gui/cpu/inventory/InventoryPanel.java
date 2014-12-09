package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.state.game.Player;
import sun.org.mozilla.javascript.tools.debugger.Dim;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dedda on 11/30/14.
 */
public class InventoryPanel extends JPanel {

    private TabbedGamePane tabbedGamePane;
    private InventoryTablePanel tablePanel;
    private HeaderBar headerBar;
    private Player player;

    public InventoryPanel(TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        player = tabbedGamePane.getGui().getGame().getPlayer();
        headerBar = new HeaderBar(player);
        tablePanel = new InventoryTablePanel(tabbedGamePane);
        intiLayout();
        tablePanel.addTransactionListener(headerBar);
        headerBar.addCategoriesChangeListener(tablePanel.getInventoryTable().getModel());
        headerBar.addCategoriesChangeListener(tablePanel.getActionTable().getModel());
    }

    private void intiLayout() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
        headerBar.setAlignmentX(CENTER_ALIGNMENT);
        headerBar.setAlignmentY(TOP_ALIGNMENT);
        Dimension preferredHeaderSize = headerBar.getPreferredSize();
        preferredHeaderSize.width = getWidth();
        preferredHeaderSize.height = 20;
        headerBar.setMaximumSize(preferredHeaderSize);
        headerBar.setPreferredSize(preferredHeaderSize);
        add(headerBar);
        add(tablePanel);
        setBackground(Color.LIGHT_GRAY);
    }

    public void cancelTransaction() {
        tablePanel.cancelTransaction();
    }

}
