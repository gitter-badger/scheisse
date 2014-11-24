package org.dedda.games.scheisse.state.game.inventory;

import org.dedda.games.scheisse.debug.SystemPrinter;

import java.util.ArrayList;

/**
 * Created by dedda on 4/18/14.
 */
public class Inventory {

    private ArrayList<Slot> slots = new ArrayList<Slot>();
    private ArrayList<InventoryChangeListener> inventoryChangeListeners = new ArrayList<InventoryChangeListener>();

    public Inventory(){
        for(int i = 0; i < 20; i++){
            slots.add(new Slot(this));
        }
    }

    /**
     *
     * @param size int
     */
    public Inventory(int size){
        for(int i = 0; i < size; i++){
            slots.add(new Slot(this));
        }
    }

    protected void triggerChangeEvent() {
        for(InventoryChangeListener inventoryChangeListener : inventoryChangeListeners){
            inventoryChangeListener.inventoryChangeAction();
        }
    }

    /**
     *
     * @return int
     */
    public int getSize(){
        return slots.size();
    }

    /**
     *
     * @param size int
     */
    public void setSize(int size){
        if(size > slots.size()){
            for(int i = slots.size(); i < size; i++){
                slots.add(new Slot(this));
            }
        }else if(size < slots.size()){
            for(int i = slots.size(); i >= size; i--){
                slots.remove(i-1);
            }
        }
        triggerChangeEvent();
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
        triggerChangeEvent();
    }

    public void setSlot(int index, Slot slot){
        this.slots.set(index, slot);
        triggerChangeEvent();
    }

    public void print(){
        SystemPrinter.debugln("Inventory:");
        SystemPrinter.debugln("size: " + slots.size());
        for(Slot slot : slots){
            SystemPrinter.debugln(slot.getDummy().getName() + ": " + slot.getNumberOfItems());
        }
    }

    public void addInventoryChangeListener(InventoryChangeListener inventoryChangeListener) {
        inventoryChangeListeners.add(inventoryChangeListener);
    }

    public void removeInventoryChangeListener(InventoryChangeListener inventoryChangeListener) {
        if(inventoryChangeListeners.contains(inventoryChangeListener)){
            inventoryChangeListeners.remove(inventoryChangeListener);
        }
    }

    public ArrayList<InventoryChangeListener> getInventoryChangeListeners() {
        return inventoryChangeListeners;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Inventory){
            Inventory inventory = (Inventory)object;
            return inventory.slots.equals(this.slots);
        }
        return false;
    }

}
