package hu.schonherz.java.training.main;

import hu.schonherz.java.training.firereader.DeveloperReader;
import hu.schonherz.java.training.firereader.EmployeeReader;
import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.Developer;
import hu.schonherz.java.training.pojo.Employee;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.thread.ReaderThread;
import hu.schonherz.java.training.thread.SynchronizationTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {

        // Reading developers from file, printing their state to console
        List<Developer> dev = DeveloperReader.readFromBinaryFile();
        for (Developer developer : dev) {
            System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");

            for (String s : developer.getTasks()) {
                System.out.println(s);
            }
        }

        System.out.println("------------------------------");

        // The same as above, using Java 8's lambda expressions
        List<Developer> devs = DeveloperReader.readFromTextFile();

        devs.forEach(d -> { 
            System.out.println(d.getName() + "(" + d.getEmployeeID() + ")");
            d.getTasks().forEach(t -> {
                System.out.println(t);
            });
        });

        System.out.println("---------------------------------------------");

        while (true) {
            homework();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Alternative, using Java 8's method reference feature
        //devs.forEach(System.out::println);
    }

    // Reading from and writing to file example.
    private static void ioHandling() {
        List<Employee> employees = EmployeeReader.read();
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getEmployeeID());
        }

        List<Developer> developers = DeveloperReader.readFromTextFile();
        for (Developer developer : developers) {
            System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");
            for (String s : developer.getTasks()) {
                System.out.println(s);
            }
        }

        DeveloperReader.writeToBinaryFile(developers);

        System.out.println("---------------------------------------------");

        List<Developer> dev = DeveloperReader.readFromBinaryFile();
        for (Developer developer : dev) {
            System.out.println(developer.getName() + " (" + developer.getEmployeeID() + ")");
            for (String s : developer.getTasks()) {
                System.out.println(s);
            }
        }
    }

    public static void test() {
        System.out.println("Teszt szöveg");
    }

    // Threading example
    private static void threading() {
        ReaderThread readerThread = new ReaderThread();
        
        //System.out.println(readerThread.getState());
        readerThread.start();
        
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println(readerThread.getState());
        try {
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test();
    }

    // Synchronized threading example
    public static void synchronizedTest() {
        SynchronizationTest st1 = new SynchronizationTest(1);
        SynchronizationTest st2 = new SynchronizationTest(2);

        st1.start();
        st2.start();
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
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private static void homework() {
        List<Server> servers = getServers();
        List<SystemAdministrator> administrators = getSystemAdministrators();

        Map<String, List<String>> serversWithAdmins = createReport(servers, administrators);

        System.out.println(serversWithAdmins);

    }

    public static Map<String, List<String>> createReport(List<Server> servers, List<SystemAdministrator> administrators) {
        Map<String, List<String>> serversWithAdmins = new HashMap<>();

        for (Server server : servers) {
            List<String> adminNames = new ArrayList<>();
            administrators.stream()
                    .filter(administrator -> administrator.getServerIDs().contains(server.getId()))
                    .forEach(administrator -> {
                        assignServerToSysAdmin(server, administrator);
                        addAdminNameToList(adminNames, administrator);
                    });
            assignServerWithAdmins(serversWithAdmins, server, adminNames);
        }
        return serversWithAdmins;
    }

    public static void assignServerWithAdmins(Map<String, List<String>> serversWithAdmins, Server server, List<String> adminNames) {
        serversWithAdmins.put(server.getName(), adminNames);
    }

    public static void addAdminNameToList(List<String> adminNames, SystemAdministrator administrator) {
        adminNames.add(administrator.getName());
    }

    public static void assignServerToSysAdmin(Server server, SystemAdministrator administrator) {
        administrator.getServers().add(server);
    }

    private static List<SystemAdministrator> getSystemAdministrators() {
        return SystemAdministratorReader.read();
    }

    private static List<Server> getServers() {
        return ServerReader.read();
    }

}