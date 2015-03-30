package org.dedda.games.scheisse.service.transport;

public class OfferContainer {

    public final long id;
    public final long userId;
    public final long itemId;
    public final long amount;
    public final long price;
    public final long buy;              //true: buying mode | false: selling mode

    public OfferContainer(final long id, final long userId, final long itemId, final long amount, final long price, final long buy) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.amount = amount;
        this.price = price;
        this.buy = buy;
    }

}
