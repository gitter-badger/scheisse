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

import static junit.framework.Assert.fail;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class CommonListenerTest extends NashornTest {

    private CommonListener listener;

    @Before
    public void setUp() throws Exception {
        ScriptEngine engine = runTestFile("src/test/javascript/js_tests/eventTest.js");
        listener = new CommonListener(engine);
    }

    @Test
    public void testGameCommonEvent() throws Exception {
        GameCommonEvent event = new GameCommonEvent(GameCommonEvent.CODE_GENERAL, "gameCommonEventData");
        listener.getEngine().eval("eventHandler.addGameCommonEventListener(gameCommonEventHandler);");
        listener.gameCommonEvent(event);
        fail("FIX!");
    }

    @Test
    public void testItemStoreEvent() throws Exception {
        ItemStoreEvent event = new ItemStoreEvent(ItemStoreEvent.CODE_GENERAL, "itemStoreEventData");
        listener.getEngine().eval("eventHandler.addItemStoreEventListener(itemStoreEventHandler);");
        listener.itemStoreEvent(event);
        fail("FIX!");
    }

    @Test
    public void testNpcStoreEvent() throws Exception {
        NpcStoreEvent event = new NpcStoreEvent(NpcStoreEvent.CODE_GENERAL, "npcStoreEventData");
        listener.getEngine().eval("eventHandler.addNpcStoreEventListener(npcStoreEventHandler);");
        listener.npcStoreEvent(event);
        fail("FIX!");
    }
}
