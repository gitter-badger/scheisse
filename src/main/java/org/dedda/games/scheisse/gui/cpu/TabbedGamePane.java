package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.gui.cpu.inventory.InventoryPanel;
import org.dedda.games.scheisse.state.game.Game;

import javax.swing.JTabbedPane;

/**
 * Created by dedda on 10/5/14.
 */
public class TabbedGamePane extends JTabbedPane {

    private ContentContainer contentContainer;
    private Gui gui;
    private Game game;
    private GamePanel gamePanel;
    private InventoryPanel inventoryPanel;
    private ShopPanel shopPanel;

    public TabbedGamePane(final ContentContainer contentContainer) {
        this.contentContainer = contentContainer;
        this.gui = contentContainer.getGui();
        this.game = this.gui.getGame();
        this.gamePanel = new GamePanel(this);
        this.inventoryPanel = new InventoryPanel(this);
        this.shopPanel = new ShopPanel(this);
        addTab("Game", this.gamePanel);
        addTab("Inventory", this.inventoryPanel);
        addTab("Shop", this.shopPanel);
        setSelectedIndex(1);
    }

    public Gui getGui() {
        return gui;
    }
}
