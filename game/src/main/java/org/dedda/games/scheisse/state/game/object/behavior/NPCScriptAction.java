package org.dedda.games.scheisse.state.game.object.behavior;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by dedda on 10/2/14.
 */
public abstract class NPCScriptAction {

    /**
     * {@link NPCScript} this action belongs to.
     */
    protected final NPCScript script;
    /**
     * {@link ScriptEngineManager} engine manager
     * for building java script {@link ScriptEngine}.
     */
    protected ScriptEngineManager scriptEngineManager;
    /**
     * java script {@link ScriptEngine} for evaluating expressions.
     */
    protected ScriptEngine scriptEngine;

    /**
     *
     * @param script
     */
    public NPCScriptAction(final NPCScript script) {
        this.script = script;
        scriptEngineManager = new ScriptEngineManager();
        scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
    }

    /**
     * determines whether the action is completed or not.
     * @return
     */
    public abstract boolean hasNextStep();

    /**
     * runs next step for this action.
     */
    public abstract void nextStep();

    /**
     *
     * @param expression java script expression including optional key words.
     * @return
     * @throws ScriptException
     */
    public final double evalDouble(String expression) throws ScriptException {
        expression = script.replaceKeysInExpression(expression);
        Object value = scriptEngine.eval(expression);
        if (value instanceof Integer) {
            return (Integer) value;
        }
        return (Double) value;
    }

    /**
     *
     * @param expression java script expression including optional key words.
     * @return
     * @throws ScriptException
     */
    public final boolean evalBool(String expression) throws ScriptException {
        expression = script.replaceKeysInExpression(expression);
        Object value = scriptEngine.eval(expression);
        return (Boolean) value;
    }

    /**
     *
     * @param expression java script expression including optional key words.
     * @return
     * @throws ScriptException
     */
    public final String evalString(String expression) throws ScriptException {
        expression = script.replaceKeysInExpression(expression);
        Object value = scriptEngine.eval(expression);
        return (String) value;
    }

}
