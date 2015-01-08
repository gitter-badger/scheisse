package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;

/**
 * Created by dedda on 08.01.15.
 */
public class ItemNameFilter extends ItemFilter {

    public static final int MODE_CONTAINS = 0;
    public static final int MODE_COMPLETE = 1;
    public static final boolean CASE_INSENSITIVE = false;
    public static final boolean CASE_SENSITIVE = true;

    private final String name;
    private final int mode;
    private final boolean caseSensitive;

    public ItemNameFilter(String name, int mode, boolean caseSensitive) {
        this.name = name;
        this.mode = mode;
        this.caseSensitive = caseSensitive;
    }

    @Override
    public boolean accept(Item item) {
        String expected = name;
        String actual = item.getName();
        if (caseSensitive == CASE_INSENSITIVE) {
            expected = expected.toLowerCase();
            actual = actual.toLowerCase();
        }
        switch (mode) {
            case MODE_CONTAINS: return actual.contains(expected);
            case MODE_COMPLETE: return actual.equals(expected);
        }
        return false;
    }
}
