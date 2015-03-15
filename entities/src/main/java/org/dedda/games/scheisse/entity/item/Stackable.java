package org.dedda.games.scheisse.entity.item;

/**
 * Created by dedda on 4/18/14.
 */
public interface Stackable {

    /**
     * maximum number of items to stack in one {@link org.dedda.games.scheisse.entity.Slot}
     * @return int
     */
    public int maxStackNumber();

}
