package scheisse.game_ai.nashorn;

import scheisse.game_ai.nashorn.exception.NashornClassNotFoundException;

import javax.print.attribute.standard.MediaSize;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornClass {

    private final ScriptEngine engine;
    private final String className;

    public NashornClass(final ScriptEngine engine, final String className) {
        this.engine = engine;
        this.className = className;
        if (!classExists()) {
            throw new NashornClassNotFoundException(className);
        }
    }

    public boolean classExists() {
        String execute = "typeof " + className + " === 'function'";
        boolean exists = false;
        try {
            exists = (boolean) engine.eval(execute);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public String getClassName() {
        return className;
    }

    public ScriptEngine getEngine() {
        return engine;
    }
}
