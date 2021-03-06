package org.dedda.games.scheisse.state.game.shop;

import org.dedda.games.scheisse.entity.item.ItemType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dedda on 25.11.14.
 */
public class ShopConnector {

    public static final long NOT_AVAILABLE = -1;

    public List<Offer> getOffers() {
        LinkedList<Offer> offers = new LinkedList<Offer>();

        return offers;
    }

    public List<Offer> getOffers(final ItemType itemType) {
        LinkedList<Offer> offers = new LinkedList<Offer>();

        return offers;
    }

    public long getSellingPrice(final long itemId) {
        return 0;
    }

    public long getBuyingPrice(final long itemId) {
        return 0;
    }

    /**
     * Telling the server, something was sold and returns the money you get.
     *
     * @param itemId id of the item to sell
     * @param number number of items to sell
     * @return amount of money you get
     */
    public long sell(final long itemId, final long number) {
        throw new UnsupportedOperationException();
    }

    /**
     * Telling the server, you bought something and returns the price to pay.
     *
     * @param itemId id of the item you bought
     * @param number number of items you bought
     * @return price to pay
     */
    public long buy(final long itemId, final long number) {
        throw new UnsupportedOperationException();
    }

}
