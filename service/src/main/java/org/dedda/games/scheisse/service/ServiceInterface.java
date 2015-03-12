package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.service.transport.EntityContainer;
import org.dedda.games.scheisse.service.transport.EntityType;

/**
 * Created by dedda on 3/12/15.
 */
public interface ServiceInterface {

    public EntityContainer get(final EntityType type, final long id);

    public void post(final EntityContainer container);

}
