/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.server_persistence;

import org.dedda.games.scheisse.entity.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author dedda
 */
@Named
@Stateless
public class UserProvider {

    @PersistenceContext(unitName = "org.dedda.games.scheisse_server-PU")
    private EntityManager em;
    
    public boolean userExists(final long id) {
        return getUser(id) != null;
    }

    public boolean userExists(final String name) {
        return getUser(name) != null;
    }
    
    public boolean emailExists(final String email) {
        return getUserByEmail(email) != null;
    }
    
    public User getUser(final long id) {
        User user = null;
        user = em.find(User.class, id);
        return user;
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createNamedQuery("user.getAll", User.class);
        return query.getResultList();
    }
    
    public User getUser(final String username) {
        User user = null;
        TypedQuery<User> query = em.createNamedQuery("user.getByName", User.class);
        query.setParameter("name", username);
        List<User> users = query.getResultList();
        if (users.size() != 0) {
            user = users.get(0);
        }
        return user;
    }
    
    public User getUserByEmail(final String email) {
        User user = null;
        TypedQuery<User> query = em.createNamedQuery("user.getByMail", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        if (users.size() != 0) {
            user = users.get(0);
        }
        return user;
    }
    
    public List<String> getAllUserNames() {
        List<String> usernames = null;
        TypedQuery<String> query = em.createNamedQuery("user.getAllNames", String.class);
        usernames = query.getResultList();
        return usernames;
    }
    
    /**
     * Saves a new {@link org.dedda.games.scheisse.entity.User} to the database
     * @param user
     * @return id of the new {@link org.dedda.games.scheisse.entity.User}, -1 if not successful
     */
    public User saveNewUser(final User user) {
        User existing = getUser(user.getName());
        if (existing != null) {
            return null;
        }
        em.persist(user);
        em.flush();
        return getUser(user.getName());
    }
    
    public User register(final String name, final String password, final String email) {
        return null;
    }
    
}
