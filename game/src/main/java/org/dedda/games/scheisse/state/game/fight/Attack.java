package org.dedda.games.scheisse.state.game.fight;

import java.util.Map;

/**
 * Created by dedda on 27.01.15.
 */
public class Attack {

    public final long baseDamage;
    public final Map<AttackElement, Long> elementalDamage;

    public Attack(long baseDamage, Map<AttackElement, Long> elementalDamage) {
        this.baseDamage = baseDamage;
        this.elementalDamage = elementalDamage;
    }
}
