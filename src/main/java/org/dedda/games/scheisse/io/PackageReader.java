package org.dedda.games.scheisse.io;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.io.resource.BinaryResource;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by dedda on 6/27/14.
 */
public class PackageReader extends FileInput{

    public static final int TYPE_LENGTH = 2;
    public static final int SIZE_LENGTH = 4;

    public BinaryResource[] readPackage(final File file) {
        BinaryResource[] resources;
        ArrayList<BinaryResource> resourceList = new ArrayList<BinaryResource>();
        BufferedInputStream inputStream;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            SystemPrinter.debugln("File " + file.getAbsolutePath() + " can not be found!");
            return null;
        }
        int buffer;
        int byteCount = 0;
        int type = 0;
        int size = 0;
        byte[] data = null;
        int dataCount = 0;
        try {
            while ((buffer = inputStream.read()) != -1){
                if (byteCount < TYPE_LENGTH) {
                    type += (int)Math.pow(256, TYPE_LENGTH - (byteCount + 1)) * buffer;
                } else if (byteCount < TYPE_LENGTH + SIZE_LENGTH) {
                    size += (int)Math.pow(256, SIZE_LENGTH - (byteCount + 1) + TYPE_LENGTH) * buffer;
                } else if (byteCount == TYPE_LENGTH + SIZE_LENGTH) {
                    data = new byte[size];
                    data[dataCount] = (byte)buffer;
                    dataCount++;
                } else {
                    if (byteCount < TYPE_LENGTH + SIZE_LENGTH + size - 1) {
                        data[dataCount] = (byte)buffer;
                        dataCount++;
                    } else {
                        data[dataCount] = (byte)buffer;
                        BinaryResource resource = new BinaryResource(data, type);
                        dataCount = 0;
                        byteCount = 0;
                        size = 0;
                        type = 0;
                        resourceList.add(resource);
                        continue;
                    }
                }
                byteCount++;
            }
        } catch (IOException e) {
            SystemPrinter.debugln("Error reading from file " + file.getAbsolutePath());
            try {
                inputStream.close();
            } catch (IOException e1) {}
            return null;
        }
        resources = new BinaryResource[resourceList.size()];
        for (int i = 0; resourceList.size() > 0; i++) {
            resources[i] = resourceList.get(0);
            resourceList.remove(0);
        }
        try {
            inputStream.close();
        } catch (IOException e) {}
        return resources;
    }
}
