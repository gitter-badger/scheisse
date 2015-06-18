package org.dedda.games.scheisse.entity.item;

import java.awt.Image;

/**
 * Created by dedda on 4/18/14.
 *
 * @author dedda
 */
public class Armor extends Item implements Wearable {

    /**
     * highest amount of damage that can be absorbed by this item.
     */
    private final long armor;

    /**
     * @param id     item id
     * @param name   item name
     * @param value  item value
     * @param armor  highest amount of damage that can be absorbed by this item.
     * @param sprite sprite for rendering
     */
    protected Armor(
        final long id,
        final String name,
        final long value,
        final long armor,
        final int types,
        final Image sprite
    ) {
        super(id, name, value, types | TYPE_ARMOR, sprite);
        this.armor = armor;
        setMaxStackAmount(1);
    }

    public static Armor register(
        final long id,
        final String name,
        final long value,
        final long armor,
        final int types,
        final Image sprite
    ) {
        return new Armor(id, name, value, armor, types, sprite);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(this.getClass())) {
            Armor armor = (Armor) object;
            return armor.getName().equals(this.getName())
                && armor.getPrice() == this.getPrice()
                && armor.armor == this.armor;
        }
        return false;
    }

}
