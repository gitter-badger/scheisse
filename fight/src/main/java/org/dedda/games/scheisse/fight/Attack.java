package org.dedda.games.scheisse.fight;

import java.util.Map;

/**
 * Created by dedda on 27.01.15.
 */
public class Attack {

    /**
     * basic damage dealt by attack.
     */
    public final long baseDamage;

    /**
     * elemental damage dealt for specific elements.
     */
    public final Map<AttackElement, Long> elementalDamage;

    /**
     * @param baseDamage      basic damage dealt by attack
     * @param elementalDamage elemental damage dealt for specific elements
     */
    public Attack(final long baseDamage, final Map<AttackElement, Long> elementalDamage) {
        this.baseDamage = baseDamage;
        this.elementalDamage = elementalDamage;
    }
}
