/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.pageProvider;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.dedda.games.scheisse_server.provider.ItemProvider;
import org.dedda.games.scheisse_server.entity.Item;

@ManagedBean
@SessionScoped
@Stateful
public class ItemList {
    
    @Inject
    private ItemProvider provider;

    public List<Item> getItems() {
        return provider.getAllItems();
    }

    public ItemProvider getProvider() {
        return provider;        
    }

    public void setProvider(ItemProvider provider) {
        this.provider = provider;
    }
    
}
