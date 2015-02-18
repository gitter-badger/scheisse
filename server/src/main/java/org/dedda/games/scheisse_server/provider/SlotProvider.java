/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.provider;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.dedda.games.scheisse_server.entity.Inventory;
import org.dedda.games.scheisse_server.entity.Slot;

@Named
@Stateless
public class SlotProvider {
    
    @PersistenceContext(unitName = "org.dedda.games.scheisse_server-PU")
    private EntityManager em;
    
    public Slot getSlot(final long id) {
        Slot slot = null;
        slot = em.find(Slot.class, id);
        return slot;
    }
    
    public List<Slot> getForInventory(final Inventory inventory) {
        TypedQuery<Slot> query = em.createNamedQuery("slot.allForInventory", Slot.class);
        query.setParameter("inventory", inventory);
        List<Slot> slots = query.getResultList();
        return slots;
    }
    
    public List<Slot> getForInventoryId(final long id) {
        TypedQuery<Slot> query = em.createNamedQuery("slot.allForInventoryId", Slot.class);
        query.setParameter("id", id);
        List<Slot> slots = query.getResultList();
        return slots;
    }
    
}
