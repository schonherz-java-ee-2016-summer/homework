package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.LinuxDatabaseAndWebServer;
import hu.schonherz.java.training.server.LinuxWebServer;
import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.WindowsServer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lenovo on 2016.07.11..
 */
public class AdminReaderTest {
    @Test
    public void readFromTextFileTest(){

        System.out.println("readFromTextFile");

        HashMap map = new HashMap();

        List<Server> servers = new ArrayList<>();
        servers.add(new WindowsServer("1","SQL01","RUNNING"));
        servers.add(new LinuxWebServer("2","WEB01","RUNNING"));
        servers.add(new LinuxDatabaseAndWebServer("3","SQLNWEB01","RUNNING"));
        servers.add(new LinuxWebServer("4","WEB02","RUNNING"));

        servers.stream().forEach((srv) -> {
                    Server ser = (Server) map.get(srv.getId());
                    if (ser == null) {
                        map.put(srv.getId(), srv);
                    }
                }
        );

        List<SystemAdministrator> expResult = new ArrayList<>();

        List<Server> srv = new ArrayList<>();
        srv.add((Server) map.get("1"));
        srv.add((Server) map.get("2"));
        srv.add((Server) map.get("3"));
        srv.add((Server) map.get("4"));
        expResult.add(new SystemAdministrator("Sysadmin Ian", 324, srv));

        List<Server> srv1 = new ArrayList<>();
        srv1.add((Server) map.get("1"));
        srv1.add((Server) map.get("2"));
        expResult.add(new SystemAdministrator("Sysadmin John", 354, srv1));

        List<Server> srv2 = new ArrayList<>();
        srv2.add((Server) map.get("3"));
        srv2.add((Server) map.get("4"));
        expResult.add(new SystemAdministrator("Sysadmin Ken", 387, srv2));

        List<SystemAdministrator> result = AdminReader.readFromTextFile(map);

        assertEquals(expResult, result);
    }
}
