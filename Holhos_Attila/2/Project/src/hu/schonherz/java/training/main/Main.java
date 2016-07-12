package hu.schonherz.java.training.main;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.Database.Status;
import hu.schonherz.java.training.firereader.DeveloperReader;
import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.Developer;
import hu.schonherz.java.training.pojo.Employee;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.RunningServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.thread.ReaderThread;
import hu.schonherz.java.training.thread.SynchronizationTest;

@SuppressWarnings("unused")
public class Main implements Runnable{

    public static void main(String[] args) {

        Main ReportWriter = new Main();
        ReportWriter.run();
    }

    /*
     * As a manager of the organization, I want a real-time report for servers which are not running.
     * The report should include which system administrators have permission for those servers.
     * 
     * -----------------------------
     * real-time report: continuously while the program is running (every 10 sec)
     * 
     * report: Write report to console.
     *         Format: serverName and the list of administrators' name
     * 
     * servers: files/servers.txt contains server information: 
     *    1) ID of server
     *    2) Name of server
     *    3) type
     *    4) status of server (RUNNING, STOPPED)
     *    
     * system administrators: files/sysadmins.txt contains information
     *    1) Name
     *    2) EmployeeID
     *    3) (rest): Id of servers for he/she has permission.
     *  
     * NOTE: You can create a new project or implement the homework here as well.
     *       Put your source code in your folder in the homework repository, under a directory called "2".
     *       Example: homeworkrepo/my_name/2/
     *
     * DEADLINE: July 7th, Thursday, 15:00 !
     *
     * TEST: The realtime report should reflect the changes in servers.txt while your code is running.
     */

    private static void homework() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));

        List<SystemAdministrator> systemAdmins = SystemAdministratorReader.readFromTextFile();
        List<RunningServer> servers = ServerReader.readFromTextFile();

        for(RunningServer server: servers){
            if(server.getRunningStatus()==false){
                System.out.println("Servername: "+ server.getName());
                for(SystemAdministrator systemAdmin: systemAdmins) {
                    for(RunningServer adminServer: systemAdmin.getServers()) {
                        if (server.getID() == adminServer.getID()) {
                            System.out.println("\t" + systemAdmin.getName());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 3) {
            i++;
            homework();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
