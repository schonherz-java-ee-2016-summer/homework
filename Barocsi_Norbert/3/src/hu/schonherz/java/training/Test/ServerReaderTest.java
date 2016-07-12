package hu.schonherz.java.training.Test;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.Server;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mindfield on 2016. 07. 11..
 */
public class ServerReaderTest {
    @Test
    public void serverListSizeTest(){
        List<Server> testList = ServerReader.readFromTextFile();
        int result = 1;
        int expected = testList.size();

        assertEquals(expected, result);
    }
    @Test
    public void serverIsServerTest(){
        List<Server> testList = ServerReader.readFromTextFile();
        Server expected = testList.get(0);

        assertTrue(expected instanceof Server);
    }
    @Test
    public void listElementTest(){
        List<Server> expected = ServerReader.readFromTextFile();
        List<Server> result = new ArrayList<>();

        result.add(new LinuxDatabaseAndWebServer(3, "SQLNWEB01", "LinuxDBandWEB", LinuxDatabaseAndWebServer.Status.DATABASESTOPPED));

        assertEquals(expected, result);
    }
}
