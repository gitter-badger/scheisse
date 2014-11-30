package org.dedda.games.scheisse.gui.shop;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;

import javax.swing.JPanel;

/**
 * Panel that is shown when the shop is opened.
 *
 * This panel contains the shop interface in the game. Here the user is able to
 * buy and sell stuff and do other things related to the game shop.
 *
 * Created by dedda on 10/7/14.
 *
 * @author dedda
 */
public class ShopPanel extends JPanel {

    /**
     * {@link TabbedGamePane} instance this panel belongs to.
     */
    private TabbedGamePane tabbedGamePane;

    /**
     * Constructor for {@link ShopPanel}s with given {@link TabbedGamePane}.
     *
     * @param tabbedGamePane {@link TabbedGamePane} instance this
     *                       panel belongs to.
     */
    public ShopPanel(final TabbedGamePane tabbedGamePane) {
        this.tabbedGamePane = tabbedGamePane;
    }

}
