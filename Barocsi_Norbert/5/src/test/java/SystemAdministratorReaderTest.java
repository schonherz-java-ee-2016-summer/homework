import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.Server;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mindfield on 2016. 07. 11..
 */
public class SystemAdministratorReaderTest {
    @Test
    public void systemAdministratorListSizeTest(){
        List<SystemAdministrator> testList = SystemAdministratorReader.readFromTextFile();
        int expected = testList.size();
        int result = 3;

        assertEquals(expected, result);
    }
    @Test
    public void systemAdministratorIsSystemAdministratorTest(){
        List<SystemAdministrator> testList = SystemAdministratorReader.readFromTextFile();
        SystemAdministrator expected = testList.get(0);

        assertTrue(expected instanceof SystemAdministrator);
    }
    @Test
    public void systemAdministratorStoppedServerListSizeTest(){
        List<SystemAdministrator> testList = SystemAdministratorReader.readFromTextFile();
        int expected = testList.get(0).getServers().size();
        int result = 1;

        assertEquals(expected, result);
    }
    @Test
    public void systemAdministratorServerIsServerTest(){
        List<SystemAdministrator> testList = SystemAdministratorReader.readFromTextFile();
        Server expected = testList.get(0).getServers().get(0);

        assertTrue(expected instanceof Server);
    }
    @Test
    public void listElementTest(){
        List<SystemAdministrator> testList = SystemAdministratorReader.readFromTextFile();
        List<Server> serverTestList = new ArrayList<>();
        serverTestList.add(new LinuxDatabaseAndWebServer(3, "SQLNWEB01", "LinuxDBandWEB",
                LinuxDatabaseAndWebServer.Status.DATABASESTOPPED));
        SystemAdministrator expected = testList.get(0);
        SystemAdministrator result = new SystemAdministrator("Sysadmin Ian", 324, serverTestList);

        assertEquals(expected, result);
    }
}
