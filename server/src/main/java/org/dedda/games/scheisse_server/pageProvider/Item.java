/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.pageProvider;

import org.dedda.games.scheisse.server_persistence.ItemProvider;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class Item {
    
    @Inject
    private ItemProvider provider;
    
    @ManagedProperty(value = "#{param.id}")
    private long id;
    
    private org.dedda.games.scheisse.entity.item.Item selected;

    public final ItemProvider getProvider() {
        return provider;
    }

    public final void setProvider(final ItemProvider provider) {
        this.provider = provider;
    }

    public final String show() {
        selected = provider.getItem(id);
        return "item";
    }
    
    public final String show(final long id){
        selected = provider.getItem(id);
        return "item";
    }
    
    public final org.dedda.games.scheisse.entity.item.Item getSelected() {
        return selected;
    }

    public final void setSelected(final org.dedda.games.scheisse.entity.item.Item selected) {
        this.selected = selected;
    }

    public final long getId() {
        return id;
    }

    public final void setId(final long id) {
        this.id = id;
    }

}
