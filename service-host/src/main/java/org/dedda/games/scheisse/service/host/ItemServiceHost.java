package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.service.ServiceInterface;
import org.dedda.games.scheisse.service.transport.EntityType;
import org.dedda.games.scheisse.service.transport.ItemContainer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "ItemService")
@Stateless
@Named
public abstract class ItemServiceHost implements ServiceInterface<ItemContainer> {

    @WebMethod(operationName = "getItem")
    public abstract ItemContainer get(@WebParam(name = "id") final long id);

    @WebMethod(operationName = "getAllItems")
    public abstract List<ItemContainer> all();

    @WebMethod
    public abstract List<ItemContainer> byType(final ItemT);

    @Override
    public void post(ItemContainer container) {

    }
}
