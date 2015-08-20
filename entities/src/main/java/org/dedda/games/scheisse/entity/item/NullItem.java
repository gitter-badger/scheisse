package org.dedda.games.scheisse.entity.item;


/**
 * Created by dedda on 5/22/14.
 *
 * @author dedda
 */
public class NullItem extends Item {

    /**
     * Default constructor for
     * {@link org.dedda.games.scheisse.entity.item.NullItem}.
     *
     * @see Item
     */
    public NullItem() {
        setId(0);
        setName("NULL");
        setPrice(0);
        setTypes(TYPE_OTHER);
        setSprite(null);
        setMaxStackAmount(1);
    }

}
