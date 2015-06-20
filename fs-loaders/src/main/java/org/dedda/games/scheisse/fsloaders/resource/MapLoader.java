package org.dedda.games.scheisse.fsloaders.resource;

import org.dedda.games.scheisse.world.Map;
import org.dedda.games.scheisse.world.soil.Soil;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by dedda on 4/19/14.
 */
public class MapLoader extends FileInput {

    private String folder;

    /**
     * @param folder String - parent folder for map files
     */
    public MapLoader(final String folder) {
        this.folder = folder;
    }

    /**
     * @param folder File - parent folder for map files
     */
    public MapLoader(final File folder) {
        this.folder = folder.getAbsolutePath();
    }

    /**
     * @return Map - map from given folder
     */
    public Map load() {
        Map map = null;

        String fileData = read(new File(folder));
        ArrayList<String> mapProperties = new ArrayList<>();
        ArrayList<String> propertyValues = new ArrayList<>();
        ArrayList<String> mapLines = new ArrayList<>();
        String line = "";
        for (int i = 0; i < fileData.length(); i++) {
            char currentChar = fileData.charAt(i);
            if (currentChar == '\n') {
                if (line != "") {
                    mapProperties.add(
                        line.substring(0, line.indexOf((int) ':'))
                    );
                    propertyValues.add(
                        line.substring(line.indexOf((int) ':') + 1)
                    );
                }
                line = "";
            } else {
                line += fileData.charAt(i);
            }
        }
        Dimension mapSize = new Dimension();
        Point mapLocation = new Point();

        for (int i = 0; i < mapProperties.size(); i++) {
            String property = mapProperties.get(i);
            String value = propertyValues.get(i);
            if (property.equals(GameDataWords.MAP_WIDTH)) {
                mapSize.width = Integer.parseInt(value);
            } else if (property.equals(GameDataWords.MAP_HEIGHT)) {
                mapSize.height = Integer.parseInt(value);
            } else if (property.equals(GameDataWords.MAP_X)) {
                mapLocation.x = Integer.parseInt(value);
            } else if (property.equals(GameDataWords.MAP_Y)) {
                mapLocation.y = Integer.parseInt(value);
            } else if (property.equals(GameDataWords.MAP_LINE)) {
                mapLines.add(value);
            }
        }
        map = new Map(mapSize);
        map.setSoil(parseMapSoil(mapLines, mapSize));
        return map;
    }

    /**
     * @param soilData ArrayList<String> - lines from map file
     * @param size     Dimension - size of the map
     * @return int[][] - soil data
     */
    public Soil.Type[][] parseMapSoil(
        final ArrayList<String> soilData,
        final Dimension size
    ) {
        Soil.Type[][] soil = new Soil.Type[size.width][size.height];
        String number = "";
        for (int y = 0; y < soilData.size(); y++) {
            String line = soilData.get(y);
            int mapX = 0;
            for (int x = 0; x < line.length(); x++) {
                if (Character.isDigit(line.charAt(x))) {
                    number += line.charAt(x);
                } else {
                    char currentChar = line.charAt(x);
                    Soil.Type currentSoil = null;
                    if (currentChar == GameDataWords.MAP_GRASS) {
                        currentSoil = Soil.Type.GRASS;
                    } else if (currentChar == GameDataWords.MAP_ROCK) {
                        currentSoil = Soil.Type.ROCK;
                    } else if (currentChar == GameDataWords.MAP_DIRT) {
                        currentSoil = Soil.Type.DIRT;
                    } else if (currentChar == GameDataWords.MAP_WATER) {
                        currentSoil = Soil.Type.WATER;
                    }
                    int soilCount;
                    if (number.equals("")) {
                        soilCount = 1;
                    } else {
                        soilCount = Integer.parseInt(number);
                    }
                    for (int i = 0; i < soilCount; i++, mapX++) {
                        soil[mapX][y] = currentSoil;
                    }
                    number = "";
                }
            }
        }
        return soil;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof MapLoader) {
            MapLoader mapLoader = (MapLoader) object;
            return mapLoader.folder.equals(this.folder);
        }
        return false;
    }

}
