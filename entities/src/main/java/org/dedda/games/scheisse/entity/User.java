/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

    /**
     * id in db.
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
    private Long id;

    /**
     * username in game and forum.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "username",
            nullable = false,
            unique = true
    )
    private String name;

    /**
     * md5-hashed password.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "passwordHash",
            nullable = false
    )
    private String passwordHash;

    /**
     * e-mail for contact and login etc.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    /**
     * experience of the user.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "experience",
            nullable = false
    )
    private long experience;

    /**
     * {@link Inventory} containing {@link org.dedda.games.scheisse.entity.item.Item}s.
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Inventory inventory;

    /*==========================*
     * GETTER & SETTER
     *==========================*/

    /**
     * {@inheritDoc}
     */
    @Override
    public final long getId() {
        return id;
    }

    /**
     *
     * @return username.
     *
     * @see #name
     */
    public final String getName() {
        return name;
    }

    /**
     *
     * @return md5-hashed password.
     *
     * @see #passwordHash
     */
    public final String getPasswordHash() {
        return passwordHash;
    }

    /**
     *
     * @return e-mail
     *
     * @see #email
     */
    public final String getEmail() {
        return email;
    }

    /**
     *
     * @return user experience
     *
     * @see #experience
     */
    public final long getExperience() {
        return experience;
    }

    /**
     *
     * @param id user id
     *
     * @see #id
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     *
     * @param name username
     *
     * @see #name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @param passwordHash md5-hashed password
     *
     * @see #passwordHash
     */
    public final void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     *
     * @param email e-mail
     *
     * @see #email
     */
    public final void setEmail(final String email) {
        this.email = email;
    }

    /**
     *
     * @param experience
     */
    public final void setExperience(final long experience) {
        this.experience = experience;
    }

    /**
     *
     * @return {@link Inventory} of this user
     *
     * @see #inventory
     * @see Inventory
     */
    public final Inventory getInventory() {
        return inventory;
    }

    /**
     *
     * @param inventory {@link Inventory} of this user
     *
     * @see #inventory
     * @see Inventory
     */
    public final void setInventory(final Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return "org.dedda.games.scheisse_server.entity.User[ id=" + id + " ]";
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
