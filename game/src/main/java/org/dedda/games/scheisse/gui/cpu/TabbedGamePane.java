package org.dedda.games.scheisse.gui.cpu;

import org.dedda.games.scheisse.gui.cpu.inventory.InventoryPanel;
import org.dedda.games.scheisse.gui.cpu.shop.ShopPanel;
import org.dedda.games.scheisse.state.game.Game;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by dedda on 10/5/14.
 */
public class TabbedGamePane extends JTabbedPane implements ChangeListener {

    private ContentContainer contentContainer;
    private Gui gui;
    private Game game;
    private GamePanel gamePanel;
    private InventoryPanel inventoryPanel;
    private ShopPanel shopPanel;
    private int lastTab;

    public TabbedGamePane(final ContentContainer contentContainer) {
        lastTab = 0;
        this.contentContainer = contentContainer;
        this.gui = contentContainer.getGui();
        this.game = this.gui.getGame();
        this.gamePanel = new GamePanel(this);
        this.inventoryPanel = new InventoryPanel(this);
        this.shopPanel = new ShopPanel(this);
        addTab("Game", this.gamePanel);
        addTab("Inventory", this.inventoryPanel);
        addTab("Shop", this.shopPanel);
        addChangeListener(this);
        setSelectedIndex(2);
    }

    public Gui getGui() {
        return gui;
    }

    public void stateChanged(final ChangeEvent changeEvent) {
        int index = getSelectedIndex();
        if (lastTab == 1 && index != 1) {
            inventoryPanel.cancelTransaction();
        } else if (lastTab == 2 && index != 2) {
            shopPanel.cancelTransaction();
        }
        lastTab = index;
    }
}
