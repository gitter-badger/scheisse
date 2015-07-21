/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.entity;

import org.dedda.games.scheisse.entity.item.Item;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author dedda
 */
@javax.persistence.Entity
@Table(name = "inventory")
public class Inventory extends Entity implements TestableEntity {

    /**
     * id of the inventory.
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
     * number of available {@link org.dedda.games.scheisse.entity.Slot}s.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
        name = "size",
        nullable = false
    )
    private long size;

    /**
     * owner of the inventory.
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    /**
     * {@link org.dedda.games.scheisse.entity.Slot}s containing items.
     */
    @OneToMany(
        mappedBy = "inventory",
        fetch = FetchType.EAGER
    )
    private List<Slot> slots;

    /*========================
     * METHODS
     ========================*/

    /**
     * checks if enough free space is available for specific
     * {@link org.dedda.games.scheisse.entity.item.Item}s.
     *
     * @param item   {@link org.dedda.games.scheisse.entity.item.Item} to add
     * @param amount amount of
     *               {@link org.dedda.games.scheisse.entity.item.Item}s to add
     * @return self explaining
     */
    public final boolean canAdd(final Item item, final long amount) {
        long free = 0;
        for (Slot slot : slots) {
            free += slot.maxAddAmount(item);
            if (free >= amount) {
                return true;
            }
        }
        return false;
    }

    /**
     * adds {@link org.dedda.games.scheisse.entity.item.Item}s to the
     * {@link org.dedda.games.scheisse.entity.Inventory}.
     * <p/>
     * checks if {@link org.dedda.games.scheisse.entity.item.Item}s fit in the
     * {@link org.dedda.games.scheisse.entity.Inventory} and adds them to the
     * right {@link org.dedda.games.scheisse.entity.Slot}s.
     *
     * @param item   {@link Item} to add
     * @param amount amount of items to add
     * @see Item
     */
    public final void add(final Item item, final long amount) {
        if (!canAdd(item, amount)) {
            return;
        }
        long remaining = amount;
        for (Slot slot : slots) {
            long maxAddAmount = slot.maxAddAmount(item);
            if (maxAddAmount > remaining) {
                maxAddAmount = remaining;
            }
            if (slot.getItem() == null) {
                slot.setItem(item);
            }
            slot.setAmount(slot.getAmount() + maxAddAmount);
            remaining -= maxAddAmount;
            if (remaining == 0) {
                break;
            }
        }
    }

    /**
     * @param item item to search for
     * @return amount of items of this type
     */
    public final long contains(final Item item) {
        if (null == item) {
            throw new IllegalArgumentException("item is null");
        }
        long amount = slots.stream().parallel().mapToLong(
            slot -> {if (slot.getItem() != null && slot.getItem().getId() == item.getId()) {
                return slot.getAmount();
            }
                return 0;
        }).sum();
        return amount;
    }

    /**
     * @param item   item to search and remove
     * @param amount amount of items to remove
     * @return amount of items actually removed
     */
    public final long remove(final Item item, final long amount) {
        long removed = 0;
        for (Slot slot : slots) {
            removed += slot.remove(item, amount - removed);
        }
        return removed;
    }

    /*==================*
     * GETTER & SETTER
     *==================*/

    /**
     * {@inheritDoc}
     */
    @Override
    public final long getId() {
        return id;
    }

    /**
     * @param id id of the inventory
     */
    public final void setId(final long id) {
        this.id = id;
    }

    /**
     * @return number of available
     * {@link org.dedda.games.scheisse.entity.Slot}s
     */
    public final long getSize() {
        return size;
    }

    /**
     * @param size number of available
     *             {@link org.dedda.games.scheisse.entity.Slot}s
     */
    public final void setSize(final long size) {
        this.size = size;
    }

    /**
     * @return owner of the inventory
     * @see User
     */
    public final User getUser() {
        return user;
    }

    /**
     * @param user owner of the inventory
     * @see User
     */
    public final void setUser(final User user) {
        this.user = user;
    }

    /**
     * @return {@link org.dedda.games.scheisse.entity.Slot}s containing items
     * @see List
     * @see Slot
     */
    public final List<Slot> getSlots() {
        return slots;
    }

    /**
     * @param slots {@link org.dedda.games.scheisse.entity.Slot}s
     *              containing items
     * @see List
     * @see Slot
     */
    public final void setSlots(final List<Slot> slots) {
        this.slots = slots;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final long getMinTestId() {
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final long getMaxTestId() {
        return -1;
    }

}
