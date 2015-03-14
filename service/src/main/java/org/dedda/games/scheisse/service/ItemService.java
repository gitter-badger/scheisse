package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.service.transport.ItemContainer;

import java.util.List;

/**
 * Created by dedda on 3/13/15.
 */
public interface ItemService {

    public List<ItemContainer> getAll();

    public ItemContainer get(final long id);

    public List<ItemContainer> search(final String name);

}
