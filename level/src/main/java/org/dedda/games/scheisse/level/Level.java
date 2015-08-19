package org.dedda.games.scheisse.level;

/**
 * Class for the leveling system.
 * <p/>
 * Here you find everything you want to know about levels and
 * needed experience.
 * <p/>
 * Created by dedda on 7/22/14.
 *
 * @author dedda
 */
public abstract class Level {

    /**
     * Private constructor.
     */
    private Level() {

    }

    /**
     * Minimum experience that is needed to be specific levels.
     */
    public static final long[] MIN_XP_FOR_LEVELS = new long[]{
        0,
        100,
        230,
        400,
        580
    };

    /**
     * @param experience Amount of experience the
     *                   {@link org.dedda.games.scheisse.state.game.Player} or
     *                   {@link NPC} has
     * @return The resulting level from the given amount of experience
     */
    public static int getLevel(final long experience) {
        int level = 0;
        for (int i = 0; i < Level.MIN_XP_FOR_LEVELS.length; i++) {
            if (experience >= Level.MIN_XP_FOR_LEVELS[i]) {
                level = i;
            } else {
                break;
            }
        }
        return level;
    }
}
