package hu.schonherz.java.training.filereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 12..
 */
public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> readSystemAdmins() {
        List<SystemAdministrator> result = new LinkedList<SystemAdministrator>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            getSystemAdmins(result, bufferedReader);

        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
        }

        return result;
    }

    private static void getSystemAdmins(List<SystemAdministrator> result, BufferedReader bufferedReader) throws IOException, MyException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] attributes = line.split(",");
            if (attributes.length < 2) {
                throw new MyException();
            }

            SystemAdministrator administrator = createSysAdminFromAttributes(attributes);
            result.add(administrator);
        }
    }

    private static SystemAdministrator createSysAdminFromAttributes(String[] attributes) {
        SystemAdministrator administrator = new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]));
        setServerIDs(attributes, administrator);
        return administrator;
    }

    private static void setServerIDs(String[] attributes, SystemAdministrator administrator) {
        for (int i = 2; i < attributes.length; i++) {
            administrator.getServerIDs().add(Integer.parseInt(attributes[i]));
        }
    }

}

