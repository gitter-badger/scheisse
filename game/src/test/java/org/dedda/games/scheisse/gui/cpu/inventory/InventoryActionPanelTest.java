package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemStore;
import org.dedda.games.scheisse.gui.cpu.ContentContainer;
import org.dedda.games.scheisse.gui.cpu.Gui;
import org.dedda.games.scheisse.gui.cpu.TabbedGamePane;
import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableModel;
import org.dedda.games.scheisse.fsloaders.resource.Resource;
import org.dedda.games.scheisse.fsloaders.resource.item.ItemLoader;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.state.game.Game;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.player.inventory.Slot;
import org.junit.Before;
import org.junit.Test;

import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.io.File;

import static org.dedda.games.scheisse.entity.item.Item.TYPE_ARMOR;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_SHIELD;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_WEAPON;
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
        initItems();
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

    private void initItems() {
        Item testWeapon = new Item();
        testWeapon.setId(1);
        testWeapon.setName("Wooden Sword");
        testWeapon.setPrice(123L);
        testWeapon.setTypes(TYPE_WEAPON);
        testWeapon.setArmor(0);
        testWeapon.setAttack(456L);
        testWeapon.setMaxStackAmount(1);
        testWeapon.setSprite(null);
        ItemStore.put(testWeapon);
        Item testArmor = new Item();
        testArmor.setId(2);
        testArmor.setName("Wooden Armor");
        testArmor.setPrice(654L);
        testArmor.setTypes(TYPE_ARMOR);
        testArmor.setArmor(321L);
        testArmor.setAttack(0);
        testArmor.setMaxStackAmount(1);
        testArmor.setSprite(null);
        ItemStore.put(testArmor);
        Item testShield = new Item();
        testShield.setId(3);
        testShield.setName("Wooden Shield");
        testShield.setPrice(246L);
        testShield.setTypes(TYPE_SHIELD);
        testShield.setArmor(135L);
        testShield.setAttack(0);
        testShield.setMaxStackAmount(1);
        testShield.setSprite(null);
        ItemStore.put(testShield);
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
        assertEquals(inventory.getSlots().get(0).getDummy(), ItemStore.forId(1));
        assertEquals(inventory.getSlots().get(1).getDummy(), ItemStore.forId(2));
        assertEquals(inventory.getSlots().get(2).getDummy(), ItemStore.forId(3));
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
            ItemStore.forId(1).getPrice() +
            ItemStore.forId(3).getPrice();
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
