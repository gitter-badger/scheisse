package org.dedda.games.scheisse.gui.cpu.inventory;

import org.dedda.games.scheisse.gui.cpu.inventory.table.InventoryTableModel;
import org.dedda.games.scheisse.state.game.Player;
import org.dedda.games.scheisse.state.game.inventory.Inventory;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 02.12.14.
 */
public class HeaderBar
        extends JPanel
        implements  InventoryTransactionListener,
                    ChangeListener {

    private Player player;
    private Inventory inventory;
    private List<CategoriesChangeListener> changeListeners;
    private List<JCheckBox> checkBoxes;

    public HeaderBar(final Player player) {
        this.player = player;
        this.inventory = player.getInventory();
        this.changeListeners = new ArrayList<>();
        this.checkBoxes = new ArrayList<>();
        for (int i = 0; i < InventoryTableModel.CATEGORIES.length; i++) {
            JCheckBox checkBox = new JCheckBox(InventoryTableModel.HEADERS[i]);
            checkBox.addChangeListener(this);
            checkBoxes.add(checkBox);
        }
    }

    public void addCategoriesChangeListener(
            final CategoriesChangeListener listener
    ) {
        this.changeListeners.add(listener);
    }

    public void removeCategoriesChangeListener(
            final CategoriesChangeListener listener
    ) {
        if (this.changeListeners.contains(listener)) {
            this.changeListeners.remove(listener);
        }
    }

    private void categoryAdded(final int category) {
        categoriesChanged(new CategoriesChangedEvent(category, -1));
    }

    private void categoryRemoved(final int category) {
        categoriesChanged(new CategoriesChangedEvent(-1, category));
    }

    private void categoriesChanged(final CategoriesChangedEvent event) {
        for (CategoriesChangeListener listener : changeListeners) {
            listener.categoriesChanged(event);
        }
    }

    public void transactionPerformed(final InventoryTransactionEvent event) {

    }

    public void stateChanged(final ChangeEvent changeEvent) {
        if (changeEvent.getSource() instanceof JCheckBox) {
            JCheckBox source = (JCheckBox) changeEvent.getSource();

        }
    }
}
