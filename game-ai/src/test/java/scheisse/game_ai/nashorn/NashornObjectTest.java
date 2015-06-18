package scheisse.game_ai.nashorn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
 */
public class NashornObjectTest {

    private NashornObject object;

    @Before
    public void setUp() throws Exception {
        NashornManager manager = new NashornManager();
        NashornClass nashornClass = new NashornClass(manager.prepareEngine(new String[]{"src/test/resources/nashorn/class.js"}), "TestClass");
        object = new NashornObject(nashornClass, "testVar", new String[]{"Test"});
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
