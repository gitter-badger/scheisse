package org.dedda.games.scheisse.gui.io.action;

/**
 * Created by dedda on 5/7/14.
 */
public class KeyActionInfo {

    private final int keyCode;

    public KeyActionInfo(final int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return keyCode;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof KeyActionInfo) {
            KeyActionInfo kai = (KeyActionInfo)object;
            return kai.keyCode == this.keyCode;
        }
        return false;
    }
}
