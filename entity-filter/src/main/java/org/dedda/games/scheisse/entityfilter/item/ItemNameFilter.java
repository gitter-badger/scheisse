package org.dedda.games.scheisse.entityfilter.item;

import org.dedda.games.scheisse.entity.item.Item;

/**
 * Created by dedda on 08.01.15.
 *
 * @author dedda
 */
public class ItemNameFilter extends ItemFilter {

    public static final int MODE_CONTAINS = 0;
    public static final int MODE_COMPLETE = 1;
    public static final boolean CASE_INSENSITIVE = false;
    public static final boolean CASE_SENSITIVE = true;

    public final String name;
    public final int mode;
    public final boolean caseSensitive;

    public ItemNameFilter(
        final String name,
        final int mode,
        final boolean caseSensitive
    ) {
        this.name = name;
        this.mode = mode;
        this.caseSensitive = caseSensitive;
    }

    @Override
    public final boolean accept(final Item item) {
        String expected = name;
        String actual = item.getName();
        if (caseSensitive == CASE_INSENSITIVE) {
            expected = expected.toLowerCase();
            actual = actual.toLowerCase();
        }
        switch (mode) {
            case MODE_CONTAINS:
                return actual.contains(expected);
            case MODE_COMPLETE:
                return actual.equals(expected);
            default:
                return false;
        }
    }
}
