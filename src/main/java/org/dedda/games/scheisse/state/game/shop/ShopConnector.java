package org.dedda.games.scheisse.state.game.shop;

import org.dedda.games.scheisse.state.game.item.ItemType;

import java.util.ArrayList;

/**
 * Created by dedda on 25.11.14.
 */
public class ShopConnector {

    public Offer[] getOffers() {
        throw new UnsupportedOperationException();
    }

    public Offer[] getOffers(ItemType itemType) {
        throw new UnsupportedOperationException();
    }

    public long getSellingPrice(long itemId) {
        throw new UnsupportedOperationException();
    }

    /**
     * Telling the server, something was sold and returns the money you get.
     * @param itemId id of the item to sell
     * @param number number of items to sell
     * @return amount of money you get
     */
    public long sell(long itemId, long number) {
        throw new UnsupportedOperationException();
    }

    /**
     * Telling the server, you bought something and returns the price to pay
     * @param itemId id of the item you bought
     * @param number number of items you bought
     * @return price to pay
     */
    public long buy(long itemId, long number) {
        throw new UnsupportedOperationException();
    }

}
