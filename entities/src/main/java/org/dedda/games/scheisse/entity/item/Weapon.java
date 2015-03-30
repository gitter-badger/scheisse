package org.dedda.games.scheisse.entity.item;

import java.awt.Image;

/**
 * Created by dedda on 4/18/14.
 * @author dedda
 */
public class Weapon extends Item implements Wearable, Holdeable {

    /**
     * @param id item id
     * @param name item name
     * @param value item value
     * @param attack max attack damage
     * @param sprite sprite for rendering
     *
     * @see #id
     * @see #name
     * @see #price
     * @see #attack
     * @see #sprite
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
    public final boolean equals(final Object object) {
        if (!super.equals(object)) {
            return false;
        }
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
     * @param id item id
     * @param name item name
     * @param value item value
     * @param attack max attack damage
     * @param sprite sprite for rendering
     * @return registered {@link org.dedda.games.scheisse.entity.item.Weapon}
     *
     * @see #id
     * @see #name
     * @see #price
     * @see #attack
     * @see #sprite
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
