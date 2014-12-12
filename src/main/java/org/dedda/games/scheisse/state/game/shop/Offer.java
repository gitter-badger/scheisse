package org.dedda.games.scheisse.state.game.shop;

/**
 * Created by dedda on 25.11.14.
 */
public class Offer {

    /**
     * Id of the offered {@link org.dedda.games.scheisse.state.game.item.Item}.
     * This id can be used to get the item from the
     * {@link org.dedda.games.scheisse.state.game.item.Item} class.
     *
     * @see org.dedda.games.scheisse.state.game.item.Item#itemForId(long)
     */
    public final long itemId;

    /**
     * Number of {@link org.dedda.games.scheisse.state.game.item.Item}s
     * being available.
     */
    public final long amountAvailable;

    /**
     * Price for a single instance of the
     * {@link org.dedda.games.scheisse.state.game.item.Item}.
     */
    public final long priceSingle;

    public Offer(final long itemId, final long amountAvailable, final long priceSingle) {
        this.itemId = itemId;
        this.amountAvailable = amountAvailable;
        this.priceSingle = priceSingle;
    }

}
