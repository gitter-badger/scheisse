package scheisse.game_ai.nashorn;

import org.junit.Before;
import org.junit.Test;
import scheisse.game_ai.nashorn.exception.NashornClassNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by dedda on 6/17/15.
 *
 * @author dedda
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

    @Test
    public void testConstructorClassNotExisting() throws Exception {
        boolean thrown = false;
        try {
            this.nashornClass = new NashornClass(new NashornManager().prepareEngine(new String[]{"src/test/resources/nashorn/class.js"}), "NotExistingClass");
        } catch(NashornClassNotFoundException e) {
            assertEquals("NotExistingClass", e.className);
            thrown = true;
        }
        assertTrue(thrown);
    }
}
