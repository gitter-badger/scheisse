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

    public ShopPanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
        this.player = tabbedGamePane.getGui().getGame().getPlayer();
        setBackground(Color.RED);
    }



}
