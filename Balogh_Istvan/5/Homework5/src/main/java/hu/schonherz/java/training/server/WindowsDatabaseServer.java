package hu.schonherz.java.training.server;

import hu.schonherz.java.training.service.Database;

/**
 * This class represents a Windows Database Server.
 */
public class WindowsDatabaseServer extends WindowsServer implements Database {

    private Status status;

    public WindowsDatabaseServer(Status status) {
        super();
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status.toString();
    }
  
    /*
    // default method has been implemented
    @Override
    public String getConnectionURL() {
        return "localhost:12345";
    }*/

}
