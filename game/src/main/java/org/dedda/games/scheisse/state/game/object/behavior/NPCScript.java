package org.dedda.games.scheisse.state.game.object.behavior;

import org.dedda.games.scheisse.state.game.object.npc.NPC;

/**
 * Created by dedda on 10/2/14.
 */
public class NPCScript {

    private final NPC npc;
    private NPCScriptAction[] action;
    private int currentAction = 0;

    public NPCScript(final NPC npc) {
        this.npc = npc;
    }

    public NPCScript(final NPC npc, final NPCScriptAction[] action) {
        this.npc = npc;
        this.action = action;
    }

    public final boolean hasNextAction() {
        return currentAction < action.length - 1;
    }

    public final void nextAction() {
        if (hasNextAction()) {
            currentAction++;
        }
    }

    public final void nextStep() {
        if (action[currentAction].hasNextStep()) {
            action[currentAction].nextStep();
        } else {
            nextAction();
        }
    }

    public final void jump(final int index) {
        currentAction = index;
    }

    public final NPC getNpc() {
        return npc;
    }

    public final NPCScriptAction[] getAction() {
        return action;
    }

    public final void setAction(final NPCScriptAction[] action) {
        this.action = action;
    }

    public final int getCurrentIndex() {
        return currentAction;
    }

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
