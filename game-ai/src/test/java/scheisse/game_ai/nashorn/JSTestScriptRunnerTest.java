package scheisse.game_ai.nashorn;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by sgoeppentin on 02.07.15.
 *
 * @author dedda
 */
public class JSTestScriptRunnerTest extends NashornTest {

    private final String JS_TEST_FOLDER = "src/test/javascript/js_tests";

    @Test
    public void testDirectory() throws Exception {
        assertTrue(runTestFolder(JS_TEST_FOLDER));
    }

}
