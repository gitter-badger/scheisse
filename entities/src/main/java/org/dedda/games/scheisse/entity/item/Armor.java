package org.dedda.games.scheisse.entity.item;

import java.awt.Image;

/**
 * Created by dedda on 4/18/14.
 */
public class Armor extends Item implements Wearable, Stackable {

    /**
     * highest amount of damage that can be absorbed by this item.
     */
    private final long armor;

    /**
     *
     * @param id item id
     * @param name item name
     * @param value item value
     * @param armor highest amount of damage that can be absorbed by this item.
     * @param sprite
     */
    protected Armor(
            final long id,
            final String name,
            final long value,
            final long armor,
            final Image sprite
    ) {
        //super(id, name, value, ARMOR, type, sprite);

        this.armor = armor;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public final int maxStackNumber() {
        return 1;
    }

}
