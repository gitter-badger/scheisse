package org.dedda.games.scheisse.savegame;

import org.dedda.games.scheisse.player.Player;
import org.dedda.games.scheisse.world.World;

/**
 * Created by dedda on 8/1/15.
 *
 * @author dedda
 */
public class SaveGame {

    private Player player;

    private World world;

    public SaveGame() {
        player = new Player(true);
    }

    public SaveGame(Player player, World world) {
        this.player = player;
    }

    public SaveGame setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof SaveGame)) {
            return false;
        }
        SaveGame other = (SaveGame) o;
        if (!player.equals(other.player)) {
            return false;
        }
        if (world == null) {
            return other.world == null;
        }
        return world.equals(world);
    }

}
