package scheisse.game_ai.nashorn;

import org.junit.Before;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;

import java.net.URLClassLoader;

import static org.junit.Assert.*;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornManagerTest {

    NashornManager manager;

    @Before
    public void setUp() throws Exception {
        manager = new NashornManager();
    }

    @Test
    public void testGetEngine() throws Exception {
        System.out.println("test");
        ScriptEngine engine = manager.getEngine();
        assertEquals(jdk.nashorn.api.scripting.NashornScriptEngine.class, engine.getClass());
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
        String exec = "javaHelper.testConnection();";
        boolean ping = (boolean)engine.eval(exec);
        assertTrue(ping);
    }
}
