package scheisse.game_ai.nashorn.event;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.dedda.games.scheisse.events.GameCommonEvent;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;
import org.dedda.games.scheisse.events.npc.NpcStoreEvent;
import org.junit.Before;
import org.junit.Test;
import scheisse.game_ai.nashorn.NashornManager;
import scheisse.game_ai.nashorn.NashornTest;

import javax.script.ScriptEngine;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class CommonListenerTest extends NashornTest {

    private CommonListener listener;

    private static final String GAME_COMMON_EVENT_TRIGGERED = "gameCommonEventTriggered";
    private static final String ITEM_STORE_EVENT_TRIGGERED = "itemStoreEventTriggered";
    private static final String NPC_STORE_EVENT_TRIGGERED = "npcStoreEventTriggered";

    private static final String GAME_COMMON_EVENT_LISTENER_COUNT = "eventHandler.gameCommonEventListeners.length";
    private static final String ITEM_STORE_EVENT_LISTENER_COUNT = "eventHandler.itemStoreEventListeners.length";
    private static final String NPC_STORE_EVENT_LISTENER_COUNT = "eventHandler.npcStoreEventListeners.length";

    @Before
    public void setUp() throws Exception {
        ScriptEngine engine = runTestFile("src/test/javascript/js_tests/eventTest.js");
        listener = new CommonListener(engine);
    }

    @Test
    public void testGameCommonEvent() throws Exception {
        GameCommonEvent event = new GameCommonEvent(GameCommonEvent.CODE_GENERAL, "gameCommonEventData");
        assertFalse((boolean) listener.getEngine().get(GAME_COMMON_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(ITEM_STORE_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(NPC_STORE_EVENT_TRIGGERED));
        assertEquals(0, (long) listener.getEngine().eval(GAME_COMMON_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(ITEM_STORE_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(NPC_STORE_EVENT_LISTENER_COUNT));
        listener.getEngine().eval("eventHandler.gameCommonEventListeners.push(gameCommonEventHandler);");
        listener.gameCommonEvent(event);
        assertTrue((boolean) listener.getEngine().get(GAME_COMMON_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(ITEM_STORE_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(NPC_STORE_EVENT_TRIGGERED));
        assertEquals(1, (long) listener.getEngine().eval(GAME_COMMON_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(ITEM_STORE_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(NPC_STORE_EVENT_LISTENER_COUNT));
    }

    @Test
    public void testItemStoreEvent() throws Exception {
        ItemStoreEvent event = new ItemStoreEvent(ItemStoreEvent.CODE_GENERAL, "itemStoreEventData");
        assertFalse((boolean) listener.getEngine().get(GAME_COMMON_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(ITEM_STORE_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(NPC_STORE_EVENT_TRIGGERED));
        assertEquals(0, (long) listener.getEngine().eval(GAME_COMMON_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(ITEM_STORE_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(NPC_STORE_EVENT_LISTENER_COUNT));
        listener.getEngine().eval("eventHandler.itemStoreEventListeners.push(itemStoreEventHandler);");
        listener.itemStoreEvent(event);
        assertFalse((boolean) listener.getEngine().get(GAME_COMMON_EVENT_TRIGGERED));
        assertTrue((boolean) listener.getEngine().get(ITEM_STORE_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(NPC_STORE_EVENT_TRIGGERED));
        assertEquals(0, (long) listener.getEngine().eval(GAME_COMMON_EVENT_LISTENER_COUNT));
        assertEquals(1, (long) listener.getEngine().eval(ITEM_STORE_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(NPC_STORE_EVENT_LISTENER_COUNT));
    }

    @Test
    public void testNpcStoreEvent() throws Exception {
        NpcStoreEvent event = new NpcStoreEvent(NpcStoreEvent.CODE_GENERAL, "npcStoreEventData");
        assertFalse((boolean) listener.getEngine().get(GAME_COMMON_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(ITEM_STORE_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(NPC_STORE_EVENT_TRIGGERED));
        assertEquals(0, (long) listener.getEngine().eval(GAME_COMMON_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(ITEM_STORE_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(NPC_STORE_EVENT_LISTENER_COUNT));
        listener.getEngine().eval("eventHandler.npcStoreEventListeners.push(npcStoreEventHandler);");
        listener.npcStoreEvent(event);
        assertFalse((boolean) listener.getEngine().get(GAME_COMMON_EVENT_TRIGGERED));
        assertFalse((boolean) listener.getEngine().get(ITEM_STORE_EVENT_TRIGGERED));
        assertTrue((boolean) listener.getEngine().get(NPC_STORE_EVENT_TRIGGERED));
        assertEquals(0, (long) listener.getEngine().eval(GAME_COMMON_EVENT_LISTENER_COUNT));
        assertEquals(0, (long) listener.getEngine().eval(ITEM_STORE_EVENT_LISTENER_COUNT));
        assertEquals(1, (long) listener.getEngine().eval(NPC_STORE_EVENT_LISTENER_COUNT));
    }
}
