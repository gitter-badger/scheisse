package org.dedda.games.scheisse.testInstances;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemCategory;
import org.dedda.games.scheisse.state.game.item.ItemType;

/**
 * Created by dedda on 4/30/14.
 */
public class TestItem extends Item {

    public static final String NAME = "test item";
    public static final long VALUE = 1234L;
    public static final int MAX_STACK = 123;

    public TestItem() {
        super("-1", NAME, VALUE, ItemCategory.OTHER, ItemType.OTHER);
    }

    static {
        itemMap.put("-1", new TestItem());
    }

    public int maxStackNumber() {
        return MAX_STACK;
    }

}
