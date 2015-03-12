package org.dedda.games.scheisse_server.transport;

import org.dedda.games.scheisse.entity.Item;

public class ItemContainer {

    public final long id;
    public final long value;
    public final String name;
    public final String type;
    public final long attack;
    public final long armor;

    public ItemContainer(final long id, final long value, final String name, final String type, final long attack, final long armor) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.armor = armor;
    }

    public ItemContainer(final Item item) {
        this.id = item.getId();
        this.value = item.getPrice();
        this.name = item.getName();
        this.type = item.getType();
        this.attack = item.getAttack();
        this.armor = item.getArmor();
    }
}
