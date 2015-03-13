/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.entity;

import org.dedda.games.scheisse.entity.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@javax.persistence.Entity
@Table(name = "slot")
@NamedQueries({
    @NamedQuery(
            name = "slot.allForInventory",
            query = "SELECT s FROM Slot s WHERE s.inventory = :inventory"
    ),
    @NamedQuery(
            name = "slot.allForInventoryId",
            query = "SELECT s FROM Slot s WHERE s.inventory.id = :id"
    )
})
public class Slot extends Entity implements TestableEntity {
    
    @Id
    @NotNull
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false,
            unique = true
    )
    private long id;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "amount",
            nullable = false,
            unique = false
    )
    private long amount;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory")
    private Inventory inventory;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item")
    private Item item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public long getMinTestId() {
        return -20;
    }

    @Override
    public long getMaxTestId() {
        return -1;
    }
    
}
