package scheisse.game_ai.nashorn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import javax.script.ScriptEngine;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.format;

/**
 * Created by sgoeppentin on 02.07.15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class JSTestScriptRunnerTest extends NashornTest {

    private static final String JS_TEST_FOLDER = "src/test/javascript/js_tests";

    @Parameters
    public static Collection<Object[]> data() {
        File folder = new File(JS_TEST_FOLDER);
        final File[] files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return file.isFile() && file.getName().endsWith("Test.js");
            }
        });
        ArrayList<Object[]> objects = new ArrayList<>(files.length);
        for (File file : files) {
            objects.add(new Object[]{file});
        }
        return objects;
    }

    @Parameter(value = 0)
    public File file;

    @Test
    public void testDirectory() throws Exception {
        ScriptEngine engine = runTestFile(file.getAbsolutePath());
        assertTrue(engineWasSuccessful(engine));
    }

}
