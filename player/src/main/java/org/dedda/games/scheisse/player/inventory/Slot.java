package org.dedda.games.scheisse.player.inventory;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemStore;
import org.dedda.games.scheisse.entity.item.NullItem;

/**
 * Created by dedda on 4/18/14.
 *
 * @author dedda
 */
public class Slot {

    private Inventory inventory;
    private long numberOfItems = 0;
    private Item dummy;

    public Slot(final Inventory inventory) {
        this.inventory = inventory;
        dummy = new NullItem();
    }

    /**
     * @param itemId Id of the item.
     */
    public Slot(final long itemId, final Inventory inventory) {
        this.dummy = ItemStore.forId(itemId);
        this.inventory = inventory;
    }

    /**
     * @return is there any space left in here?
     */
    public final boolean canAdd() {
        return numberOfItems < dummy.maxStackNumber();
    }

    /**
     * @param item org.dedda.games.scheisse.entity.item.Item
     */
    public final void add(final Item item) {
        if (item.getClass().equals(dummy.getClass())) {
            if (canAdd()) {
                numberOfItems++;
            }
        }
        inventory.triggerChangeEvent();
    }

    /**
     * removes one from the item counter.
     */
    public final void remove() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }
        inventory.triggerChangeEvent();
    }

    /**
     * @param dummy org.dedda.games.scheisse.entity.item.Item
     */
    public final void setDummy(final Item dummy) {
        this.dummy = dummy;
        inventory.triggerChangeEvent();
    }

    /**
     * @return org.dedda.games.scheisse.entity.item.Item
     */
    public final Item getDummy() {
        return dummy;
    }

    /**
     * @return int
     */
    public final long getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * @param numberOfItems int
     */
    public final void setNumberOfItems(final long numberOfItems) {
        this.numberOfItems = numberOfItems;
        inventory.triggerChangeEvent();
    }

    @Override
    public final boolean equals(final Object object) {
        if (object instanceof Slot) {
            Slot slot = (Slot) object;
            return slot.dummy.equals(this.dummy)
                && slot.numberOfItems == this.numberOfItems;
        }
        return false;
    }

}
