package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.entity.item.Item;

import java.util.List;

/**
 * Created by dedda on 3/13/15.
 */
public interface ItemService {

    public List<Item> getAll();

    public Item get(final long id);

    public List<Item> search(final String name);

}
