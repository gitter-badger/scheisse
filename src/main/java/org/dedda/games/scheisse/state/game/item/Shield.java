package org.dedda.games.scheisse.state.game.item;

import static org.dedda.games.scheisse.state.game.item.ItemType.SHIELD;

/**
 * Created by dedda on 4/18/14.
 */
public class Shield extends Armor implements Wearable, Holdeable{

    /**
     *
     * @param name String - item name
     * @param value long - item value
     * @param armor long
     */
    public Shield(long id, String name, long value, long armor) {
        super(id, name, value, armor, SHIELD);
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Shield){
            Shield shield = (Shield)object;
            return shield.armor == this.armor
                    && shield.value == this.value
                    && shield.name.equals(this.name);
        }
        return false;
    }
}
