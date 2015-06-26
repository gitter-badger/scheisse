package org.dedda.games.scheisse.fsloaders.resource.item;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemStore;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_ARMOR;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_SHIELD;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_WEAPON;

public class ItemLoaderTest {

    private ItemLoader instance;

    @Before
    public void setUp() throws Exception {
        instance = new ItemLoader();
        ItemStore.clear();
    }

    @Test
    public void testLoadItem() throws Exception {
        Item testWeapon = new Item();
        testWeapon.setId(4);
        testWeapon.setName("Wooden Sword");
        testWeapon.setPrice(123L);
        testWeapon.setTypes(TYPE_WEAPON);
        testWeapon.setArmor(0);
        testWeapon.setAttack(456L);
        testWeapon.setMaxStackAmount(1);
        testWeapon.setSprite(null);
        ItemStore.put(testWeapon);
        Item testArmor = new Item();
        testArmor.setId(5);
        testArmor.setName("Wooden Armor");
        testArmor.setPrice(654L);
        testArmor.setTypes(TYPE_ARMOR);
        testArmor.setArmor(321L);
        testArmor.setAttack(0);
        testArmor.setMaxStackAmount(1);
        testArmor.setSprite(null);
        ItemStore.put(testArmor);
        Item testShield = new Item();
        testShield.setId(6);
        testShield.setName("Wooden Shield");
        testShield.setPrice(246L);
        testShield.setTypes(TYPE_SHIELD);
        testShield.setArmor(135L);
        testShield.setAttack(0);
        testShield.setMaxStackAmount(1);
        testShield.setSprite(null);
        ItemStore.put(testShield);
        ItemLoader itemLoader = new ItemLoader();
        Item weapon = itemLoader.loadItem(
            new File(
                "src/test/test_files/classes/" +
                    "org/dedda/games/scheisse/io/resource/item/" +
                    "ItemLoader/wood_sword.di"
            )
        );
        Item armor = itemLoader.loadItem(
            new File(
                "src/test/test_files/classes/" +
                    "org/dedda/games/scheisse/io/resource/item/" +
                    "ItemLoader/wood_armor.di"
            )
        );
        Item shield = itemLoader.loadItem(
            new File(
                "src/test/test_files/classes/" +
                    "org/dedda/games/scheisse/io/resource/item/" +
                    "ItemLoader/wood_shield.di"
            )
        );
        assertTrue(testWeapon.equals(weapon));
        assertTrue(testArmor.equals(armor));
        assertTrue(testShield.equals(shield));
    }

    @Test
    public void testLoadAll() throws Exception {
        instance.loadAll(new File("src/test/test_files/classes/org/dedda/games/scheisse/io/resource/item/ItemLoader"));
        assertEquals(9, ItemStore.getItemMap().size());
    }
}
