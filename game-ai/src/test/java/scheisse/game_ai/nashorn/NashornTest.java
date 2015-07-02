package scheisse.game_ai.nashorn;

import javax.script.ScriptEngine;
import java.io.File;
import java.io.FileReader;

/**
 * Created by sgoeppentin on 02.07.15.
 *
 * @author dedda
 */
public class NashornTest {

    protected NashornManager manager;

    public NashornTest() {
        this.manager = new NashornManager();
    }

    protected ScriptEngine getEngine() {
        return this.manager.getEngine();
    }

    protected ScriptEngine getEngine(final String[] files) throws Exception {
        return this.manager.prepareEngine(files);
    }

    protected ScriptEngine getBasicGameEngine() throws Exception {
        return this.manager.getBasicGameScriptEngine();
    }

    protected NashornClass getNashornClass(final ScriptEngine engine, final String className) {
        return new NashornClass(engine, className);
    }

    protected NashornObject getNashornObject(final ScriptEngine engine, final String className, final String varName, final String[] params) {
        NashornClass nashornClass = getNashornClass(engine, className);
        return new NashornObject(nashornClass, varName, params);
    }

    protected boolean isNashornScriptEngine(final ScriptEngine engine) {
        return jdk.nashorn.api.scripting.NashornScriptEngine.class.equals(engine.getClass());
    }

    protected ScriptEngine runTestFile(final String fileName) throws Exception {
        ScriptEngine engine = getBasicGameEngine();
        engine.eval(new FileReader(new File(fileName)));
        return engine;
    }

    protected boolean engineWasSuccessful(final ScriptEngine engine) throws Exception {
        String isSuccesDefined = "typeof success !== 'undefined';";
        String areErrorMessagesDefined = "typeof errorMessages === 'array';";
        if (!(boolean) engine.eval(isSuccesDefined)) {
            System.out.println("Success is not defined in engine!");
            return false;
        }
        if ((boolean) engine.eval("success;")) {
            return true;
        }
        if ((boolean) engine.eval(areErrorMessagesDefined)) {
            String[] errorMessages = (String[]) engine.eval("errorMessages;");
            for (String message : errorMessages) {
                System.out.println(message);
            }
        }
        return false;
    }

}
