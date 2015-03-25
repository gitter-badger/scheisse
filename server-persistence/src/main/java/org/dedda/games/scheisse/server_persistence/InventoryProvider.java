/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.server_persistence;

import org.dedda.games.scheisse.entity.Inventory;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class InventoryProvider {
    
    @PersistenceContext(unitName = "org.dedda.games.scheisse_server-PU")
    private EntityManager em;

    public final Inventory get(final long id) {
        Inventory inventory = null;
        inventory = em.find(Inventory.class, id);
        return inventory;
    }

    public final EntityManager getEm() {
        return em;
    }

    public final void setEm(final EntityManager em) {
        this.em = em;
    }
}
