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
@Entity
@Table(name = "inventory")
public class Inventory implements TestableEntity {
    
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
            name = "size",
            nullable = false
    )
    private long size;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(
            mappedBy = "inventory",
            fetch = FetchType.EAGER
    )
    private List<Slot> slots;
    
    /*==================*
     * GETTER & SETTER
     *==================*/
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public long getMinTestId() {
        return -1;
    }

    @Override
    public long getMaxTestId() {
        return -1;
    }
    
}
