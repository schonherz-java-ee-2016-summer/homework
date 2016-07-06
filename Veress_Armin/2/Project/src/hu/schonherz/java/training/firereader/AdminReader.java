package hu.schonherz.java.training.firereader;

/**
 * Created by Lenovo on 2016.07.04..
 */

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdminReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> read() {
        List<SystemAdministrator> result = new LinkedList<SystemAdministrator>();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            List<SystemAdministrator> admins = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                List<Server> serverList = new ArrayList<>();
                List<String> serverID = new ArrayList<>();
                if (attributes.length < 2) {
                    throw new MyException();
                }
                for(int i = 2; i<attributes.length; i++) {
                        serverID.add(attributes[i]);
                }

                Map<Integer, Server> serverMap = ServerReader.readFromTextFile();

                SystemAdministrator sysadmin = new SystemAdministrator();
                for(Map.Entry<Integer, Server> map : serverMap.entrySet()){
                    for(String string : serverID){
                        if(Integer.parseInt(string)==map.getKey()){
                            serverList.add(map.getValue());
                        }
                    }
                }
                result.add(new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), serverList));
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
