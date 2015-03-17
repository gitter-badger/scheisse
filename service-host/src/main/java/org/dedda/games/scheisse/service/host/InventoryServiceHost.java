package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.entity.Inventory;
import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.server_persistence.InventoryProvider;
import org.dedda.games.scheisse.server_persistence.ItemProvider;
import org.dedda.games.scheisse.service.InventoryService;

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
    public Inventory get(@WebParam(name = "session")final UUID session) {
        User user = loginSessionCache.getForUUID(session);
        if (null == user) {
            return null;
        }
        return user.getInventory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @WebMethod(operationName = "addItem")
    public Inventory addItem(@WebParam(name = "itemId")final long id, @WebParam(name = "amount")final long amount, @WebParam(name = "session")final UUID session) {
        User user = loginSessionCache.getForUUID(session);
        if (null == user) {
            return null;
        }
        Item item = itemProvider.getItem(id);
        Inventory inventory = user.getInventory();
        if (null != item) {
            if (inventory.canAdd(item, amount)) {
                inventory.add(item, amount);
            }
        }
        return inventory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @WebMethod(operationName = "removeItem")
    public Inventory removeItem(@WebParam(name = "itemId")final long id, @WebParam(name = "amount")final long amount, @WebParam(name = "session")final UUID session) {
        User user = loginSessionCache.getForUUID(session);
        if (null == user) {
            return null;
        }
        Item item = itemProvider.getItem(id);
        Inventory inventory = user.getInventory();
        if (null == item) {
            return inventory;
        }
        inventory.remove(item, amount);
        return inventory;
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
    public void setLoginSessionCache(final LoginSessionCache loginSessionCache) {
        this.loginSessionCache = loginSessionCache;
    }
}
