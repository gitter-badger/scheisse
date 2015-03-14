package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.entity.Inventory;
import org.dedda.games.scheisse.server_persistence.InventoryProvider;
import org.dedda.games.scheisse.service.InventoryService;
import org.dedda.games.scheisse.service.transport.InventoryContainer;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.UUID;

@WebService(name = "InventoryService")
public class InventoryServiceHost implements InventoryService {

    @Inject
    private InventoryProvider provider;

    @Override
    @WebMethod(operationName = "getInventory")
    public InventoryContainer get(@WebParam(name = "session")final UUID session) {

        return null;
    }

    @Override
    @WebMethod(operationName = "addItem")
    public void addItem(@WebParam(name = "itemId")final long id, @WebParam(name = "amount")final long amount, @WebParam(name = "session")final UUID session) {

    }

    @Override
    @WebMethod(operationName = "removeItem")
    public void removeItem(@WebParam(name = "itemId")final long id, @WebParam(name = "amount")final long amount, @WebParam(name = "session")final UUID session) {

    }

    @WebMethod(exclude = true)
    public InventoryProvider getProvider() {
        return provider;
    }

    @WebMethod(exclude = true)
    public void setProvider(InventoryProvider provider) {
        this.provider = provider;
    }
}
