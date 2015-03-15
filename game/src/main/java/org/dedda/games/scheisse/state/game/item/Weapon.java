package org.dedda.games.scheisse.state.game.item;

import org.dedda.games.scheisse.state.game.object.Person;

import java.awt.*;

import static org.dedda.games.scheisse.state.game.item.ItemType.WEAPON;

/**
 * Created by dedda on 4/18/14.
 */
public class Weapon extends Item implements Wearable, Holdeable {

    protected final long attack;

    /**
     *
     * @param name String - item name
     * @param value long - item value
     * @param attack long
     */
    protected Weapon(
            final long id,
            final String name,
            final long value,
            final long attack,
            final Image sprite
    ) {
        super(id, name, value, ItemCategory.WEAPPON, WEAPON, sprite);
        this.attack = attack;
    }

    /**
     *
     * @return long
     */
    public long getAttack() {
        return attack;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Weapon) {
            Weapon weapon = (Weapon) object;
            return weapon.getName().equals(this.getName())
                    && weapon.value == this.value
                    && weapon.attack == this.attack;
        }
        return false;
    }

    public int maxStackNumber() {
        return 1;
    }

    public void render(final Person person) {

    }

    /**
     * Creates a new {@link Weapon} item and takes care of possible errors.
     * @param id
     * @param name
     * @param value
     * @param attack
     * @param sprite
     * @return
     */
    public static Weapon register(
            final long id,
            final String name,
            final long value,
            final long attack,
            final Image sprite
    ) {
        return new Weapon(id, name, value, attack, sprite);
    }

}
