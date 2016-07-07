package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

public class WindowsDatabaseServer extends WindowsServer implements Database {

    private Status status;

    public WindowsDatabaseServer(int id, String name, String type,Status status) {
        super(id,name,type);
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
