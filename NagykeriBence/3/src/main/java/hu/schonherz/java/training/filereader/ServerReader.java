package hu.schonherz.java.training.filereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.server.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ServerReader {

    private static String SUBDIRECTORY = "files";
    private static String FILENAME = "servers.txt";
    private static File file = FileFactory.getInstance(SUBDIRECTORY + "/" + FILENAME);

    public static Server read(int id) {
        Server result = null;
        if (file == null) {
            file = FileFactory.getInstance(SUBDIRECTORY + "/" + FILENAME);
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] attributes = line.split(",");
                    if (Integer.parseInt(attributes[0]) == id) {
                        result = ServerFactory.getInstance(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3]);
                    }
                }
            } catch (IOException e) {
                System.out.println(FILENAME + " is not found.");
            }
        }
        return result;
    }

    public static void setPath(String _SUBDIRECTORY, String _FILENAME) {
        SUBDIRECTORY = _SUBDIRECTORY;
        FILENAME = _FILENAME;
        file = FileFactory.getInstance(SUBDIRECTORY + "/" + FILENAME);
    }
}
