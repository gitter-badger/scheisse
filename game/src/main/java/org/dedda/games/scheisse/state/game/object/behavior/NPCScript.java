package org.dedda.games.scheisse.state.game.object.behavior;

import org.dedda.games.scheisse.state.game.object.npc.NPC;

/**
 * Created by dedda on 10/2/14.
 */
public class NPCScript {

    /**
     * {@link NPC} to control.
     */
    private final NPC npc;
    /**
     * parsed actions from script file.
     */
    private NPCScriptAction[] action;
    /**
     * cursor for current action.
     */
    private int currentAction = 0;

    /**
     * @param npc
     */
    public NPCScript(final NPC npc) {
        this.npc = npc;
    }

    /**
     * @param npc
     * @param action
     */
    public NPCScript(final NPC npc, final NPCScriptAction[] action) {
        this.npc = npc;
        this.action = action;
    }

    /**
     * @return
     */
    public final boolean hasNextAction() {
        return currentAction < action.length - 1;
    }

    /**
     * jumps to next action.
     */
    public final void nextAction() {
        if (hasNextAction()) {
            currentAction++;
        }
    }

    /**
     * runs one step of the current action.
     */
    public final void nextStep() {
        if (action[currentAction].hasNextStep()) {
            action[currentAction].nextStep();
        } else {
            nextAction();
        }
    }

    /**
     * jumps to specific action.
     *
     * @param index
     */
    public final void jump(final int index) {
        currentAction = index;
    }

    /**
     * @return
     */
    public final NPC getNpc() {
        return npc;
    }

    /**
     * @return
     */
    public final NPCScriptAction[] getAction() {
        return action;
    }

    /**
     * @param action
     */
    public final void setAction(final NPCScriptAction[] action) {
        this.action = action;
    }

    /**
     * @return
     */
    public final int getCurrentIndex() {
        return currentAction;
    }

    /**
     * replaces key words in {@link String}s.
     *
     * @param expression
     * @return
     */
    public final String replaceKeysInExpression(String expression) {
        expression = expression.replace(
            "npc.location.x",
            npc.getLocation().getX() + ""
        );
        expression = expression.replace(
            "npc.location.y",
            npc.getLocation().getY() + ""
        );
        expression = expression.replace(
            "npc.maxSpeed",
            npc.getMaxSpeed() + ""
        );
        expression = expression.replace(
            "npc.direction",
            npc.getDirection() + ""
        );
        expression = expression.replace("npc.evil", npc.isEvil() + "");
        expression = expression.replace("npc.name", npc.getName());
        return expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
        if (!object.getClass().equals(this.getClass())) {
            return false;
        }
        NPCScript npcSkript = (NPCScript) object;
        if (npcSkript.getNpc() != npc) {
            return false;
        }
        if (npcSkript.action.length != action.length) {
            return false;
        }
        for (int i = 0; i < action.length; i++) {
            if (!action[i].equals(npcSkript.action[i])) {
                return false;
            }
        }
        return true;
    }
}
