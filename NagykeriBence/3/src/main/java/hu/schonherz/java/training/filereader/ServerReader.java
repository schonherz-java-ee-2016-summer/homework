package hu.schonherz.java.training.filereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.server.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";
    private static File file;

    static {
        try {
            file = new File(ServerReader.class.getClassLoader().getResource(SUBDIRECTORY + /*File.separator*/ "/" + FILENAME).getFile());
        } catch (NullPointerException npe) {
            System.out.println(FILENAME + " is not found.");
        }
    }

    public static Server read(int id) {
        Server result = null;
        if (file == null) {
            try {
                file = new File(ServerReader.class.getClassLoader().getResource(SUBDIRECTORY + /*File.separator*/ "/" + FILENAME).getFile());
            } catch (NullPointerException npe) {
                System.out.println(FILENAME + " is not found.");
            }
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] attributes = line.split(",");
                    if (Integer.parseInt(attributes[0]) == id) {
                        if ("Win".equals(attributes[2])) {
                            result = new WindowsDatabaseServer(Database.Status.RUNNING);
                        } else if ("LinuxWeb".equals(attributes[2])) {
                            result = new LinuxWebServer(WebContainer.Status.RUNNING);
                        } else if ("LinuxDBandWEB".equals(attributes[2])) {
                            result = new LinuxDatabaseAndWebServer(LinuxDatabaseAndWebServer.Status.RUNNING);
                        }
                        result.setName(attributes[1]);
                    }

                }
            } catch (IOException e) {
                System.out.println(FILENAME + " is not found.");
            }
        }
        return result;
    }

}
