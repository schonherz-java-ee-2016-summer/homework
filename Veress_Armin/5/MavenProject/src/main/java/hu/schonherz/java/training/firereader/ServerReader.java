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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class ServerReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static Map readFromTextFile() {
        Map<String, Server> result = new HashMap();
        
         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
             createMap(result, bufferedReader);
        } catch (IOException e) {
            System.out.println("io error");
            return null;
        }

        return result;
    }
    
    private static void createMap(Map result, BufferedReader reader) {
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                switch (attributes[2]) {
                    case "Win":
                        result.put(attributes[0], new WindowsServer(attributes[0], attributes[1], attributes[3]));
                        break;
                    case "LinuxWeb":
                        result.put(attributes[0], new LinuxWebServer(attributes[0], attributes[1], attributes[3]));
                        break;
                    case "LinuxDBandWEB":
                        result.put(attributes[0], new LinuxDatabaseAndWebServer(attributes[0], attributes[1], attributes[3]));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("io error");
        }
    }
}
