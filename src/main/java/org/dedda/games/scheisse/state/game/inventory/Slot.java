package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.state.game.item.Item;

/**
 * Created by dedda on 4/18/14.
 */
public class Slot {

    private Inventory inventory;
    private int numberOfItems = 0;
    private Item dummy;

    public Slot(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     *
     * @param dummy Item - dummy file to get class information for item type
     */
    public Slot(Item dummy, Inventory inventory){
        this.dummy = dummy;
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
    public int getNumberOfItems() {
        return numberOfItems;
    }

    /**
     *
     * @param numberOfItems int
     */
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
        inventory.triggerChangeEvent();
    }

    /**
     *
     * @return Class - class of suitable items
     */
    public Class getDummyClass(){
        return dummy.getClass();
    }

    /**
     *
     * @param dummyClass Class - class for suitable items
     */
    public void setDummyClass(Class dummyClass){
        try {
            this.dummy = (Item) dummyClass.cast(dummyClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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
