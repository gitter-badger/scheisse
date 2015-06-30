package org.dedda.games.scheisse.server.web;

import org.dedda.games.scheisse.entity.Inventory;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Created by dedda on 6/30/15.
 *
 * @author dedda
 */
@Named("name")
@SessionScoped
public class User {

    private org.dedda.games.scheisse.entity.User selected;

    private Inventory inventory;

    public org.dedda.games.scheisse.entity.User getSelected() {
        return selected;
    }

    public void setSelected(org.dedda.games.scheisse.entity.User selected) {
        this.selected = selected;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
