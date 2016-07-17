package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.filereader.ServerReader;
import hu.schonherz.java.training.filereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.util.List;

/**
 * Created by Home on 2016. 07. 12..
 */
public class Report implements Runnable{
    @Override
    public void run() {
        while (true){
            createReport();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e){
                System.out.println("Thread was interrupted!");
            }
        }
    }

    public static void createReport(){
        List<Server> servers = ServerReader.readServers();
        List<SystemAdministrator> admins = SystemAdministratorReader.readSystemAdmins();

        for (Server server : servers){

            if (server != null) {
                for (SystemAdministrator admin : admins){
                    if (admin.getServerIDs().contains(server.getId())){
                        System.out.println(admin.getName() + server.getName());
                    }
                }
            }
        }

    }
}
