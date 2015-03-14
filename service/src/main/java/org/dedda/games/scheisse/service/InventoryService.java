package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.service.transport.InventoryContainer;

import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public interface InventoryService {

    public InventoryContainer get(final UUID session);

    public void addItem(final long id, final long amount, final UUID session);

    public void removeItem(final long id, final long amount, final UUID session);

}
