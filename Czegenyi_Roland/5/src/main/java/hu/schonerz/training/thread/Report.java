package hu.schonerz.training.thread;

import hu.schonerz.training.filereader.ServerReader;
import hu.schonerz.training.filereader.SysAdminReader;
import hu.schonerz.training.pojo.SystemAdministrator;
import hu.schonerz.training.server.Server;
import hu.schonerz.training.server.Status;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating reports.
 */
public class Report {

    public void run() {
        while (true) {
            initialization();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void initialization() {
        List<Server> servers = ServerReader.readFile();
        List<SystemAdministrator> admins = SysAdminReader.readFile();

        print(servers, admins);
    }

    public List<Server> stoppedServers(List<Server> servers) {
        List<Server> stoppedServers = new ArrayList<>();
        servers.stream()
                .filter((s) -> (Status.STOPPED.toString().equals(s.getStatus())))
                .map((s) -> {
                    return s;
                })
                .forEach((Server s) -> {
                    stoppedServers.add(s);
                });
        return stoppedServers;

    }

    public void print(List<Server> servers, List<SystemAdministrator> admins) {
        stoppedServers(servers).stream().forEach((Server s) -> {
            System.out.print(s.getId() + " - " + s.getName());
            admins.stream()
                    .filter((admin) -> (admin.getServers().contains(s.getId())))
                    .forEach((SystemAdministrator admin) -> {
                        System.out.print(" - " + admin.getName());
                    });
            System.out.println();
        });
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
