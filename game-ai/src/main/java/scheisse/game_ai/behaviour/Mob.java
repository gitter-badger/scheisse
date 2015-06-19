package scheisse.game_ai.behaviour;

import javax.script.ScriptEngine;

/**
 * Created by sgoeppentin on 18.06.15.
 *
 * @author dedda
 */
public abstract class Mob extends MobAI {

    public Mob(final ScriptEngine engine, final String jsClass, final String jsVarName, final String[] constructorParams) {
        super(engine, jsClass, jsVarName, constructorParams);
    }
}
