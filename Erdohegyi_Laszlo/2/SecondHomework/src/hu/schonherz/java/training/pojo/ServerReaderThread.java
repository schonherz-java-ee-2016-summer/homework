package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.util.List;

public class ServerReaderThread extends Thread{

    @Override
    public void run(){
        int i = 0;

        while(i < 3){
            i++;

            List<Server> servers = ServerReader.readFromTextFile();
            List<SystemAdministrator> sysAdmins = SystemAdministratorReader.readFromTextFile();

            for(Server server : servers){
                System.out.print(server.getName() + " - " );
                for(SystemAdministrator sysAdmin : sysAdmins){
                    for(Server s : sysAdmin.getServers()){
                        if(server.getID() == s.getID()){
                            System.out.println(sysAdmin.getName());
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
