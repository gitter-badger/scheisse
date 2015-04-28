/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.server_persistence;

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
        return em.find(Item.class, id);
    }

    public List<Item> getAllItems() {
        TypedQuery<Item> query = em.createNamedQuery("item.getAll", Item.class);
        return query.getResultList();
    }

    public List<Item> search(final String name) {
        TypedQuery<Item> query = em.createNamedQuery("item.searchByName", Item.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public final EntityManager getEm() {
        return em;
    }

    public final void setEm(EntityManager em) {
        this.em = em;
    }
}
