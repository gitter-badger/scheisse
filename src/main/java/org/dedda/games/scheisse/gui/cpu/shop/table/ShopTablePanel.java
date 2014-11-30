package org.dedda.games.scheisse.gui.cpu.shop.table;

import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.shop.ShopConnector;

import javax.swing.*;

/**
 * Created by dedda on 11/30/14.
 */
public class ShopTablePanel extends JPanel {

    private ShopConnector shop;
    private Inventory inventory;
    private Player player;

    public ShopTablePanel(final TabbedGamePane tabbedGamePane) {
        player = tabbedGamePane.getGui().getGame().getPlayer();
        inventory = player.getInventory();
        shop = new ShopConnector();
    }

    public void refresh() {

    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public ShopConnector getShop() {
        return shop;
    }

    public void setShop(ShopConnector shop) {
        this.shop = shop;
    }
}
