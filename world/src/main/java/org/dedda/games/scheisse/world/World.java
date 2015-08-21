package org.dedda.games.scheisse.world;

import java.awt.*;

/**
 * Created by dedda on 8/21/15.
 *
 * @author dedda
 */
public class World {

    private final int width;
    private final int height;

    private Map[][] maps;

    public World(final Dimension size) {
        this.width = size.width;
        this.height = size.height;
        maps = new Map[width][height];
    }

    public World(final int width, final int height) {
        this.width = width;
        this.height = height;
        maps = new Map[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map[][] getMaps() {
        return maps;
    }

    public Map getMap(final Point location) {
        return getMap(location.x, location.y);
    }

    public Map getMap(final int x, final int y) {
        return maps[x][y];
    }

    public World setMaps(final Map[][] maps) {
        if (maps.length > width || maps[0].length > height) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.maps = maps;
        return this;
    }

    public World setMap(final Point location, final Map map) {
        return setMap(location.x, location.y, map);
    }

    public World setMap(final int x, final int y, final Map map) {
        maps[x][y] = map;
        return this;
    }
>>>>>>> master
}
