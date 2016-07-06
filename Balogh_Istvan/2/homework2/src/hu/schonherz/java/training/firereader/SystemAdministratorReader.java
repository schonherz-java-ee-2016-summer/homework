package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.RunningServer;
import hu.schonherz.java.training.server.Server;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> read() {
        List<SystemAdministrator> result = new LinkedList<SystemAdministrator>();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length < 2) {
                    throw new MyException();
                }

                SystemAdministrator administrator = new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]));

                for (int i = 2; i < attributes.length; i++) {
                    administrator.getServerIDs().add(Integer.parseInt(attributes[i]));
                }

                result.add(administrator);
            }

        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
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
