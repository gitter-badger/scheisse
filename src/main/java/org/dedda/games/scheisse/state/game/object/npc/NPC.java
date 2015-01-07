package org.dedda.games.scheisse.state.game.object.npc;

import org.dedda.games.scheisse.state.game.object.GameObject;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by dedda on 7/20/14.
 */
public class NPC extends GameObject {

    protected double maxSpeed;
    protected boolean evil;
    protected double direction = 0;
    protected String name = "unnamed";

    public NPC(final Point2D.Double location) {
        super(location);
    }

    public NPC(final Point2D.Double location, final double maxSpeed, final boolean evil) {
        super(location);
        this.maxSpeed = maxSpeed;
    }

    public boolean canMove(final double direction, final double amount) {

        return true;
    }

    public void move(final double amount) {
        location.x += Math.cos(direction) * amount;
        location.y += Math.sin(direction) * amount;
    }

    public void rotate(final double angle) {
        direction += angle;
        direction %= 2 * Math.PI;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(final double direction) {
        this.direction = direction;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(final double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isEvil() {
        return evil;
    }

    public void setEvil(final boolean evil) {
        this.evil = evil;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void render(Graphics2D g2d) {

    }
}
