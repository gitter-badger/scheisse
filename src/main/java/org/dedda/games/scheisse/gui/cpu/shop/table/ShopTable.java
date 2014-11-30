package org.dedda.games.scheisse.gui.cpu.shop.table;

import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTable;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.shop.Shop;

import javax.swing.*;
import javax.swing.text.PlainDocument;

/**
 * Created by dedda on 11/30/14.
 */
public class ShopTable extends InventoryTable {

    private Shop shop;
    private Inventory inventory;
    private Player player;
    private JTable table;

    public ShopTable(final ShopTablePanel panel) {
        super(panel.getInventory());
        this.shop = panel.getShop();
        this.inventory = panel.getInventory();
        this.player = panel.getPlayer();
    }



}
