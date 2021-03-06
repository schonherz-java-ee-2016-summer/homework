package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class for reading system administrators with static {@link #read()} method.
 */
public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> read() {
        List<SystemAdministrator> result = new LinkedList<SystemAdministrator>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            getSystemAdministrators(result, reader);

        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
        }

        return result;
    }

    private static void getSystemAdministrators(List<SystemAdministrator> result, BufferedReader reader) throws IOException, MyException {
        String line;
        while ((line = reader.readLine()) != null) {
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
