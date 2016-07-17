/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class AdminReader {

    /**
     *
     */
    private static final String SUBDIRECTORY = "files";
    /**
     *
     */
    private static final String FILENAME = "sysadmins.txt";

    /**
     *
     */
    private static final File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    /**
     *
     * @return lol
     */
    public static List < SystemAdministrator > readFromTextFile(){
        List < SystemAdministrator > result = new ArrayList<>();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
             createList(result, bufferedReader);
        } catch (IOException e) {
            System.out.println("io error");
        }

        return result;
    }

    /**
     *
     * @param result result
     * @param reader reader
     */
    private static void createList(List < SystemAdministrator > result, BufferedReader reader) {
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                List<Server> servers = new ArrayList<>();

                for (int i = 2; i < attributes.length; i++) {
                    Server srv = (Server) Observer.getMap().get(attributes[i]);
                    if (srv != null) {
                      servers.add(srv);
                    }
                }
                result.add(new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), servers));
            }
        } catch (IOException e) {
            System.out.println("io error");
        }
    }
}