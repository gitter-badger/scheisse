/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.pageProvider;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.server_persistence.ItemProvider;

import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
@Stateful
public class ItemList {
    
    @Inject
    private ItemProvider provider;

    public final List<Item> getItems() {
        return provider.getAllItems();
    }

    public final ItemProvider getProvider() {
        return provider;        
    }

    public final void setProvider(final ItemProvider provider) {
        this.provider = provider;
    }
    
}
