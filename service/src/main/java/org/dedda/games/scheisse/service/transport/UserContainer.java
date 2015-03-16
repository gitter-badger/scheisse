package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 3/12/15.
 */
public class UserContainer extends EntityContainer {

    public UserContainer(final User user) {
        super(EntityType.USER, user);
    }

    public static UserContainer convert(final User user) {
        return new UserContainer(user);
    }

    public static List<UserContainer> convert(final List<User> users) {
        List<UserContainer> containers = new ArrayList<>(users.size());
        for (User user : users) {
            containers.add(convert(user));
        }
        return containers;
    }

}
