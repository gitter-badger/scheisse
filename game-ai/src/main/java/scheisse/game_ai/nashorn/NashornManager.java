package scheisse.game_ai.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornManager {

    public ScriptEngine getEngine() {
        return new ScriptEngineManager().getEngineByName("nashorn");
    }

    public ScriptEngine prepareEngine(final String[] jsFilesToLoad) throws FileNotFoundException, ScriptException {
        final ScriptEngine engine = getEngine();
        for (String js : jsFilesToLoad) {
            engine.eval(new FileReader(js));
        }
        return engine;
    }

}
