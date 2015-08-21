package org.dedda.games.scheisse.fsloaders.resource.world;

import org.dedda.games.scheisse.fsloaders.resource.JsonLoader;
import org.dedda.games.scheisse.fsloaders.resource.world.map.MapLoader;
import org.dedda.games.scheisse.tool.Parse;
import org.dedda.games.scheisse.world.Map;
import org.dedda.games.scheisse.world.World;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by dedda on 11/2/14.
 *
 * @author dedda
 */
public class WorldLoader extends JsonLoader {

    private MapLoader mapLoader;

    public WorldLoader() {
        this.mapLoader = new MapLoader();
    }

    public World load(final File file) throws FileNotFoundException {
        World world = null;
        JsonObject root = readRoot(file);
        String sizeS = root.getString("dimensions");
        Dimension size = Parse.toDimension(sizeS);
        world = new World(size);
        JsonArray mapsJson = root.getJsonArray("map-files");
        int mapCount = mapsJson.size();
        String folder = file.getParent();
        folder += folder.endsWith("/") ? "" : "/";
        for (int i = 0; i < mapCount; i++) {
            String fileName = mapsJson.getString(i);
            File mapFile = new File(folder + fileName);
            Map map = mapLoader.load(mapFile);
            world.setMap(map.getLocation(), map);
        }
        return world;
    }

}
