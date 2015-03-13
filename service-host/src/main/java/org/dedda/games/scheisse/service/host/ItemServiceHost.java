package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.server_persistence.ItemProvider;
import org.dedda.games.scheisse.service.ItemService;
import org.dedda.games.scheisse.service.transport.ItemContainer;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;

@WebService(name = "ItemService")
public class ItemServiceHost implements ItemService {

    @Inject
    private ItemProvider provider;

    @Override
    public Collection<ItemContainer> getAll() {
        return ItemContainer.convert(provider.getAllItems());
    }

    @Override
    public ItemContainer get(long id) {
        return ItemContainer.convert(provider.getItem(id));

    }

    @WebMethod(exclude = true)
    public ItemProvider getProvider() {
        return provider;
    }

    @WebMethod(exclude = true)
    public void setProvider(ItemProvider provider) {
        this.provider = provider;
    }
}
