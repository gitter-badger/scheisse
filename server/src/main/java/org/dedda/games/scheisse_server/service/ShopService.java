package org.dedda.games.scheisse_server.service;

import org.dedda.games.scheisse_server.transport.ItemFilterContainer;
import org.dedda.games.scheisse_server.transport.OfferContainer;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "ShopService")
@Stateless
@Named
public class ShopService {
    
    @WebMethod(operationName = "getRegularPrice")
    public final long getRegularPrice(@WebParam(name = "id") final long di) {
        return 0;
    }
    
    @WebMethod(operationName = "getAvailableQuantity")
    public final long getAvailableQuantity(@WebParam(name = "id") final long id) {
        return 0;
    }
    
    @WebMethod(operationName = "getAvailableQuantityForPrice")
    public final long getAvailableQuantityForPrice(@WebParam(name = "id") final long id, @WebParam(name = "price") final long price){
        return 0;
    }

    @WebMethod(operationName = "getAvailableOffers")
    public final OfferContainer[] getAvailableOffers() {
        return null;
    }

    @WebMethod(operationName = "getOffersWithFilter")
    public final OfferContainer[] getOffersWithFilter(@WebParam(name = "filter") final ItemFilterContainer filter) {
        return null;
    }

    @WebMethod(operationName = "requestOffer")
    public final boolean requestOffer(@WebParam(name = "offer") final OfferContainer offer) {
        return false;
    }

    @WebMethod(operationName = "getAvailableItems")
    public final long[] getAvailableItems() {
        return null;
    }
    
    @WebMethod(operationName = "sell")
    public final long sell(@WebParam(name = "id") final long id, @WebParam(name = "amount") final long amount, @WebParam(name = "sessionId") final String sessionId) {
        return 0;
    }
    
    @WebMethod(operationName = "buy")
    public final long buy(@WebParam(name = "id") final long id, @WebParam(name = "amount") final long amount, @WebParam(name = "sessionId") final String sessionId) {
        return 0;
    }
    
}
