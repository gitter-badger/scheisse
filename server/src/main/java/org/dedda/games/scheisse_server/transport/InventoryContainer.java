package org.dedda.games.scheisse_server.transport;

import org.dedda.games.scheisse.entity.Inventory;

/**
 * Created by dedda on 2/9/15.
 */
public class InventoryContainer {

    public final long id;
    public final long size;
    public final long userId;
    public final SlotContainer[] slots;

    public InventoryContainer(long id, long size, long userId, SlotContainer[] slots) {
        this.id = id;
        this.size = size;
        this.userId = userId;
        this.slots = slots;
    }

    public InventoryContainer(final Inventory inventory) {
        this.id = inventory.getId();
        this.size = inventory.getSize();
        this.userId = inventory.getUser().getId();
        this.slots = new SlotContainer[inventory.getSlots().size()];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new SlotContainer(inventory.getSlots().get(i));
        }
    }
}
