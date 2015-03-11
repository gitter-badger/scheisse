/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.pageProvider;

import java.util.List;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.dedda.games.scheisse_server.entity.Slot;
import org.dedda.games.scheisse_server.provider.ItemProvider;

@ManagedBean
@RequestScoped
public class Item {
    
    @Inject
    private ItemProvider provider;
    
    @ManagedProperty(value = "#{param.id}")
    private long id;
    
    private org.dedda.games.scheisse_server.entity.Item selected;

    public ItemProvider getProvider() {
        return provider;
    }

    public void setProvider(ItemProvider provider) {
        this.provider = provider;
    }

    public String show() {
        selected = provider.getItem(id);
        return "item";
    }
    
    public String show(final long id){
        selected = provider.getItem(id);
        return "item";
    }
    
    public org.dedda.games.scheisse_server.entity.Item getSelected() {
        return selected;
    }

    public void setSelected(org.dedda.games.scheisse_server.entity.Item selected) {
        this.selected = selected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}