package hu.schonerz.training.filereader;

import hu.schonerz.training.server.Server;
import hu.schonerz.training.server.Status;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServerReaderTest {

    public ServerReaderTest() {
    }

    @Test(expected = NullPointerException.class)
    public void testIfFileIsExist() throws FileNotFoundException {
        File server = ServerReader.createFile("asd");
    }

    @Test
    public void testReadFile() {
        List<Server> s = ServerReader.readFile();
        assertNotNull(s);
    }

    @Test(expected = MyException.class)
    public void testLineProcessingException() throws MyException {
        String line = "Linux,WEB01,RUNNING";
        Server server = ServerReader.lineProcessing(line);
    }

    @Test
    public void testLineSplittingArgumentsNumber() throws MyException {
        String line = "1,Linux,WEB01,RUNNING";
        Server server = ServerReader.lineProcessing(line);
        String[] attributes = line.split(",");

        assertEquals(attributes.length, 4);
    }

    @Test
    public void testLineSplittingToArguments() throws MyException {
        String line = "1,Solaris,WEB01,RUNNING";
        Server server = ServerReader.lineProcessing(line);
        String[] attributes = line.split(",");

        assertEquals(Integer.parseInt(attributes[0]), 1);
        assertEquals(attributes[1], "Solaris");
        assertEquals(attributes[2], "WEB01");
        assertEquals(attributes[3], "RUNNING");
    }

    @Test
    public void testServerCreator() throws MyException {
        String line = "5,MacX,WEB01,RUNNING";
        String[] attributes = line.split(",");
        Server server = ServerReader
                .serverCreator(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3]);

        assertEquals(server.getId(), 5);
        assertEquals(server.getName(), "MacX");
        assertEquals(server.getType(), "WEB01");
        assertEquals(server.getStatus(), Status.RUNNING.name());
    }

    @Test
    public void testIfFirstAttributeIsParsaable() throws MyException {
        String line = "5,MacX,WEB01,RUNNING";
        String[] attributes = line.split(",");
        assertEquals(Integer.parseInt(attributes[0]), 5);
    }
}
