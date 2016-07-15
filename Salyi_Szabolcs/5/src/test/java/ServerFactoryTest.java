import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.ServerFactory;
import hu.schonherz.java.training.server.WindowsServer;

/**
 * Created by Home on 2016. 07. 15..
 */
public class ServerFactoryTest {

    @Test
    public void shouldReturnNullParameter(){
        Assert.assertNull(ServerFactory.getServer(null));
    }

    @Test
    public void shouldReturnNullParameter1(){
        Assert.assertNull(ServerFactory.getServer(""));
    }

    @Test
    public void shouldReturnWindowsServerOnWinParameter() {
        Server windowsServer = ServerFactory.getServer("Win");

        Assert.assertEquals(WindowsServer.class, windowsServer.getClass());
    }

    @Test
    public void shouldReturnLinuxWebServerOnLinuxWebParameter() {
        Server linuxWebServer = ServerFactory.getServer("LinuxWeb");

        Assert.assertTrue(linuxWebServer.getClass().equals(LinuxWebServer.class));
    }

    @Test
    public void shouldReturnLinuxDatabaseAndWebServerOnLinuxDBandWEBParameter() {
        Server linuxDBandWebServer = ServerFactory.getServer("LinuxDBandWEB");

        Assert.assertTrue(linuxDBandWebServer.getClass().equals(LinuxDatabaseAndWebServer.class));
    }


}


