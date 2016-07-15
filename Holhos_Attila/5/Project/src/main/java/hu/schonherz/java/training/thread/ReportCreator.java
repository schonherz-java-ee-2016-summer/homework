package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Attila on 2016.07.12..
 */

public class ReportCreator implements Runnable{

    public void run() {
        while (true) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            System.out.println(sdf.format(cal.getTime()));
            createReport();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createReport() {
        List<SystemAdministrator> systemAdmins = SystemAdministratorReader.readSystemAdminFromText("files"
                + File.separator + "sysadmins.txt");
        List<Server> servers = ServerReader.readServersFromText("files" + File.separator + "servers.txt");
        for (Server server :servers){
            if ("STOPPED".equals(server.getStatus())) {
                System.out.println("Servername: " + server.getName());
                for (SystemAdministrator systemAdmin : systemAdmins) {
                    for (Integer adminServerID : systemAdmin.getServers()) {
                        if (server.getID() == adminServerID) {
                            System.out.println("\t" + systemAdmin.getName());
                        }
                    }
                }
            }
        }
    }
}
