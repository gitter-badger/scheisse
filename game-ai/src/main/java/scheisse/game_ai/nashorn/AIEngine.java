package scheisse.game_ai.nashorn;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.*;

/**
 * Created by dedda on 8/19/15.
 *
 * @author dedda
 */
public class AIEngine {

    private final ScriptEngine engine;

    public AIEngine(ScriptEngine engine) {
        if (!engine.getClass().equals(jdk.nashorn.api.scripting.NashornScriptEngine.class)) {
            throw new RuntimeException("Wrong engine type given!");
        }
        this.engine = engine;
    }

    public AIEngine runFile(final String file) throws FileNotFoundException, ScriptException {
        return runFile(new File(file));
    }

    public AIEngine runFile(final File file) throws FileNotFoundException, ScriptException {
        if (file.isFile()) {
            if (file.getName().endsWith(".json")) {
                loadFilesFromJSON(file);
            } else {
                eval(new FileReader(file));
            }
        } else {
            File[] files = file.listFiles((dir, name) -> {
                return name.endsWith(".js");
            });
            for (File jsFile : files) {
                eval(new FileReader(jsFile));
            }
        }
        return this;
    }

    public AIEngine runFiles(final String[] files) throws FileNotFoundException, ScriptException {
        for (String file : files) {
            runFile(new File(file));
        }
        return this;
    }

    public AIEngine runFiles(final File[] files) throws FileNotFoundException, ScriptException {
        for (File file : files) {
            runFile(file);
        }
        return this;
    }

    public AIEngine installFolder(final File folder) throws Exception {
        if (!folder.exists() || !folder.isDirectory()) {
            throw new Exception("expected folder!");
        }
        String path = folder.getAbsolutePath();
        path = path + (path.endsWith("/") ? "" : "/");
        final File runningOrderFile = new File(path + "runningOrder.json");
        if (runningOrderFile.exists()) {
            loadFilesFromJSON(runningOrderFile);
            return this;
        }
        File[] files = folder.listFiles(f -> (f.getName().endsWith(".js")));
        for (File f : files) {
            engine.eval(new FileReader(f));
        }
        return this;
    }

    public AIEngine loadFilesFromJSON(final File jsonFile) throws FileNotFoundException, ScriptException {
        String folder = jsonFile.getParent();
        JsonReader reader = Json.createReader(new FileInputStream(jsonFile));
        JsonObject root = reader.readObject();
        JsonArray files = root.getJsonArray("files");
        for (int i = 0; i < files.size(); i++) {
            String file = folder + '/' + files.getString(i);
            engine.eval(new FileReader(file));
        }
        return this;
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

    public AIEngine put(final String name, final Object object) {
        engine.put(name, object);
        return this;
    }

}
