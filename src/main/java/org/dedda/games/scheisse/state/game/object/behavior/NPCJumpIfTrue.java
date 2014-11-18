package org.dedda.games.scheisse.state.game.object.behavior;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by dedda on 10/4/14.
 */
public class NPCJumpIfTrue extends NPCScriptAction {

    private String expression;
    private int jumpPoint;

    public NPCJumpIfTrue(NPCScript skript) {
        super(skript);
    }

    @Override
    public boolean hasNextStep() {
        return true;
    }

    @Override
    public void nextStep() {
        boolean evaluation = false;
        try {
            evaluation = evalBool(this.expression);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        if(evaluation){
            script.jump(jumpPoint);
        }
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getJumpPoint() {
        return jumpPoint;
    }

    public void setJumpPoint(int jumpPoint) {
        this.jumpPoint = jumpPoint;
    }

    public ScriptEngineManager getScriptEngineManager() {
        return scriptEngineManager;
    }

    public void setScriptEngineManager(ScriptEngineManager scriptEngineManager) {
        this.scriptEngineManager = scriptEngineManager;
    }

    public ScriptEngine getScriptEngine() {
        return scriptEngine;
    }

    public void setScriptEngine(ScriptEngine scriptEngine) {
        this.scriptEngine = scriptEngine;
    }

    @Override
    public boolean equals(Object object){
        if(!object.getClass().equals(this.getClass())){
            return false;
        }
        NPCJumpIfTrue npcJumpIfTrue = (NPCJumpIfTrue)object;
        if(!npcJumpIfTrue.getExpression().equals(expression)){
            return false;
        }
        if(npcJumpIfTrue.getJumpPoint() != jumpPoint){
            return false;
        }
        return true;
    }
}
