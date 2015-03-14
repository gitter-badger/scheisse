package org.dedda.games.scheisse.service;

import org.dedda.games.scheisse.service.transport.SlotContainer;

import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public interface SlotService {

    public SlotContainer get(final int number, final UUID session);

    public void empty(final int number, final UUID session);

}
