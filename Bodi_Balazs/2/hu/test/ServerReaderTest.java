package hu.test;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.Server;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bmbal on 2016. 07. 10..
 */
public class ServerReaderTest {
    @Test
    public void readStoppedServers() throws Exception {
    List<Server> testList = ServerReader.readStoppedServers();
    assertEquals(testList.size(), 1);
    }

}