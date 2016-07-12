package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 12..
 */
public class StoppedServersThread {
    public static void Report(){
        while (true) {
            StoppedServers();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void StoppedServers() {

        List<Server> stoppedServers = ServerReader.readStoppedServers();
        List<SystemAdministrator> administrators = SystemAdministratorReader.read();

        for (Server actualServer : stoppedServers
                ) {
            System.out.println("\n" + actualServer.getName() + " " + actualServer.getType() + " is not RUNNING!");
            System.out.println("Administrator(s) who have permission for it:");
            for (SystemAdministrator actualAdministrator : administrators
                    ) {
                if(actualAdministrator.getServers().contains(actualServer.getID())){
                    System.out.println("-" + actualAdministrator);
                }
            }
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        }

    }
}
