package org.dedda.games.scheisse.tool;

import java.awt.geom.Point2D;

/**
 * Class for calculating distances and directions / angles between points.
 * <p/>
 * Created by dedda on 10/4/14.
 *
 * @author dedda
 */
public final class Distances {

    private Distances() {

    }

    /**
     * Calculates the angle between two {@link java.awt.geom.Point2D.Double}s.
     *
     * @param start       Start {@link java.awt.geom.Point2D.Double}
     * @param destination Destination {@link java.awt.geom.Point2D.Double}
     * @return Angle between start and destination
     */
    public static double getDirectionTo(
        final Point2D.Double start,
        final Point2D.Double destination) {
        double dy = destination.getY() - start.getY();
        double distance = getDistanceTo(start, destination);
        return Math.asin(dy / distance);
    }

    /**
     * Calculates the distance between two {@link java.awt.geom.Point2D.Double}s.
     *
     * @param start       Start {@link java.awt.geom.Point2D.Double}
     * @param destination Destination {@link java.awt.geom.Point2D.Double}
     * @return Distance between start and destination
     */
    public static double getDistanceTo(
        final Point2D.Double start,
        final Point2D.Double destination) {
        double dx = destination.getX() - start.getX();
        double dy = destination.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

}
