package org.dedda.games.scheisse.io.net.service;

import org.dedda.games.scheisse.main.Main;
import org.dedda.games.scheisse.state.game.item.*;
import org.dedda.games.scheisse.webService.client.ItemService;
import org.dedda.games.scheisse.webService.client.itemService.*;

import java.awt.*;
import java.util.List;

/**
 * Created by dedda on 2/7/15.
 */
public class ItemServiceImpl {

    private Toolkit tk = Toolkit.getDefaultToolkit();

    public void registerAll() {
        List<org.dedda.games.scheisse.webService.client.itemService.Item> items = ItemService.getAllItems();
        for (org.dedda.games.scheisse.webService.client.itemService.Item item : items) {
            register(item);
        }
    }

    private void register(org.dedda.games.scheisse.webService.client.itemService.Item item) {
        if (item.getType().equals("ARMOR")) {
            Armor.register(item.getId(), item.getName(), item.getPrice(), item.getArmor(), ItemType.CLOTHING, getImage(item));
        } else if (item.getType().equals("WEAPON")) {
            Weapon.register(item.getId(), item.getName(), item.getPrice(), item.getAttack(), getImage(item));
        } else if (item.getType().equals("SHIELD")) {
            Shield.register(item.getId(), item.getName(), item.getPrice(), item.getArmor(), getImage(item));
        }
    }

    private Image getImage(org.dedda.games.scheisse.webService.client.itemService.Item item) {
        String fileName = Main.INSTALLATION_FOLDER + "data/image/" + item.getName().toLowerCase().replace(' ', '_') + ".png";
        System.out.println("image: " + fileName);
        return tk.getImage(fileName);
    }

}
