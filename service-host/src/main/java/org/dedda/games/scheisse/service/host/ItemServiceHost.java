package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.server_persistence.ItemProvider;
import org.dedda.games.scheisse.service.ItemService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "ItemService")
public class ItemServiceHost implements ItemService {

    @Inject
    private ItemProvider provider;

    @Override
    @WebMethod(operationName = "getAllItems")
    public List<Item> getAll() {
        return provider.getAllItems();
    }

    @Override
    @WebMethod(operationName = "getById")
    public Item get(@WebParam(name = "id") final long id) {
        return provider.getItem(id);
    }

    @Override
    @WebMethod(operationName = "searchItem")
    public List<Item> search(@WebParam(name = "name") final String name) {
        return provider.search(name);
    }

    @WebMethod(exclude = true)
    public ItemProvider getProvider() {
        return provider;
    }

    @WebMethod(exclude = true)
    public void setProvider(final ItemProvider provider) {
        this.provider = provider;
    }
}
