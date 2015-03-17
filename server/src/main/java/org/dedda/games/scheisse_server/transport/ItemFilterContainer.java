package org.dedda.games.scheisse_server.transport;

/**
 * @author dedda
 */
public class ItemFilterContainer {

    public final long[] userIds;
    public final long[] itemIds;
    public final String[] itemTypes;
    /**
     * '*' is a place holder for any possible combination of chars or nothing.
     */
    public final String[] itemNames;
    /**
     * attack[0] = minimum | attack[1] = exact  | attack[2] = maximum   || <0 counts as empty.
     */
    public final long[] attack;
    /**
     * armor[0] = minimum | armor[1] = exact    | armor[2] = maximum    || <0 counts as empty.
     */
    public final long[] armor;
    /**
     * value[0] = minimum | value[1] = exact    | value[2] = maximum    || <0 counts as empty.
     */
    public final long[] value;
    /**
     * level[0] = minimum | level[1] = exact    | level[2] = maximum    || <0 counts as empty.
     */
    public final long[] level;

    public ItemFilterContainer(
            final long[] userIds,
            final long[] itemIds,
            final String[] itemTypes,
            final String[] itemNames,
            final long[] attack,
            final long[] armor,
            final long[] value,
            final long[] level
    ) {
        this.userIds = userIds;
        this.itemIds = itemIds;
        this.itemTypes = itemTypes;
        this.itemNames = itemNames;
        this.attack = attack;
        this.armor = armor;
        this.value = value;
        this.level = level;
    }
}
