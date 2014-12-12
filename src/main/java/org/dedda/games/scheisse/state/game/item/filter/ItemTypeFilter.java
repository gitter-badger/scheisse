package org.dedda.games.scheisse.state.game.item.filter;

import org.dedda.games.scheisse.state.game.item.Item;

/**
 * Created by dedda on 10/7/14.
 */
public class ItemTypeFilter extends ItemFilter {

    private Class itemClasses[];

    public ItemTypeFilter(final Class itemClasses[]) {
        this.itemClasses = itemClasses;
    }

    @Override
    public boolean accept(final Item item) {
        for(Class current : itemClasses){
            if(item.getClass().equals(current)){
                return true;
            }
        }
        return false;
    }
}
