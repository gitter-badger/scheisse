package org.dedda.games.scheisse.fsloaders.resource.testInstances;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemStore;

/**
 * Created by dedda on 4/30/14.
 *
 * @author dedda
 */
public class TestItem extends Item {

    public static final String NAME = "test item";
    public static final long VALUE = 1234L;
    public static final int MAX_STACK = 123;

    public TestItem() {
        super(-1, NAME, VALUE, Item.TYPE_OTHER, null);
    }

    static {
        ItemStore.getItemMap().put(-1L, new TestItem());
    }

    public int maxStackNumber() {
        return MAX_STACK;
    }

}
