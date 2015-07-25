package org.dedda.games.scheisse.events.item;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class ItemStoreEvent {

    public static final int CODE_GENERAL = 0;
    public static final int CODE_ITEM_REGISTERED = 1;
    public static final int CODE_ITEM_UNREGISTERED = 2;

    private final int code;
    private final Object otherData;

    public ItemStoreEvent(final int code, final Object otherData) {
        this.code = code;
        this.otherData = otherData;
    }

    public int getCode() {
        return code;
    }

    public Object getOtherData() {
        return otherData;
    }
}
