package hu.schonherz.java.training.filereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class providing static methods
 * to read the system administrator data from text files
 * under the /src/main/resources subdirectory.
 */
public class SystemAdministratorReader {

    private static ClassLoader classLoader = SystemAdministratorReader.class.getClassLoader();
    private static File file = new File(classLoader.getResource("sysadmins.txt").getFile());

    public static List<Server> createServerList(String [] lineAttributes){
        List<Server> servers = new ArrayList<>();
        List<Server> readServers = ServerReader.readFromTextFile();

        for (int i = 2; i < lineAttributes.length; i++){
            for (Server s : readServers){
                if (Integer.parseInt(lineAttributes[i]) == s.getID()){
                    servers.add(s);
                }
            }
        }

        return servers;
    }

    public static List<SystemAdministrator> readFromTextFile(){
        List<SystemAdministrator> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null){
                String [] attributes = line.split(",");

                result.add(new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), createServerList(attributes)));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        } catch (IOException e){
            System.out.println("File is corrupted.");
        }

        return result;
    }
}
