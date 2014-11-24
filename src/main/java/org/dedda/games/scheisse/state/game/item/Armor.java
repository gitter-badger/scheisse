package org.dedda.games.scheisse.state.game.item;

import org.dedda.games.scheisse.state.game.object.Person;

import static org.dedda.games.scheisse.state.game.item.ItemCategory.ARMOR;

/**
 * Created by dedda on 4/18/14.
 */
public class Armor extends Item implements Wearable{

    protected final long armor;

    /**
     *
     * @param name String - item name
     * @param value long - item value
     * @param armor long
     */
    public Armor(long id, String name, long value, long armor, ItemType type){
        super(id, name, value, ARMOR, type);
        this.armor = armor;
    }

    /**
     *
     * @return long
     */
    public long getArmor() {
        return armor;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Armor){
            Armor armor = (Armor)object;
            return armor.name.equals(this.name)
                    && armor.value == this.value
                    && armor.armor == this.armor;
        }
        return false;
    }

    public int maxStackNumber() {
        return 1;
    }

    public void render(Person person) {

    }
}
