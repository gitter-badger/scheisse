package org.dedda.games.scheisse.world.building;

import junit.framework.TestCase;
import org.dedda.games.scheisse.tool.Direction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;

import static org.dedda.games.scheisse.tool.Direction.DOWN;
import static org.dedda.games.scheisse.tool.Direction.LEFT;
import static org.dedda.games.scheisse.tool.Direction.UP;

/**
 * @author dedda
 */
@RunWith(Parameterized.class)
public class DoorTest extends TestCase {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new Direction[]{DOWN, UP}, false, DOWN, true},
            {new Direction[]{DOWN, UP}, false, LEFT, false},
            {new Direction[]{DOWN, UP}, true, DOWN, false},
            {new Direction[]{DOWN, UP}, true, LEFT, false},
        });
    }

    @Parameter(value = 0)
    public Direction[] passingDirections;

    @Parameter(value = 1)
    public boolean locked;

    @Parameter(value = 2)
    public Direction direction;

    @Parameter(value = 3)
    public boolean canPass;

    @Test
    public void testCanPass() throws Exception {
        Door door = new Door(null, null, passingDirections, locked);
        assertEquals(canPass, door.canPass(direction, null));
    }
}
