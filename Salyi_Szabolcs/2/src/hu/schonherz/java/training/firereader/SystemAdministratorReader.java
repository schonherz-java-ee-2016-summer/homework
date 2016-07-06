package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 05..
 */
public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static final File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> readFromTextFile() {

        List<SystemAdministrator> result = new LinkedList<>();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] attributes = line.split(",");
                List<Server> tmp = new LinkedList<>();
                List<Server> servers = ServerReader.readFromTextFile();
                ;

                for (int i = 2; i < attributes.length; i++) {
                    for (Server s : servers) {
                        if (Integer.parseInt(attributes[i]) == s.getID()) {
                            tmp.add(s);
                        }
                    }
                }

                result.add(new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), tmp));

            }

        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("BufferReader isn't closed!");
                }
            }
        }
        return result;
    }
}