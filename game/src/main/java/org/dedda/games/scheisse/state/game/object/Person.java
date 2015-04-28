package org.dedda.games.scheisse.state.game.object;

import org.dedda.games.scheisse.state.game.fight.Attack;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * Created by dedda on 4/18/14.
 */
public abstract class Person {

    protected long experience;
    protected String name;
    protected Point map;
    protected Point2D.Double location;

    public abstract void attack(Person person);

    public abstract void getAttacked(Attack attack);

    public Point2D.Double getLocation() {
        return location;
    }

    public void setLocation(final Point2D.Double location) {
        this.location = location;
    }

    public Point getMap() {
        return map;
    }

    public void setMap(final Point map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(final long experience) {
        this.experience = experience;
    }


}
