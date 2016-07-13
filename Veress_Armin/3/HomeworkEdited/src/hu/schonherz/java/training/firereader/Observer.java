/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Lenovo
 * 
 */
public class Observer {
    private static Map<String, Server> map = null;
    public static void read() {
        map = ServerReader.readFromTextFile();
        List<SystemAdministrator> admins = AdminReader.readFromTextFile();
        assignServerAdmin(admins);
        showStatus(map);
    }
    
    public static Map<String, Server> getMap()
    {
        return Observer.map;
    }
    
    public static void setMap(Map<String, Server> map)
    {
        Observer.map=map;
    }
    
    public static void assignServerAdmin(List<SystemAdministrator> adms)
    {
        adms.stream().forEach((admin) -> {
            admin.getServers().stream().forEach((serv) -> {
                serv.addAdmin(admin);
            });
        });
    }
    
    public static void showStatus(Map<String, Server> map)
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
}
