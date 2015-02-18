package org.dedda.games.scheisse.state.game.item;

import org.dedda.games.scheisse.state.game.object.Person;

/**
 * Created by dedda on 4/18/14.
 */
public interface Wearable {

    /**
     *
     * @param person Person - person to draw on
     */
    public void render(final Person person);

}
