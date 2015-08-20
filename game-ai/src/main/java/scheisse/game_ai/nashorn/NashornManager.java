package scheisse.game_ai.nashorn;

import org.dedda.games.scheisse.game.GameSession;
import scheisse.game_ai.Store;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornManager {

    public final AIEngine getEngine() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        return new AIEngine(engine);
    }

    public final AIEngine prepareEngine(final String[] jsFilesToLoad) throws FileNotFoundException, ScriptException {
        AIEngine engine = getEngine();
        engine.eval("load(\"nashorn:mozilla_compat.js\");");
        engine.runFiles(jsFilesToLoad);
        return engine;
    }

    public final AIEngine getBasicGameScriptEngine(final Store store) throws FileNotFoundException, ScriptException {
        final String[] files = {"src/main/javascript/requiredJsFiles.json"};
        AIEngine engine = getEngine();
        engine.eval("load(\"nashorn:mozilla_compat.js\");");
        engine.put("store", store).put("gameSession", GameSession.getInstance()).runFiles(files);
        return engine;
    }
}
