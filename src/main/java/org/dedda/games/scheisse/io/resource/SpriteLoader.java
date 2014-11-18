package org.dedda.games.scheisse.io.resource;

import org.dedda.games.scheisse.gui.sprite.Sprite;
import org.dedda.games.scheisse.io.FileInput;
import org.dedda.games.scheisse.tool.Parse;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by dedda on 7/21/14.
 */
public class SpriteLoader extends FileInput {

    public static final String LOCATION_ON_OBJECT = "loc";

    public Sprite getSprite(final File imageFile, final File configFile) {
        Map<String, String> map = getMap(configFile);
        Sprite sprite = new Sprite(readImage(imageFile), Parse.toPoint(map.get(LOCATION_ON_OBJECT)), null, null);
        return null;
    }

    public Sprite[] getSprites(final File folder) {
        int i = 0;
        ArrayList<Sprite> sprites = new ArrayList<Sprite>();
        while (
                new File(folder.getAbsolutePath() + "/image" + i + ".png").exists()
             && new File(folder.getAbsolutePath() + "/config" + i + ".dgm").exists()) {
            File configFile = new File(folder.getAbsolutePath() + "/config" + i + ".dgm");
            File imageFile = new File(folder.getAbsolutePath() + "/image" + i + ".png");
            sprites.add(getSprite(imageFile, configFile));
            i++;
        }
        Sprite spriteArray[] = new Sprite[sprites.size()];
        for (int k = 0; k < sprites.size(); k++) {
            spriteArray[k] = sprites.get(k);
        }
        return spriteArray;
    }

}
