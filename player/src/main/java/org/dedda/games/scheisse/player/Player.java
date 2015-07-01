package org.dedda.games.scheisse.player;

import org.dedda.games.scheisse.tool.SystemPrinter;
import org.dedda.games.scheisse.fight.Attack;
import org.dedda.games.scheisse.player.inventory.Inventory;
import org.dedda.games.scheisse.npc.Person;
import org.dedda.games.scheisse.npc.PlayerObject;

/**
 * Created by dedda on 4/18/14.
 *
 * @author dedda
 */
public class Player extends Person {

    private PlayerObject playerObject;
    private Inventory inventory;
    private long money;

    public Player(final boolean newInstance) {
        playerObject = new PlayerObject();
        this.inventory = new Inventory();
        money = 0;
        if (newInstance) {
            initNew();
        }
    }

    private void initNew() {
        experience = 0L;
    }

    /**
     * @return {@link PlayerObject}
     * this {@link Player} belongs to
     */
    public PlayerObject getPlayerObject() {
        return playerObject;
    }

    /**
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

    public long getMoney() {
        return money;
    }

    public void setMoney(final long money) {
        this.money = money;
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
    public boolean equals(final Object object) {
        if (object instanceof Player) {
            Player player = (Player) object;
            return player.experience == this.experience
                && player.inventory.equals(this.inventory)
                && player.name.equals(this.name);
        }
        return false;
    }

    @Override
    public void attack(Person person) {

    }

    @Override
    public void getAttacked(Attack attack) {

    }
}
