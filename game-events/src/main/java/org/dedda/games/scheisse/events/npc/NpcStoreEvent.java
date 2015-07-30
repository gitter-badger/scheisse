package org.dedda.games.scheisse.events.npc;

import org.dedda.games.scheisse.events.BaseEvent;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class NpcStoreEvent extends BaseEvent {

    public static final int CODE_NPC_CREATED = 1;
    public static final int CODE_NPC_REVIVED = 2;
    public static final int CODE_NPC_DIED = 3;
    public static final int CODE_NPC_REGISTERED = 4;
    public static final int CODE_NPC_UNREGISTERED = 5;

    public NpcStoreEvent(final int code, final Object otherData) {
        super(code, otherData);
    }
}
