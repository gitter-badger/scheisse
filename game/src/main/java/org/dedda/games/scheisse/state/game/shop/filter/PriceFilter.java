package org.dedda.games.scheisse.state.game.shop.filter;

import org.dedda.games.scheisse.state.game.shop.Offer;

/**
 * Created by dedda on 11/30/14.
 */
public class PriceFilter extends ShopFilter {

    public final int min;
    public final int max;

    public PriceFilter(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean accept(final Offer offer) {
        return min <= offer.priceSingle && offer.priceSingle <= max;
    }
}
