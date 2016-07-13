package hu.schonherz.java.training;

import hu.schonherz.java.training.main.Main;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.ServerFactory;
import hu.schonherz.java.training.server.WindowsServer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HomeworkTest {

    private static List<Server> servers;
    private static List<SystemAdministrator> administrators;

    @BeforeClass
    public static void setUp() {
        servers = new ArrayList<Server>();
        administrators = new ArrayList<SystemAdministrator>();

        Server windowsServer = ServerFactory.getServer("Win");
        windowsServer.setId(1);
        windowsServer.setName("WinServer");
        Server linuxWebServer = ServerFactory.getServer("LinuxWeb");
        linuxWebServer.setId(2);
        linuxWebServer.setName("LinuxWebServer");

        SystemAdministrator cartman = new SystemAdministrator("Cartman", 15);
        cartman.setServerIDs(Arrays.asList(1));
        SystemAdministrator doxy = new SystemAdministrator("Doxy", 10);
        doxy.setServerIDs(Arrays.asList(1, 2));

        servers.add(windowsServer);
        servers.add(linuxWebServer);
        administrators.add(cartman);
        administrators.add(doxy);
    }

    @Test
    public void shouldAddServerToSysAdminsServers() {
        Main.assignServerToSysAdmin(servers.get(0), administrators.get(0));

        assertTrue(administrators.get(0).getServers().contains(servers.get(0)));
    }

    @Test
    public void shouldPutServerAndNamesInMap() {
        Map<String, List<String>> serversWithAdmins = new HashMap<>();
        List<String> adminNames = administrators.stream()
                                                .map(SystemAdministrator::getName)
                                                .collect(Collectors.toList());
        Server exampleServer = new WindowsServer();
        exampleServer.setId(1);
        exampleServer.setName("Example");

        Main.assignServerWithAdmins(serversWithAdmins, exampleServer, adminNames);

        assertNotNull(serversWithAdmins);
        assertTrue(serversWithAdmins.size() > 0);
        assertTrue(serversWithAdmins.containsKey(exampleServer.getName()));
        assertTrue(serversWithAdmins.containsValue(adminNames));
    }

    @Test
    public void shouldCreateReport() {
        Map<String, List<String>> serversWithAdmins = new HashMap<>();
        serversWithAdmins.put("WinServer", Arrays.asList("Cartman", "Doxy"));
        serversWithAdmins.put("LinuxWebServer", Arrays.asList("Doxy"));

        assertEquals(serversWithAdmins, Main.createReport(servers, administrators));
    }

}