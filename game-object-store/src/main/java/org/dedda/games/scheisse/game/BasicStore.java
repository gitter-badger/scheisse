package org.dedda.games.scheisse.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dedda on 7/25/15.
 *
 * @author dedda
 */
public abstract class BasicStore<T> {

    private Map<Long, T> objectsMap;
    private long idCounter = 0;

    public BasicStore() {
        this.objectsMap = new HashMap<>();
    }

    public T getValue(final long id) {
        if (objectsMap.containsKey(id)) {
            return objectsMap.get(id);
        }
        return null;
    }

    public long getKey(final T object) {
        for (Map.Entry<Long, T> e : objectsMap.entrySet()) {
            if (e.getValue().equals(object)) {
                return e.getKey();
            }
        }
        return -1;
    }

    public long register(final T object) {
        long key = getKey(object);
        if (key > -1) {
            return key;
        }
        objectsMap.put(idCounter, object);
        key = idCounter;
        idCounter++;
        registerEvent(key, object);
        return key;
    }

    public void unregister(final T object) {
        long key = getKey(object);
        if (key > -1) {
            objectsMap.remove(key);
            unregisterEvent(key, object);
        }
    }

    public long getIdCounter() {
        return idCounter;
    }

    protected abstract void registerEvent(long key, T object);
    protected abstract void unregisterEvent(long key, T object);

}
