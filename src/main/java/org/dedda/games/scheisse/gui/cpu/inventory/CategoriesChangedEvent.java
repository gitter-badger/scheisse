package org.dedda.games.scheisse.gui.cpu.inventory;

/**
 * Created by dedda on 02.12.14.
 */
public class CategoriesChangedEvent {

    public final int ADDED;
    public final int REMOVED;

    public CategoriesChangedEvent(final int ADDED, final int REMOVED) {
        this.ADDED = ADDED;
        this.REMOVED = REMOVED;
    }
}
