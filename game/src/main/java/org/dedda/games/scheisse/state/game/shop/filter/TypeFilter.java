package org.dedda.games.scheisse.state.game.shop.filter;

import org.dedda.games.scheisse.state.game.shop.Offer;

/**
 * Created by dedda on 12/1/14.
 */
public class TypeFilter extends ShopFilter {

    @Override
    public boolean accept(Offer offer) {
        return false;
    }
}
