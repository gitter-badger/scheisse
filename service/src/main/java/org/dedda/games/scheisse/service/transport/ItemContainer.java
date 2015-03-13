package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 3/12/15.
 */
public class ItemContainer extends EntityContainer{

    public ItemContainer(Item item) {
        super(EntityType.ITEM, item);
    }

    public static ItemContainer convert(final Item item) {
        return new ItemContainer(item);
    }

    public static List<ItemContainer> convert(final List<Item> items) {
        List<ItemContainer> containers = new ArrayList<>(items.size());
        for (Item item : items) {
            containers.add(convert(item));
        }
        return containers;
    }

}
