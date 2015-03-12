package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.service.ServiceInterface;
import org.dedda.games.scheisse.service.transport.EntityContainer;
import org.dedda.games.scheisse.service.transport.EntityType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class ServiceHost implements ServiceInterface {

    @WebMethod(operationName = "get")
    public EntityContainer get(@WebParam(name = "type")EntityType type, @WebParam(name = "id")long id) {
        return null;
    }

    @WebMethod(operationName = "post")
    public void post(@WebParam(name = "container")EntityContainer container) {

    }
}
