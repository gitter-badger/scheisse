package org.dedda.games.scheisse.gui.cpu.shop.table;

import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.shop.Offer;
import org.dedda.games.scheisse.state.game.shop.Shop;
import org.dedda.games.scheisse.state.game.shop.filter.ShopFilter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 11/30/14.
 */
public class ShopTable extends JScrollPane {

    private Shop shop;
    private Inventory inventory;
    private Player player;
    private JTable table;
    private List<Offer> offers;
    private List<ShopFilter> shopFilters;
    private ShopTableModel model;

    public ShopTable(final ShopTablePanel panel) {
        this.inventory = panel.getInventory();
        this.shop = panel.getShop();
        this.inventory = panel.getInventory();
        this.player = panel.getPlayer();
        this.model = new ShopTableModel(this);
        offers = new ArrayList<>();
        shopFilters = new ArrayList<>();
        refresh();
    }

    public void refresh() {
        offers = shop.getOffers(shopFilters);
    }

    public Shop getShop() {
        return shop;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public List<ShopFilter> getShopFilters() {
        return shopFilters;
    }
}
