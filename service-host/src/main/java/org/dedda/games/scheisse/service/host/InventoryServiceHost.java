package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.entity.Inventory;
import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.server_persistence.InventoryProvider;
import org.dedda.games.scheisse.server_persistence.ItemProvider;
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

    @Inject
    private ItemProvider itemProvider;

    @Inject
    private LoginSessionCache loginSessionCache;

    /**
     * {@inheritDoc}
     */
    @Override
    @WebMethod(operationName = "getInventory")
    public InventoryContainer get(@WebParam(name = "session")final UUID session) {
        User user = loginSessionCache.getForUUID(session);
        if (null == user) {
            return null;
        }
        return InventoryContainer.convert(user.getInventory());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @WebMethod(operationName = "addItem")
    public void addItem(@WebParam(name = "itemId")final long id, @WebParam(name = "amount")final long amount, @WebParam(name = "session")final UUID session) {
        User user = loginSessionCache.getForUUID(session);
        if (null == user) {
            return;
        }
        Item item = itemProvider.getItem(id);
        if (null == item) {
            return;
        }
        Inventory inventory = user.getInventory();
        if (inventory.canAdd(item, amount)) {
            inventory.add(item, amount);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @WebMethod(operationName = "removeItem")
    public long removeItem(@WebParam(name = "itemId")final long id, @WebParam(name = "amount")final long amount, @WebParam(name = "session")final UUID session) {
        User user = loginSessionCache.getForUUID(session);
        if (null == user) {
            return 0;
        }
        Item item = itemProvider.getItem(id);
        if (null == item) {
            return 0;
        }
        Inventory inventory = user.getInventory();
        return inventory.remove(item, amount);
    }

    @WebMethod(exclude = true)
    public InventoryProvider getProvider() {
        return provider;
    }

    @WebMethod(exclude = true)
    public void setProvider(final InventoryProvider provider) {
        this.provider = provider;
    }

    @WebMethod(exclude = true)
    public LoginSessionCache getLoginSessionCache() {
        return loginSessionCache;
    }

    @WebMethod(exclude = true)
    public void setLoginSessionCache(LoginSessionCache loginSessionCache) {
        this.loginSessionCache = loginSessionCache;
    }
}
