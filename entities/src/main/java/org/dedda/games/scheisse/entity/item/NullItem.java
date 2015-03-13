package org.dedda.games.scheisse.entity.item;


/**
 * Created by dedda on 5/22/14.
 */
public class NullItem extends Item {

    public NullItem() {
        //super(0, "NULL", 0, ItemCategory.OTHER, null);
        setId(0);
        setName("NULL");
        setPrice(0);
        setCategory(ItemCategory.OTHER);
        setSprite(null);
    }

    public int maxStackNumber() {
        return 1;
    }
}
