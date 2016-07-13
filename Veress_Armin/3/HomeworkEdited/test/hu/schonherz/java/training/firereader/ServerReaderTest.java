package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsServer;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Lenovo on 2016.07.11..
 */
public class ServerReaderTest {
    @Test
    public void readFromTextFileTest() {
        System.out.println("readFromTextFile");
        Map<String, Server> expResult = new HashMap();
        expResult.put("1", new WindowsServer("1","SQL01","RUNNING"));
        expResult.put("2", new LinuxWebServer("2","WEB01","RUNNING"));
        expResult.put("3", new LinuxDatabaseAndWebServer("3","SQLNWEB01","RUNNING"));
        expResult.put("4", new LinuxWebServer("4","WEB02","RUNNING"));
        Map<String, Server> result = ServerReader.readFromTextFile();
        assertEquals(expResult, result);
    }
}
