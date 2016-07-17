package hu.test;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.Server;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 12..
 */
public class ServerReaderTest {
    private List<Server> resultOfCallingSuperMethod = ServerReader.readStoppedServers();
    private LinuxDatabaseAndWebServer actual = (LinuxDatabaseAndWebServer) resultOfCallingSuperMethod.get(0);



    @Test
    public void testTheNumberOfTheStoppedServers() throws Exception {
        Assert.assertNotNull(resultOfCallingSuperMethod);
        Assert.assertEquals(resultOfCallingSuperMethod.size(),1);
    }
    @Test
    public void testTheClassOfTheStoppedServers() throws Exception{
        Assert.assertNotNull(resultOfCallingSuperMethod);
        Assert.assertEquals(resultOfCallingSuperMethod.get(0).getClass(), LinuxDatabaseAndWebServer.class);
    }
    @Test
    public void testThatTheServersAreReallyStopped() throws Exception{
        Assert.assertNotNull(resultOfCallingSuperMethod);
        Assert.assertEquals(actual.getStatus() , "DATABASESTOPPED" );
    }
    @Test
    public void testTheIDOfTheServers() throws Exception{
        Assert.assertNotNull(resultOfCallingSuperMethod);
        Assert.assertEquals(actual.getID(), 3);
    }

}