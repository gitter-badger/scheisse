package org.dedda.games.scheisse.main;

import org.dedda.games.scheisse.fsloaders.resource.FileInput;
import org.dedda.games.scheisse.tool.Parse;
import org.junit.Test;

import java.awt.Dimension;
import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionsTest {

    @Test
    public void testInitialization() {
        File optionsFile = new File(
            System.getProperty("user.home") + "/.scheisse.conf"
        );
        if (optionsFile.exists()) {
            optionsFile.delete();
        }
        Options.initDefault();
        assertEquals(new Dimension(600, 400), Options.getResolution());
        assertTrue(Options.isCheckInternetConnection());
        assertTrue(optionsFile.exists());
        HashMap<String, String> expectedFileMap =
            new HashMap<String, String>();
        expectedFileMap.put("res", "600,400");
        expectedFileMap.put("check net", "1");
        HashMap<String, String> actualFileMap;
        FileInput input = new FileInput();
        actualFileMap = input.getMap(optionsFile);
        assertEquals(expectedFileMap, actualFileMap);
    }

    @Test
    public void testSet() {
        HashMap<String, String> settingsMap = new HashMap<String, String>();
        settingsMap.put("res", "800,600");
        settingsMap.put("check net", "0");
        Options.set(settingsMap);
        assertEquals(
            Parse.toDimension(settingsMap.get("res")),
            Options.getResolution()
        );
        assertEquals(
            Parse.toBoolean(settingsMap.get("check net")),
            Options.isCheckInternetConnection()
        );
        Options.save();
        FileInput input = new FileInput();
        HashMap<String, String> savedMap = input.getMap(Options.OPTIONS_FILE);
        assertEquals(settingsMap, savedMap);
    }

}
