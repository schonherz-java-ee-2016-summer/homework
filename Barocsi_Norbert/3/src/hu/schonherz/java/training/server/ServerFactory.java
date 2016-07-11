package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;

/**
 * Created by Mindfield on 2016. 07. 11..
 */
public class ServerFactory {
    public static Server getServer(String[] attributes){

        if("Win".equals(attributes[2])){
            return new WindowsDatabaseServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], Database.Status.valueOf(attributes[3]));
        } else if("LinuxWeb".equals(attributes[2])){
            return new LinuxWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], WebContainer.Status.valueOf(attributes[3]));
        } else if ("LinuxDBandWEB".equals(attributes[2])) {
            return new LinuxDatabaseAndWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxDatabaseAndWebServer.Status.valueOf(attributes[3]));
        } else{
            return null;
        }

    }
}
