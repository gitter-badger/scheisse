package scheisse.game_ai.nashorn;

import org.junit.Test;

import javax.script.ScriptEngine;

import static junit.framework.Assert.assertTrue;

/**
 * Created by sgoeppentin on 02.07.15.
 *
 * @author dedda
 */
public class JSTestScriptRunnerTest extends NashornTest {

    private final String MOB_TEST = "src/test/javascript/js_tests/mobTest.js";
    private final String INVENTORY_TEST = "src/test/javascript/js_tests/inventoryTest.js";

    @Test
    public void testMobTest() throws Exception {
        ScriptEngine engine = runTestFile(MOB_TEST);
        assertTrue(engineWasSuccessful(engine));
    }

    @Test
    public void testInventoryTest() throws Exception {
        ScriptEngine engine = runTestFile(INVENTORY_TEST);
        assertTrue(engineWasSuccessful(engine));
    }

}
