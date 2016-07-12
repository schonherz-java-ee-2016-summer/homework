package hu.test;

import hu.schonherz.java.training.firereader.SystemAdministratorReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 12..
 */
public class SystemAdministratorReaderTest {
    private List<SystemAdministrator> actual = SystemAdministratorReader.read();
    private List<SystemAdministrator> testList = testListMaker();

    @Test
    public void testTheNumbersOfAdministrators() throws Exception {
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.size(), 3);
    }
    @Test
    public void testTheClassOfTheFirstAdministrator() throws Exception{
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.get(0).getClass(), SystemAdministrator.class);
    }
    @Test
    public void testTheClassOfTheSecondAdministrator() throws Exception{
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.get(1).getClass(), SystemAdministrator.class);
    }
    @Test
    public void testTheClassOfTheThirdAdministrator() throws Exception{
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.get(2).getClass(), SystemAdministrator.class);
    }
    @Test
    public void testThatTheItemsAreEqual() throws Exception{
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.get(0), testList.get(0));
        Assert.assertEquals(actual.get(1), testList.get(1));
        Assert.assertEquals(actual.get(2), testList.get(2));
    }

    private static List<SystemAdministrator> testListMaker(){
        List<SystemAdministrator> result = new LinkedList<>();
        List<Integer> srvrs = new LinkedList<>();
        srvrs.clear();
        srvrs.add(1);
        srvrs.add(2);
        srvrs.add(3);
        srvrs.add(4);
        result.add(new SystemAdministrator("Sysadmin Ian", 324, srvrs));
        srvrs.clear();
        srvrs.add(1);
        srvrs.add(2);
        result.add(new SystemAdministrator("Sysadmin John", 354, srvrs));
        srvrs.clear();
        result.add(new SystemAdministrator("Sysadmin Ken", 387, srvrs));
        return result;
    }
}