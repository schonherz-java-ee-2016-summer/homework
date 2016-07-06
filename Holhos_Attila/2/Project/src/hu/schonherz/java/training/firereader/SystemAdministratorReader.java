package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxServer;
import hu.schonherz.java.training.server.Server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.05..
 */

public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> readFromTextFile(){
        List<SystemAdministrator> systemAdmins = new ArrayList<SystemAdministrator>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(SUBDIRECTORY + File.separator + FILENAME));
            String line;
            while((line=br.readLine())!=null){
                String[] seged = line.split(",");
                List<Server> adminServers = new ArrayList<Server>();
                List<Server> servers = ServerReader.readFromTextFile();
                for(int i=2;seged.length>i;i++) {
                    for(Server s: servers) {
                        if (Integer.parseInt(seged[i]) == s.getID()){
                            adminServers.add(s);
                        }
                    }
                }
                systemAdmins.add(new SystemAdministrator(seged[0],Integer.parseInt(seged[1]),adminServers));
            }
        } catch(FileNotFoundException e){
            System.out.println("The file is not found!");
        } catch(IOException e){
            System.out.println("It is an IO Exception.");
        }
        return systemAdmins;
    }
}
