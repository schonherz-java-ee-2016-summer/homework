package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 05..
 */
public class ServerReaderThread extends Thread {

    @Override
    public void run() {
        int i = 0;

        while (i < 3) {
            i++;

            for (String s : serversAndSystemAdministratorsListConsoleReport()) {
                System.out.println(s);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> serversAndSystemAdministratorsListConsoleReport() {
        List<Server> servers = ServerReader.readFromTextFile();
        List<SystemAdministrator> systemadmin = SystemAdministratorReader.readFromTextFile();

        List<String> result = new ArrayList<>();

        servers.stream().forEach(server -> {
            result.add(server.getName() + " - ");
            systemadmin.stream().forEach(sysadmin -> {
                sysadmin.getServers().stream().forEach(s -> {
                    if (server.getIdentity() == s.getIdentity()) {
                        result.add(sysadmin.getName());
                    }
                });
            });
        });

        return result;
    }
}
