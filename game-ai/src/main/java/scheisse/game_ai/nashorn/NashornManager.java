package scheisse.game_ai.nashorn;

import scheisse.game_ai.GameStore;
import scheisse.game_ai.MobStore;
import scheisse.game_ai.behaviour.Mob;

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

    private static GameStore gameStore = new GameStore() {
        @Override
        public MobStore getMobStore() {
            return new MobStore() {
                @Override
                public Mob getMob(String id) {
                    return null;
                }

                @Override
                public String putMob(Object mobObject) {
                    return null;
                }
            };
        }

        @Override
        public void setMobStore(MobStore mobStore) {

        }
    };

    public ScriptEngine getEngine() {
        return new ScriptEngineManager().getEngineByName("nashorn");
    }

    public ScriptEngine prepareEngine(final String[] jsFilesToLoad) throws FileNotFoundException, ScriptException {
        final ScriptEngine engine = getEngine();
        engine.eval("load(\"nashorn:mozilla_compat.js\");");
        engine.put("_gameStore", gameStore);
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
        ScriptEngine engine = prepareEngine(new String[]{"src/main/javascript/requiredJsFiles.json"});
        return engine;
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

    public static GameStore getGameStore() {
        return gameStore;
    }

    public static void setGameStore(GameStore gameStore) {
        NashornManager.gameStore = gameStore;
    }
}
