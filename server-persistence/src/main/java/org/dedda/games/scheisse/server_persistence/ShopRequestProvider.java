package org.dedda.games.scheisse.server_persistence;

import org.dedda.games.scheisse.entity.ShopRequest;
import org.dedda.games.scheisse.entity.User;
import org.dedda.games.scheisse.entity.item.Item;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
@Stateless
public class ShopRequestProvider {

    @PersistenceContext(unitName = "org.dedda.games.scheisse_server-PU")
    private EntityManager em;
    
    @Inject
    private ItemProvider itemProvider;
    
    @Inject
    private UserProvider userProvider;
    
    public final List<ShopRequest> getForUser(final User user) {
        TypedQuery<ShopRequest>  query = em.createNamedQuery("shopRequest.getForUser", ShopRequest.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    public final List<ShopRequest> getForUser(final long userId) {
        TypedQuery<ShopRequest>  query = em.createNamedQuery("shopRequest.getForUser", ShopRequest.class);
        User user = userProvider.getUser(userId);
        query.setParameter("user", user);
        return query.getResultList();
    }

    public final List<ShopRequest> getForPrice(final long price) {
        TypedQuery<ShopRequest>  query = em.createNamedQuery("shopRequest.getForPrice", ShopRequest.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    public final List<ShopRequest> getForItem(final Item item) {
        TypedQuery<ShopRequest> query = em.createNamedQuery("shopRequest.getForItem", ShopRequest.class);
        query.setParameter("item", item);
        return query.getResultList();
    }

}
