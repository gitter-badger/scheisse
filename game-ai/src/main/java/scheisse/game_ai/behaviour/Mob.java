package scheisse.game_ai.behaviour;

import javax.script.ScriptEngine;

/**
 * Created by sgoeppentin on 18.06.15.
 *
 * @author dedda
 */
public abstract class Mob extends MobAI{

    public Mob(ScriptEngine engine, String jsClass, String jsVarName, String[] constructorParams) {
        super(engine, jsClass, jsVarName, constructorParams);
    }
}
