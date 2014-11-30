package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.NullItem;

/**
 * Created by dedda on 4/18/14.
 */
public class Slot {

    private Inventory inventory;
    private long numberOfItems = 0;
    private Item dummy;

    public Slot(Inventory inventory){
        this.inventory = inventory;
        dummy = new NullItem();
    }

    /**
     *
     * @param itemId Id of the item
     */
    public Slot(long itemId, Inventory inventory){
        this.dummy = Item.itemForId(itemId);
        this.inventory = inventory;
    }

    /**
     *
     * @return boolean - is there any space left in here?
     */
    public boolean canAdd(){
        return numberOfItems < dummy.maxStackNumber();
    }

    /**
     *
     * @param item Item
     */
    public void add(Item item){
        if(item.getClass().equals(dummy.getClass())){
            if(canAdd()){
                numberOfItems++;
            }
        }
        inventory.triggerChangeEvent();
    }

    /**
     * removes one from the item counter
     */
    public void remove(){
        if(numberOfItems > 0){
            numberOfItems--;
        }
        inventory.triggerChangeEvent();
    }

    /**
     *
     * @param dummy Item
     */
    public void setDummy(Item dummy){
        this.dummy = dummy;
        inventory.triggerChangeEvent();
    }

    /**
     *
     * @return Item
     */
    public Item getDummy() {
        return dummy;
    }

    /**
     *
     * @return int
     */
    public long getNumberOfItems() {
        return numberOfItems;
    }

    /**
     *
     * @param numberOfItems int
     */
    public void setNumberOfItems(long numberOfItems) {
        this.numberOfItems = numberOfItems;
        inventory.triggerChangeEvent();
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Slot){
            Slot slot = (Slot)object;
            return slot.dummy.equals(this.dummy)
                    && slot.numberOfItems == this.numberOfItems;
        }
        return false;
    }

}
