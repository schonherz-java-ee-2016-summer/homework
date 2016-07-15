package hu.schonherz.java.training.filereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class providing static methods
 * to read the system administrator data from text
 * under the /files subdirectory.
 */
public class SysAdmReader {

    private static String SUBDIRECTORY = "files";
    private static String FILENAME = "sysadmins.txt";
    private static File file = FileFactory.getInstance(SUBDIRECTORY + "/" + FILENAME);

    /**
     * @return List of system administrators which has been found in sysadmins.txt file
     */
    public static List<SystemAdministrator> read() {
        List<SystemAdministrator> result = new ArrayList<>();
        if (file == null) {
            file = FileFactory.getInstance(SUBDIRECTORY + "/" + FILENAME);
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] attributes = line.split(",");
                    List<Server> servers = new ArrayList<>();
                    SystemAdministrator sysadm = new SystemAdministrator();
                    sysadm.setName(attributes[0]);
                    sysadm.setEmployeeID(Integer.parseInt(attributes[1]));
                    for (int i = 2; i < attributes.length; i++) {
                        Server server = ServerReader.read(Integer.parseInt(attributes[i]));
                        if (server != null)
                            servers.add(server);
                    }
                    sysadm.setServers(servers);
                    result.add(sysadm);
                }
            } catch (IOException e) {
                System.out.println(FILENAME + " is not found.");
            }
        }
        return result;
    }

    public static void setPath(String _SUBDIRECTORY, String _FILENAME) {
        SUBDIRECTORY = _SUBDIRECTORY;
        FILENAME = _FILENAME;
        file = FileFactory.getInstance(SUBDIRECTORY + "/" + FILENAME);
    }

}
