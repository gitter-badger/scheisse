package org.dedda.games.scheisse_server.transport;

import org.dedda.games.scheisse_server.entity.Slot;

public class SlotContainer {

    public final long id;
    public final long amount;
    public final ItemContainer item;

    public SlotContainer(long id, long amount, ItemContainer item) {
        this.id = id;
        this.amount = amount;
        this.item = item;
    }

    public SlotContainer(final Slot slot) {
        this.id = slot.getId();
        this.amount = slot.getAmount();
        this.item = new ItemContainer(slot.getItem());
    }
}
