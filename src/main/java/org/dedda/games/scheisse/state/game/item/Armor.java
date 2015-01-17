package org.dedda.games.scheisse.state.game.item;

import org.dedda.games.scheisse.state.game.object.Person;

import java.awt.*;

import static org.dedda.games.scheisse.state.game.item.ItemCategory.ARMOR;

/**
 * Created by dedda on 4/18/14.
 */
public class Armor extends Item implements Wearable {

    private final long armor;

    /**
     *
     * @param name String - item name
     * @param value long - item value
     * @param armor long
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

    @Override
    public final boolean equals(final Object object) {
        if(object.getClass().equals(this.getClass())){
            Armor armor = (Armor)object;
            return armor.name.equals(this.name)
                    && armor.value == this.value
                    && armor.armor == this.armor;
        }
        return false;
    }

    public final int maxStackNumber() {
        return 1;
    }

    public void render(final Person person) {

    }

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
