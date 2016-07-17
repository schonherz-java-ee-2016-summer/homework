package hu.schonerz.training.filereader;

import hu.schonerz.training.pojo.SystemAdministrator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SysAdminReaderTest {

    public SysAdminReaderTest() {
    }

    @Test(expected = NullPointerException.class)
    public void testIfFileIsExist() throws FileNotFoundException {
        File server = ServerReader.createFile("asd");
    }

    @Test
    public void testReadFile() {
        List<SystemAdministrator> s = SysAdminReader.readFile();
        assertNotNull(s);
    }

    @Test(expected = MyException.class)
    public void testLineProcessingException() throws MyException {
        String line = "A,12";
        SystemAdministrator sa = SysAdminReader.lineProcessing(line);
    }

    @Test
    public void testLineSplittingArgumentsNumber() throws MyException {
        String line = "JDOE,111,1,2,3,4";
        SystemAdministrator sa = SysAdminReader.lineProcessing(line);
        String[] attributes = line.split(",");

        assertEquals(attributes.length, 6);
    }

    @Test
    public void testLineSplittingToArguments() throws MyException {
        String line = "Norman,322,1,2,3,4";
        SystemAdministrator sa = SysAdminReader.lineProcessing(line);
        String[] attributes = line.split(",");

        assertEquals(attributes[0], "Norman");
        List<Integer> serverIds = new ArrayList<>();

        for (int i = 2; i < attributes.length; i++) {
            serverIds.add(Integer.parseInt(attributes[i]));
        }
        assertTrue(serverIds.get(0).equals(1));
        assertTrue(serverIds.get(1).equals(2));
        assertTrue(serverIds.get(2).equals(3));
        assertTrue(serverIds.get(3).equals(4));
    }

    @Test
    public void testServerCreator() throws MyException {
        String line = "Norman,322,1,2,3,4";
        String[] attributes = line.split(",");

        List<Integer> serverIds = new ArrayList<>();

        for (int i = 2; i < attributes.length; i++) {
            serverIds.add(Integer.parseInt(attributes[i]));
        }
        SystemAdministrator sa = SysAdminReader
                .adminCreator(attributes[0], Integer.parseInt(attributes[1]), serverIds);

        assertEquals(sa.getEmployeeID(), 322);
        assertEquals(sa.getName(), "Norman");
        assertEquals(sa.getServers(), serverIds);
    }
}
