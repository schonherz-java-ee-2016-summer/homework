package hu.schonherz.java.training;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static hu.schonherz.java.training.filereader.SystemAdministratorReader.readFromTextFile;
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
