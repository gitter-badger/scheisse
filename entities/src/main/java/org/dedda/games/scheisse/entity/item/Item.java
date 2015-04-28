package org.dedda.games.scheisse.entity.item;

import org.dedda.games.scheisse.entity.TestableEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.awt.Image;

/**
 * @author dedda
 */
@javax.persistence.Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(
        name = "item.getAll",
        query = "SELECT i " +
            "FROM org.dedda.games.scheisse.entity.item.Item i"
    ),
    @NamedQuery(
        name = "item.getForType",
        query = "SELECT i " +
            "FROM org.dedda.games.scheisse.entity.item.Item i " +
            "WHERE i.type = :type"
    ),
    @NamedQuery(
        name = "item.searchByName",
        query = "SELECT i FROM Item where i.name LIKE :name"
    )
})
public class Item
    extends org.dedda.games.scheisse.entity.Entity
    implements TestableEntity {

    /**
     * item id.
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
     * default item price / value.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
        name = "price",
        nullable = false
    )
    private long price;

    /**
     * item name.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
        name = "name",
        nullable = false,
        unique = true
    )
    private String name;

    /**
     * item type.
     */
    @NotNull
    @Basic(optional = false)
    @Column(
        name = "type",
        nullable = false
    )
    private String type;

    /**
     * highest amount of damage to be dealt with this item.
     */
    @Column(
        name = "attack"
    )
    private long attack;

    /**
     * highest amount of damage that can be absorbed by this item.
     */
    @Column(
        name = "armor"
    )
    private long armor;

    /**
     * max possible stack amount.
     */
    @Column(
        name = "max_stack"
    )
    private long maxStackAmount;

    /**
     * sprite to be rendered in inventory.
     */
    private Image sprite;

    /**
     * item category.
     *
     * @see ItemCategory
     */
    private ItemCategory category;

    /**
     * @return item id
     */
    @Override
    public final long getId() {
        return id;
    }

    /**
     * @return default item price / value
     */
    public final long getPrice() {
        return price;
    }

    /**
     * @return item name
     */
    public final String getName() {
        return name;
    }

    /**
     * @return item type
     */
    public final String getType() {
        return type;
    }

    /**
     * @return highest amount of damage to be dealt with this item
     */
    public final long getAttack() {
        return attack;
    }

    /**
     * @return highest amount of damage that can be absorbed by this item
     */
    public final long getArmor() {
        return armor;
    }

    /**
     * @param id item id
     */
    public final void setId(final long id) {
        this.id = id;
    }

    /**
     * @param price default item price / value
     */
    public final void setPrice(final long price) {
        this.price = price;
    }

    /**
     * @param name item name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @param type item type
     */
    public final void setType(final String type) {
        this.type = type;
    }

    /**
     * @param attack highest amount of damage to be dealt with this item
     */
    public final void setAttack(final long attack) {
        this.attack = attack;
    }

    /**
     * @param armor highest amount of damage that can be absorbed by this item
     */
    public final void setArmor(final long armor) {
        this.armor = armor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final long getMinTestId() {
        return -9;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final long getMaxTestId() {
        return -1;
    }

    /**
     * @return item category
     * @see ItemCategory
     */
    public final ItemCategory getCategory() {
        return category;
    }

    /**
     * @param category item category
     * @see ItemCategory
     */
    public final void setCategory(final ItemCategory category) {
        this.category = category;
    }

    /**
     * @return sprite to be rendered in inventory
     */
    public final Image getSprite() {
        return sprite;
    }

    /**
     * @param sprite sprite to be rendered in inventory
     */
    public final void setSprite(final Image sprite) {
        this.sprite = sprite;
    }

    /**
     * @return max stack amount
     */
    public final long getMaxStackAmount() {
        return maxStackAmount;
    }

    /**
     * @param maxStackAmount max stack amount
     */
    public final void setMaxStackAmount(final long maxStackAmount) {
        this.maxStackAmount = maxStackAmount;
    }

    /**
     * {@inheritDoc}
     */
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
