package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.item.Item;

/**
 * Created by dedda on 3/12/15.
 */
public class ItemContainer extends EntityContainer{

    public ItemContainer(Item item) {
        super(EntityType.ITEM, item);
    }

}
