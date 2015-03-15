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
 * @author dedda
 */
@javax.persistence.Entity
@Table(name = "shopRequest")
@NamedQueries({
    @NamedQuery(
            name = "shopRequest.getForUser",
            query = "SELECT sr FROM ShopRequest sr WHERE sr.user = :user"
    ),
    @NamedQuery(
            name = "shopRequest.getForPrice",
            query = "SELECT sr FROM ShopRequest sr WHERE sr.singlePrice = :price"
    ),
    @NamedQuery(
            name = "shopRequest.getFotItem",
            query = "SELECT sr FROM ShopRequest sr WHERE sr.item = :item"
    )
})
public class ShopRequest extends Entity {

    /**
     * request id
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
     * {@link org.dedda.games.scheisse.entity.User} who created this request
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    /**
     * requested {@link org.dedda.games.scheisse.entity.item.Item}
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId")
    private Item item;

    /**
     * requested / available amount of items
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
     * price per single {@link org.dedda.games.scheisse.entity.item.Item}
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "singlePrice",
            nullable = false,
            unique = false
    )
    private long singlePrice;

    /**
     * buying / selling mode
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "buy",
            nullable = false,
            unique = false
    )
    private boolean buy;

    /**
     * created time stamp
     */
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "timestamp",
            nullable = false,
            unique = false
    )
    private long timestamp;
    
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(final long amount) {
        this.amount = amount;
    }

    public long getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(final long singlePrice) {
        this.singlePrice = singlePrice;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(final boolean buy) {
        this.buy = buy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    
}
