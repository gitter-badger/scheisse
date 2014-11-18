package org.dedda.games.scheisse.state.game.map.building;

import org.dedda.games.scheisse.state.game.Direction;
import org.dedda.games.scheisse.state.game.Player;

import java.awt.*;

/**
 * Created by dedda on 9/15/14.
 */
public class Door {

    private Point location;
    private Dimension size;
    private Direction passingDirection[];
    private boolean locked;

    public Door(Point location, Dimension size, Direction[] passingDirection, boolean locked) {
        this.location = location;
        this.size = size;
        this.passingDirection = passingDirection;
        this.locked = locked;
    }

    public boolean canPass(Direction direction, Player player){
        for(Direction dir : passingDirection){
            if(dir.equals(direction)){
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