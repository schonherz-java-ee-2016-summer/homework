package hu.schonherz.java.training;

import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsDatabaseServer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static hu.schonherz.java.training.filereader.ServerReader.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServerReaderTest {

    @Test
    public void readFromTextFileTest(){
        List<Server> read = readFromTextFile();
        List<Server> expectedRead = new ArrayList<Server>();

        expectedRead.add(new WindowsDatabaseServer(1, "SQL01", "Win", WindowsDatabaseServer.Status.valueOf("RUNNING")));
        expectedRead.add(new LinuxWebServer(2, "WEB01", "LinuxWeb", LinuxWebServer.Status.valueOf("STOPPED")));
        expectedRead.add(new LinuxDatabaseAndWebServer(3, "SQLNWEB01", "LinuxDBandWEB", LinuxDatabaseAndWebServer.Status.valueOf("RUNNING")));
        expectedRead.add(new LinuxWebServer(4, "WEB02", "LinuxWeb", LinuxWebServer.Status.valueOf("STOPPED")));

        assertEquals(expectedRead, read);
        //assertTrue(expectedRead.equals(read));
    }

}
