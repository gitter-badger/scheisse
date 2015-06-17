package org.dedda.games.scheisse.entity.item;

import org.junit.Before;
import org.junit.Test;

import static org.dedda.games.scheisse.entity.item.Item.TYPE_ARMOR;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_DUAL_WEAPON;
import static org.dedda.games.scheisse.entity.item.Item.TYPE_OTHER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ItemTest {

    private Item instance;
    private Item testInstance;

    @Before
    public void setUp() {
        instance = new Item();
        instance.setId(0);
        instance.setArmor(10);
        instance.setAttack(100);
        instance.setTypes(TYPE_OTHER);
        instance.setName("item");
        instance.setPrice(25);
        instance.setSprite(null);
        testInstance = new Item();
        testInstance.setArmor(instance.getArmor());
        testInstance.setAttack(instance.getAttack());
        testInstance.setTypes(instance.getTypes());
        testInstance.setId(instance.getId());
        testInstance.setName(instance.getName());
        testInstance.setPrice(instance.getPrice());
        testInstance.setSprite(instance.getSprite());
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(instance, testInstance);
        setUp();
        testInstance.setId(1);
        assertNotEquals(instance, testInstance);
        setUp();
        testInstance.setArmor(0);
        assertNotEquals(instance, testInstance);
        setUp();
        testInstance.setAttack(0);
        assertNotEquals(instance, testInstance);
        setUp();
        testInstance.setTypes(TYPE_ARMOR);
        assertNotEquals(instance, testInstance);
        setUp();
        testInstance.setName("false name");
        assertNotEquals(instance, testInstance);
        setUp();
        testInstance.setPrice(0);
        assertNotEquals(instance, testInstance);
        setUp();
        testInstance.setTypes(TYPE_DUAL_WEAPON);
        assertNotEquals(instance, testInstance);
    }
}
