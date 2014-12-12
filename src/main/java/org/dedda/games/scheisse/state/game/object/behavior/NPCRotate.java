package org.dedda.games.scheisse.state.game.object.behavior;

/**
 * Created by dedda on 10/5/14.
 */
public class NPCRotate extends NPCScriptAction {

    private double amount;

    public NPCRotate(final NPCScript script) {
        super(script);
    }

    @Override
    public boolean hasNextStep() {
        return true;
    }

    @Override
    public void nextStep() {
        script.getNpc().rotate(amount);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(final String expression) {

    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }
}
