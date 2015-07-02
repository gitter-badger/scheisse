package scheisse.game_ai.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;

/**
 * Created by sgoeppentin on 02.07.15.
 *
 * @author dedda
 */
public class NashornTest {

    protected NashornManager manager;

    public NashornTest() {
        this.manager = new NashornManager();
    }

    protected ScriptEngine getEngine() {
        return this.manager.getEngine();
    }

    protected ScriptEngine getEngine(final String[] files) throws Exception {
        return this.manager.prepareEngine(files);
    }

    protected ScriptEngine getBasicGameEngine() throws Exception {
        return this.manager.getBasicGameScriptEngine();
    }

    protected NashornClass getNashornClass(final ScriptEngine engine, final String className) {
        return new NashornClass(engine, className);
    }

    protected NashornObject getNashornObject(final ScriptEngine engine, final String className, final String varName, final String[] params) {
        NashornClass nashornClass = getNashornClass(engine, className);
        return new NashornObject(nashornClass, varName, params);
    }

    protected boolean isNashornScriptEngine(final ScriptEngine engine) {
        return jdk.nashorn.api.scripting.NashornScriptEngine.class.equals(engine.getClass());
    }

}
