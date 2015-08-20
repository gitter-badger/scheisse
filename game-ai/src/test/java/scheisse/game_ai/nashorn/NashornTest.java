package scheisse.game_ai.nashorn;

import org.dedda.games.scheisse.entity.Inventory;
import org.dedda.games.scheisse.entity.User;
import scheisse.game_ai.Store;

import javax.script.ScriptEngine;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;

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

    protected AIEngine getEngine() {
        return this.manager.getEngine();
    }

    protected AIEngine getEngine(final String[] files) throws Exception {
        return this.manager.prepareEngine(files);
    }

    protected AIEngine getBasicGameEngine() throws Exception {
        return this.manager.getBasicGameScriptEngine(prepareStore());
    }

    protected NashornClass getNashornClass(final AIEngine engine, final String className) {
        return new NashornClass(engine, className);
    }

    protected NashornObject getNashornObject(final AIEngine engine, final String className, final String varName, final String[] params) {
        NashornClass nashornClass = getNashornClass(engine, className);
        return new NashornObject(nashornClass, varName, params);
    }

    protected AIEngine runTestFile(final String fileName) throws Exception {
        long time = System.currentTimeMillis();
        System.out.println("-INFO- Starting javascript test " + fileName);
        AIEngine engine = getBasicGameEngine();
        engine.runFile(PRE_TEST_FILE).runFile(fileName).runFile(POST_TEST_FILE);
        System.out.println("-INFO- tests run... " + (System.currentTimeMillis() - time) + "ms");
        return engine;
    }

    protected boolean engineWasSuccessful(final AIEngine engine) throws Exception {
        String isSuccessDefined = "typeof success !== 'undefined';";
        String areErrorMessagesDefined = "typeof errorMessages === 'array';";
        if (!(boolean) engine.eval(isSuccessDefined)) {
            System.out.println("-WARNING- Success is not defined in engine!");
            return false;
        }
        if ((boolean) engine.get("success")) {
            return true;
        }
        if ((boolean) engine.eval(areErrorMessagesDefined)) {
            String[] errorMessages = (String[]) engine.get("errorMessages");
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
            AIEngine engine = runTestFile(files[i].getAbsolutePath());
            if (!engineWasSuccessful(engine)) {
                success = false;
            }
        }
        return success;
    }

    private Store prepareStore() {
        Store store = new Store();
        User user = new User();
        user.setId(1L);
        user.setName("Test user");
        user.setEmail("test@user.com");
        user.setExperience(10L);
        user.setPasswordHash("test hash");
        Inventory inventory = new Inventory();
        user.setInventory(inventory);
        store.setUser(user);
        return store;
    }

}
