package org.dedda.games.scheisse.state.game.object;

import java.awt.geom.Point2D;

/**
 * Created by dedda on 4/18/14.
 */
public abstract class GameObject {

    //location on the map:
    protected Point2D.Double location;

    protected GameObject(final Point2D.Double location) {
        this.location = location;
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
            GameObject gameObject = (GameObject) object;
            return (gameObject.location.equals(this.location));
        }
        return false;
    }

    public int compareTo(final GameObject gameObject) {
        return 0;
    }

}
