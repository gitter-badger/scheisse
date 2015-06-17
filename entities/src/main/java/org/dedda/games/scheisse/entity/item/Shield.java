package org.dedda.games.scheisse.entity.item;

import java.awt.Image;

/**
 * Created by dedda on 4/18/14.
 *
 * @author dedda
 */
public class Shield extends Armor implements Wearable, Holdeable {

    /**
     * @param id     item id
     * @param name   item name
     * @param value  item value
     * @param armor  max armor
     * @param sprite sprite for rendering
     * @see #id
     * @see #name
     * @see #price
     * @see #armor
     * @see #sprite
     */
    protected Shield(
        final long id,
        final String name,
        final long value,
        final long armor,
        final int types,
        final Image sprite
    ) {
        super(id, name, value, armor, types | TYPE_SHIELD, sprite);
    }

    /**
     * @param id     item id
     * @param name   item name
     * @param value  item value
     * @param armor  max armor
     * @param sprite sprite for rendering
     * @return registered {@link org.dedda.games.scheisse.entity.item.Shield}
     * @see #id
     * @see #name
     * @see #price
     * @see #armor
     * @see #sprite
     */
    public static Shield register(
        final long id,
        final String name,
        final long value,
        final long armor,
        final int types,
        final Image sprite
    ) {
        return new Shield(id, name, value, armor, types, sprite);
    }
}
