package org.dedda.games.scheisse.fsloaders.resource.item;

import org.dedda.games.scheisse.entity.item.Armor;
import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemStore;
import org.dedda.games.scheisse.entity.item.ItemType;
import org.dedda.games.scheisse.entity.item.Shield;
import org.dedda.games.scheisse.entity.item.Weapon;
import org.dedda.games.scheisse.fsloaders.resource.testInstances.TestItem;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ItemLoaderTest {

    private ItemLoader instance;

    @Before
    public void setUp() throws Exception {
        instance = new ItemLoader();
    }

    @Test
    public void testLoadItem() throws Exception {
        Weapon testWeapon = Weapon.register(1, "Wooden Sword", 123L, 456L, Item.TYPES_CLOTHING, null);
        Armor testArmor = Armor.register(
            2,
            "Wooden Armor",
            654L,
            321L,
            Item.TYPES_CLOTHING,
            null
        );
        Shield testShield = Shield.register(3, "Wooden Shield", 246L, 135L, Item.TYPE_SHIELD, null);
        ItemLoader itemLoader = new ItemLoader();
        Weapon weapon = (Weapon) itemLoader.loadItem(
            new File(
                "src/test/test_files/classes/" +
                    "org/dedda/games/scheisse/io/resource/item/" +
                    "ItemLoader/wood_sword.di"
            )
        );
        Armor armor = (Armor) itemLoader.loadItem(
            new File(
                "src/test/test_files/classes/" +
                    "org/dedda/games/scheisse/io/resource/item/" +
                    "ItemLoader/wood_armor.di"
            )
        );
        Shield shield = (Shield) itemLoader.loadItem(
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
//        Weapon testWeapon = Weapon.register(1, "Wooden Sword", 123L, 456L, Item.TYPE_WEAPON, null);
//        Armor testArmor = Armor.register(
//            2,
//            "Wooden Armor",
//            654L,
//            321L,
//            Item.TYPES_CLOTHING,
//            null
//        );
//        Shield testShield = Shield.register(3, "Wooden Shield", 246L, 135L, Item.TYPE_SHIELD, null);
        instance.loadAll(new File("src/test/test_files/classes/org/dedda/games/scheisse/io/resource/item/ItemLoader"));
        assertEquals(10, ItemStore.getItemMap().size());
    }
}
