package org.dedda.games.scheisse.io;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.io.net.HttpDownloader;
import org.dedda.games.scheisse.io.resource.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by dedda on 4/19/14.
 */
public class Installer {

    public Installer() {

    }

    public boolean install() {
        return true;
    }

    public boolean installSingle(final URL source, final String destination) {
        HttpDownloader downloader = new HttpDownloader(source);
        try {
            downloader.download(Resource.TEMP_FOLDER + "downloadFile.zip");
        } catch (IOException e) {
            e.printStackTrace();
            SystemPrinter.debugln("FAIL!");
            return false;
        }
        Unzip unzip = new Unzip(
            new File(Resource.TEMP_FOLDER + "downloadFile.zip"),
            new File(destination)
        );
        unzip.unzip();
        new File(Resource.TEMP_FOLDER + "downloadFile.zip").delete();
        return true;
    }
}
