package org.dedda.games.scheisse.fsloaders.resource;

import org.dedda.games.scheisse.fsloaders.resource.net.HttpDownloader;
import org.dedda.games.scheisse.tool.SystemPrinter;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by dedda on 4/19/14.
 *
 * @author dedda
 */
public class Installer {

    public Installer() {

    }

    public boolean installSingle(final URL source, final String destination) {
        HttpDownloader downloader = new HttpDownloader(source);
        final File ZIP_FILE = new File(Resource.TEMP_FOLDER + "downloadFile.zip");
        try {
            downloader.download(ZIP_FILE.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            SystemPrinter.debugln("FAIL!");
            return false;
        }
        Unzip unzip = new Unzip(
            ZIP_FILE,
            new File(destination)
        );
        unzip.unzip();
        ZIP_FILE.delete();
        return true;
    }
}
