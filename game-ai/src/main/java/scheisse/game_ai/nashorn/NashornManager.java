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
        engine = prepareEngine(engine, jsFilesToLoad);
        return engine;
    }

    public final AIEngine prepareEngine(final AIEngine engine, final String[] jsFilesToLoad) throws FileNotFoundException, ScriptException {
        for (String js : jsFilesToLoad) {
            File file = new File(js);
            if (file.isFile()) {
                if (file.getName().endsWith(".json")) {
                    loadFilesFromJSON(engine, file);
                } else {
                    engine.eval(new FileReader(js));
                }
            } else {
                File[] files = file.listFiles((dir, name) -> {
                    return name.endsWith(".js");
                });
                for (File jsFile : files) {
                    engine.eval(new FileReader(jsFile));
                }
            }
        }
        return engine;
    }

    public final AIEngine getBasicGameScriptEngine(final Store store) throws FileNotFoundException, ScriptException {
        AIEngine engine = getEngine();
        engine.eval("load(\"nashorn:mozilla_compat.js\");");
        engine.put("store", store);
        engine.put("gameSession", GameSession.getInstance());
        engine = prepareEngine(engine, new String[]{"src/main/javascript/requiredJsFiles.json"});
        return engine;
    }

    public void installFolder(final AIEngine engine, final File folder) throws Exception {
        if (!folder.exists() || !folder.isDirectory()) {
            throw new Exception("expected folder!");
        }
        final File runningOrderFile = new File((folder.getAbsolutePath() + (folder.getAbsolutePath().endsWith("/") ? "" : "/")) + "runningOrder.json");
        if (runningOrderFile.exists()) {
            loadFilesFromJSON(engine, runningOrderFile);
            return;
        }
        File[] files = folder.listFiles(f -> (f.getName().endsWith(".js")));
        for (File f : files) {
            engine.eval(new FileReader(f));
        }
    }

    private void loadFilesFromJSON(final AIEngine engine, final File jsonFile) throws FileNotFoundException, ScriptException {
        String folder = jsonFile.getParent();
        JsonReader reader = Json.createReader(new FileInputStream(jsonFile));
        JsonObject root = reader.readObject();
        JsonArray files = root.getJsonArray("files");
        for (int i = 0; i < files.size(); i++) {
            String file = folder + '/' + files.getString(i);
            engine.eval(new FileReader(file));
        }
    }
}
