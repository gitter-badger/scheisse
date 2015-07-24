package org.dedda.games.scheisse.events;

/**
 * Created by dedda on 7/23/15.
 *
 * @author dedda
 */
public class GameCommonEvent {

    public static final int CODE_GENERAL = 0;
    public static final int CODE_NEW_GAME_STARTED = 1;
    public static final int CODE_GAME_LOADED = 2;
    public static final int CODE_GAME_PAUSED = 3;
    public static final int CODE_GAME_RESUMED = 4;
    public static final int CODE_GAME_STOPPED = 5;

    private final int code;
    private final Object otherData;

    public GameCommonEvent(final int code, final Object otherData) {
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
