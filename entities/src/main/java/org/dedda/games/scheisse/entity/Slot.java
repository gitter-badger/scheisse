package org.dedda.games.scheisse.entity;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.Stackable;

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
     * slot id.
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
     * item amount.
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
     * {@link org.dedda.games.scheisse.entity.Inventory} this slot belongs to.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory")
    private Inventory inventory;

    /**
     * contained item.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item")
    private Item item;

    /*====================
     * METHODS
     ====================*/

    public final boolean canAdd(final Item item, final long amount) {
        if (null == item) {
            throw new IllegalArgumentException("item is null");
        }
        if (amount < 1) {
            throw new IllegalArgumentException("amount < 1");
        }
        return maxAddAmount(item) >= amount;
    }

    public final long maxAddAmount(final Item item) {
        if (null == item) {
            throw new IllegalArgumentException("item is null");
        }
        if (getItem().getId() == item.getId()) {
            if (item instanceof Stackable) {
                return ((Stackable) item).maxStackNumber() - getAmount();
            }
            return getAmount() == 0 ? 1 : 0;
        }
        return 0;
    }

    /**
     * @param item item to remove
     * @param amount amount of items to remove
     * @return amount of items actually removed
     */
    public final long remove(final Item item, final long amount) {
        if (null == item) {
            throw new IllegalArgumentException("item is null");
        }
        if (null == getItem()) {
            return 0;
        }
        long removed = 0;
        if (getItem().getId() == item.getId()) {
            setAmount(getAmount() - amount);
            removed = amount > getAmount() ? getAmount() : amount;
            if (getAmount() <= 0) {
                setAmount(0);
                setItem(null);
            }
        }
        return removed;
    }

    /*=================
     * GETTER & SETTER
     =================*/

    /**
     * @return slot id
     */
    public final long getId() {
        return id;
    }

    /**
     * @param id slot id
     */
    public final void setId(final long id) {
        this.id = id;
    }

    /**
     * @return item amount
     */
    public final long getAmount() {
        return amount;
    }

    /**
     * @param amount item amount
     */
    public final void setAmount(final long amount) {
        this.amount = amount;
    }

    public final Inventory getInventory() {
        return inventory;
    }

    public final void setInventory(final Inventory inventory) {
        this.inventory = inventory;
    }

    public final Item getItem() {
        return item;
    }

    public final void setItem(final Item item) {
        this.item = item;
    }

    @Override
    public final long getMinTestId() {
        return -20;
    }

    @Override
    public final long getMaxTestId() {
        return -1;
    }

}
