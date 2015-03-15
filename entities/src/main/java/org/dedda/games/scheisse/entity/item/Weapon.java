package org.dedda.games.scheisse.entity.item;

import java.awt.*;

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
        //super(id, name, value, ItemCategory.WEAPPON, WEAPON, sprite);
        setId(id);
        setName(name);
        setPrice(value);
        setCategory(ItemCategory.WEAPPON);
        setSprite(sprite);
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
                    && weapon.getPrice() == this.getPrice()
                    && weapon.attack == this.attack;
        }
        return false;
    }

    public int maxStackNumber() {
        return 1;
    }

    /**
     * Creates a new {@link Weapon} item and takes care of possible errors.
     * @param id
     * @param name
     * @param value
     * @param attack
     * @param sprite
     * @return registered {@link org.dedda.games.scheisse.entity.item.Weapon}
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
