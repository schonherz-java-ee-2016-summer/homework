package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nutty on 2016.07.11..
 */
public class ServerFactory {
    private static Server instance = null;
    private static List<Server> distinctServers = new ArrayList<>();

    public static Server getInstance(int id, String name, String type, String status) {
        Enum statusEnum = getStatus(type, status);
        switch (type) {
            case "Win":
                instance = new WindowsDatabaseServer((WindowsDatabaseServer.Status) statusEnum);
                break;
            case "LinuxWeb":
                instance = new LinuxWebServer((LinuxWebServer.Status) statusEnum);
                break;
            case "LinuxDBandWEB":
                instance = new LinuxDatabaseAndWebServer((LinuxDatabaseAndWebServer.Status) statusEnum);
                break;
        }
        instance.setName(name);
        instance.setId(id);
        if (distinctServers.contains(instance)) {
            int index = distinctServers.indexOf(instance);
            instance = distinctServers.get(index);
        } else
            distinctServers.add(instance);
        return instance;
    }

    private static Enum getStatus(String type, String status) {
        Enum result = null;
        switch (type) {
            case "Win":
                if (status.equals("RUNNING"))
                    result = Database.Status.RUNNING;
                else result = Database.Status.STOPPED;
                break;
            case "LinuxWeb":
                if (status.equals("RUNNING"))
                    result = WebContainer.Status.RUNNING;
                else result = WebContainer.Status.STOPPED;
                break;
            case "LinuxDBandWEB":
                if (status.equals("RUNNING"))
                    result = LinuxDatabaseAndWebServer.Status.RUNNING;
                else result = LinuxDatabaseAndWebServer.Status.DATABASESTOPPED;
                break;
        }
        return result;
    }
}
