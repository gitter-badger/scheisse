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
    public final boolean hasNextStep() {
        return true;
    }

    @Override
    public final void nextStep() {
        script.getNpc().rotate(amount);
    }

    public final double getAmount() {
        return amount;
    }

    public final void setAmount(final String expression) {

    }

    public final void setAmount(final double amount) {
        this.amount = amount;
    }
}
