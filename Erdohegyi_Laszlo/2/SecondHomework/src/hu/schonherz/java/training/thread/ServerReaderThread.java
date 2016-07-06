package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.util.List;

public class ServerReaderThread extends Thread{

    @Override
    public void run(){
        while(true){
            List<Server> servers = ServerReader.readFromTextFile();
            List<SystemAdministrator> sysAdmins = SystemAdministratorReader.readFromTextFile();

            for(Server server : servers){
                System.out.println(server.getName());
                for(SystemAdministrator sysAdmin : sysAdmins){
                    for(Server s : sysAdmin.getServers()){
                        if(server.getID() == s.getID()){
                            System.out.println(sysAdmin.getName());
                        }
                    }
                }
                System.out.println();
            }

            System.out.println("------------------------------");

            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
