/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonerz.training.thread;

import hu.schonerz.training.pojo.SystemAdministrator;
import hu.schonerz.training.server.Server;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roli
 */
public class ReportTest {

    public ReportTest() {
    }

    @Test
    public void testReport() {
        Server s1 = new Server(1, "Solaris", "Web", "STOPPED");
        Server s2 = new Server(2, "Teradata", "WebDB", "RUNNING");
        Server s3 = new Server(3, "Informix", "Ingres", "STOPPED");

        List<Server> servers = new LinkedList<>();
        servers.add(s1);
        servers.add(s2);
        servers.add(s3);

        List<Integer> elliotHaveAccess = new LinkedList<>();
        elliotHaveAccess.add(1);
        elliotHaveAccess.add(2);

        
        SystemAdministrator a1 = new SystemAdministrator("Elliot Alderson", 111, elliotHaveAccess);

        List<SystemAdministrator> admins = new LinkedList<>();
        admins.add(a1);
        new Report().print(servers, admins);

 /*   = List < SystemAdministrator > admins = SysAdminReader.readFile();*/
    }

    @Test
    public void testRun() {

    }

    @Test
    public void testPrint() {
    }

}
