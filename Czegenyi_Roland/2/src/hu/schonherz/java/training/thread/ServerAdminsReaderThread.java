package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SysAdminReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.util.List;

/**
 * Class for write to console the name and the list of administrators of the servers which are not running.
 */
public class ServerAdminsReaderThread implements Runnable {
    @Override
    public void run() {

        while (true) {

            List<Server> server = ServerReader.read();
            List<SystemAdministrator> systemAdministrator = SysAdminReader.read();

            for (Server serv : server) {
                if ("STOPPED".equals(serv.getStatus().toString())) {
                    System.out.print(serv.getName() + " ");
                    for (SystemAdministrator sysAdmin : systemAdministrator)
                        for (Server serv2 : sysAdmin.getServers())
                            if (serv2.getId() == serv.getId())
                                System.out.print(sysAdmin.getName() + " ");
                    System.out.println();
                }

            }
            System.out.println("---------------------------------------------");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
