package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsServer;
import org.junit.Test;

import java.util.ArrayList;
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

        List<Server> expResult = new ArrayList<>();
        expResult.add(new WindowsServer("1","SQL01","RUNNING"));
        expResult.add(new LinuxWebServer("2","WEB01","RUNNING"));
        expResult.add(new LinuxDatabaseAndWebServer("3","SQLNWEB01","RUNNING"));
        expResult.add(new LinuxWebServer("4","WEB02","RUNNING"));

        List<Server> result = ServerReader.readFromTextFile();

        /*boolean testResult = true;

        for(Server s:expResult){
            for(Server v:result){
                if(s.getId().equals(v.getId())) {
                    if(!(s.equals(v))){
                        testResult = false;
                    }
                }
            }
        }
        assertTrue(testResult);*/

        assertEquals(expResult, result);
    }
}
