package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.05..
 */

public class ServerReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readFromTextFile(){
        List<Server> servers = new ArrayList<Server>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!= null){
                String[] seged = line.split(",");
                if("Win".equals(seged[2])){
                    servers.add(new WindowsDatabaseServer(Integer.parseInt(seged[0]),seged[1],seged[2], Database.Status.valueOf(seged[3])));
                } else if("LinuxWeb".equals(seged[2])){
                    servers.add(new LinuxWebServer(Integer.parseInt(seged[0]),seged[1],seged[2], WebContainer.Status.valueOf(seged[3])));
                } else if("LinuxDBandWEB".equals(seged[2])) {
                    servers.add(new LinuxDatabaseAndWebServer(Integer.parseInt(seged[0]),seged[1],seged[2], LinuxDatabaseAndWebServer.Status.valueOf(seged[3])));
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("The file is not found!");
        } catch (IOException e){
            System.out.println("We got an IO Exception!");
        }
        return servers;
    }
}
