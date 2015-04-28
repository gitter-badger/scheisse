package org.dedda.games.scheisse.state.game.map;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Created by dedda on 4/18/14.
 */
public class MapObject {

    protected Point location;
    protected Dimension size;

    public MapObject(final Point location, final Dimension size) {
        this.location = location;
        this.size = size;
    }

    /**
     * @return Point - location on the map
     */
    public Point getLocation() {
        return location;
    }

    /**
     * @param location Point - location on the map
     */
    public void setLocation(final Point location) {
        this.location = location;
    }

    /**
     * @return Dimension
     */
    public Dimension getSize() {
        return size;
    }

    /**
     * @param size Dimension
     */
    public void setSize(final Dimension size) {
        this.size = size;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof MapObject) {
            MapObject mapObject = (MapObject) object;
            return mapObject.location.equals(this.location)
                && mapObject.size.equals(this.size);
        }
        return false;
    }

}
