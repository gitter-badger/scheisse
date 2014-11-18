package org.dedda.games.scheisse.state.game.item;

import static org.dedda.games.scheisse.state.game.item.ItemType.NULL;

/**
 * Created by dedda on 5/22/14.
 */
public class NullItem extends Item{

    public NullItem() {
        super("Null", "", 0, ItemCategory.OTHER, NULL);
    }

    public int maxStackNumber() {
        return 1;
    }
}
