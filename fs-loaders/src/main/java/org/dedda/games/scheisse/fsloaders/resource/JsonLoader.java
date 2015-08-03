package org.dedda.games.scheisse.fsloaders.resource;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dedda on 7/30/15.
 *
 * @author dedda
 */
public class JsonLoader extends FileInput {

    public JsonObject readRoot(final File file) throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileInputStream(file));
        JsonObject root = reader.readObject();
        return root;
    }

}
