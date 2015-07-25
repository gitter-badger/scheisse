package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.games.scheisse.entity.item.Item.TYPE_BOOTS;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_GLOVES;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_HELMET;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_JACKET;
import static org.dedda.games.scheisse.entityfilter.item.ItemTypeFilter.STRATEGY_ALL;
import static org.dedda.games.scheisse.entityfilter.item.ItemTypeFilter.STRATEGY_NONE;
import static org.dedda.games.scheisse.entityfilter.item.ItemTypeFilter.STRATEGY_SOME;
import static org.junit.Assert.*;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class ItemTypeFilterTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{TYPE_BOOTS, TYPE_GLOVES}, STRATEGY_NONE, false},
            {new int[]{TYPE_BOOTS, TYPE_HELMET}, STRATEGY_NONE, false},
            {new int[]{TYPE_HELMET, TYPE_JACKET}, STRATEGY_NONE, true},
            {new int[]{TYPE_BOOTS, TYPE_GLOVES}, STRATEGY_SOME, true},
            {new int[]{TYPE_BOOTS, TYPE_HELMET}, STRATEGY_SOME, true},
            {new int[]{TYPE_HELMET, TYPE_JACKET}, STRATEGY_SOME, false},
            {new int[]{TYPE_BOOTS, TYPE_GLOVES}, STRATEGY_ALL, true},
            {new int[]{TYPE_BOOTS, TYPE_HELMET}, STRATEGY_ALL, false},
            {new int[]{TYPE_HELMET, TYPE_JACKET}, STRATEGY_ALL, false}
        });
    }

    public final Item item = new Item(0, "", 0, TYPE_BOOTS | TYPE_GLOVES, null);

    @Parameter(value = 0)
    public int[] types;

    @Parameter(value = 1)
    public int strategy;

    @Parameter(value = 2)
    public boolean accept;

    @Test
    public void testAccept() throws Exception {
        ItemTypeFilter filter = new ItemTypeFilter(types, strategy);
        boolean actual = filter.accept(item);
        assertEquals(accept, actual);
    }
}
