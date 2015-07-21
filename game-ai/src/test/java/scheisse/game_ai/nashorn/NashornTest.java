package scheisse.game_ai.nashorn;

import junit.framework.Assert;

import javax.script.ScriptEngine;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Collectors;

import static junit.framework.Assert.fail;

/**
 * Created by sgoeppentin on 02.07.15.
 *
 * @author dedda
 */
public class NashornTest {

    protected NashornManager manager;

    private final File PRE_TEST_FILE = new File("src/test/javascript/pre_test.js");
    private final File POST_TEST_FILE = new File("src/test/javascript/post_test.js");

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
        long time = System.currentTimeMillis();
        System.out.println("-INFO- Starting javascript test " + fileName);
        ScriptEngine engine = getBasicGameEngine();
        engine.eval(new FileReader(PRE_TEST_FILE));
        engine.eval(new FileReader(new File(fileName)));
        engine.eval(new FileReader(POST_TEST_FILE));
        System.out.println("-INFO- tests run... " + (System.currentTimeMillis() - time) + "ms");
        return engine;
    }

    protected boolean engineWasSuccessful(final ScriptEngine engine) throws Exception {
        String isSuccessDefined = "typeof success !== 'undefined';";
        String areErrorMessagesDefined = "typeof errorMessages === 'array';";
        if (!(boolean) engine.eval(isSuccessDefined)) {
            System.out.println("-WARNING- Success is not defined in engine!");
            return false;
        }
        if ((boolean) engine.eval("success;")) {
            return true;
        }
        if ((boolean) engine.eval(areErrorMessagesDefined)) {
            String[] errorMessages = (String[]) engine.eval("errorMessages;");
            for (String message : errorMessages) {
                System.out.println("-INFO- " + message);
            }
        }
        return false;
    }

    protected boolean runTestFolder(final String folderName) throws Exception {
        final File folder = new File(folderName);
        boolean success = true;
        if (!folder.exists() || !folder.isDirectory()) {
            fail(" is not a folder...");
        }
        final File[] files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return file.isFile() && file.getName().endsWith("Test.js");
            }
        });
        for (int i = 0; i < files.length; i++) {
            ScriptEngine engine = runTestFile(files[i].getAbsolutePath());
            if (!engineWasSuccessful(engine)) {
                success = false;
            }
        }
        return success;
    }

}
