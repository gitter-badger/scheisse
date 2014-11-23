package org.dedda.games.scheisse.io.resource.item;

import junit.framework.Assert;
import org.dedda.games.scheisse.state.game.item.*;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class ItemLoaderTest {

    @Test
    public void testLoadItem() throws Exception {
        Weapon testWeapon = new Weapon("1", "Wooden Sword", 123L, 456L);
        Armor testArmor = new Armor("2", "Wooden Armor", 654L, 321L, ItemType.CLOTHING);
        Shield testShield = new Shield("3", "Wooden Shield", 246L, 135L);
        ItemLoader itemLoader = new ItemLoader();
        Weapon weapon = (Weapon) itemLoader.loadItem(new File("src/test/test_files/data/item/wood_sword.di"));
        Armor armor = (Armor) itemLoader.loadItem(new File("src/test/test_files/data/item/wood_armor.di"));
        Shield shield = (Shield) itemLoader.loadItem(new File("src/test/test_files/data/item/wood_shield.di"));
        Assert.assertTrue(testWeapon.equals(weapon));
        Assert.assertTrue(testArmor.equals(armor));
        Assert.assertTrue(testShield.equals(shield));
    }

    @Test
    public void testLoadAll() throws Exception{
        Weapon testWeapon = new Weapon("1", "Wooden Sword", 123L, 456L);
        Armor testArmor = new Armor("2", "Wooden Armor", 654L, 321L, ItemType.CLOTHING);
        Shield testShield = new Shield("3", "Wooden Shield", 246L, 135L);
        ItemLoader itemLoader = new ItemLoader();
        ArrayList<Item> items = itemLoader.loadAll(new File("src/test/test_files/data/item/"));
        Assert.assertTrue(items.size() == 3);
        Assert.assertTrue(items.contains(testWeapon));
        Assert.assertTrue(items.contains(testArmor));
        Assert.assertTrue(items.contains(testShield));
    }
}