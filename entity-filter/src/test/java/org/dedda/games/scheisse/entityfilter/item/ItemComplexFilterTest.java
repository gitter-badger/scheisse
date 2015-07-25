package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.games.scheisse.entityfilter.item.ItemComplexFilter.MODE_ALL;
import static org.dedda.games.scheisse.entityfilter.item.ItemComplexFilter.MODE_NONE;
import static org.dedda.games.scheisse.entityfilter.item.ItemComplexFilter.MODE_ONE;
import static org.dedda.games.scheisse.entityfilter.item.ItemComplexFilter.MODE_ONE_OR_MORE;
import static org.junit.Assert.*;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class ItemComplexFilterTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new boolean[]{false, false, false}, MODE_NONE, true},
            {new boolean[]{false, true, false}, MODE_NONE, false},
            {new boolean[]{false, true, false}, MODE_ONE, true},
            {new boolean[]{false, false, false}, MODE_ONE, false},
            {new boolean[]{true, false, true}, MODE_ONE, false},
            {new boolean[]{false, true, false}, MODE_ONE_OR_MORE, true},
            {new boolean[]{false, false, false}, MODE_ONE_OR_MORE, false},
            {new boolean[]{true, false, true}, MODE_ONE_OR_MORE, true},
            {new boolean[]{false, true, false}, MODE_ALL, false},
            {new boolean[]{false, false, false}, MODE_ALL, false},
            {new boolean[]{true, true, true}, MODE_ALL, true},
        });
    }

    public final Item item = new Item();

    @Parameter(value = 0)
    public boolean[] acceptSub;

    @Parameter(value = 1)
    public int strategy;

    @Parameter(value = 2)
    public boolean accept;

    @Test
    public void testAccept() throws Exception {
        ItemFilter[] filters = new ItemFilter[3];
        for (int i = 0; i < filters.length; i++) {
            final int current = i;
            filters[i] = new ItemFilter() {
                @Override
                public boolean accept(Item item) {
                    return acceptSub[current];
                }
            };
        }
        ItemComplexFilter filter = new ItemComplexFilter(filters, strategy);
        boolean actual = filter.accept(item);
        assertEquals(accept, actual);
    }
}
