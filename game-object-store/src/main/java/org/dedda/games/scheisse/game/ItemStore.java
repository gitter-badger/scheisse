package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;

import static org.dedda.games.scheisse.events.item.ItemStoreEvent.CODE_ITEM_REGISTERED;
import static org.dedda.games.scheisse.events.item.ItemStoreEvent.CODE_ITEM_UNREGISTERED;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
public class ItemStore extends BasicStore<Item> {

    @Override
    protected void registerEvent(final long key, final Item object) {
        GameSession.getInstance().itemStoreEvent(new ItemStoreEvent(CODE_ITEM_REGISTERED, object));
    }

    @Override
    protected void unregisterEvent(final long key, final Item object) {
        GameSession.getInstance().itemStoreEvent(new ItemStoreEvent(CODE_ITEM_UNREGISTERED, object));
    }

}
