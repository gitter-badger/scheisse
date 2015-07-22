package scheisse.game_ai.object_skeletons;

import java.util.List;

/**
 * Created by dedda on 7/22/15.
 *
 * @author dedda
 */
public interface Inventory {

    boolean canAdd(Item item, long amount);
    void add(Item item, long amount);
    long contains(Item item);
    long remove(Item item);

    long getId();
    long getSize();
    void setSize(long size);
    User getUser();
    List<Slot> getSlots();
    void setSlots(List<Slot> slots);

}
