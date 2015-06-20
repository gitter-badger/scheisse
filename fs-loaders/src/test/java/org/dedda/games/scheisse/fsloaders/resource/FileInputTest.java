package org.dedda.games.scheisse.fsloaders.resource;

import org.dedda.games.scheisse.fsloaders.resource.FileInput;
import org.junit.Before;
import org.junit.Test;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileInputTest {

    private FileInput fileInput;
    private File[] files;
    private String folder;

    @Before
    public void setUp() {
        folder = "src/test/test_files/classes/" +
            "org/dedda/games/scheisse/io/FileInput/";
        files = new File[]{
            new File(folder + "read"),
            new File(folder + "readImage.png"),
            new File(folder + "readArray"),
            new File(folder + "getLines"),
            new File(folder + "getMap"),
            new File(folder + "getMapEscaped")
        };
        fileInput = new FileInput();
    }

    @Test
    public void testRead() throws Exception {
        File file = files[0];
        String expected = "simple test for reading\nfiles";
        String actual = fileInput.read(file);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadImage() throws Exception {
        Image expected =
            Toolkit.
                getDefaultToolkit().
                getImage(files[1].getAbsolutePath());
        Image actual = fileInput.readImage(files[1]);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadArray() throws Exception {
        File file = files[2];
        int expected[] = new int[]{(int) 'A', (int) 'b', (int) 'C'};
        int actual[] = fileInput.readArray(file);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLines() throws Exception {
        File file = files[3];
        String expected[] = new String[]{
            "line0",
            "line1",
            "line2"
        };
        String actual[] = fileInput.getLines(file);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetMap() throws Exception {
        File file = files[4];
        HashMap<String, String> expected = new HashMap<String, String>();
        expected.put("line0", "value0");
        expected.put("line1", "value1");
        expected.put("line2", "value2");
        HashMap<String, String> actual = fileInput.getMap(file);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMapEscaped() throws Exception {
        File file = files[5];
        HashMap<String, String> expected = new HashMap<String, String>();
        expected.put("line0", "value0");
        expected.put("line1", "value1");
        expected.put("line2", "value2");
        HashMap<String, String> actual = fileInput.getMap(file, true);
        assertEquals(expected, actual);
    }
}
