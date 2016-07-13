package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.WebContainer;

public class ServerFactory {

    public static Server getServer(String type) {
        if (type == null)
            return null;

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
