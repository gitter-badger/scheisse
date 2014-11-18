package org.dedda.games.scheisse.io.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by Dedda on 19.04.2014.
 */
public class HttpDownloader {

    private URL url;

    /**
     * @param url Source URL
     */
    public HttpDownloader(final URL url) {
        this.url = url;
    }

    /**
     * @param fileName Path to destination file
     * @return Succeeded or not
     */
    public boolean download(final String fileName) throws IOException {
        try {
            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            throw e;
        }
        return true;
    }

    /**
     * @param file Destination file
     * @return Succeeded or not
     */
    public boolean download(final File file) throws IOException {
        return this.download(file.getAbsolutePath());
    }

    /**
     * @return URL The {@link URL} set in the constructor
     */
    public URL getUrl() {
        return url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        if (object instanceof HttpDownloader) {
            HttpDownloader hdl = (HttpDownloader) object;
            return hdl.url.equals(this.url);
        }
        return false;
    }
}
