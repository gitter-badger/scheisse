package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.ShopRequest;

/**
 * Created by dedda on 3/12/15.
 */
public class ShopRequestContainer extends EntityContainer {

    public ShopRequestContainer(ShopRequest request) {
        super(EntityType.SHOP_REQUEST, request);
    }
}
