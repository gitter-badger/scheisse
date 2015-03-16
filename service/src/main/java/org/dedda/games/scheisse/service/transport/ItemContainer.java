package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 3/12/15.
 */
public class ItemContainer extends EntityContainer{

    public ItemContainer(final Item item) {
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

    public static Item convertBack(final ItemContainer container) {
        Item item = (Item) container.getEntity();
        return item;
    }

    public static List<Item> convertBack(final List<ItemContainer> containers) {
        List<Item> items = new ArrayList<>(containers.size());
        for (ItemContainer container : containers) {
            items.add(convertBack(container));
        }
        return items;
    }

    @Override
    public boolean equals(final Object o) {
        if (null == o) {
            return false;
        }
        if (o.getClass() != ItemContainer.class) {
            return false;
        }
        ItemContainer other = (ItemContainer) o;
        if (!getEntity().equals(other.getEntity())) {
            return false;
        }
        return true;
    }

}
