package org.dedda.games.scheisse.world.building;

import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.tool.Direction;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Created by dedda on 9/15/14.
 *
 * @author dedda
 */
public class Door {

    private Point location;
    private Dimension size;
    private Direction[] passingDirection;
    private boolean locked;

    public Door(
        final Point location,
        final Dimension size,
        final Direction[] passingDirection,
        final boolean locked
    ) {
        this.location = location;
        this.size = size;
        this.passingDirection = passingDirection;
        this.locked = locked;
    }

    public boolean canPass(final Direction direction, final Player player) {
        for (Direction dir : passingDirection) {
            if (dir.equals(direction)) {
                return !locked;
            }
        }
        return false;
    }

    public Point getLocation() {
        return location;
    }

    public Dimension getSize() {
        return size;
    }

    public Direction[] getPassingDirection() {
        return passingDirection;
    }

    public boolean isLocked() {
        return locked;
    }
}
