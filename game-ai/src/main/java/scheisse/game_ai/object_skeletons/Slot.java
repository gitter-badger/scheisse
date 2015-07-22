package scheisse.game_ai.object_skeletons;

/**
 * Created by dedda on 7/22/15.
 *
 * @author dedda
 */
public interface Slot {

    boolean canAdd(Item item, long amount);
    long maxAddAmount(Item item);
    long remove(Item item, long amount);

    long getId();
    long getAmount();
    void setAmount(long amount);
    Inventory getInventory();
    Item getItem();
    void setItem(Item item);

}
