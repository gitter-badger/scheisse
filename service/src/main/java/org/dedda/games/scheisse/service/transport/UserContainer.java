package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.User;

/**
 * Container for transporting {@link User}s.
 *
 * @author dedda
 */
public class UserContainer {

    /**
     * user id.
     *
     * @see User#id
     */
    public final long id;
    /**
     * username.
     *
     * @see User#name
     */
    public final String name;
    /**
     * account e-mail.
     *
     * @see User#email
     */
    public final String email;
    /**
     * experience of {@link User}.
     *
     * @see User#experience
     */
    public final long experience;

    /**
     *
     * @param id user id
     * @param name username
     * @param email account e-mail
     * @param experience experience of {@link User}
     *
     * @see User#id
     * @see User#name
     * @see User#email
     * @see User#experience
     */
    public UserContainer(final long id, final String name, final String email, final long experience) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    /**
     *
     * @param user {@link User} to convert
     *
     * @see User
     */
    public UserContainer(final User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.experience = user.getExperience();
    }

    /**
     *
     * @return user id
     *
     * @see User#id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @return username
     *
     * @see User#name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return account e-mail
     *
     * @see User#email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return user experience
     *
     * @see User#experience
     */
    public long getExperience() {
        return experience;
    }
}
