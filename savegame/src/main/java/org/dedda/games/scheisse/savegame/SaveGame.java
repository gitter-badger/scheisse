package org.dedda.games.scheisse.savegame;

import org.dedda.games.scheisse.npc.npc.NPC;
import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.quest.Quest;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
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
        quests = new ArrayList<>();
        npcs = new ArrayList<>();
    }

    public SaveGame(Player player, List<Quest> quests, List<NPC> npcs) {
        this.player = player;
        this.quests = quests;
        this.npcs = npcs;
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

    protected void setPlayer(Player player) {
        this.player = player;
    }

    protected void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    protected void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
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
