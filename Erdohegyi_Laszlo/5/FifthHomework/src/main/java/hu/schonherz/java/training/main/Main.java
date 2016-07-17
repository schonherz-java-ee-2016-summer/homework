package hu.schonherz.java.training.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.schonherz.java.training.filereader.ServerReader;
import hu.schonherz.java.training.filereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;


/**
 * <h1>Fifth Homework</h1>
 * The FifthHomework program implements an application that
 * outputs the "STOPPED" servers and their administrators
 * to the console in every 10 seconds.
 *
 * @author  László Erdőhegyi
 * @version 1.0-SNAPSHOT
 * @since   2016-7-17
 */
@SuppressWarnings("unused")
public class Main {

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
    private static void homework(){
        while (true){
            List<Server> servers = ServerReader.readFromTextFile();
            List<SystemAdministrator> systemAdmins = SystemAdministratorReader.readFromTextFile();

            List<Server> stoppedList = stoppedServers(servers, systemAdmins);

            Map<String, List<String>> stoppedServersReport = stoppedServersWithAdmins(stoppedList, systemAdmins);

            System.out.println(stoppedServersReport);
            System.out.println("------------------------------");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static List<Server> stoppedServers(List<Server> srvrs, List<SystemAdministrator> sysAs){
        List<Server> stoppedServersList = new ArrayList<Server>();

        for (Server server : srvrs){
            if ("Win".equals(server.getType()) && "STOPPED".equals(((WindowsDatabaseServer) server).getStatus())){
                stoppedServersList.add(server);
            } else if ("LinuxWeb".equals(server.getType()) && "STOPPED".equals(((LinuxWebServer) server).getStatus())){
                stoppedServersList.add(server);
            } else if ("LinuxDBandWEB".equals(server.getType())
                    && "DATABASESTOPPED".equals(((LinuxDatabaseAndWebServer) server).getStatus())){
                stoppedServersList.add(server);
            }
        }
        return stoppedServersList;
    }

    private static Map<String, List<String>> stoppedServersWithAdmins(List<Server> stoppedSrvrs, List<SystemAdministrator> sysAdmins){
        Map<String, List<String>> stoppedReport = new HashMap<>();
        List<String> stoppedServerAdmins = new ArrayList<String>();

        for (Server actStoppedServer : stoppedSrvrs){
            for (SystemAdministrator actSysAdmin : sysAdmins){
                for (Server s : actSysAdmin.getServers()){
                    if (s.getID() == actStoppedServer.getID()){
                        stoppedServerAdmins.add(actSysAdmin.getName());
                    }
                }
            }
            stoppedReport.put(actStoppedServer.getName(), stoppedServerAdmins);
            stoppedServerAdmins = new ArrayList<String>();
        }

        return stoppedReport;
    }

}
