package scheisse.game_ai.nashorn;

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
import java.io.FilenameFilter;

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
        engine.eval("load(\"nashorn:mozilla_compat.js\");");
        engine.eval("importClass(java.util.HashMap);");
        NashornToJavaConnector connector = new NashornToJavaConnector();
        engine.put("connector", connector);
        for (String js : jsFilesToLoad) {
            File file = new File(js);
            if (file.isFile()) {
                if (file.getName().endsWith(".json")) {
                    loadFilesFromJSON(engine, file);
                } else {
                    engine.eval(new FileReader(js));
                }
            } else {
                File files[] = file.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".js");
                    }
                });
                for (File jsFile : files) {
                    engine.eval(new FileReader(jsFile));
                }
            }
        }
        return engine;
    }

    public ScriptEngine getBasicGameScriptEngine() throws FileNotFoundException, ScriptException {
        return prepareEngine(new String[]{"src/main/javascript/requiredJsFiles.json"});
    }

    private void loadFilesFromJSON(final ScriptEngine engine, final File jsonFile) throws FileNotFoundException, ScriptException {
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
