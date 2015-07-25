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

import static org.dedda.games.scheisse.entity.item.Item.TYPES_CLOTHING;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_ARMOR;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_DUAL_WEAPON;
import static org.dedda.games.scheisse.entityfilter.item.ItemArmorFilter.MODE_ABOVE;
import static org.dedda.games.scheisse.entityfilter.item.ItemArmorFilter.MODE_EXACT;
import static org.junit.Assert.*;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class ItemArmorFilterTest {

    @Parameters
    public static Collection<Object[]> data() {
        Item item = new Item(0, "", 0, TYPE_DUAL_WEAPON, null);
        item.setArmor(10);
        Item armor = new Item(0, "", 0, TYPE_ARMOR, null);
        armor.setArmor(10);
        return Arrays.asList(new Object[][]{

            {item, MODE_ABOVE, 9, false},
            {item, MODE_ABOVE, 10, false},
            {item, MODE_ABOVE, 11, false},
            {armor, MODE_ABOVE, 9, true},
            {armor, MODE_ABOVE, 10, false},
            {armor, MODE_ABOVE, 11, false}
        });
    }

    @Parameter(value = 0)
    public Item item;

    @Parameter(value = 1)
    public int mode;

    @Parameter(value = 2)
    public long armor;

    @Parameter(value = 3)
    public boolean accept;

    @Test
    public void testAccept() throws Exception {
        ItemArmorFilter filter = new ItemArmorFilter(armor, mode);
        boolean actual = filter.accept(item);
        assertEquals(accept, actual);
    }
}
