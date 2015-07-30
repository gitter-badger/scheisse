package org.dedda.games.scheisse.events.item;

import org.dedda.games.scheisse.events.BaseEvent;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class ItemStoreEvent extends BaseEvent {

    public static final int CODE_ITEM_REGISTERED = 1;
    public static final int CODE_ITEM_UNREGISTERED = 2;

    public ItemStoreEvent(final int code, final Object otherData) {
        super(code, otherData);
    }
}
