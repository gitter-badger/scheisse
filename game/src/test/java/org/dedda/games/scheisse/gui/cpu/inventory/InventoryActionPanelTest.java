package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.ContentContainer;
import org.dedda.games.scheisse.gui.cpu.Gui;
import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableModel;
import org.dedda.games.scheisse.io.resource.Resource;
import org.dedda.games.scheisse.io.resource.item.ItemLoader;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.inventory.Slot;
import org.dedda.games.scheisse.state.game.item.Item;
import org.junit.Before;
import org.junit.Test;

import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InventoryActionPanelTest {

    private InventoryActionPanel panel;
    private Inventory inventory;
    private InventoryTablePanel inventoryTablePanel;
    private Player player;

    @Before
    public void setUp() throws Exception {
        new ItemLoader().loadAll(new File(Resource.ITEM_FOLDER));
        inventory = new Inventory();
        inventory.getSlots().clear();
        Slot slot = new Slot(1L, inventory);
        slot.setNumberOfItems(10);
        inventory.addSlot(slot);
        slot = new Slot(2L, inventory);
        slot.setNumberOfItems(12);
        inventory.addSlot(slot);
        slot = new Slot(3L, inventory);
        slot.setNumberOfItems(2);
        inventory.addSlot(slot);
        player = new Player(false);
        player.setInventory(inventory);
        Game game = mock(Game.class);
        when(game.getPlayer()).thenReturn(player);
        Gui gui = mock(Gui.class);
        when(gui.getGame()).thenReturn(game);
        ContentContainer contentContainer = mock(ContentContainer.class);
        when(contentContainer.getGui()).thenReturn(gui);
        TabbedGamePane tabbedGamePane = mock(TabbedGamePane.class);
        when(tabbedGamePane.getGui()).thenReturn(gui);
        inventoryTablePanel = new InventoryTablePanel(tabbedGamePane);
        panel = inventoryTablePanel.getActionPanel();
        inventoryTablePanel.getInventoryTable().getModel().enableCategory(
            InventoryTableModel.ID
        );
    }

    @Test
    public void testInitialization() {
        assertEquals(
            inventory,
            inventoryTablePanel.getInventoryTable().getInventory()
        );
        assertEquals(
            inventory,
            panel.
                getInventoryTablePanel().
                getInventoryTable().
                getInventory()
        );
        assertEquals(inventory.getSlots().get(0).getDummy(), Item.forId(1));
        assertEquals(inventory.getSlots().get(1).getDummy(), Item.forId(2));
        assertEquals(inventory.getSlots().get(2).getDummy(), Item.forId(3));
        assertEquals(inventory.getSlots().get(0).getNumberOfItems(), 10);
        assertEquals(inventory.getSlots().get(1).getNumberOfItems(), 12);
        assertEquals(inventory.getSlots().get(2).getNumberOfItems(), 2);
    }

    @Test
    public void testAdd() {
        ListSelectionModel selectionModel =
            inventoryTablePanel.
                getInventoryTable().
                getTable().
                getSelectionModel();
        selectionModel.clearSelection();
        selectionModel.addSelectionInterval(0, 0);
        selectionModel.addSelectionInterval(2, 2);
        SpinnerNumberModel spinnerModel =
            (SpinnerNumberModel) panel.
                getNumberSpinner().
                getModel();
        assertEquals(spinnerModel.getMaximum(), 2.0);
        spinnerModel.setValue(1.0);
        for (ActionListener actionListener :
            panel.
                getAddButton().
                getActionListeners()) {
            actionListener.actionPerformed(null);
        }
        assertEquals(inventory.getSlotWithItemId(1).getNumberOfItems(), 9);
        assertEquals(inventory.getSlotWithItemId(3).getNumberOfItems(), 1);
        Inventory actionInventory =
            inventoryTablePanel.getActionTable().getInventory();
        actionInventory.print();
        assertEquals(
            actionInventory.getSlotWithItemId(1).getNumberOfItems(), 1
        );
        assertEquals(
            actionInventory.getSlotWithItemId(3).getNumberOfItems(), 1
        );

    }

    @Test
    public void testRemove() {
        testAdd();
        ListSelectionModel selectionModel =
            inventoryTablePanel.
                getActionTable().
                getTable().
                getSelectionModel();
        selectionModel.clearSelection();
        selectionModel.addSelectionInterval(0, 0);
        SpinnerNumberModel spinnerModel =
            (SpinnerNumberModel) panel.getNumberSpinner().getModel();
        assertEquals(spinnerModel.getMaximum(), 1.0);
        spinnerModel.setValue(1.0);
        for (ActionListener actionListener :
            panel.
                getRemoveButton().
                getActionListeners()
            ) {
            actionListener.actionPerformed(null);
        }
        assertEquals(inventory.getSlotWithItemId(1).getNumberOfItems(), 10);
        assertEquals(inventory.getSlotWithItemId(3).getNumberOfItems(), 1);
        Inventory actionInventory =
            inventoryTablePanel.getActionTable().getInventory();
        actionInventory.print();
        assertNull(actionInventory.getSlotWithItemId(1));
        assertEquals(
            actionInventory.getSlotWithItemId(3).getNumberOfItems(), 1
        );
    }

    @Test
    public void testOk() {
        testAdd();
        long money = player.getMoney();
        long newMoney = money +
            Item.forId(1).getValue() +
            Item.forId(3).getValue();
        InventoryActionComboBox comboBox = panel.getActionComboBox();
        comboBox.setSelectedItem(InventoryActionComboBox.SELL);
        for (ActionListener actionListener :
            panel.
                getOkButton().
                getActionListeners()
            ) {
            actionListener.actionPerformed(null);
        }
        assertEquals(newMoney, player.getMoney());
        assertEquals(
            inventoryTablePanel.
                getActionTable().
                getInventory().
                getSize(), 0
        );
    }
}
