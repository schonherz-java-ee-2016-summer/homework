package hu.schonherz.java.training.firereader;

/**
 * Created by Lenovo on 2016.07.04..
 */

import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.server.*;
import hu.schonherz.java.training.ServerService.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static Map<Integer, Server> readFromTextFile() {
        Map<Integer, Server> result = new HashMap<Integer, Server>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                Server newSr=null;
                int key = Integer.parseInt(attributes[0]);
                if(result.containsKey(key)){
                    newSr = result.get(key);
                    if(newSr instanceof LinuxDatabaseAndWebServer){
                        LinuxDatabaseAndWebServer ldaws=(LinuxDatabaseAndWebServer)newSr;
                        if(attributes[3].equals("RUNNING")){
                            ldaws.setStatus(LinuxDatabaseAndWebServer.Status.RUNNING);
                        } else if(attributes[3].equals("DATABASESTOPPED")){
                            ldaws.setStatus(LinuxDatabaseAndWebServer.Status.DATABASESTOPPED);
                        } else if(attributes[3].equals("WEBCONTAINERSTOPPER")){
                            ldaws.setStatus(LinuxDatabaseAndWebServer.Status.WEBCONTAINERSTOPPER);
                        }
                    }
                    else if(newSr instanceof LinuxWebServer){
                        LinuxWebServer lws=(LinuxWebServer)newSr;

                        if(attributes[3].equals("RUNNING")){
                            lws.setStatus(WebContainer.Status.RUNNING);}
                        else if(attributes[3].equals("STOPPED")){
                            lws.setStatus(WebContainer.Status.STOPPED);
                        }
                    }
                    else if(newSr instanceof WindowsDatabaseServer){
                        WindowsDatabaseServer wds=(WindowsDatabaseServer) newSr;
                        if(attributes[3].equals("RUNNING")){
                            wds.setStatus(Database.Status.RUNNING);}
                        else if(attributes[3].equals("STOPPED")){
                            wds.setStatus(Database.Status.STOPPED);
                        }
                    }
                }
                else{
                    if(attributes[2].equals("Win")){
                        if(attributes[3].equals("RUNNING")){
                            newSr = new WindowsDatabaseServer(Database.Status.RUNNING);}
                        else{
                            newSr = new WindowsDatabaseServer(Database.Status.STOPPED);
                        }
                    }
                    else if(attributes[2].equals("LinuxWeb")){
                        if(attributes[3].equals("RUNNING")){
                            newSr = new LinuxWebServer(WebContainer.Status.RUNNING);}
                        else{
                            newSr = new LinuxWebServer(WebContainer.Status.STOPPED);
                        }

                    }
                    else if(attributes[2].equals("LinuxDBandWEB")){
                        if(attributes[3].equals("RUNNING")){
                            newSr = new LinuxDatabaseAndWebServer(LinuxDatabaseAndWebServer.Status.RUNNING);}
                        else if(attributes[3].equals("DATABASESTOPPED")){
                            newSr = new LinuxDatabaseAndWebServer(LinuxDatabaseAndWebServer.Status.DATABASESTOPPED);
                        }
                        else{
                            newSr = new LinuxDatabaseAndWebServer(LinuxDatabaseAndWebServer.Status.DATABASESTOPPED);
                        }
                    }result.put(Integer.parseInt(attributes[0]), newSr);
                }
            }

        } catch (IOException e) {
            System.out.println("io error");
        }

        return result;
    }
}
