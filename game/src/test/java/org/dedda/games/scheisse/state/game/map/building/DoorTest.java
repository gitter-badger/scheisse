package org.dedda.games.scheisse.state.game.map.building;

import junit.framework.TestCase;
import org.dedda.games.scheisse.state.game.Direction;

public class DoorTest extends TestCase {

    private Door door;

    public void testCanPass() throws Exception {
        door = new Door(
                null,
                null,
                new Direction[]{Direction.LEFT, Direction.RIGHT},
                false
        );
        assertTrue(door.canPass(Direction.LEFT, null));
        assertTrue(door.canPass(Direction.RIGHT, null));
    }
}