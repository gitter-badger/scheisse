package org.dedda.games.scheisse.service.host;

import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.entity.item.ItemCategory;
import org.dedda.games.scheisse.server_persistence.ItemProvider;
import org.dedda.games.scheisse.service.transport.ItemContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemServiceHostTest {

    private ItemServiceHost instance;
    private ItemProvider provider;
    private List<Item> items;
    private List<Item> search;

    @Before
    public void setUp() throws Exception {
        instance = new ItemServiceHost();
        items = new ArrayList<>(3);
        Item item = new Item();
        item.setId(0);
        item.setPrice(10);
        item.setName("item 1");
        item.setAttack(0);
        item.setArmor(10);
        item.setCategory(ItemCategory.ARMOR);
        items.add(item);
        item = new Item();
        item.setId(1);
        item.setPrice(20);
        item.setName("item 2");
        item.setAttack(10);
        item.setArmor(0);
        item.setCategory(ItemCategory.WEAPPON);
        items.add(item);
        item = new Item();
        item.setId(2);
        item.setPrice(30);
        item.setName("last");
        item.setAttack(0);
        item.setArmor(0);
        item.setCategory(ItemCategory.TOOL);
        items.add(item);
        search = new ArrayList<>(2);
        search.add(items.get(0));
        search.add(items.get(1));
        provider = mock(ItemProvider.class);
        when(provider.getItem(0)).thenReturn(items.get(0));
        when(provider.getItem(1)).thenReturn(items.get(1));
        when(provider.getItem(2)).thenReturn(items.get(2));
        when(provider.getAllItems()).thenReturn(items);
        when(provider.search("tem")).thenReturn(search);
        instance.setProvider(provider);
    }

    @Test
    public void testGetAll() throws Exception {
        List<ItemContainer> actual = instance.getAll();
        List<ItemContainer> expected = ItemContainer.convert(items);
        for (ItemContainer container : expected) {
            assertTrue(actual.contains(container));
        }
        for (ItemContainer container : actual) {
            assertTrue(expected.contains(container));
        }
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(items.get(0), instance.get(0).getEntity());
        assertEquals(items.get(1), instance.get(1).getEntity());
        assertEquals(items.get(2), instance.get(2).getEntity());
    }

    @Test
    public void testSearch() throws Exception {
        List<ItemContainer> actual = instance.search("tem");
        List<ItemContainer> expected = ItemContainer.convert(search);
        for (ItemContainer container : expected) {
            actual.contains(container);
        }
        for (ItemContainer container : actual) {
            assertTrue(expected.contains(container));
        }
    }
}