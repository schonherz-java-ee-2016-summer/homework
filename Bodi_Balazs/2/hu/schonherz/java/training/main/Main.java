package hu.schonherz.java.training.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.Database.Status;
import hu.schonherz.java.training.firereader.DeveloperReader;
import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.Developer;
import hu.schonherz.java.training.pojo.Employee;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.*;
import hu.schonherz.java.training.thread.ReaderThread;
import hu.schonherz.java.training.thread.SynchronizationTest;
import jdk.nashorn.internal.objects.NativeArray;


public class Main {
    
    

    public static void main(String[] args) {

        mainThreadStart();

    }

    public static void mainThreadStart(){
        while (true) {
            homework();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
