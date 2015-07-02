package scheisse.game_ai.nashorn;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptEngine;
import java.util.HashMap;

import static junit.framework.Assert.assertTrue;

/**
 * Created by sgoeppentin on 02.07.15.
 *
 * @author dedda
 */
public class JSTestScriptRunnerTest extends NashornTest {

    private HashMap<String, String[]> testScripts;

    private final String MOB_TEST = "src/test/javascript/js_tests/mobTest.js";

    @Before
    public void setUp() {
        this.testScripts = new HashMap<>();
        testScripts.put(
            MOB_TEST, new String[]{
                "src/main/javascript/mob.js"
            });
    }

    @Test
    public void testMobTest() throws Exception {
        ScriptEngine engine = runTestFile(MOB_TEST, testScripts.get(MOB_TEST));
        assertTrue(engineWasSuccessful(engine));
    }

}
