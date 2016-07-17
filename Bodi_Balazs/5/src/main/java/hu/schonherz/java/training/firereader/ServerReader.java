package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
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
 * Created by bmbal on 2016. 07. 07..
 */
public class ServerReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";
    private static final String RUNNINGSERVERKEYWORD = "RUNNING";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readStoppedServers() {
        List<Server> result = new LinkedList<Server>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String [] attributes = line.split(",");

                if(attributes.length != 4){
                    throw new MyException();
                }
                if(!attributes[3].equals(RUNNINGSERVERKEYWORD)) {
                    if (attributes[2].equals("LinuxDBandWEB")) {
                        result.add(new LinuxDatabaseAndWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxDatabaseAndWebServer.Status.DATABASESTOPPED));
                    } else if (attributes[2].equals("LinuxWeb")) {
                        result.add(new LinuxWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], WebContainer.Status.STOPPED));
                    } else if (attributes[2].equals("Win")) {
                        result.add(new WindowsDatabaseServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], Database.Status.STOPPED));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corruptd");
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

