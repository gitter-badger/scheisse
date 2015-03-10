package org.dedda.games.scheisse.gui.cpu.shop.table;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.shop.Shop;
import org.dedda.games.scheisse.state.game.shop.ShopConnector;

import javax.swing.*;

/**
 * Created by dedda on 11/30/14.
 */
public class ShopTablePanel extends JPanel {

    private Shop shop;
    private Inventory inventory;
    private Player player;

    public ShopTablePanel(final TabbedGamePane tabbedGamePane) {
        player = tabbedGamePane.getGui().getGame().getPlayer();
        inventory = player.getInventory();
        shop = new Shop();
    }

    public void refresh() {

    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
