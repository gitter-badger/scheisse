/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse_server.entity;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dedda
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(
            name = "item.getAll",
            query = "SELECT i FROM Item i"
    ),
    @NamedQuery(
            name = "item.getForType",
            query = "SELECT i FROM Item i WHERE i.type = :type"
    )
})
public class Item implements TestableEntity {
    
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
            name = "price",
            nullable = false
    )
    private long price;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "name",
            nullable = false,
            unique = true
    )
    private String name;
    
    @NotNull
    @Basic(optional = false)
    @Column(
            name = "type",
            nullable = false
    )
    private String type;
    
    @Column(
            name = "attack"
    )
    private long attack;
    
    @Column(
            name = "armor"
    )
    private long armor;

    @OneToMany(
            mappedBy = "item",
            fetch = FetchType.LAZY
    )
    private List<Slot> slots;
    
    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    public long getAttack() {
        return attack;
    }

    public long getArmor() {
        return armor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public void setArmor(long armor) {
        this.armor = armor;
    }

    @Override
    public long getMinTestId() {
        return -9;
    }

    @Override
    public long getMaxTestId() {
        return -1;
    }
    
}
