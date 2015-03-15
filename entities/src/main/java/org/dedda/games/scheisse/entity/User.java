/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dedda
 */
@javax.persistence.Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(
                name = "user.getAll",
                query = "SELECT u FROM User u"
        ),
        @NamedQuery(
                name = "user.getByName",
                query = "SELECT u FROM User u WHERE u.name = :name"
        ),
        @NamedQuery(
                name = "user.getAllNames",
                query = "SELECT u.name FROM User u"
        ),
        @NamedQuery(
                name = "user.getByMail",
                query = "SELECT u FROM User u WHERE u.email = :email"
        )
})
public class User extends Entity implements TestableEntity {
    
    @Id
    @NotNull
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false,
            unique = true
    )
    private Long id;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "username",
            nullable = false,
            unique = true
    )
    private String name;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "passwordHash",
            nullable = false
    )
    private String passwordHash;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "experience",
            nullable = false
    )
    private long experience;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Inventory inventory;
    
    /*==========================*
     * GETTER & SETTER
     *==========================*/
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public long getExperience() {
        return experience;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setExperience(final long experience) {
        this.experience = experience;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(final Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(final Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.dedda.games.scheisse_server.entity.User[ id=" + id + " ]";
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
