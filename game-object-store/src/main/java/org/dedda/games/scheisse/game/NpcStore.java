package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.events.npc.NpcStoreEvent;
import org.dedda.games.scheisse.npc.npc.NPC;

import static org.dedda.games.scheisse.events.npc.NpcStoreEvent.CODE_NPC_UNREGISTERED;

/**
 * Created by dedda on 7/27/15.
 *
 * @author dedda
 */
public class NpcStore extends BasicStore<NPC> {

    @Override
    protected void registerEvent(final long key, final NPC object) {
        GameSession.getInstance().npcStoreEvent(new NpcStoreEvent(CODE_NPC_UNREGISTERED, object));
    }

    @Override
    protected void unregisterEvent(final long key, final NPC object) {
        GameSession.getInstance().npcStoreEvent(new NpcStoreEvent(CODE_NPC_UNREGISTERED, object));
    }
}
