package org.dedda.games.scheisse_server.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
