package org.dedda.games.scheisse.game;

import org.dedda.games.scheisse.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
public class UserStore {

    private Map<Long, User> userMap;
    private long idCounter = 0;

    public UserStore() {
        this.userMap = new HashMap<>();
    }

    public User getUser(final long id) {
        if (userMap.containsKey(id)) {
            return userMap.get(id);
        }
        return null;
    }

    public long getKey(final User user) {
        for (Map.Entry<Long, User> e : userMap.entrySet()) {
            if (e.getValue().equals(user)) {
                return e.getKey();
            }
        }
        return -1;
    }

    public long register(final User user) {
        long key = getKey(user);
        if (key > -1) {
            return key;
        }
        userMap.put(idCounter++, user);
        return idCounter;
    }

    public void unregister(final User user) {
        long key = getKey(user);
        if (key > -1) {
            userMap.remove(key);
        }
    }

}
