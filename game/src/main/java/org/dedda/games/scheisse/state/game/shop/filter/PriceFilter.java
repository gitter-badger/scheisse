package org.dedda.games.scheisse.state.game.shop.filter;

import org.dedda.games.scheisse.state.game.shop.Offer;

/**
 * Created by dedda on 11/30/14.
 */
public class PriceFilter extends ShopFilter{

    public final int min;
    public final int max;

    public PriceFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean accept(Offer offer) {
        return min <= offer.priceSingle && offer.priceSingle <= max;
    }
}
