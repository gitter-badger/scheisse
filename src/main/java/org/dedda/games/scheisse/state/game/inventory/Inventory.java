package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.state.game.item.Item;

import java.util.ArrayList;

/**
 * Created by dedda on 4/18/14.
 */
public class Inventory {

    private ArrayList<Slot> slots = new ArrayList<Slot>();
    private ArrayList<InventoryChangeListener> inventoryChangeListeners = new ArrayList<InventoryChangeListener>();

    public Inventory() {
        for (int i = 0; i < 20; i++) {
            slots.add(new Slot(this));
        }
    }

    /**
     *
     * @param size int
     */
    public Inventory(final int size) {
        for (int i = 0; i < size; i++) {
            slots.add(new Slot(this));
        }
    }

    public void triggerChangeEvent() {
        for(InventoryChangeListener inventoryChangeListener : inventoryChangeListeners){
            inventoryChangeListener.inventoryChangeAction();
        }
    }

    public void addItems(final Item item, final long amount) {
        Slot slot = getSlotWithItemId(item.getId());
        if (slot == null) {
            slot = new Slot(item.getId(), this);
            addSlot(slot);
        }
        slot.setNumberOfItems(slot.getNumberOfItems() + amount);
        triggerChangeEvent();
    }

    public void removeItems(final Item item, final long amount) {
        Slot slot = getSlotWithItemId(item.getId());
        if (slot != null) {
            slot.setNumberOfItems(slot.getNumberOfItems() - amount);
            if (slot.getNumberOfItems() <= 0) {
                slots.remove(slot);
            }
        }
        triggerChangeEvent();
    }

    public void removeItems(final long id, final long amount) {
        removeItems(Item.forId(id), amount);
    }

    public void addItems (final long id, final long amount) {
        addItems(Item.forId(id), amount);
    }

    /**
     *
     * @return int
     */
    public int getSize() {
        return slots.size();
    }

    /**
     *
     * @param size int
     */
    public void setSize(final int size) {
        if (size > slots.size()) {
            for (int i = slots.size(); i < size; i++) {
                slots.add(new Slot(this));
            }
        } else if (size < slots.size()) {
            for (int i = slots.size(); i >= size; i--) {
                slots.remove(i-1);
            }
        }
        triggerChangeEvent();
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(final ArrayList<Slot> slots) {
        this.slots = slots;
        triggerChangeEvent();
    }

    public void setSlot(final int index, final Slot slot) {
        this.slots.set(index, slot);
        triggerChangeEvent();
    }

    public void addSlot(final Slot slot) {
        this.slots.add(slot);
        triggerChangeEvent();
    }

    public void print() {
        SystemPrinter.debugln("Inventory:");
        SystemPrinter.debugln("size: " + slots.size());
        for (Slot slot : slots) {
            SystemPrinter.debugln(slot.getDummy().getName() + ": " + slot.getNumberOfItems());
        }
    }

    public boolean containsSlotWithItemId(final long id) {
        for (Slot slot : slots) {
            if (slot.getDummy().getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Slot getSlotWithItemId(final long id) {
        for (Slot slot : slots) {
            Item dummy = slot.getDummy();
            if (dummy.getId() == id) {
                return slot;
            }
        }
        return null;
    }

    public void addInventoryChangeListener(final InventoryChangeListener listener) {
        inventoryChangeListeners.add(listener);
    }

    public void removeInventoryChangeListener(final InventoryChangeListener listener) {
        if (inventoryChangeListeners.contains(listener)) {
            inventoryChangeListeners.remove(listener);
        }
    }

    public ArrayList<InventoryChangeListener> getInventoryChangeListeners() {
        return inventoryChangeListeners;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Inventory) {
            Inventory inventory = (Inventory)object;
            return inventory.slots.equals(this.slots);
        }
        return false;
    }

}
