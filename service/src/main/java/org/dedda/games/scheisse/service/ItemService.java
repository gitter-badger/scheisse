package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.service.transport.ItemContainer;

import java.util.Collection;

/**
 * Created by dedda on 3/13/15.
 */
public interface ItemService {

    public Collection<ItemContainer> getAll();

    public ItemContainer get(final long id);

}
