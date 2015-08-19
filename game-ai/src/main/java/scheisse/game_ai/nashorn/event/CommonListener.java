package scheisse.game_ai.nashorn.event;

import org.dedda.games.scheisse.events.GameCommonEvent;
import org.dedda.games.scheisse.events.GameCommonEventListener;
import org.dedda.games.scheisse.events.item.ItemStoreEvent;
import org.dedda.games.scheisse.events.item.ItemStoreEventListener;
import org.dedda.games.scheisse.events.npc.NpcStoreEvent;
import org.dedda.games.scheisse.events.npc.NpcStoreEventListener;
import org.dedda.games.scheisse.game.GameSession;
import scheisse.game_ai.nashorn.AIEngine;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Created by dedda on 7/24/15.
 *
 * @author dedda
 */
public class CommonListener implements GameCommonEventListener,
    ItemStoreEventListener,
    NpcStoreEventListener{

    private AIEngine engine;

    public CommonListener(final AIEngine engine) {
        this.engine = engine;
    }

    public void register() {
        GameSession.getInstance().addListener(this);
    }

    @Override
    public void gameCommonEvent(final GameCommonEvent event) {
        engine.put("tmpEvent", event);
        eval("eventHandler.gameCommonEvent(tmpEvent);");
    }

    @Override
    public void itemStoreEvent(final ItemStoreEvent event) {
        engine.put("tmpEvent", event);
        eval("eventHandler.itemStoreEvent(tmpEvent);");
    }

    @Override
    public void npcStoreEvent(final NpcStoreEvent event) {
        engine.put("tmpEvent", event);
        eval("eventHandler.npcStoreEvent(tmpEvent);");
    }

    private void eval(final String script) {
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public AIEngine getEngine() {
        return engine;
    }
}
