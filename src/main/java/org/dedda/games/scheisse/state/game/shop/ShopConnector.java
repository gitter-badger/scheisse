
package org.dedda.games.scheisse.state.game.shop;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemType;
import org.dedda.games.scheisseServiceClient.service.ShopServiceClient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dedda on 25.11.14.
 */
public class ShopConnector {

    public List<Offer> getOffers() {
        List<Long> availableIDs = ShopServiceClient.getAvailableItems();
        LinkedList<Offer> offers = new LinkedList<Offer>();
        for (long currentId : availableIDs) {
            long availableAmount = ShopServiceClient.getAvailableQuantity(currentId);
            long price = ShopServiceClient.getBuyingPrice(currentId);
            offers.add(new Offer(currentId, availableAmount, price));
        }
        return offers;
    }

    public List<Offer> getOffers(ItemType itemType) {
        ArrayList<Long> allIDs = new ArrayList<Long>();
        for (long currentId : Item.getItemMap().keySet()) {
            if (Item.itemForId(currentId).getType() == itemType) {
                allIDs.add(currentId);
            }
        }
        LinkedList<Offer> offers = new LinkedList<Offer>();
        for (long currentId : allIDs) {
            long price = getBuyingPrice(currentId);
            if (price >= 0) {
                long amountAvailable = ShopServiceClient.getAvailableQuantity(currentId);
                Offer offer = new Offer(currentId, amountAvailable, price);
            }
        }
        return offers;
    }

    public long getSellingPrice(final long itemId) {
        return ShopServiceClient.getSellingPrice(itemId);
    }

    public long getBuyingPrice(final long itemId) {
        return ShopServiceClient.getBuyingPrice(itemId);
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
