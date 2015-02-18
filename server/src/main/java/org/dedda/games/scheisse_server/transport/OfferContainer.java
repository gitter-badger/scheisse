package org.dedda.games.scheisse_server.transport;

public class OfferContainer {

    public final long id;
    public final long userId;
    public final long itemId;
    public final long amount;
    public final long price;
    public final long buy;              //true: buying mode | false: selling mode

    public OfferContainer(long id, long userId, long itemId, long amount, long price, long buy) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.amount = amount;
        this.price = price;
        this.buy = buy;
    }

}
