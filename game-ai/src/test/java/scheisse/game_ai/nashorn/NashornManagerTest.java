package scheisse.game_ai.nashorn;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;

import static org.junit.Assert.*;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornManagerTest extends NashornTest {

    @Test
    public void testGetEngine() throws Exception {
        System.out.println("test");
        AIEngine engine = manager.getEngine();
    }

    @Test
    public void testPrepareEngine() throws Exception {
        AIEngine engine = manager.prepareEngine(new String[]{"src/test/javascript/test.js"});
        int a = 1;
        int b = 2;
        int expected = a + b;
        int ans = ((Number) engine.invokeFunction("addition", a, b)).intValue();
        assertEquals(expected, ans);
    }

    @Test
    public void testPrepareEngineDirectory() throws Exception {
        AIEngine engine = manager.prepareEngine(new String[]{"src/test/javascript/test_dir"});
        int a = 1;
        int b = 2;
        int expected = a + b;
        int ans = ((Number) engine.invokeFunction("addition", a, b)).intValue();
        assertEquals(expected, ans);
        int y = ((Number) (engine.eval("y;"))).intValue();
        assertEquals(10, y);
    }
}
