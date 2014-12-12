package org.dedda.games.scheisse.state.game.map;

import org.dedda.games.scheisse.state.game.map.soil.Soil;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dedda on 4/18/14.
 */
public class Chunk {

    public static final int CHUNK_SIZE = 16;

    private Point minLocation;
    private Point maxLocation;
    private ArrayList<MapObject> objects;
    private Soil.Type soil[][];

    /**
     *
     * @param minLocation Point - x and y from left upper corner
     * @param maxLocation Point - x and y from right bottom corner
     */
    public Chunk(final Point minLocation, final Point maxLocation) {
        this.minLocation = minLocation;
        this.maxLocation = maxLocation;
        soil = new Soil.Type[CHUNK_SIZE][CHUNK_SIZE];
    }

    /**
     *
     * @return ArrayList<MapObject> - objects in this chunk
     */
    public ArrayList<MapObject> getObjects() {
        return objects;
    }

    /**
     *
     * @param objects ArrayList<MapObject> - objects in this chunk
     */
    public void setObjects(final ArrayList<MapObject> objects) {
        this.objects = objects;
    }

    /**
     *
     * @param object MapObject
     */
    public void addObject(final MapObject object){
        this.objects.add(object);
    }

    /**
     *
     * @return int[][] - soil in this chunk
     */
    public Soil.Type[][] getSoil() {
        return soil;
    }

    /**
     *
     * @param soil int[][] - soil in this chunk
     */
    public void setSoil(final Soil.Type[][] soil) {
        this.soil = soil;
    }

    /**
     *
     * @param location Point - location on map
     * @param soil int
     */
    public void setSoilAbsolute(final Point location, final Soil.Type soil) {
        this.soil[location.x - minLocation.x][location.y - minLocation.y] = soil;
    }

    /**
     *
     * @param location Point - location on chunk
     * @param soil int
     */
    public void setSoilRelative(final Point location, final Soil.Type soil) {
        this.soil[location.x][location.y] = soil;
    }

    /**
     *
     * @return Point
     */
    public Point getMinLocation() {
        return minLocation;
    }

    /**
     *
     * @return Point
     */
    public Point getMaxLocation() {
        return maxLocation;
    }

    @Override
    public boolean equals(final Object object) {
        if(!(object instanceof Chunk)){
            return false;
        }
        Chunk chunk = (Chunk)object;
        if (!chunk.maxLocation.equals(this.maxLocation)) {
            return false;
        }
        if (!chunk.minLocation.equals(this.minLocation)) {
            return false;
        }
        if (!chunk.objects.equals(this.objects)) {
            return false;
        }
        if (!chunk.soil.equals(this.soil)) {
            return false;
        }
        return true;
    }
}
