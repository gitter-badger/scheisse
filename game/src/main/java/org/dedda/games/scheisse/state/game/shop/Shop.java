package org.dedda.games.scheisse.state.game.shop;

import org.dedda.games.scheisse.state.game.shop.filter.ShopFilter;
import org.dedda.games.scheisse.state.game.shop.filter.TypeFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 11/30/14.
 */
public class Shop {

    private ShopConnector connector;

    public Shop() {
        connector = new ShopConnector();
    }

    public List<Offer> getOffers() {
        return connector.getOffers();
    }

    public List<Offer> getOffers(final List<ShopFilter> filters) {
        List<Offer> offers = getOffers();
        for (ShopFilter filter : filters) {
            offers = filter.accept(offers);
        }
        return offers;
    }

}
