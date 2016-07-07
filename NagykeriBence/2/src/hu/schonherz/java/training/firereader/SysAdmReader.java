package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.DatabaseAndWeb;
import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.pojo.Employee;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class providing static methods
 * to read the system administrator data from text
 * under the /files subdirectory.
 */
public class SysAdmReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
  
    /**
     * @return List of system administrators which has been found in sysadmins.txt file
     */
    public static List<SystemAdministrator> read() {
        List<SystemAdministrator> result = new ArrayList<>();

        /* Alternative solution
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            // do stuff
        }*/


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                List<Server> servers = new ArrayList<>();
                SystemAdministrator sysadm = new SystemAdministrator();
                sysadm.setName(attributes[0]);
                sysadm.setEmployeeID(Integer.parseInt(attributes[1]));
                for (int i = 2; i < attributes.length; i++){
                    Server server = ServerReader.read(Integer.parseInt(attributes[i]));
                    if (server != null)
                        servers.add(server);
                }
                sysadm.setServers(servers);
                result.add(sysadm);
            }
        } catch (IOException e) {
            System.out.println("File is not found");
        }

        return result;
    }

}
