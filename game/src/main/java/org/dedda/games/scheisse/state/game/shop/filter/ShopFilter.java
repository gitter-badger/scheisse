package org.dedda.games.scheisse.state.game.shop.filter;

import org.dedda.games.scheisse.state.game.shop.Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dedda on 11/30/14.
 */
public abstract class ShopFilter {

    public abstract boolean accept(Offer offer);

    public List<Offer> accept(List<Offer> offers) {
        LinkedList<Offer> list = new LinkedList<Offer>();
        for (Offer offer : offers) {
            if (accept(offer)) {
                list.add(offer);
            }
        }
        return list;
    }

}
