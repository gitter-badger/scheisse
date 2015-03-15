package org.dedda.games.scheisse_server.transport;

import org.dedda.games.scheisse.entity.User;

public class UserContainer {

    public final long id;
    public final String name;
    public final String email;
    public final long experience;

    public UserContainer(final long id, final String name, final String passwordHash, final String email, final long experience) {
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
