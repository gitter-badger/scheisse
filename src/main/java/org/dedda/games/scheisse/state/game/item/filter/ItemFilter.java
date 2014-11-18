package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;

import java.util.ArrayList;

/**
 * Created by dedda on 10/7/14.
 */
public abstract class ItemFilter {

    public abstract boolean accept(Item item);

    public ArrayList<Item> filter(ArrayList<Item> items) {
        ArrayList<Item> filtered = new ArrayList<Item>();
        for(Item item : items){
            if(accept(item)){
                filtered.add(item);
            }
        }
        return filtered;
    }

}
