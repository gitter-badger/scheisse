package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.service.InventoryService;
import org.dedda.games.scheisse.service.transport.InventoryContainer;

import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public class InventoryServiceHost implements InventoryService {

    @Override
    public InventoryContainer get(UUID session) {
        return null;
    }

    @Override
    public void addItem(long id, long amount, UUID session) {

    }

    @Override
    public void removeItem(long id, long amount, UUID session) {

    }
}
