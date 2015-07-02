package scheisse.game_ai.nashorn;

import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptEngine;

import static org.junit.Assert.*;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornObjectTest extends NashornTest {

    private NashornObject object;

    @Before
    public void setUp() throws Exception {
        ScriptEngine engine = manager.prepareEngine(new String[]{"src/test/javascript/class.js"});
        object = getNashornObject(engine, "TestClass", "testVar", new String[]{"Test"});
    }

    @Test
    public void testGetProperty() throws Exception {
        assertEquals("Test", object.getProperty("x"));
    }

    @Test
    public void testSetProperty() throws Exception {
        object.setProperty("x", "Changed");
        assertEquals("Changed", object.getProperty("x"));
    }
}
