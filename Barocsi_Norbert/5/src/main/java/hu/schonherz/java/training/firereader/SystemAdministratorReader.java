package hu.schonherz.java.training.firereader;;

import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.pojo.SystemAdministrator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 03..
 */
public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SystemAdministratorReader.class.getClassLoader().
            getResource(SUBDIRECTORY + "/" + FILENAME).getFile());

    public static List<SystemAdministrator> readFromTextFile(){
        List<SystemAdministrator> result = new ArrayList<>();

        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(file))) {
            systemadministratorsAddList(result, bufferedreader);
        } catch (IOException e) {
            System.out.println("io error");
        }

        return result;
    }

    private static void systemadministratorsAddList(List<SystemAdministrator> result, BufferedReader bufferedreader) throws IOException{
        String line;

        while ((line = bufferedreader.readLine()) != null) {
            String [] attributes = line.split(",");
            result.add(new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), serverPermissionControl(attributes)));
        }
    }

    private static List<Server> serverPermissionControl(String[] attributes){
        List<Server> servers = new ArrayList<>();
        List<Server> serversreader = ServerReader.readFromTextFile();

        for (int i = 2; i < attributes.length; i++) {
            for (Server s: serversreader) {
                if (Integer.parseInt(attributes[i]) == s.getIdentity()) {
                    servers.add(s);
                }
            }
        }
        return servers;
    }
}
