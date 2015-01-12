package org.dedda.games.scheisse.gui.cpu.shop;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.state.game.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dedda on 10/5/14.
 */
public class ShopPanel extends JPanel {

    private TabbedGamePane tabbedGamePane;
    private Player player;
    private JProgressBar progressBar;
    private ShopTablePanel tablePanel;

    public ShopPanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        this.player = tabbedGamePane.getGui().getGame().getPlayer();
        setBackground(Color.LIGHT_GRAY);
        progressBar = new JProgressBar();
        tablePanel = new ShopTablePanel();
        intiLayout();
    }

    private void intiLayout() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
        progressBar.setAlignmentX(CENTER_ALIGNMENT);
        progressBar.setAlignmentY(TOP_ALIGNMENT);
        Dimension preferredHeaderSize = progressBar.getPreferredSize();
        preferredHeaderSize.width = getWidth();
        preferredHeaderSize.height = 20;
        progressBar.setMaximumSize(preferredHeaderSize);
        progressBar.setPreferredSize(preferredHeaderSize);
        add(progressBar);
        add(tablePanel);
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
