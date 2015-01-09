package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.NullItem;

/**
 * Created by dedda on 4/18/14.
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
     *
     * @param itemId Id of the item
     */
    public Slot(final long itemId, final Inventory inventory) {
        this.dummy = Item.forId(itemId);
        this.inventory = inventory;
    }

    /**
     *
     * @return is there any space left in here?
     */
    public boolean canAdd() {
        return numberOfItems < dummy.maxStackNumber();
    }

    /**
     *
     * @param item Item
     */
    public void add (final Item item) {
        if (item.getClass().equals(dummy.getClass())) {
            if (canAdd()) {
                numberOfItems++;
            }
        }
        inventory.triggerChangeEvent();
    }

    /**
     * removes one from the item counter
     */
    public void remove() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }
        inventory.triggerChangeEvent();
    }

    /**
     *
     * @param dummy Item
     */
    public void setDummy(final Item dummy) {
        this.dummy = dummy;
        inventory.triggerChangeEvent();
    }

    /**
     *
     * @return Item
     */
    public Item getDummy() {
        return dummy;
    }

    /**
     *
     * @return int
     */
    public long getNumberOfItems() {
        return numberOfItems;
    }

    /**
     *
     * @param numberOfItems int
     */
    public void setNumberOfItems(final long numberOfItems) {
        this.numberOfItems = numberOfItems;
        inventory.triggerChangeEvent();
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Slot) {
            Slot slot = (Slot)object;
            return slot.dummy.equals(this.dummy)
                    && slot.numberOfItems == this.numberOfItems;
        }
        return false;
    }

}
