package org.dedda.games.scheisse.state.game;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.state.game.inventory.Inventory;
import org.dedda.games.scheisse.state.game.object.Person;
import org.dedda.games.scheisse.state.game.object.PlayerObject;

/**
 * Created by dedda on 4/18/14.
 */
public class Player extends Person {

    private PlayerObject playerObject;
    private Inventory inventory;

    public Player(final boolean newInstance) {
        playerObject = new PlayerObject();
        this.inventory = new Inventory();
        if (newInstance) {
            initNew();
        }
    }

    private void initNew() {
        experience = 0L;
    }

    /**
     *
     * @return
     */
    public PlayerObject getPlayerObject() {
        return playerObject;
    }

    /**
     *
     * @param playerObject
     */
    public void setPlayerObject(final PlayerObject playerObject) {
        this.playerObject = playerObject;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(final Inventory inventory) {
        this.inventory = inventory;
    }

    public void print() {
        SystemPrinter.debugln("GuiPlayer:");
        SystemPrinter.debugln("name: " + name);
        SystemPrinter.debugln("exp: " + experience);
        SystemPrinter.debugln("map: " + map);
        SystemPrinter.debugln("location: " + location);
        inventory.print();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Player) {
            Player player = (Player)object;
            return player.experience == this.experience
                    && player.inventory.equals(this.inventory)
                    && player.name.equals(this.name)
                    //&& player.playerObject.equals(this.playerObject)
                    ;
        }
        return false;
    }
}
