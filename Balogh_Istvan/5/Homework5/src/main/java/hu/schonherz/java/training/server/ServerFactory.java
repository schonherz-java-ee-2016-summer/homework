package hu.schonherz.java.training.server;

import hu.schonherz.java.training.service.WebContainer;

/**
 * This class is for creating {@link Server} objects with static {@link #getServer(String)} method.
 */
public class ServerFactory {

    public static Server getServer(String type) {
        if (type == null) {
            return null;
        }

        switch (type) {
            case "Win":  {
                return new WindowsServer();
            }
            case "LinuxWeb": {
                return new LinuxWebServer(WebContainer.Status.RUNNING);
            }
            case "LinuxDBandWEB": {
                return new LinuxDatabaseAndWebServer(LinuxDatabaseAndWebServer.Status.RUNNING);
            }
        }

        return null;
    }

}
