package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

public class WindowsDatabaseServer extends WindowsServer implements Database {

    private Status status;

    public WindowsDatabaseServer(int ID, String name, String type, Status status) {
        super(ID, name, type);
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof WindowsDatabaseServer))
            return false;

        WindowsDatabaseServer windowsDS = (WindowsDatabaseServer) obj;

        return this.getID() == windowsDS.getID() && this.getName().equals(windowsDS.getName());
    }
    /*
    // default method has been implemented
    @Override
    public String getConnectionURL() {
        return "localhost:12345";
    }*/

}
