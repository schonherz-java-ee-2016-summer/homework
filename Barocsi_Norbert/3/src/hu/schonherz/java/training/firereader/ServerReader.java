package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.server.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 03..
 */
public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readFromTextFile(){
        List<Server> result = new ArrayList<>();

        BufferedReader bufferedreader = null;

        try {
            bufferedreader = new BufferedReader(new FileReader(file));
            String line;

            while((line = bufferedreader.readLine()) != null){
                String[] attributes = line.split(",");

                if("Win".equals(attributes[2]) && "STOPPED".equals(attributes[3])){
                    result.add(new WindowsDatabaseServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], Database.Status.valueOf(attributes[3])));
                } else if("LinuxWeb".equals(attributes[2]) && "STOPPED".equals(attributes[3])){
                    result.add(new LinuxWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], WebContainer.Status.valueOf(attributes[3])));
                } else if ("LinuxDBandWEB".equals(attributes[2]) && "DATABASESTOPPED".equals(attributes[3])){
                    result.add(new LinuxDatabaseAndWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxDatabaseAndWebServer.Status.valueOf(attributes[3])));
                }

            }

        }catch (IOException e){
            System.out.println("io error");
        }

        return result;
    }
}
