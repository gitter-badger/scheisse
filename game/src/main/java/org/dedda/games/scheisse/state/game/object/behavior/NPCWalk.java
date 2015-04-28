package org.dedda.games.scheisse.state.game.object.behavior;

/**
 * Created by dedda on 10/2/14.
 */
public class NPCWalk extends NPCScriptAction {

    protected double amount;
    protected double direction;
    protected double restAmount;
    protected double maxSpeed;

    public NPCWalk(final NPCScript skript) {
        super(skript);
        maxSpeed = skript.getNpc().getMaxSpeed();
    }

    @Override
    public boolean hasNextStep() {
        if (maxSpeed < restAmount) {
            return script.getNpc().canMove(direction, maxSpeed) &&
                restAmount > 0;
        } else {
            return script.getNpc().canMove(direction, restAmount) &&
                restAmount > 0;
        }
    }

    @Override
    public void nextStep() {
        if (hasNextStep()) {
            script.getNpc().setDirection(direction);
            if (maxSpeed < restAmount) {
                script.getNpc().move(maxSpeed);
                restAmount -= maxSpeed;
            } else {
                script.getNpc().move(restAmount);
                restAmount = 0;
            }
        }
    }

    public final double getAmount() {
        return amount;
    }

    public final double getDirection() {
        return direction;
    }

    public final double getRestAmount() {
        return restAmount;
    }

    public final void setAmount(final double amount) {
        this.amount = amount;
        this.restAmount = amount;
    }

    public final void setDirection(final double direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(final Object object) {
        if (!object.getClass().equals(this.getClass())) {
            return false;
        }
        NPCWalk npcWalk = (NPCWalk) object;
        if (npcWalk.direction != direction) {
            return false;
        }
        if (npcWalk.amount != amount) {
            return false;
        }
        return true;
    }
}
