package hu.schonherz.java.training.firereader;

/**
 * Created by Lenovo on 2016.07.04..
 */

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdminReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    /**
     * @return List of employees which has been found in sysadmins.txt file
     */
    public static List<SystemAdministrator> read() {
        List<SystemAdministrator> result = new LinkedList<SystemAdministrator>();

        /* Alternative solution
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            // do stuff
        }*/

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                List<Server2> serverek = new ArrayList<Server2>();
                if (attributes.length < 2) {
                    throw new MyException();
                }
                for(int i = 2; i<attributes.length; i++) {
                    //serverek.add(attributes[i]);
                }
                SystemAdministrator admin = new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), serverek);
                result.add(admin);
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
