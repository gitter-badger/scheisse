package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.Entity;
import org.dedda.games.scheisse.entity.Slot;

/**
 * Created by dedda on 3/12/15.
 */
public class SlotContainer extends EntityContainer {

    public SlotContainer(Slot slot) {
        super(EntityType.SLOT, slot);
    }

}