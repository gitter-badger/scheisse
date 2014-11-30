package org.dedda.games.scheisse.gui.cpu.shop;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.gui.cpu.inventory.InventoryTransactionEvent;
import org.dedda.games.scheisse.gui.cpu.inventory.InventoryTransactionListener;
import org.dedda.games.scheisse.gui.cpu.shop.table.ShopTablePanel;
import org.dedda.games.scheisse.state.game.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dedda on 10/5/14.
 */
public class ShopPanel extends JPanel implements InventoryTransactionListener{

    private TabbedGamePane tabbedGamePane;
    private JLabel headerBar;
    private Player player;
    private ShopTablePanel tablePanel;

    public ShopPanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        this.player = tabbedGamePane.getGui().getGame().getPlayer();
        headerBar = new JLabel("Money: " + player.getMoney());
        tablePanel = new ShopTablePanel(tabbedGamePane);
        setBackground(Color.LIGHT_GRAY);
        intiLayout();
    }

    private void intiLayout() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
        headerBar.setAlignmentX(CENTER_ALIGNMENT);
        headerBar.setAlignmentY(TOP_ALIGNMENT);
        Dimension preferredHeaderSize = headerBar.getPreferredSize();
        preferredHeaderSize.width += 100;
        headerBar.setMaximumSize(preferredHeaderSize);
        headerBar.setPreferredSize(preferredHeaderSize);
        add(headerBar);
        add(tablePanel);
        setBackground(Color.LIGHT_GRAY);
    }

    public void transactionPerformed(InventoryTransactionEvent event) {

    }

    public void cancelTransaction() {

    }

}
