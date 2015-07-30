package org.dedda.games.scheisse.events.user;

import org.dedda.games.scheisse.events.BaseEvent;

/**
 * Created by dedda on 7/27/15.
 *
 * @author dedda
 */
public class UserStoreEvent extends BaseEvent {

    public static final int CODE_USER_LOGGED_IN = 1;
    public static final int CODE_USER_LOGGED_OUT = 2;
    public static final int CODE_USER_REGISTERED = 3;
    public static final int CODE_USER_UNREGISTERED = 4;
    public static final int CODE_USER_CREATED = 5;

    public UserStoreEvent(final int code, final Object otherData) {
        super(code, otherData);
    }
}
