package hu.schonherz.java.training.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.RunningServer;

@SuppressWarnings("unused")
public class Main{

    public static void main(String[] args) {

        homework();
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
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    System.out.println(sdf.format(cal.getTime()));

                    List<SystemAdministrator> systemAdmins = SystemAdministratorReader.readFromTextFile("files" + File.separator + "sysadmins.txt");
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
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable).run();
    }

}
