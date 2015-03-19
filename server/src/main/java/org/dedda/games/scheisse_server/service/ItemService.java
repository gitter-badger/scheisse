/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.service;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.server_persistence.ItemProvider;
import org.dedda.games.scheisse_server.transport.ItemContainer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 *
 * @author dedda
 */
@WebService(serviceName = "ItemService")
@Stateless
@Named
public class ItemService {

    @Inject
    private ItemProvider itemProvider;
    
    @WebMethod(operationName = "getItem")
    public final ItemContainer getItem(@WebParam(name = "id") final long id) {
        return new ItemContainer(itemProvider.getItem(id));
    }
    
    @WebMethod(operationName = "getAllItems")
    public final ItemContainer[] getAllItems() {
        List<Item> items = itemProvider.getAllItems();
        ItemContainer[] containers = new ItemContainer[items.size()];
        for (int i = 0; i < items.size(); i++) {
            containers[i] = new ItemContainer(items.get(i));
        }
        return containers;
    }

    @WebMethod(exclude = true)
    public final ItemProvider getItemProvider() {
        return itemProvider;
    }

    @WebMethod(exclude = true)
    public final void setItemProvider(final ItemProvider itemProvider) {
        this.itemProvider = itemProvider;
    }
    
}
