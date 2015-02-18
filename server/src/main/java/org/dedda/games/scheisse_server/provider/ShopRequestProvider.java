package org.dedda.games.scheisse_server.provider;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.dedda.games.scheisse_server.entity.Item;
import org.dedda.games.scheisse_server.entity.ShopRequest;
import org.dedda.games.scheisse_server.entity.User;

@Named
@Stateless
public class ShopRequestProvider {

    @PersistenceContext(unitName = "org.dedda.games.scheisse_server-PU")
    private EntityManager em;
    
    @Inject
    private ItemProvider itemProvider;
    
    @Inject
    private UserProvider userProvider;
    
    public List<ShopRequest> getForUser(final User user) {
        TypedQuery<ShopRequest>  query = em.createNamedQuery("shopRequest.getForUser", ShopRequest.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    public List<ShopRequest> getForPrice(final long price) {
        TypedQuery<ShopRequest>  query = em.createNamedQuery("shopRequest.getForPrice", ShopRequest.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    public List<ShopRequest> getForItem(final Item item) {
        TypedQuery<ShopRequest> query = em.createNamedQuery("shopRequest.getForItem", ShopRequest.class);
        query.setParameter("item", item);
        return query.getResultList();
    }

}
