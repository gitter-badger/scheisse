package org.dedda.games.scheisse.state.game.object;

import org.dedda.games.scheisse.state.game.level.Level;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person();
    }

    @Test
    public void testGetLevel() throws Exception {
        person.setExperience(12);
        assertEquals(0, Level.getLevel(person.experience));
        person.setExperience(100);
        assertEquals(1, Level.getLevel(person.experience));
    }
}