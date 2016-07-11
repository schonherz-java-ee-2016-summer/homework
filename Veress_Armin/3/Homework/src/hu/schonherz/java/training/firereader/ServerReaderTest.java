package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsServer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lenovo on 2016.07.11..
 */
public class ServerReaderTest {
    @Test
    public void readFromTextFileTest(){
        System.out.println("readFromTextFile");
        HashMap expResult = new HashMap();
        expResult.put("1", new WindowsServer("1","SQL01","RUNNING"));
        expResult.put("2", new LinuxWebServer("2","WEB01","RUNNING"));
        expResult.put("3", new LinuxDatabaseAndWebServer("3","SQLNWEB01","RUNNING"));
        expResult.put("4", new LinuxWebServer("4","WEB02","RUNNING"));
        HashMap result = ServerReader.readFromTextFile();
        assertEquals(expResult, result);
    }
}
