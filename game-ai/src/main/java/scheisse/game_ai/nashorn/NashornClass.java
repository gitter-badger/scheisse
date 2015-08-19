package scheisse.game_ai.nashorn;

import scheisse.game_ai.nashorn.exception.NashornClassNotFoundException;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornClass {

    private final AIEngine engine;
    private final String className;

    public NashornClass(final AIEngine engine, final String className) {
        this.engine = engine;
        this.className = className;
        if (!classExists()) {
            throw new NashornClassNotFoundException(className);
        }
    }

    public final boolean classExists() {
        String execute = "typeof " + className + " === 'function'";
        boolean exists = false;
        try {
            exists = (boolean) engine.eval(execute);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public final String getClassName() {
        return className;
    }

    public final AIEngine getEngine() {
        return engine;
    }
}
