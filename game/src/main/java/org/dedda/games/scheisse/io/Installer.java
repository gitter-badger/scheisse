package org.dedda.games.scheisse.io;

import org.dedda.games.scheisse.debug.SystemPrinter;
import org.dedda.games.scheisse.io.net.HttpDownloader;
import org.dedda.games.scheisse.io.resource.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by dedda on 4/19/14.
 */
public class Installer {

    private boolean gui;

    public Installer() {

    }

    public boolean install() {
        if (gui) {

        }
        HashMap<URL, String> downloadMap = Resource.getDownloadList();
        for (URL url : downloadMap.keySet()) {
            SystemPrinter.debugln(
                    "installing from URL: " + url.toString() + " ... "
            );
            if (!installSingle(url, downloadMap.get(url))) {
                return false;
            }
            SystemPrinter.debugln("OK!");
        }
        return true;
    }

    public boolean installSingle(final URL source, final String destination) {
        if (gui) {

        }
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
