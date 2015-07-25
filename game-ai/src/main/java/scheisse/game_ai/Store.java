package scheisse.game_ai;

import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.entity.item.Item;
import org.dedda.games.scheisse.events.GameCommonEvent;
import org.dedda.games.scheisse.events.GameCommonEventListener;
import org.dedda.games.scheisse.world.Map;

import java.util.List;

/**
 * Created by dedda on 7/23/15.
 *
 * @author dedda
 */
public class Store implements GameCommonEventListener {

    private User user;
    private List<Item> availableItems;
    private Map map;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(final List<Item> availableItems) {
        this.availableItems = availableItems;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(final Map map) {
        this.map = map;
    }

    @Override
    public void gameCommonEvent(final GameCommonEvent event) {

    }
}
