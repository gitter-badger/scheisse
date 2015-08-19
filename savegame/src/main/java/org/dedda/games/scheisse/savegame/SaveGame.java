package org.dedda.games.scheisse.savegame;

import org.dedda.games.scheisse.npc.npc.NPC;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.quest.Quest;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Created by dedda on 8/1/15.
 *
 * @author dedda
 */
public class SaveGame {

    private Player player;

    private List<Quest> quests;

    private List<NPC> npcs;

    public SaveGame() {
        player = new Player(true);
    }

    public void placeNPC(final NPC npc, final Point map, final Point2D.Double location) {
        if (npcs.parallelStream().filter(n -> n.getId() == npc.getId()).count() == 0) {
            npc.setMap(map);
            npc.setLocation(location);
            npcs.add(npc);
        } else {
            npcs.parallelStream().filter(n -> n.getId() == npc.getId()).forEach(n -> {n.setMap(map); n.setLocation(location);});
        }
    }

    public Player getPlayer() {
        return player;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }
}
