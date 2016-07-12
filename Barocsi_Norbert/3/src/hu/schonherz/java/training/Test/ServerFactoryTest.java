package hu.schonherz.java.training.Test;

import hu.schonherz.java.training.server.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mindfield on 2016. 07. 12..
 */
public class ServerFactoryTest {

    @Test
    public void winDBTest(){
        String[] attributes = new String[4];
        attributes[0] = "1";
        attributes[1] = "SQL01";
        attributes[2] = "Win";
        attributes[3] = "RUNNING";
        Server windowsServer = ServerFactory.getServer(attributes);

        assertEquals(windowsServer.getClass(), WindowsDatabaseServer.class);
    }
    @Test
    public void linuxWTest(){
        String[] attributes = new String[4];
        attributes[0] = "2";
        attributes[1] = "WEB01";
        attributes[2] = "LinuxWeb";
        attributes[3] = "RUNNING";
        Server linuxWebServer = ServerFactory.getServer(attributes);

        assertEquals(linuxWebServer.getClass(), (LinuxWebServer.class));
    }
    @Test
    public void linuxDWTest(){
        String[] attributes = new String[4];
        attributes[0] = "3";
        attributes[1] = "SQLNWEB01";
        attributes[2] = "LinuxDBandWEB";
        attributes[3] = "RUNNING";
        Server linuxDatabaseWebServer = ServerFactory.getServer(attributes);

        assertEquals(linuxDatabaseWebServer.getClass(), (LinuxDatabaseAndWebServer.class));
    }
}
