package org.dedda.games.scheisse.io;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dedda on 4/18/14.
 */
public class FileInput {

    /**
     *
     * @param file File
     * @return String - data from file in string representation
     */
    public String read(final File file) {
        String data = "";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int buffer;
            while ((buffer = fileReader.read()) != -1) {
                data += (char)buffer;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     *
     * @param file File
     * @return Image
     */
    public Image readImage(final File file) {
        return Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
    }

    public int[] readArray(final File file) {
        int data[] = new int[(int) file.length()];
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int buffer;
            for (int i = 0; i < data.length; i++) {
                if ((buffer = fileReader.read()) != -1) {
                    data[i] = buffer;
                } else {
                    throw new IOException("End of file reached!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     *
     * @param file File
     * @return String[]
     */
    public String[] getLines(final File file) {
        String lines[];
        ArrayList<String> lineList = new ArrayList<String>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(
                new InputStreamReader(fis, Charset.forName("UTF-8"))
        );
        String line;
        try {
            while ((line = br.readLine()) != null) {
               lineList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines = new String[lineList.size()];
        for (int i = 0; i < lineList.size(); i++) {
            lines[i] = lineList.get(i);
        }
        return lines;
    }

    public HashMap<String, String> getMap(final File file) {
        String lines[] = getLines(file);
        HashMap<String, String> map = new HashMap<String, String>();
        for (String line : lines) {
            map.put(line.substring(0, line.indexOf(':')), line.substring(line.indexOf(':')+1));
        }
        return map;
    }

    public HashMap<String, String> getMap(final File file, final boolean escape) {
        if (!escape) {
            return getMap(file);
        }
        String lines[] = getLines(file);
        HashMap<String, String> map = new HashMap<String, String>();
        for (String line : lines) {
            if (!line.startsWith("#")) {
                map.put(line.substring(0, line.indexOf(':')), line.substring(line.indexOf(':')+1));
            }
        }
        return map;
    }

}
