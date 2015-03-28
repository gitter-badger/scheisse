package org.dedda.games.scheisse.state.game.object.behavior;

import org.dedda.games.scheisse.tool.Distances;

import java.awt.geom.Point2D;

/**
 * Created by dedda on 10/3/14.
 */
public class NPCWalkToDestination extends NPCWalk {

    protected Point2D.Double destination;

    public NPCWalkToDestination(final NPCScript skript) {
        super(skript);
    }

    @Override
    public final boolean hasNextStep() {
        return !(script.getNpc().getLocation().getX() ==
                destination.getX() &&
                script.getNpc().getLocation().getY() ==
                destination.getY());
    }

    @Override
    public final void nextStep() {
        if (hasNextStep()) {
            double npcX = script.getNpc().getLocation().getX();
            double npcY = script.getNpc().getLocation().getY();
            if (
                npcX < destination.getX() + 0.1 && npcX >
                    destination.getX() - 0.1
                ) {
                npcX = destination.getX();
            }
            if (
                npcY < destination.getY() + 0.1 && npcY >
                    destination.getY() - 0.1
                ) {
                npcY = destination.getY();
            }
            script.getNpc().setLocation(new Point2D.Double(npcX, npcY));
            calcRestAmount();
            if (npcX != destination.getX() || npcY != destination.getY()) {
                script.getNpc().setDirection(direction);
                if (maxSpeed >= restAmount) {
                    script.getNpc().move(restAmount);
                } else {
                    script.getNpc().move(maxSpeed);
                }
            }
            calcRestAmount();
        }
    }

    private final void calcRestAmount() {
        restAmount = Distances.getDistanceTo(
                script.getNpc().getLocation(), destination
        );
    }

    public Point2D.Double getDestination() {
        return destination;
    }

    public final void setDestination(final Point2D.Double destination) {
        this.destination = destination;
        direction = Distances.getDirectionTo(
                script.getNpc().getLocation(), destination
        );
    }

    @Override
    public final boolean equals(final Object object) {
        if (!object.getClass().equals(this.getClass())) {
            return false;
        }
        NPCWalkToDestination npcWalkToDestination =
                (NPCWalkToDestination) object;
        if (npcWalkToDestination.destination.x != destination.x ||
                npcWalkToDestination.destination.y != destination.y) {
            return false;
        }
        return true;
    }
}
