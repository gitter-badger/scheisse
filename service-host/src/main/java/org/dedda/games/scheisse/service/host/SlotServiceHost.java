package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.service.SlotService;
import org.dedda.games.scheisse.service.transport.SlotContainer;

import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public class SlotServiceHost implements SlotService {
    @Override
    public SlotContainer get(int number, UUID session) {
        return null;
    }

    @Override
    public void empty(int number, UUID session) {

    }
}
