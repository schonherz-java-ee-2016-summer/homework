package hu.schonherz.java.training.filereader;

import hu.schonherz.java.training.server.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utility class providing static methods
 * to read the servers from text
 * under the /files subdirectory.
 */
public class ServerReader {

    private static String subdirectory = "files";
    private static String filename = "servers.txt";
    private static File file = FileFactory.getInstance(subdirectory + "/" + filename);

    /**
     * A method for filling the System Administrator servers list.
     *
     * @param id The server id.
     * @return A proper type Server.
     */
    public static Server read(int id) {
        Server result = null;
        if (file == null) {
            file = FileFactory.getInstance(subdirectory + "/" + filename);
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
                System.out.println(filename + " is not found.");
            }
        }
        return result;
    }

    public static void setPath(String subdir, String nameOfFile) {
        subdirectory = subdir;
        filename = nameOfFile;
        file = FileFactory.getInstance(subdirectory + "/" + filename);
    }
}
