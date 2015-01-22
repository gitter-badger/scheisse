package org.dedda.games.scheisse.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by dedda on 4/18/14.
 *
 * @author dedda
 */
public class Unzip {

    /**
     * Zip file to extract.
     */
    private File source;

    /**
     * Destination file or folder.
     */
    private File destination;

    /**
     *
     * @param source File
     * @param destination File
     */
    public Unzip(final File source, final File destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * Unzips the source file to the destination file / folder.
     *
     * @return {@link ArrayList} of all unzipped {@link File}s
     */
    public ArrayList<File> unzip() {
        ArrayList<File> files = new ArrayList<File>();
        byte buffer[] = new byte[1024];
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(source));
            if (!destination.exists()) {
                destination.mkdir();
            }
            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                File file =
                        new File(
                                destination.getAbsolutePath() + (
                                destination.getAbsolutePath().endsWith("/") ?
                                        "" : "/"
                                ) +
                                fileName
                        );
                files.add(file);
                System.out.println("Unzipping file: " + file.getAbsoluteFile());
                new File(file.getParent()).mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                int length;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                fileOutputStream.close();
                entry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Unzip) {
            Unzip unzip = (Unzip)object;
            return unzip.source.equals(this.source)
                    && unzip.destination.equals(this.destination);
        }
        return false;
    }

}
