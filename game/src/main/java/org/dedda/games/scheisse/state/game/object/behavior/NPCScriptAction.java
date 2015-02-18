package org.dedda.games.scheisse.state.game.object.behavior;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by dedda on 10/2/14.
 */
public abstract class NPCScriptAction {

    protected final NPCScript script;
    protected ScriptEngineManager scriptEngineManager;
    protected ScriptEngine scriptEngine;

    public NPCScriptAction(final NPCScript script) {
        this.script = script;
        scriptEngineManager = new ScriptEngineManager();
        scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
    }

    public abstract boolean hasNextStep();
    public abstract void nextStep();

    public double evalDouble(String expression) throws ScriptException {
        expression = script.replaceKeysInExpression(expression);
        Object value = scriptEngine.eval(expression);
        if (value instanceof Integer) {
            return (Integer)value;
        }
        return (Double)value;
    }

    public boolean evalBool(String expression) throws ScriptException {
        expression = script.replaceKeysInExpression(expression);
        Object value = scriptEngine.eval(expression);
        return (Boolean)value;
    }

    public String evalString(String expression) throws ScriptException {
        expression = script.replaceKeysInExpression(expression);
        Object value = scriptEngine.eval(expression);
        return (String)value;
    }

}
