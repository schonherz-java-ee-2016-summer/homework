package hu.schonherz.java.training.test;

import hu.schonherz.java.training.server.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class ServerFactoryTest {

    @Test
    public void shouldReturnNullOnNullParameter() {
        Assert.assertNull(ServerFactory.getServer(null));
    }

    @Test
    public void shouldReturnWindowsServerOnWinParameter() {
        Server windowsServer = ServerFactory.getServer("Win");

        Assert.assertNotNull(windowsServer);
        Assert.assertEquals(WindowsServer.class, windowsServer.getClass());
    }

    @Test
    public void shouldReturnLinuxWebServerOnLinuxWebParameter() {
        Server linuxWebServer = ServerFactory.getServer("LinuxWeb");

        Assert.assertNotNull(linuxWebServer);
        Assert.assertTrue(linuxWebServer.getClass().equals(LinuxWebServer.class));
    }

    @Test
    public void shouldReturnLinuxDatabaseAndWebServerOnLinuxDBandWEBParameter() {
        Server linuxDBandWebServer = ServerFactory.getServer("LinuxDBandWEB");

        Assert.assertNotNull(linuxDBandWebServer);
        Assert.assertTrue(linuxDBandWebServer.getClass().equals(LinuxDatabaseAndWebServer.class));
    }

}