package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTable;
import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableModel;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 02.12.14.
 */
public class HeaderBar extends JPanel implements InventoryTransactionListener, ChangeListener {

    private Player player;
    private Inventory inventory;
    private List<CategoriesChangeListener> changeListeners;
    private List<JCheckBox> checkBoxes;

    public HeaderBar(Player player) {
        this.player = player;
        this.inventory = player.getInventory();
        this.changeListeners = new ArrayList<CategoriesChangeListener>();
        this.checkBoxes = new ArrayList<JCheckBox>();
        for (int i = 0; i < InventoryTableModel.CATEGORIES.length; i++) {
            JCheckBox checkBox = new JCheckBox(InventoryTableModel.HEADERS[i]);
            checkBox.addChangeListener(this);
            checkBoxes.add(checkBox);
        }
    }

    public void addCategoriesChangeListener(CategoriesChangeListener listener) {
        this.changeListeners.add(listener);
    }

    public void removeCategoriesChangeListener(CategoriesChangeListener listener) {
        if (this.changeListeners.contains(listener)) {
            this.changeListeners.remove(listener);
        }
    }

    private void categoryAdded(int category) {
        categoriesChanged(new CategoriesChangedEvent(category, -1));
    }

    private void categoryRemoved(int category) {
        categoriesChanged(new CategoriesChangedEvent(-1, category));
    }

    private void categoriesChanged(CategoriesChangedEvent event) {
        for (CategoriesChangeListener listener : changeListeners) {
            listener.categoriesChanged(event);
        }
    }

    public void transactionPerformed(InventoryTransactionEvent event) {

    }

    public void stateChanged(ChangeEvent changeEvent) {
        if (changeEvent.getSource() instanceof JCheckBox) {
            JCheckBox source = (JCheckBox)changeEvent.getSource();

        }
    }
}
