/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.provider;

import org.dedda.games.scheisse.entity.item.Item;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
@Stateless
public class ItemProvider {
    
    @PersistenceContext(unitName = "org.dedda.games.scheisse_server-PU")
    private EntityManager em;
    
    public Item getItem(final long id) {
        Item item = null;
        item = em.find(Item.class, id);
        return item;
    }
    
    public List<Item> getAllItems() {
        TypedQuery<Item> query = em.createNamedQuery("item.getAll", Item.class);
        List<Item> items = query.getResultList();
        return items;
    }
    
    public List<Item> getItems(final String type) {
        TypedQuery<Item> query = em.createNamedQuery("item.getForType", Item.class);
        query.setParameter("type", type);
        List<Item> items = query.getResultList();
        return items;
    }

}
