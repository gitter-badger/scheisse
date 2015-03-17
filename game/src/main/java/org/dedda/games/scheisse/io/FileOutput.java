package org.dedda.games.scheisse.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by dedda on 4/18/14.
 */
public class FileOutput {

    private File file;
    private FileWriter writer;

    public FileOutput(final File file) {
        this.file = file;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(final String data) {
        try {
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArray(final int[] data) {
        for (int i = 0; i < data.length; i++) {
            try {
                writer.write(data[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writerCharArray(final char[] data) {
        try {
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLines(final String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            try {
                writer.write(lines[i] + '\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHashMap(final HashMap<String, String> map) {
        for (String key : map.keySet()) {
            try {
                writer.write(key + ":" + map.get(key) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
