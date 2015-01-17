package org.dedda.games.scheisse.state.game.item;

import java.awt.*;

import static org.dedda.games.scheisse.state.game.item.ItemType.SHIELD;

/**
 * Created by dedda on 4/18/14.
 */
public class Shield extends Armor implements Wearable, Holdeable {

    /**
     *
     * @param name String - item name
     * @param value long - item value
     * @param armor long
     */
    protected Shield(
            final long id,
            final String name,
            final long value,
            final long armor,
            final Image sprite
    ) {
        super(id, name, value, armor, SHIELD, sprite);
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Shield) {
            Shield shield = (Shield)object;
            return shield.armor == this.armor
                    && shield.value == this.value
                    && shield.name.equals(this.name);
        }
        return false;
    }

    public static Shield register(
            final long id,
            final String name,
            final long value,
            final long armor,
            final Image sprite
    ) {
        return new Shield(id, name, value, armor, sprite);
    }
}
