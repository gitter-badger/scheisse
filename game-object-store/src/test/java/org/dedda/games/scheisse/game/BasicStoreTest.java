package org.dedda.games.scheisse.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 7/25/15.
 */
public class BasicStoreTest {

    private BasicStore<String> stringStore;
    private boolean registered = false;
    private boolean unregistered = false;

    @Before
    public void setUp() throws Exception {
        stringStore = new BasicStore<String>() {
            @Override
            protected void registerEvent(long key, String object) {
                registered = true;
            }
            @Override
            protected void unregisterEvent(long key, String object) {
                unregistered = true;
            }
        };
    }

    @Test
    public void testRegister() throws Exception {
        long key = stringStore.register("one");
        assertTrue(registered);
        assertFalse(unregistered);
        assertEquals(0, key);
    }

    @Test
    public void testGetValue() throws Exception {
        long key = stringStore.register("one");
        assertEquals("one", stringStore.getValue(key));
    }

    @Test
    public void testGetKey() throws Exception {
        long key = stringStore.register("one");
        assertEquals(key, stringStore.getKey("one"));
    }

    @Test
    public void testUnregister() throws Exception {
        long key = stringStore.register("one");
        assertFalse(unregistered);
        stringStore.unregister("one");
        assertTrue(unregistered);
        assertEquals(-1, stringStore.getKey("one"));
        assertEquals(null, stringStore.getValue(key));
    }
}
