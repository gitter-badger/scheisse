package scheisse.game_ai;

import scheisse.game_ai.behaviour.Mob;

/**
 * Created by sgoeppentin on 19.06.15.
 *
 * @author dedda
 */
public interface MobStore {

    Mob getMob(final String id);

    String putMob(final Object mobObject);

}
