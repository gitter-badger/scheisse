package org.dedda.games.scheisse.entity.item;

import java.awt.Image;

/**
 * Created by dedda on 4/18/14.
 */
public class Weapon extends Item implements Wearable, Holdeable {

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
        setAttack(attack);
        setMaxStackAmount(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Weapon) {
            Weapon weapon = (Weapon) object;
            return weapon.getName().equals(this.getName())
                    && weapon.getPrice() == this.getPrice()
                    && weapon.getAttack() == this.getAttack();
        }
        return false;
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
    public final static Weapon register(
            final long id,
            final String name,
            final long value,
            final long attack,
            final Image sprite
    ) {
        return new Weapon(id, name, value, attack, sprite);
    }

}
