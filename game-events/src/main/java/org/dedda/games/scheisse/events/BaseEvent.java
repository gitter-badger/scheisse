package org.dedda.games.scheisse.events;

/**
 * Created by dedda on 7/27/15.
 *
 * @author dedda
 */
public abstract class BaseEvent {

    public static final int CODE_GENERAL = 0;

    private final int code;
    private final Object otherData;

    public BaseEvent(final int code, final Object otherData) {
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
