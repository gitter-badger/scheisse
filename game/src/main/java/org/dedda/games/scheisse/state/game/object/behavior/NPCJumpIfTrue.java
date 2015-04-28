package org.dedda.games.scheisse.state.game.object.behavior;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by dedda on 10/4/14.
 */
public class NPCJumpIfTrue extends NPCScriptAction {

    /**
     * expression that is expected to evaluate to true.
     */
    private String expression;
    /**
     * point to jump to in script.
     */
    private int jumpPoint;

    /**
     * @param skript
     */
    public NPCJumpIfTrue(final NPCScript skript) {
        super(skript);
    }

    /**
     * this method always returns true. after jump the cursor in the script
     * is at a different position so this action can't be run twice.
     *
     * @return always true
     * @see NPCScriptAction#hasNextStep()
     */
    @Override
    public final boolean hasNextStep() {
        return true;
    }

    /**
     * evaluates expected expression and jumps or continues.
     *
     * @see NPCScriptAction#nextStep()
     */
    @Override
    public final void nextStep() {
        boolean evaluation = false;
        try {
            evaluation = evalBool(this.expression);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        if (evaluation) {
            script.jump(jumpPoint);
        }
    }

    /**
     * @return
     */
    public final String getExpression() {
        return expression;
    }

    /**
     * @param expression
     */
    public final void setExpression(final String expression) {
        this.expression = expression;
    }

    /**
     * @return
     */
    public final int getJumpPoint() {
        return jumpPoint;
    }

    /**
     * @param jumpPoint
     */
    public final void setJumpPoint(final int jumpPoint) {
        this.jumpPoint = jumpPoint;
    }

    /**
     * @return
     */
    public final ScriptEngineManager getScriptEngineManager() {
        return scriptEngineManager;
    }

    /**
     * @param scriptEngineManager
     */
    public final void setScriptEngineManager(final ScriptEngineManager scriptEngineManager) {
        this.scriptEngineManager = scriptEngineManager;
    }

    /**
     * @return
     */
    public final ScriptEngine getScriptEngine() {
        return scriptEngine;
    }

    /**
     * @param scriptEngine
     */
    public final void setScriptEngine(final ScriptEngine scriptEngine) {
        this.scriptEngine = scriptEngine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
        if (!object.getClass().equals(this.getClass())) {
            return false;
        }
        NPCJumpIfTrue npcJumpIfTrue = (NPCJumpIfTrue) object;
        if (!npcJumpIfTrue.getExpression().equals(expression)) {
            return false;
        }
        if (npcJumpIfTrue.getJumpPoint() != jumpPoint) {
            return false;
        }
        return true;
    }
}
