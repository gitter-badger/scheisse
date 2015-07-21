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
            "WHERE i.types = :types"
    ),
    @NamedQuery(
        name = "item.searchByName",
        query = "SELECT i FROM Item where i.name LIKE :name"
    )
})
public class Item
    extends org.dedda.games.scheisse.entity.Entity
    implements TestableEntity, Stackable {

    public static final int TYPE_OTHER = 1;
    public static final int TYPE_TOOL = 2;
    public static final int TYPE_SINGLE_WEAPON = 4;
    public static final int TYPE_DUAL_WEAPON = 8;
    public static final int TYPE_HELMET = 16;
    public static final int TYPE_JACKET = 32;
    public static final int TYPE_PANTS = 64;
    public static final int TYPE_GLOVES = 128;
    public static final int TYPE_BOOTS = 256;
    public static final int TYPE_SHIELD = 512;

    public static final int TYPE_ARMOR = 65536;
    public static final int TYPE_WEAPON = 131072;

    public static final int TYPES_CLOTHING =
        TYPE_HELMET | TYPE_JACKET | TYPE_PANTS | TYPE_GLOVES | TYPE_BOOTS;

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
        unique = true,
        length = 50
    )
    private String name;

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
     * min level needed to use this item.
     */
    @Column(
        name = "min_level"
    )
    private long minLevel;

    /**
     *
     */
    @Column(
        name = "types"
    )
    private int types;

    /**
     * sprite to be rendered in inventory.
     */
    private Image sprite;

    public Item() {
    }

    public Item(long id, String name, long price, int types, Image sprite) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.types = types;
        this.sprite = sprite;
    }


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

    public final long getMinLevel() {
        return minLevel;
    }

    public final void setMinLevel(long minLevel) {
        this.minLevel = minLevel;
    }

    public final int getTypes() {
        return types;
    }

    public final void setTypes(int types) {
        this.types = types;
    }

    public final boolean isType(final int type) {
        return (this.types & type) != 0;
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
        if (price != item.price) {
            return false;
        }
        if (!name.equals(item.name)) {
            return false;
        }
        if (types != item.types) {
            return false;
        }
        return true;
    }

    @Override
    public long maxStackNumber() {
        return this.maxStackAmount;
    }
}
