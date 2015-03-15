package org.dedda.games.scheisse_server.transport;

import org.dedda.games.scheisse.entity.Slot;

public class SlotContainer {

    public final long id;
    public final long amount;
    public final ItemContainer item;

    public SlotContainer(final long id, final long amount, final ItemContainer item) {
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
