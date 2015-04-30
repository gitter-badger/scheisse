package org.dedda.games.scheisse.webservice.client;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.service.ItemService;

import java.util.List;

/**
 * @author dedda
 */
public class ItemServiceClient implements ItemService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Item> getAll() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item get(final long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Item> search(final String name) {
        return null;
    }
}
