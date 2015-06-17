package scheisse.game_ai.nashorn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 6/17/15.
 */
public class NashornClassTest {

    NashornClass nashornClass;

    @Before
    public void setUp() throws Exception {
        this.nashornClass = new NashornClass(new NashornManager().prepareEngine(new String[]{"src/test/resources/nashorn/class.js"}), "TestClass");
    }

    @Test
    public void testClassExists() throws Exception {
        assertTrue(nashornClass.classExists());
    }
}
