package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.service.transport.InventoryContainer;

import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public interface InventoryService {

    /**
     * @param session session key to get inventory for
     * @return {@link org.dedda.games.scheisse.service.transport.InventoryContainer}
     *          containing the inventory
     */
    public InventoryContainer get(final UUID session);

    /**
     * @param id id of the {@link org.dedda.games.scheisse.entity.item.Item}
     *           to add
     * @param amount amount of items to add
     * @param session session key of logged in user to give the items
     */
    public void addItem(final long id, final long amount, final UUID session);

    /**
     * @param id id of the {@link org.dedda.games.scheisse.entity.item.Item}
     *           to remove
     * @param amount amount of items to remove
     * @param session session key of the logged in user
     * @return amount of actually removed items
     */
    public long removeItem(final long id, final long amount, final UUID session);

}
