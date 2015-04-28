/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.server_persistence;

import org.dedda.games.scheisse.entity.Inventory;
import org.dedda.games.scheisse.entity.Slot;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
@Stateless
public class SlotProvider {

    @PersistenceContext(unitName = "org.dedda.games.scheisse_server-PU")
    private EntityManager em;

    public final Slot getSlot(final long id) {
        Slot slot = null;
        slot = em.find(Slot.class, id);
        return slot;
    }

    public final List<Slot> getForInventory(final Inventory inventory) {
        TypedQuery<Slot> query = em.createNamedQuery("slot.allForInventory", Slot.class);
        query.setParameter("inventory", inventory);
        List<Slot> slots = query.getResultList();
        return slots;
    }

    public final List<Slot> getForInventoryId(final long id) {
        TypedQuery<Slot> query = em.createNamedQuery("slot.allForInventoryId", Slot.class);
        query.setParameter("id", id);
        List<Slot> slots = query.getResultList();
        return slots;
    }

}
