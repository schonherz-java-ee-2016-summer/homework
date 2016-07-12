/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonerz.training.thread;

import hu.schonerz.training.filereader.MyException;
import hu.schonerz.training.pojo.SystemAdministrator;
import hu.schonerz.training.server.Server;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 *
 * @author Roli
 */
public class ReportTest {

    public ReportTest() {
    }
    public static List<Server> servers = new LinkedList<>();
    public static List<SystemAdministrator> admins = new LinkedList<>();

    @BeforeClass
    public static void init() {
        Server s1 = new Server(1, "Solaris", "Web", "STOPPED");
        Server s2 = new Server(2, "Teradata", "WebDB", "RUNNING");
        Server s3 = new Server(3, "Informix", "Ingres", "STOPPED");

        servers.add(s1);
        servers.add(s2);
        servers.add(s3);

        List<Integer> elliotHaveAccess = new LinkedList<>();
        elliotHaveAccess.add(1);
        elliotHaveAccess.add(2);

        List<Integer> jdoeHaveAccess = new LinkedList<>();
        jdoeHaveAccess.add(3);
        jdoeHaveAccess.add(2);

        SystemAdministrator a1 = new SystemAdministrator("Elliot Alderson", 111, elliotHaveAccess);
        SystemAdministrator a2 = new SystemAdministrator("JDOE", 111, jdoeHaveAccess);

        admins.add(a1);
        admins.add(a2);

    }

    @Test
    public void testRunningServersSize() {

        Report r = new Report();
        assertEquals(r.stoppedServers(servers).size(), 2);

    }

    //NOTE: I don't know if it's a good method for testing threads, probably is not.
    @Test//(expected = AssertionError.class)
    public void testThreadInterruptedException() /* throws AssertionError */ {

        Report r = new Report();
        Thread t = new Thread(new Runnable() {

            @Test(expected = InterruptedException.class)
            @Override
            public void run() {

                r.run();
            }
        });
        t.start();
        t.interrupt();

    }

}
