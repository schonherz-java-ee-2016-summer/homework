package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

public class WindowsDatabaseServer extends WindowsServer implements Database {

    private Status status;

    //created
    public WindowsDatabaseServer(int ID, String name, String type,Status status) {
        super(ID,name,type);
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
