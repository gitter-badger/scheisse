package org.dedda.games.scheisse.world;

import org.dedda.games.scheisse.world.soil.Soil;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import static org.dedda.games.scheisse.world.Chunk.CHUNK_SIZE;

/**
 * @author dedda
 */
public class Map {

    private Dimension size;
    private Dimension chunkGridSize;
    private Chunk[][] chunk;
    private ArrayList<MapObject> objects;

    /**
     * @param size Dimension
     */
    public Map(final Dimension size) {
        init(size, new ArrayList<MapObject>());
    }

    /**
     * @param size    Dimension
     * @param objects ArrayList<MapObject> - inital objects on the map
     */
    private final void init(
        final Dimension size,
        final ArrayList<MapObject> objects
    ) {
        this.size = size;

        // init chunks:
        float chunksXf = (float) size.width / CHUNK_SIZE;
        float chunksYf = (float) size.height / CHUNK_SIZE;
        int chunksXi = (int) chunksXf;
        int chunksYi = (int) chunksYf;
        if ((float) chunksXi < chunksXf) {
            chunksXi++;
        }
        if ((float) chunksYi < chunksYf) {
            chunksYi++;
        }
        chunkGridSize = new Dimension(chunksXi, chunksYi);
        this.chunk = new Chunk[chunksXi][chunksYi];
        for (int x = 0; x < chunksXi; x++) {
            int minX = x * CHUNK_SIZE;
            int maxX = ((x + 1) * CHUNK_SIZE < size.width) ?
                ((x + 1) * CHUNK_SIZE) :
                size.width;
            for (int y = 0; y < chunksYi; y++) {
                int minY = y * CHUNK_SIZE;
                int maxY = ((y + 1) * CHUNK_SIZE < size.height) ?
                    ((y + 1) * CHUNK_SIZE) :
                    size.height;
                this.chunk[x][y] = new Chunk(
                    new Point(minX, minY), new Point(maxX, maxY)
                );
            }
        }
        setObjects(objects);
    }

    public void update() {

    }

    /**
     * @param object MapObject
     */
    public final void addObject(final MapObject object) {
        this.objects.add(object);
        addObjectToChunks(object);
    }

    /**
     * adds the guiElement to all corresponding chunks.
     *
     * @param object MapObject
     */
    private final void addObjectToChunks(final MapObject object) {
        Point objectMin = object.getLocation();
        Point objectMax = new Point(
            objectMin.x + object.getSize().width,
            objectMin.y + object.getSize().height
        );
        int chunkMinX = objectMin.x / CHUNK_SIZE;
        int chunkMinY = objectMin.y / CHUNK_SIZE;
        int chunkMaxX = objectMax.x / CHUNK_SIZE
            + (((float) objectMax.x / CHUNK_SIZE
            > objectMax.x / CHUNK_SIZE) ? (0) : (1));
        int chunkMaxY = objectMax.y / CHUNK_SIZE
            + (((float) objectMax.y / CHUNK_SIZE
            > objectMax.y / CHUNK_SIZE) ? (0) : (1));
        for (int x = chunkMinX; x <= chunkMaxX; x++) {
            for (int y = chunkMinY; y <= chunkMaxY; y++) {
                chunk[x][y].addObject(object);
            }
        }
    }

    /**
     * @param objects ArrayList<MapObject> - objects on the map
     */
    public final void setObjects(final ArrayList<MapObject> objects) {
        this.objects = objects;
        for (MapObject object : objects) {
            addObjectToChunks(object);
        }
    }

    /**
     * @param objects MapObject[] - objects on the map
     */
    public final void setObjects(final MapObject[] objects) {
        for (MapObject object : objects) {
            addObject(object);
            addObjectToChunks(object);
        }
    }

    /**
     * @param location Point
     * @param soil     int
     */
    public final void setSoil(final Point location, final Soil.Type soil) {
        int chunkX = location.x / CHUNK_SIZE;
        int chunkY = location.y / CHUNK_SIZE;
        this.chunk[chunkX][chunkY].setSoilAbsolute(location, soil);
    }

    /**
     * @param soil int[][]
     */
    public final void setSoil(final Soil.Type[][] soil) {
        for (int x = 0; x < size.width; x++) {
            for (int y = 0; y < size.height; y++) {
                setSoil(new Point(x, y), soil[x][y]);
            }
        }
    }

    /**
     * @return int[][]
     */
    public final Soil.Type[][] getSoil() {
        Soil.Type[][] soil = new Soil.Type[size.width][size.height];
        for (int x = 0; x < size.width; x++) {
            for (int y = 0; y < size.height; y++) {
                soil[x][y] = chunk[x / CHUNK_SIZE][y / CHUNK_SIZE]
                    .getSoil()[x - x / CHUNK_SIZE][y - y / CHUNK_SIZE];
            }
        }
        return soil;
    }

    /**
     * @return Dimension
     */
    public final Dimension getSize() {
        return size;
    }

    /**
     * @return Dimension
     */
    public final Dimension getChunkGridSize() {
        return chunkGridSize;
    }

    /**
     * @return Chunk[][]
     */
    public final Chunk[][] getChunk() {
        return chunk;
    }

    /**
     * @return ArrayList<MapObject> - objects ob the map
     */
    public final ArrayList<MapObject> getObjects() {
        return objects;
    }

    public final void print() {
//        SystemPrinter.debugln("Map:");
//        SystemPrinter.debugln("size: " + size);
//        SystemPrinter.debugln("chunk grid size: " + chunkGridSize);
//        for (int i = 0; i < size.height; i++) {
//            for (int k = 0; k < size.width; k++) {
//                SystemPrinter.debug(
//                    String.valueOf(getSoil()[k][i]).charAt(0) + ""
//                );
//            }
//            SystemPrinter.debugln("");
//        }
    }

    @Override
    public final boolean equals(final Object object) {
        if (!(object instanceof Map)) {
            return false;
        }
        Map map = (Map) object;
        if (map.chunkGridSize.width != this.chunkGridSize.width
            || map.chunkGridSize.height != this.chunkGridSize.height) {
            return false;
        }
        for (int x = 0; x < chunkGridSize.width; x++) {
            for (int y = 0; y < chunkGridSize.height; y++) {
                if (!this.chunk[x][y].equals(map.chunk[x][y])) {
                    return false;
                }
            }
        }
        if (this.objects.size() != map.objects.size()) {
            return false;
        }

        return true;
    }

}
