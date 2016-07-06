package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;
import hu.schonherz.java.training.server.WindowsServer;

import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 05..
 */
public class ServerReaderThread extends Thread{

    @Override
    public void run(){
        int i = 0;

        while(i < 3){
            i++;

            List<Server> servers = ServerReader.readFromTextFile();
            List<SystemAdministrator> systemadmin = SystemAdministratorReader.readFromTextFile();

            for(Server server : servers){
                System.out.print(server.getName()+" - " );
                for(SystemAdministrator sysadmin : systemadmin){
                    for (Server s : sysadmin.getServers()) {
                        if(server.getID() == s.getID()){
                            System.out.println(sysadmin.getName());
                        }
                    }
                }
            }
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
