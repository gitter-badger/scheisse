package org.dedda.games.scheisse.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileTypesTest {

    @Test
    public void testInit() throws Exception {
        assertEquals(".dpk", FileTypes.getExtension("dedda_package"));
        assertEquals(".ds", FileTypes.getExtension("dedda_script"));
        assertEquals(".di", FileTypes.getExtension("dedda_item"));
        assertEquals(".dm", FileTypes.getExtension("dedda_map"));
        assertEquals(".dsg", FileTypes.getExtension("dedda_savegame"));
    }
}