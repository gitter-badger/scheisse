package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.Inventory;

/**
 * Created by dedda on 3/12/15.
 */
public class InventoryContainer extends EntityContainer {

    public InventoryContainer(Inventory inventory) {
        super(EntityType.INVENTORY, inventory);
    }
}
