package org.dedda.games.scheisse.state.game.item;

import org.dedda.games.scheisse.state.game.object.Person;

import java.awt.*;

import static org.dedda.games.scheisse.state.game.item.ItemCategory.ARMOR;

/**
 * Created by dedda on 4/18/14.
 */
public class Armor extends Item implements Wearable {

    /**
     * highest amount of damage that can be absorbed by this item.
     */
    private final long armor;

    /**
     * @param id item id
     * @param name item name
     * @param value item value
     * @param armor highest amount of damage that can be absorbed by this item.
     * @param type item type
     * @param sprite
     */
    protected Armor(
            final long id,
            final String name,
            final long value,
            final long armor,
            final ItemType type,
            final Image sprite
    ) {
        super(id, name, value, ARMOR, type, sprite);
        this.armor = armor;
    }

    /**
     *
     * @return long
     */
    public final long getArmor() {
        return armor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(this.getClass())) {
            Armor armor = (Armor) object;
            return armor.name.equals(this.name)
                    && armor.value == this.value
                    && armor.armor == this.armor;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public final int maxStackNumber() {
        return 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final Person person) {

    }

    /**
     * @param id item id
     * @param name item name
     * @param value item value
     * @param armor highest amount of damage that can be absorbed by this item.
     * @param type item type
     * @param sprite
     * @return registered armor
     */
    public static Armor register(
            final long id,
            final String name,
            final long value,
            final long armor,
            final ItemType type,
            final Image sprite
    ) {
        return new Armor(id, name, value, armor, type, sprite);
    }
}
