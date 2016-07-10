package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class providing static methods
 * to read the server data from text and binary files
 * under the /files subdirectory.
 */
public class ServerReader {


    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> read() {
        List<Server> result = new LinkedList<>();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length < 4)
                    throw new MyException();


                /*if ("Win".equals(attributes[2]))
                    result.add(new WindowsDatabaseServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], WindowsDatabaseServer.Status.valueOf(attributes[3])));
                else if ("LinuxWeb".equals(attributes[2]))
                    result.add(new LinuxWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxWebServer.Status.valueOf(attributes[3])));
                else if ("LinuxDBandWEB".equals(attributes[2]))
                    result.add(new LinuxDatabaseAndWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxDatabaseAndWebServer.Status.valueOf(attributes[3])));
*/

                switch (attributes[2]) {
                    case "Win":
                        result.add(new WindowsDatabaseServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], WindowsDatabaseServer.Status.valueOf(attributes[3])));
                        break;
                    case "LinuxWeb":
                        result.add(new LinuxWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxWebServer.Status.valueOf(attributes[3])));
                        break;
                    case "LinuxDBandWEB":
                        result.add(new LinuxDatabaseAndWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxDatabaseAndWebServer.Status.valueOf(attributes[3])));
                        break;
                    default:
                        System.out.println("Server type is not recognized.");
                        break;

                }
            }
        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("BufferedReader was not closed");
                }
            }
        }

        return result;
    }
}
