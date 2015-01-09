package org.dedda.games.scheisse.io;

import org.dedda.games.scheisse.state.game.map.Map;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static org.dedda.games.scheisse.state.game.map.soil.Soil.Type;
import static org.dedda.games.scheisse.state.game.map.soil.Soil.Type.*;
import static org.junit.Assert.assertEquals;

public class MapLoaderTest {

    private MapLoader mapLoader;
    private Map map;
    private Type soil[][];

    @Before
    public void setUp() throws Exception {
        mapLoader = new MapLoader(new File("src/test/test_files/classes/org/dedda/games/scheisse/io/MapLoader"));
        map = new Map(new Dimension(5, 4));
        soil = new Type[5][4]/*{
                {DIRT,  DIRT,   DIRT,   DIRT,   GRASS},
                {GRASS, GRASS,  GRASS,  GRASS,  ROCK},
                {ROCK,  ROCK,   ROCK,   ROCK,   WATER},
                {WATER, WATER,  WATER,  WATER,  DIRT}
        }*/;
        soil[0][0] = DIRT;  soil[1][0] = DIRT;  soil[2][0] = DIRT;  soil[3][0] = DIRT;  soil[4][0] = GRASS;
        soil[0][1] = GRASS; soil[1][1] = GRASS; soil[2][1] = GRASS; soil[3][1] = GRASS; soil[4][1] = ROCK;
        soil[0][2] = ROCK;  soil[1][2] = ROCK;  soil[2][2] = ROCK;  soil[3][2] = ROCK;  soil[4][2] = WATER;
        soil[0][3] = WATER; soil[1][3] = WATER; soil[2][3] = WATER; soil[3][3] = WATER; soil[4][3] = DIRT;
        map.setSoil(soil);
    }

    @Test
    public void testLoad() throws Exception {
        Map map = mapLoader.load();
        this.map.print();
        map.print();
        assertEquals(this.map.getSoil(), map.getSoil());
    }

    @Test
    public void testParseMapSoil() throws Exception {
        ArrayList<String> soilData = new ArrayList<String>();
        soilData.add("DDDDG");
        soilData.add("GGGGR");
        soilData.add("RRRRW");
        soilData.add("WWWWD");
        Type soil[][] = mapLoader.parseMapSoil(soilData, new Dimension(5, 4));
        assertEquals(this.soil, soil);
    }
}