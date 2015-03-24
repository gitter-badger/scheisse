package org.dedda.games.scheisse.state.game.item;

import java.awt.Image;

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
