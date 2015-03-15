/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author dedda
 */
@javax.persistence.Entity
@Table(name = "inventory")
public class Inventory extends Entity implements TestableEntity {

    /**
     * id of the inventory
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
     * number of available {@link org.dedda.games.scheisse.entity.Slot}s
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "size",
            nullable = false
    )
    private long size;

    /**
     * owner of the inventory
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    /**
     * {@link org.dedda.games.scheisse.entity.Slot}s containing items
     */
    @OneToMany(
            mappedBy = "inventory",
            fetch = FetchType.EAGER
    )
    private List<Slot> slots;
    
    /*==================*
     * GETTER & SETTER
     *==================*/

    /**
     * @return id of the inventory
     */
    public long getId() {
        return id;
    }

    /**
     * @param id id of the inventory
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return number of available {@link org.dedda.games.scheisse.entity.Slot}s
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size number of available {@link org.dedda.games.scheisse.entity.Slot}s
     */
    public void setSize(final long size) {
        this.size = size;
    }

    /**
     * @return owner of the inventory
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user owner of the inventory
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * @return {@link org.dedda.games.scheisse.entity.Slot}s containing items
     */
    public List<Slot> getSlots() {
        return slots;
    }

    /**
     * @param slots {@link org.dedda.games.scheisse.entity.Slot}s containing items
     */
    public void setSlots(final List<Slot> slots) {
        this.slots = slots;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getMinTestId() {
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getMaxTestId() {
        return -1;
    }
    
}
