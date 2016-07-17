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

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof WindowsDatabaseServer)) {
            return false;
        }

        WindowsDatabaseServer windowsDs = (WindowsDatabaseServer) obj;

        return this.getID() == windowsDs.getID() && this.getName().equals(windowsDs.getName())
                && this.getType().equals(windowsDs.getType()) && this.getStatus().equals(windowsDs.getStatus());
    }

    /*
    // default method has been implemented
    @Override
    public String getConnectionURL() {
        return "localhost:12345";
    }*/

}
