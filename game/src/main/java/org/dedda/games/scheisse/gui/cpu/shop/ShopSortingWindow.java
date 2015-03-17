package org.dedda.games.scheisse.gui.cpu.shop;

import javax.swing.JFrame;

/**
 * Created by dedda on 12.01.15.
 */
public class ShopSortingWindow extends JFrame {

    private ShopPanel shopPanel;
    private ShopSortingPanel sortingPanel;

    public ShopSortingWindow(final ShopPanel shopPanel) {
        this.shopPanel = shopPanel;
        this.sortingPanel = new ShopSortingPanel(shopPanel);
    }
}
