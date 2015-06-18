package scheisse.game_ai.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
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
        for (String js : jsFilesToLoad) {
            File file = new File(js);
            if (file.isFile()) {
                engine.eval(new FileReader(js));
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

}
