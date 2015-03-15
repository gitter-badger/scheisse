package org.dedda.games.scheisse.entity.item;

import org.dedda.games.scheisse.entity.TestableEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;

/**
 *
 * @author dedda
 */
@javax.persistence.Entity
@Table(name = "item")
@NamedQueries({
        @NamedQuery(
                name = "item.getAll",
                query = "SELECT i FROM org.dedda.games.scheisse.entity.item.Item i"
        ),
        @NamedQuery(
                name = "item.getForType",
                query = "SELECT i FROM org.dedda.games.scheisse.entity.item.Item i WHERE i.type = :type"
        ),
        @NamedQuery(
                name = "item.searchByName",
                query = "SELECT i FROM Item where i.name LIKE :name"
        )
})
public class Item extends org.dedda.games.scheisse.entity.Entity implements TestableEntity {

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

    private Image sprite;

    private ItemCategory category;

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

    public void setId(final long id) {
        this.id = id;
    }

    public void setPrice(final long price) {
        this.price = price;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setAttack(final long attack) {
        this.attack = attack;
    }

    public void setArmor(final long armor) {
        this.armor = armor;
    }

    public long getMinTestId() {
        return -9;
    }

    public long getMaxTestId() {
        return -1;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(final ItemCategory category) {
        this.category = category;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(final Image sprite) {
        this.sprite = sprite;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (armor != item.armor) {
            return false;
        }
        if (attack != item.attack) {
            return false;
        }
        if (id != item.id) {
            return false;
        }
        if (price != item.price) {
            return false;
        }
        if (category != item.category) {
            return false;
        }
        if (!name.equals(item.name)) {
            return false;
        }
        if (!type.equals(item.type)) {
            return false;
        }
        return true;
    }
}
