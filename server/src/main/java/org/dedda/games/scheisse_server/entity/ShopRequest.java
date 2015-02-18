package org.dedda.games.scheisse_server.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
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
public class ShopRequest {
    
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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itemId")
    private Item item;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "amount",
            nullable = false,
            unique = false
    )
    private long amount;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "singlePrice",
            nullable = false,
            unique = false
    )
    private long singlePrice;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "buy",
            nullable = false,
            unique = false
    )
    private boolean buy;

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

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(long singlePrice) {
        this.singlePrice = singlePrice;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
}
