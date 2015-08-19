package scheisse.game_ai.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.Reader;

/**
 * Created by dedda on 8/19/15.
 *
 * @author dedda
 */
public class AIEngine {

    private final ScriptEngine engine;

    public AIEngine(ScriptEngine engine) {
        this.engine = engine;
    }

    public Object invokeFunction(String name, Object... args) throws ScriptException, NoSuchMethodException {
        return ((Invocable) engine).invokeFunction(name, args);
    }

    public Object eval(final String command) throws ScriptException {
        return engine.eval(command);
    }

    public Object eval(final Reader reader) throws ScriptException {
        return engine.eval(reader);
    }

    public Object get(String name) {
        return engine.get(name);
    }

    public void put(final String name, final Object object) {
        engine.put(name, object);
    }

}
