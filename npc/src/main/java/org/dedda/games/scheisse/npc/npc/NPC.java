package org.dedda.games.scheisse.npc.npc;

import org.dedda.games.scheisse.fight.Attack;
import org.dedda.games.scheisse.npc.Person;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * Created by dedda on 7/20/14.
 */
public class NPC extends Person {

    protected long id;
    protected double maxSpeed;
    protected boolean evil;
    protected double direction = 0;
    protected String name = "unnamed";

    public NPC(final Point2D.Double location) {
        setLocation(location);
    }

    public NPC(
        final long id,
        final Point2D.Double location,
        final double maxSpeed,
        final boolean evil
    ) {
        setId(id);
        setLocation(location);
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

    @Override
    public void attack(final Person person) {

    }

    @Override
    public void getAttacked(final Attack attack) {

    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
