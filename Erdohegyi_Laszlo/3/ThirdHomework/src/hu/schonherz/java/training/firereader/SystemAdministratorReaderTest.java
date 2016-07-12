package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static hu.schonherz.java.training.firereader.SystemAdministratorReader.readFromTextFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SystemAdministratorReaderTest {

    @Test
    public void readFromTextFileTest(){
        List<SystemAdministrator> read = readFromTextFile();
        List<SystemAdministrator> expectedRead = new ArrayList<SystemAdministrator>();

        List<Server> servers = ServerReader.readFromTextFile();
        List<Server> firstAdminServers = new ArrayList<Server>();
        firstAdminServers.add(servers.get(0));
        firstAdminServers.add(servers.get(1));
        firstAdminServers.add(servers.get(2));
        firstAdminServers.add(servers.get(3));

        List<Server> secondAdminServers = new ArrayList<Server>();
        firstAdminServers.add(servers.get(0));
        firstAdminServers.add(servers.get(1));

        List<Server> thirdAdminServers = new ArrayList<Server>();
        firstAdminServers.add(servers.get(2));
        firstAdminServers.add(servers.get(3));

        expectedRead.add(new SystemAdministrator("Sysadmin Ian", 324, firstAdminServers));
        expectedRead.add(new SystemAdministrator("Sysadmin John", 354, secondAdminServers));
        expectedRead.add(new SystemAdministrator("Sysadmin Ken", 387, thirdAdminServers));

        assertEquals(read, expectedRead);
        //assertTrue(read.equals(expectedRead));
    }

}
