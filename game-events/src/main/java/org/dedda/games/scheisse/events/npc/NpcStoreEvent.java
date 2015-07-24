package org.dedda.games.scheisse.events.npc;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class NpcStoreEvent {

    public static final int CODE_GENERAL = 0;
    public static final int CODE_NPC_CREATED = 1;
    public static final int CODE_NPC_REVIVED = 2;
    public static final int CODE_NPC_DIED = 3;

    private final int code;
    private final Object otherData;

    public NpcStoreEvent(int code, Object otherData) {
        this.code = code;
        this.otherData = otherData;
    }

    public Object getOtherData() {
        return otherData;
    }

    public int getCode() {
        return code;
    }
}
