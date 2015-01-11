package org.dedda.games.scheisse.gui.resource;

import org.dedda.games.scheisse.exception.gui.ResourcePackException;
import org.dedda.games.scheisse.io.resource.Resource;

import java.io.File;
import java.util.HashMap;

import static org.dedda.games.scheisse.exception.gui.ResourcePackException.ALREADY_REGISTERED;

/**
 * Created by dedda on 11.01.15.
 */
public class ResourcePack {

    private static HashMap<String, ResourcePack> installedPacks =
            new HashMap<String, ResourcePack>();

    public final String name;
    public final File baseDirectory;
    public final SpritePack[] spritePacks;

    public ResourcePack(String name) {
        this.name = name;
        baseDirectory = new File(Resource.IMAGE_FOLDER + name + "/");
        spritePacks = new SpritePack[]{
                new DecorationPack(this)
        };
    }

    public static void registerPack(ResourcePack pack)
            throws ResourcePackException
    {
        String name = pack.name;
        if (installedPacks.containsKey(name)) {
            throw new ResourcePackException(ALREADY_REGISTERED);
        }
        installedPacks.put(name, pack);
    }

}
