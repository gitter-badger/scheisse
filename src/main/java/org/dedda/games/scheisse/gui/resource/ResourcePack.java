package org.dedda.games.scheisse.gui.resource;

import org.dedda.games.scheisse.exception.gui.ResourcePackException;
import org.dedda.games.scheisse.io.resource.Resource;

import java.io.File;
import java.util.HashMap;

import static org.dedda.games.scheisse.exception.gui.ResourcePackException.ALREADY_REGISTERED;
import static org.dedda.games.scheisse.exception.gui.ResourcePackException.NO_SUCH_SPRITE;

/**
 * Created by dedda on 11.01.15.
 */
public class ResourcePack {

    private static final int DECORATION_OFFSET = 0;

    private static final int MENU_OFFSET = DECORATION_OFFSET + DecorationPack.LENGTH;

    private static final int SOIL_OFFSET = MENU_OFFSET + MenuPack.LENGTH;

    private static final int PLAYER_OFFSET = SOIL_OFFSET + SoilPack.LENGTH;

    private static final int NPC_OFFSET = PLAYER_OFFSET + PlayerPack.LENGTH;

    private static HashMap<String, ResourcePack> installedPacks =
            new HashMap<String, ResourcePack>();

    public final String name;
    public final File baseDirectory;
    public final SpritePack[] spritePacks;

    public ResourcePack(String name) {
        this.name = name;
        baseDirectory = new File(Resource.IMAGE_FOLDER + name + "/");
        spritePacks = new SpritePack[]{
                new DecorationPack(this),
                new MenuPack(this),
                new SoilPack(this),
                new PlayerPack(this),
                new NPCPack(this)
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

    public Sprite get(int key) throws ResourcePackException {
        if (key < DECORATION_OFFSET) {
            throw new ResourcePackException(NO_SUCH_SPRITE);
        } else if (key < MENU_OFFSET) {
            return spritePacks[0].get(key - DECORATION_OFFSET);
        } else if (key < SOIL_OFFSET) {
            return spritePacks[1].get(key - MENU_OFFSET);
        } else if (key < PLAYER_OFFSET) {
            return spritePacks[2].get(key - SOIL_OFFSET);
        } else if (key < NPC_OFFSET) {
            return spritePacks[3].get(key - PLAYER_OFFSET);
        } else if (key < NPC_OFFSET - NPCPack.LENGTH) {
            return spritePacks[4].get(key - NPC_OFFSET);
        }
        throw new ResourcePackException(NO_SUCH_SPRITE);
    }

}
