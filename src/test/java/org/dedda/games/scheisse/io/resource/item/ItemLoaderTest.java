package org.dedda.games.scheisse.io.resource.item;

import org.dedda.games.scheisse.state.game.item.*;
import org.dedda.games.scheisse.state.game.item.Item;
import org.dedda.games.scheisse.state.game.item.ItemType;
import org.dedda.games.scheisse.testInstances.TestItem;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.*;

public class ItemLoaderTest {

    @Before
    public void setUp() throws Exception {
        new TestItem();
    }

    @Test
    public void testLoadItem() throws Exception {
        Weapon testWeapon = new Weapon(1, "Wooden Sword", 123L, 456L, null);
        Armor testArmor = new Armor(2, "Wooden Armor", 654L, 321L, ItemType.CLOTHING, null);
        Shield testShield = new Shield(3, "Wooden Shield", 246L, 135L, null);
        ItemLoader itemLoader = new ItemLoader();
        Weapon weapon = (Weapon) itemLoader.loadItem(new File("src/test/test_files/data/item/wood_sword.di"));
        Armor armor = (Armor) itemLoader.loadItem(new File("src/test/test_files/data/item/wood_armor.di"));
        Shield shield = (Shield) itemLoader.loadItem(new File("src/test/test_files/data/item/wood_shield.di"));
        assertTrue(testWeapon.equals(weapon));
        assertTrue(testArmor.equals(armor));
        assertTrue(testShield.equals(shield));
    }

    @Test
    public void testLoadAll() throws Exception{
        Weapon testWeapon = new Weapon(1, "Wooden Sword", 123L, 456L, null);
        Armor testArmor = new Armor(2, "Wooden Armor", 654L, 321L, ItemType.CLOTHING, null);
        Shield testShield = new Shield(3, "Wooden Shield", 246L, 135L, null);
        Item.printMap();
        assertEquals(Item.getItemMap().size(), 11);
        assertTrue(Item.getItemMap().containsValue(testWeapon));
        assertTrue(Item.getItemMap().containsValue(testArmor));
        assertTrue(Item.getItemMap().containsValue(testShield));
    }
}