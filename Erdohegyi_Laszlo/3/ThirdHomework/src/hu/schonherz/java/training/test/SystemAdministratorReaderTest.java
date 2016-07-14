package hu.schonherz.java.training.test;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;
import org.junit.Assert;
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

        expectedRead.add(new SystemAdministrator("Sysadmin Ian", 324));
        expectedRead.add(new SystemAdministrator("Sysadmin John", 354));
        expectedRead.add(new SystemAdministrator("Sysadmin Ken", 387));

        assertEquals(expectedRead, read);
        //assertTrue(expectedRead.equals(read));
    }

}
