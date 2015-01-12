package org.dedda.games.scheisse.gui.cpu.shop;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.filter.ItemComplexFilter;
import org.dedda.games.scheisse.state.game.item.filter.ItemFilter;
import org.dedda.games.scheisse.state.game.shop.ShopConnector;

import static org.dedda.games.scheisse.state.game.shop.ShopConnector.NOT_AVAILABLE;

/**
 * Created by dedda on 12.01.15.
 */
public class ShopSortingFilter extends ItemComplexFilter {

    public final ShopConnector shop;

    public ShopSortingFilter(
            final ShopConnector shop,
            final ItemFilter[] itemFilters,
            final int mode
    ) {
        super(itemFilters, mode);
        this.shop = shop;
    }

    @Override
    public boolean accept(final Item item) {
        if (!super.accept(item)) {
            return false;
        }
        return shop.getBuyingPrice(item.getId()) != NOT_AVAILABLE;
    }

}
