/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lenovo
 *
 */
public class ReadServers {

    private static HashMap map = null;
    public static void read() {
        map = ServerReader.readFromTextFile();
        List<SystemAdministrator> admins = AdminReader.readFromTextFile();
        assignServerAdmin(admins);
        showStatus(map);
    }

    public static HashMap getMap()
    {
        return ReadServers.map;
    }

    public static void setMap(HashMap map)
    {
        ReadServers.map=map;
    }

    public static void assignServerAdmin(List<SystemAdministrator> adms)
    {
        adms.stream().forEach((admin) -> {
            admin.getServers().stream().forEach((serv) -> {
                serv.addAdmin(admin);
            });
        });
    }

    public static void showStatus(HashMap map)
    {
        Set<String> keySet = map.keySet();
        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            Server srv = (Server) map.get(keySetIterator.next());
            if(!srv.isRunning())
            {
                System.out.println(srv.getName() + "(" + srv.getId() + ")");
                srv.getAdmins().forEach(a -> {
                    System.out.println(a.getName());
                });
            }
        }
    }


/*
    private static final HashMap map = new HashMap();
    public static void read() {
        map.clear();
        List<Server> servers = ServerReader.readFromTextFile();
        servers.stream().forEach((srv) -> {
            Server ser = (Server) map.get(srv.getId());
            if (ser == null) {
                map.put(srv.getId(), srv);
            }
        });

        List<SystemAdministrator> admins = AdminReader.readFromTextFile(map);
        admins.stream().forEach((admin) -> {
            admin.getServers().stream().forEach((serv) -> {
                serv.addAdmin(admin);
            });
        });

        servers.forEach((Server s) -> {
            if(!s.isRunning())
            {
                System.out.println(s.getName() + "(" + s.getId() + ")");
                s.getAdmins().forEach(a -> {
                     System.out.println(a.getName());
                 });
            }
        });
    }
*/
}