package org.dedda.games.scheisse.gui.io.action;

/**
 * Created by dedda on 5/7/14.
 */
public class MouseActionInfo {

    private final int button;
    private final int scrollAmount;
    private final int locationX;
    private final int locationY;

    public MouseActionInfo(
            final int button,
            final int scrollAmount,
            final int locationX,
            final int locationY) {
        this.button = button;
        this.scrollAmount = scrollAmount;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public int getButton() {
        return button;
    }

    public int getScrollAmount() {
        return scrollAmount;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof MouseActionInfo) {
            MouseActionInfo mai = (MouseActionInfo)object;
            return mai.locationY == this.locationY
                    && mai.locationX == this.locationX
                    && mai.button == this.button
                    && mai.scrollAmount == this.scrollAmount;
        }
        return false;
    }

}
