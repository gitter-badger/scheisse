package org.dedda.games.scheisse.fsloaders.resource;

import org.dedda.games.scheisse.fsloaders.resource.world.map.MapLoader;
import org.dedda.games.scheisse.world.Map;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static org.dedda.games.scheisse.fsloaders.resource.TestFiles.MAP_LOADER_FILE;
import static org.dedda.games.scheisse.world.soil.Soil.Type;
import static org.dedda.games.scheisse.world.soil.Soil.Type.DIRT;
import static org.dedda.games.scheisse.world.soil.Soil.Type.GRASS;
import static org.dedda.games.scheisse.world.soil.Soil.Type.ROCK;
import static org.dedda.games.scheisse.world.soil.Soil.Type.WATER;
import static org.junit.Assert.assertEquals;

public class MapLoaderTest {

    private MapLoader mapLoader;
    private Map map;
    private Type soil[][];

    @Before
    public void setUp() throws Exception {
        mapLoader = new MapLoader();
        map = new Map(new Dimension(3, 3));
        soil = new Type[3][3];

        soil[0][0] = GRASS;
        soil[1][0] = ROCK;
        soil[2][0] = DIRT;

        soil[0][1] = WATER;
        soil[1][1] = GRASS;
        soil[2][1] = ROCK;

        soil[0][2] = DIRT;
        soil[1][2] = WATER;
        soil[2][2] = GRASS;

        map.setSoil(soil);
        map.setLocation(new Point(1, 2));
    }

    @Test
    public void testLoad() throws Exception {
        Map map = mapLoader.load(new File(MAP_LOADER_FILE));
        assertEquals(this.map.getSoil(), map.getSoil());
        assertEquals(this.map.getSize(), map.getSize());
        assertEquals(this.map.getLocation(), map.getLocation());
    }

}
