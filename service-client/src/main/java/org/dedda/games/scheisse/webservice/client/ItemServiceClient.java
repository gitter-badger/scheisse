package org.dedda.games.scheisse.webservice.client;

import org.dedda.games.scheisse.service.ItemService;
import org.dedda.games.scheisse.service.transport.ItemContainer;

import java.util.List;

/**
 *
 * @author dedda
 */
public class ItemServiceClient implements ItemService {

    @Override
    public List<ItemContainer> getAll() {
        return null;
    }

    @Override
    public ItemContainer get(final long id) {
        return null;
    }

    @Override
    public List<ItemContainer> search(final String name) {
        return null;
    }
}
