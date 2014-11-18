package org.dedda.games.scheisse.state.game.object.behavior;

import org.dedda.games.scheisse.state.game.object.npc.NPC;

/**
 * Created by dedda on 10/2/14.
 */
public class NPCScript {

    private final NPC npc;
    private NPCScriptAction action[];
    private int currentAction = 0;

    public NPCScript(NPC npc) {
        this.npc = npc;
    }

    public NPCScript(NPC npc, NPCScriptAction[] action) {
        this.npc = npc;
        this.action = action;
    }

    public boolean hasNextAction(){
        return currentAction < action.length - 1;
    }

    public void nextAction(){
        if(hasNextAction()){
            currentAction++;
        }
    }

    public void nextStep(){
        if(action[currentAction].hasNextStep()){
            action[currentAction].nextStep();
        }else{
            nextAction();
        }
    }

    public void jump(int index){
        currentAction = index;
    }

    public NPC getNpc() {
        return npc;
    }

    public NPCScriptAction[] getAction() {
        return action;
    }

    public void setAction(NPCScriptAction[] action) {
        this.action = action;
    }

    public int getCurrentIndex() {
        return currentAction;
    }

    public String replaceKeysInExpression(String expression){
        expression = expression.replace("npc.location.x", npc.getLocation().getX() + "");
        expression = expression.replace("npc.location.y", npc.getLocation().getY() + "");
        expression = expression.replace("npc.maxSpeed", npc.getMaxSpeed() + "");
        expression = expression.replace("npc.direction", npc.getDirection() + "");
        expression = expression.replace("npc.evil", npc.isEvil() + "");
        expression = expression.replace("npc.name", npc.getName());
        return expression;
    }

    @Override
    public boolean equals(Object object){
        if(!object.getClass().equals(this.getClass())){
           return false;
        }
        NPCScript npcSkript = (NPCScript)object;
        if(npcSkript.getNpc() != npc){
            return false;
        }
        if(npcSkript.action.length != action.length){
            return false;
        }
        for(int i = 0; i < action.length; i++){
            if(!action[i].equals(npcSkript.action[i])){
                return false;
            }
        }
        return true;
    }
}
