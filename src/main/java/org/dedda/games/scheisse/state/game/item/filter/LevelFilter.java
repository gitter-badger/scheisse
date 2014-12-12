package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;

/**
 * Created by dedda on 10/11/14.
 */
public class LevelFilter extends ItemFilter{

    private long level;

    public LevelFilter(final long level) {
        this.level = level;
    }

    @Override
    public boolean accept(final Item item) {
        return item.getMinLevel() <= level;
    }

}
