package org.dedda.games.scheisse_server.pageProvider;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import org.dedda.games.scheisse_server.entity.Slot;
import org.dedda.games.scheisse_server.provider.UserProvider;

@ManagedBean
@RequestScoped
public class User {

    @Inject
    private UserProvider userProvider;
        
    @ManagedProperty(value = "#{param.id}")
    private long id;
    
    private org.dedda.games.scheisse_server.entity.User selected;
    
    public String show() {
        selected = userProvider.getUser(id);
        return "user";
    }

    public UserProvider getUserProvider() {
        return userProvider;
    }

    public void setUserProvider(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public org.dedda.games.scheisse_server.entity.User getSelected() {
        return selected;
    }

    public void setSelected(org.dedda.games.scheisse_server.entity.User selected) {
        this.selected = selected;
    }
    
    public List<Slot> getSlots() {
        System.out.println(selected);
        System.out.println("inventory size: " + selected.getInventory().getSize());
        System.out.println("slots for " + selected.getName() + ": " + selected.getInventory().getSlots().size());
        return selected.getInventory().getSlots();
    }
    
}
