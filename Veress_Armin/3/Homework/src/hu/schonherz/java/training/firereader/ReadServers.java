/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Lenovo
 *
 */
public class ReadServers {

    private static HashMap map = null;
    public static void read() {
        List<Server> servers = ServerReader.readFromTextFile();
        map = createMap(servers);
        List<SystemAdministrator> admins = AdminReader.readFromTextFile();
        assignServerAdmin(admins);
        showStatus(servers);
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

    public static HashMap createMap(List<Server> srvs)
    {
        HashMap smap = new HashMap();
        srvs.stream().forEach((srv) -> {
            Server ser = (Server) smap.get(srv.getId());
            if (ser == null) {
                smap.put(srv.getId(), srv);
            }
        });
        return smap;
    }

    public static void showStatus(List<Server> srvs)
    {
        srvs.forEach((Server s) -> {
            if(!s.isRunning())
            {
                System.out.println(s.getName() + "(" + s.getId() + ")");
                s.getAdmins().forEach(a -> {
                    System.out.println(a.getName());
                });
            }
        });
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