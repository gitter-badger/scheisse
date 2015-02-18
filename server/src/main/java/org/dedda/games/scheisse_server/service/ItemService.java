/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.service;

import java.util.LinkedList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.dedda.games.scheisse_server.entity.Item;
import org.dedda.games.scheisse_server.provider.ItemProvider;
import org.dedda.games.scheisse_server.transport.ItemContainer;

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
    public ItemContainer getItem(@WebParam(name = "id") final long id) {
        return new ItemContainer(itemProvider.getItem(id));
    }
    
    @WebMethod(operationName = "getAllItems")
    public ItemContainer[] getAllItems() {
        List<Item> items = itemProvider.getAllItems();
        ItemContainer[] containers = new ItemContainer[items.size()];
        for (int i = 0; i < items.size(); i++) {
            containers[i] = new ItemContainer(items.get(i));
        }
        return containers;
    }
    
    @WebMethod(operationName = "getItems")
    public ItemContainer[] getItems(@WebParam(name = "type") final String type) {
        List<Item> items = itemProvider.getItems(type);
        ItemContainer[] containers = new ItemContainer[items.size()];
        for (int i = 0; i < items.size(); i++) {
            containers[i] = new ItemContainer(items.get(i));
        }
        return containers;
    }

    @WebMethod(exclude = true)
    public ItemProvider getItemProvider() {
        return itemProvider;
    }

    @WebMethod(exclude = true)
    public void setItemProvider(ItemProvider itemProvider) {
        this.itemProvider = itemProvider;
    }
    
}