package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
public class ItemFilterTest {

    @Test
    public void testFilter() throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, "", 0, 0, null));
        items.add(new Item(1, "", 0, 0, null));
        items.add(new Item(2, "", 0, 0, null));
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(items.get(1));
        ItemFilter filter = new ItemFilter() {
            @Override
            public boolean accept(Item item) {
                return item.getId() == 1;
            }
        };
        ArrayList<Item> filtered = filter.filter(items);
        for (Item item : expected) {
            assertTrue(filtered.contains(item));
            filtered.remove(item);
        }
        assertEquals(0, filtered.size());
    }
}
