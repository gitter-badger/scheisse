package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.entity.item.Item;

import java.util.List;

/**
 * Created by dedda on 3/13/15.
 *
 * @author dedda
 */
public interface ItemService {

    /**
     *
     * @return {@link List} of all {@link Item}s.
     */
    public List<Item> getAll();

    /**
     *
     * @param id id of the requested {@link Item}.
     * @return loaded {@link Item}.
     */
    public Item get(final long id);

    /**
     * Search {@link Item}s by name.
     *
     * @param name {@link String} contained by the name.
     * @return {@link List} of found {@link Item}s.
     */
    public List<Item> search(final String name);

}
