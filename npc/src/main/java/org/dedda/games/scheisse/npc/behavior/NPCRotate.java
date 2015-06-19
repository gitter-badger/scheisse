package org.dedda.games.scheisse.npc.behavior;

/**
 * Created by dedda on 10/5/14.
 */
public class NPCRotate extends NPCScriptAction {

    /**
     * angle for rotation.
     */
    private double amount;

    /**
     * @param script
     */
    public NPCRotate(final NPCScript script) {
        super(script);
    }

    /**
     * @return
     */
    @Override
    public final boolean hasNextStep() {
        return true;
    }

    /**
     * rotates npc.
     */
    @Override
    public final void nextStep() {
        script.getNpc().rotate(amount);
    }

    /**
     * @return
     */
    public final double getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public final void setAmount(final double amount) {
        this.amount = amount;
    }
}
