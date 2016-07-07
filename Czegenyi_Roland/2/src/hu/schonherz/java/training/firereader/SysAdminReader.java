package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class providing static methods
 * to read the administrator data from text and binary files
 * under the /files subdirectory.
 */
public class SysAdminReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> read() {
        List<SystemAdministrator> result = new LinkedList<>();


        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");

                List<Server> server = new ArrayList<>();
                List<Server> servers = ServerReader.read();


                for (int i = 2; i < attributes.length; i++)
                    for (Server serv : servers)
                        if (Integer.parseInt(attributes[i]) == serv.getId())
                            server.add(serv);
                result.add(new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), server));

            }
        } catch (IOException e) {
            System.out.println("File is not found");

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
