package org.dedda.games.scheisse.entity;

import org.dedda.games.scheisse.entity.item.Item;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dedda
 */
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

    /**
     * slot id
     */
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

    /**
     * item amount
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "amount",
            nullable = false,
            unique = false
    )
    private long amount;

    /**
     * {@link org.dedda.games.scheisse.entity.Inventory} this slot belongs to
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory")
    private Inventory inventory;

    /**
     * contained item
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item")
    private Item item;

    /**
     * @return slot id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id slot id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return item amount
     */
    public long getAmount() {
        return amount;
    }

    /**
     * @param amount item amount
     */
    public void setAmount(final long amount) {
        this.amount = amount;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(final Inventory inventory) {
        this.inventory = inventory;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(final Item item) {
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
