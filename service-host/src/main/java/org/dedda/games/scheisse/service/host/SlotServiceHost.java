package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.server_persistence.SlotProvider;
import org.dedda.games.scheisse.service.SlotService;
import org.dedda.games.scheisse.service.transport.SlotContainer;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.UUID;

/**
 * Created by dedda on 3/13/15.
 */
public class SlotServiceHost implements SlotService {

    @Inject
    private SlotProvider provider;

    @Override
    @WebMethod(operationName = "getByNumberAndSession")
    public SlotContainer get(@WebParam(name = "slotNumber")final int number, @WebParam(name = "session")UUID session) {
        return null;
    }

    @Override
    @WebMethod(operationName = "emptySlot")
    public void empty(@WebParam(name = "slotNumber")final int number, @WebParam(name = "session")final UUID session) {

    }

    @WebMethod(exclude = true)
    public SlotProvider getProvider() {
        return provider;
    }

    @WebMethod(exclude = true)
    public void setProvider(SlotProvider provider) {
        this.provider = provider;
    }
}
