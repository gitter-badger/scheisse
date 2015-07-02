package scheisse.game_ai.nashorn;

import org.junit.Before;
import org.junit.Test;
import scheisse.game_ai.GameStore;

import javax.script.Invocable;
import javax.script.ScriptEngine;

import java.net.URLClassLoader;

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
        ScriptEngine engine = manager.getEngine();
        assertTrue(isNashornScriptEngine(engine));
    }

    @Test
    public void testPrepareEngine() throws Exception {
        ScriptEngine engine = manager.prepareEngine(new String[]{"src/test/javascript/test.js"});
        int a = 1;
        int b = 2;
        int expected = a + b;
        int ans = ((Number) ((Invocable) engine).invokeFunction("addition", a, b)).intValue();
        assertEquals(expected, ans);
    }

    @Test
    public void testPrepareEngineDirectory() throws Exception {
        ScriptEngine engine = manager.prepareEngine(new String[]{"src/test/javascript/test_dir"});
        int a = 1;
        int b = 2;
        int expected = a + b;
        int ans = ((Number) ((Invocable) engine).invokeFunction("addition", a, b)).intValue();
        assertEquals(expected, ans);
        int y = ((Number) (engine.eval("y;"))).intValue();
        assertEquals(10, y);
    }

    @Test
    public void testGetBasicGameScriptEngine() throws Exception {
        ScriptEngine engine = manager.getBasicGameScriptEngine();
        String exec = "_gameStore;";
        Object value = engine.eval(exec);
        assertTrue(value instanceof GameStore);
    }
}
