package org.dedda.games.scheisse.gui.cpu.shop;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.gui.cpu.inventory.InventoryTransactionEvent;
import org.dedda.games.scheisse.gui.cpu.inventory.InventoryTransactionListener;
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

    private JProgressBar progressBar;

    public ShopPanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        this.player = tabbedGamePane.getGui().getGame().getPlayer();
        headerBar = new JLabel("Money: " + player.getMoney());
        setBackground(Color.LIGHT_GRAY);
        progressBar = new JProgressBar();
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
        setBackground(Color.LIGHT_GRAY);
    }

    public void transactionPerformed(InventoryTransactionEvent event) {

    }

    public void cancelTransaction() {
        progressBar.setAlignmentX(CENTER_ALIGNMENT);
        progressBar.setAlignmentY(TOP_ALIGNMENT);
        Dimension preferredHeaderSize = progressBar.getPreferredSize();
        preferredHeaderSize.width = getWidth();
        preferredHeaderSize.height = 20;
        progressBar.setMaximumSize(preferredHeaderSize);
        progressBar.setPreferredSize(preferredHeaderSize);
        add(progressBar);
        setBackground(Color.LIGHT_GRAY);
    }

    public void setProgress(final int done, final int of) {
        progressBar.setMinimum(0);
        progressBar.setMaximum(of);
        progressBar.setValue(done);
        progressBar.setString(done + " / " + of);
        progressBar.setStringPainted(done < of);
        progressBar.repaint();
    }

}
