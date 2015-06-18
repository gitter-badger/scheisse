package scheisse.game_ai.behaviour;

import scheisse.game_ai.nashorn.NashornClass;
import scheisse.game_ai.nashorn.NashornObject;

import javax.script.ScriptEngine;

/**
 * Created by sgoeppentin on 18.06.15.
 *
 * @author dedda
 */
public abstract class MobAI {

    private final NashornObject NASHORN_OBJECT;
    private final ScriptEngine ENGINE;

    public MobAI(final ScriptEngine engine, final String jsClass, final String jsVarName, final String[] constructorParams) {
        this.ENGINE = engine;
        NashornClass nashornClass = new NashornClass(engine, jsClass);
        NashornObject nashornObject = new NashornObject(nashornClass, jsVarName, constructorParams);
        this.NASHORN_OBJECT = nashornObject;
    }

    public final void tick(final float dt) {
        preTick(dt);
        doTick(dt);
        postTick(dt);
    }

    public void doTick(final float dt) {
        String execute = NASHORN_OBJECT.varName + ".tick(" + dt + ");";
    }

    public void preTick(final float dt) {

    }

    public void postTick(final float dt) {

    }

}
