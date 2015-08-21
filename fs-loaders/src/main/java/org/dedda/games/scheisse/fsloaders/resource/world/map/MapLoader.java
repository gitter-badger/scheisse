package org.dedda.games.scheisse.fsloaders.resource.world.map;

import org.dedda.games.scheisse.fsloaders.resource.GameDataWords;
import org.dedda.games.scheisse.fsloaders.resource.JsonLoader;
import org.dedda.games.scheisse.tool.Parse;
import org.dedda.games.scheisse.world.Map;
import org.dedda.games.scheisse.world.soil.Soil;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by dedda on 4/19/14.
 *
 * @author dedda
 */
public class MapLoader extends JsonLoader {

    public Map load(final File file) throws FileNotFoundException {
        Map map;
        JsonObject root = readRoot(file);
        String sizeS = root.getString("size");
        Dimension size = Parse.toDimension(sizeS);
        map = new Map(size);
        String locationS = root.getString("location");
        Point location = Parse.toPoint(locationS);
        map.setLocation(location);
        JsonArray soilJson = root.getJsonArray("soil");
        Soil.Type soil[][] = parseSoil(soilJson, size);
        map.setSoil(soil);
        return map;
    }

    private Soil.Type[][] parseSoil(final JsonArray soilJson, final Dimension size) {
        Soil.Type soil[][] = new Soil.Type[size.width][size.height];
        int soilLineCount = soilJson.size();
        if (soilLineCount != size.height) {
            throw new RuntimeException("Wrong line count");
        }
        for (int y = 0; y < soilLineCount; y++) {
            char[] soilChars = soilJson.getString(y).toCharArray();
            if (soilChars.length != size.width) {
                throw new RuntimeException("Wrong line length");
            }
            for (int x = 0; x < soilChars.length; x++) {
                soil[x][y] = parseSoil(soilChars[x]);
            }
        }
        return soil;
    }

//    /**
//     * @return Map - map from given folder
//     */
//    public Map load(final File file) {
//        Map map = null;
//
//        String fileData = read(file);
//        ArrayList<String> mapProperties = new ArrayList<>();
//        ArrayList<String> propertyValues = new ArrayList<>();
//        ArrayList<String> mapLines = new ArrayList<>();
//        String line = "";
//        for (int i = 0; i < fileData.length(); i++) {
//            char currentChar = fileData.charAt(i);
//            if (currentChar == '\n') {
//                if (line != "") {
//                    mapProperties.add(
//                        line.substring(0, line.indexOf((int) ':'))
//                    );
//                    propertyValues.add(
//                        line.substring(line.indexOf((int) ':') + 1)
//                    );
//                }
//                line = "";
//            } else {
//                line += fileData.charAt(i);
//            }
//        }
//        Dimension mapSize = new Dimension();
//        Point mapLocation = new Point();
//
//        for (int i = 0; i < mapProperties.size(); i++) {
//            String property = mapProperties.get(i);
//            String value = propertyValues.get(i);
//            if (property.equals(GameDataWords.MAP_WIDTH)) {
//                mapSize.width = Integer.parseInt(value);
//            } else if (property.equals(GameDataWords.MAP_HEIGHT)) {
//                mapSize.height = Integer.parseInt(value);
//            } else if (property.equals(GameDataWords.MAP_X)) {
//                mapLocation.x = Integer.parseInt(value);
//            } else if (property.equals(GameDataWords.MAP_Y)) {
//                mapLocation.y = Integer.parseInt(value);
//            } else if (property.equals(GameDataWords.MAP_LINE)) {
//                mapLines.add(value);
//            }
//        }
//        map = new Map(mapSize);
//        map.setSoil(parseMapSoil(mapLines, mapSize));
//        return map;
//    }
//
//    /**
//     * @param soilData ArrayList<String> - lines from map file
//     * @param size     Dimension - size of the map
//     * @return int[][] - soil data
//     */
//    public Soil.Type[][] parseMapSoil(
//        final ArrayList<String> soilData,
//        final Dimension size
//    ) {
//        Soil.Type[][] soil = new Soil.Type[size.width][size.height];
//        String number = "";
//        for (int y = 0; y < soilData.size(); y++) {
//            String line = soilData.get(y);
//            int mapX = 0;
//            for (int x = 0; x < line.length(); x++) {
//                if (Character.isDigit(line.charAt(x))) {
//                    number += line.charAt(x);
//                } else {
//                    char currentChar = line.charAt(x);
//                    Soil.Type currentSoil = null;
//                    if (currentChar == GameDataWords.MAP_GRASS) {
//                        currentSoil = Soil.Type.GRASS;
//                    } else if (currentChar == GameDataWords.MAP_ROCK) {
//                        currentSoil = Soil.Type.ROCK;
//                    } else if (currentChar == GameDataWords.MAP_DIRT) {
//                        currentSoil = Soil.Type.DIRT;
//                    } else if (currentChar == GameDataWords.MAP_WATER) {
//                        currentSoil = Soil.Type.WATER;
//                    }
//                    int soilCount;
//                    if (number.equals("")) {
//                        soilCount = 1;
//                    } else {
//                        soilCount = Integer.parseInt(number);
//                    }
//                    for (int i = 0; i < soilCount; i++, mapX++) {
//                        soil[mapX][y] = currentSoil;
//                    }
//                    number = "";
//                }
//            }
//        }
//        return soil;
//    }

    private Soil.Type parseSoil(final char c) {
        Soil.Type currentSoil = null;
        if (c == GameDataWords.MAP_GRASS) {
            currentSoil = Soil.Type.GRASS;
        } else if (c == GameDataWords.MAP_ROCK) {
            currentSoil = Soil.Type.ROCK;
        } else if (c == GameDataWords.MAP_DIRT) {
            currentSoil = Soil.Type.DIRT;
        } else if (c == GameDataWords.MAP_WATER) {
            currentSoil = Soil.Type.WATER;
        }
        return currentSoil;
    }

    @Override
    public boolean equals(final Object object) {
        return object instanceof MapLoader;
    }

}
