package org.dedda.games.scheisse_server.transport;

import org.dedda.games.scheisse_server.entity.User;

public class UserContainer {

    public final long id;
    public final String name;
    public final String email;
    public final long experience;

    public UserContainer(long id, String name, String passwordHash, String email, long experience) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    public UserContainer(final User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.experience = user.getExperience();
    }
}
