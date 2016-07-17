package hu.schonherz.java.training.server;

import hu.schonherz.java.training.serverservice.Database;
import hu.schonherz.java.training.serverservice.WebContainer;

/**
 * A class for linux database and web servers.
 */
public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {

    /**
     * An enum to specify the status of the LinuxDatabaseAndWebServer.
     */
    public enum Status {RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPED}

    private Status status;

    public LinuxDatabaseAndWebServer(int id, String name, String type, Status status) {
        super(id, name, type);
        this.status = status;
    }

    @Override
    public void startWebContainer() {
        System.out.println("Web container is starting");
    }

    @Override
    public void stopWebContainer() {
        System.out.println("Web container is stopping");
    }

    @Override
    public void restartWebContainer() {
        if (status == Status.RUNNING) {
            stopWebContainer();
        }

        startWebContainer();
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public String getConnectionURL() {
        return "localhost:54321";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof LinuxDatabaseAndWebServer)) {
            return false;
        }

        LinuxDatabaseAndWebServer linuxDaws = (LinuxDatabaseAndWebServer) obj;

        return this.getID() == linuxDaws.getID() && this.getName().equals(linuxDaws.getName())
                && this.getType().equals(linuxDaws.getType()) && this.getStatus().equals(linuxDaws.getStatus());
    }

}
