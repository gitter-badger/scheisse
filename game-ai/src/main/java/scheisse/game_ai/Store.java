package scheisse.game_ai;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.world.Map;
import sun.security.acl.WorldGroupImpl;

import java.util.List;

/**
 * Created by dedda on 7/23/15.
 *
 * @author dedda
 */
public class Store {

    private User user;
    private List<Item> availableItems;
    private Map map;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<Item> availableItems) {
        this.availableItems = availableItems;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
