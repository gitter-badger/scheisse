package org.dedda.games.scheisse.gui.cpu.inventory;

/**
 * Created by dedda on 11/30/14.
 */
public abstract class InventoryTransactionEvent {

    public static final int GENERAL = 0;
    public static final int FINANCIAL = 1;
    public static final int ITEM_ONLY = 2;

    public abstract int getEventType();

}
