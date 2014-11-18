package org.dedda.games.scheisse.state.game.object;

import org.dedda.games.scheisse.gui.Drawable;
import org.dedda.games.scheisse.gui.game.object.GameGuiObject;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * Created by dedda on 4/18/14.
 */
public abstract class GameObject implements Drawable {

    //location on the map:
    protected Point2D.Double location;
    //object for rendering:
    protected GameGuiObject guiObject;

    protected GameObject(final Point2D.Double location, final GameGuiObject guiObject) {
        this.location = location;
        this.guiObject = guiObject;
    }

    /**
     *
     * @return Point2D.Double - location on the map
     */
    public Point2D.Double getLocation() {
        return location;
    }

    /**
     *
     * @param location Point2D.Double - location on the map
     */
    public void setLocation(final Point2D.Double location) {
        this.location = location;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof GameObject) {
            GameObject gameObject = (GameObject)object;
            return (gameObject.location.equals(this.location));
        }
        return false;
    }

    public void render(final Graphics2D g2d) {
        guiObject.render(g2d);
    }

    public int compareTo(final GameObject gameObject) {
        return 0;
    }

}
