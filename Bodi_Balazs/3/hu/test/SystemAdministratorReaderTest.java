package hu.test;

import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bmbal on 2016. 07. 12..
 */
public class SystemAdministratorReaderTest {
    private List<SystemAdministrator> actual = SystemAdministratorReader.read();
    @Test
    public void testTheNumbersOfAdministrators() throws Exception {
        Assert.assertEquals(actual.size(), 3);
    }
    @Test(timeout = 10)
    public void testTheClassOfTheFirstAdministrator() throws Exception{
        Assert.assertEquals(actual.get(0).getClass(), SystemAdministrator.class);
    }
    @Test(timeout = 10)
    public void testTheClassOfTheSecondAdministrator() throws Exception{
        Assert.assertEquals(actual.get(1).getClass(), SystemAdministrator.class);
    }
    @Test(timeout = 10)
    public void testTheClassOfTheThirdAdministrator() throws Exception{
        Assert.assertEquals(actual.get(2).getClass(), SystemAdministrator.class);
    }
}