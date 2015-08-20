package org.dedda.games.scheisse.fsloaders.resource;

import org.dedda.games.scheisse.fsloaders.resource.BinaryResource;
import org.dedda.games.scheisse.fsloaders.resource.PackageReader;
import org.junit.Test;

import java.io.File;

import static org.dedda.games.scheisse.fsloaders.resource.TestFiles.PACKAGE_READER_FILE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PackageReaderTest {

    @Test
    public void testReadPackage() throws Exception {
        File packageFile = new File(PACKAGE_READER_FILE);
        PackageReader packageReader = new PackageReader();
        BinaryResource[] resources = {
            new BinaryResource(
                new byte[]{
                    0x64,
                    0x62,
                    0x66,
                    0x70},
                0x0001),
            new BinaryResource(
                new byte[]{
                    0x50,
                    0x45,
                    0x53,
                    0x54,
                    0x76,
                    0x70,
                    0x43,
                    0x41,
                    0x62,
                    0x61},
                0x5C01)
        };
        BinaryResource actualResources[] =
            packageReader.readPackage(packageFile);
        assertTrue(resources.length == actualResources.length);
        if (resources.length == actualResources.length) {
            for (int i = 0; i < resources.length; i++) {
                assertEquals(resources[i], actualResources[i]);
            }
        }
    }
}
