package org.dedda.games.scheisse_server.pageProvider;

import org.dedda.games.scheisse.entity.Slot;
import org.dedda.games.scheisse.server_persistence.UserProvider;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@RequestScoped
public class User {

    @Inject
    private UserProvider userProvider;

    @ManagedProperty(value = "#{param.id}")
    private long id;

    private org.dedda.games.scheisse.entity.User selected;

    public final String show() {
        selected = userProvider.getUser(id);
        return "user";
    }

    public final UserProvider getUserProvider() {
        return userProvider;
    }

    public final void setUserProvider(final UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public final long getId() {
        return id;
    }

    public final void setId(final long id) {
        this.id = id;
    }

    public final org.dedda.games.scheisse.entity.User getSelected() {
        return selected;
    }

    public final void setSelected(final org.dedda.games.scheisse.entity.User selected) {
        this.selected = selected;
    }
    
    public final List<Slot> getSlots() {
        System.out.println(selected);
        System.out.println("inventory size: " + selected.getInventory().getSize());
        System.out.println("slots for " + selected.getName() + ": " + selected.getInventory().getSlots().size());
        return selected.getInventory().getSlots();
    }

}
