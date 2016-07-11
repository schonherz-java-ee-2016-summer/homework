/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsServer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ServerReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readFromTextFile() {
        List<Server> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            createList(result, bufferedReader);
        } catch (IOException e) {
            System.out.println("io error");
        }

        return result;
    }

    private static void createList(List<Server> result, BufferedReader reader)
    {
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes[2].equals("Win"))
                    result.add(new WindowsServer(attributes[0], attributes[1], attributes[3]));
                else if (attributes[2].equals("LinuxWeb"))
                    result.add(new LinuxWebServer(attributes[0], attributes[1], attributes[3]));
                else if (attributes[2].equals("LinuxDBandWEB"))
                    result.add(new LinuxDatabaseAndWebServer(attributes[0], attributes[1], attributes[3]));
            }
        } catch (IOException e)
        {
            System.out.println("io error");
        }
    }

/*
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readFromTextFile() {
        List<Server> result = new ArrayList<>();

         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes[2].equals("Win"))
                    result.add(new WindowsServer(attributes[0], attributes[1], attributes[3]));
                else if (attributes[2].equals("LinuxWeb"))
                    result.add(new LinuxWebServer(attributes[0], attributes[1], attributes[3]));
                else if (attributes[2].equals("LinuxDBandWEB"))
                    result.add(new LinuxDatabaseAndWebServer(attributes[0], attributes[1], attributes[3]));
            }
        } catch (IOException e) {
            System.out.println("io error");
        }

        return result;
    }
*/
}
