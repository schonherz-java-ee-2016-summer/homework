package hu.schonherz.java.training.server;

import hu.schonherz.java.training.serverservice.Database;
import hu.schonherz.java.training.serverservice.WebContainer;
/**
 *
 */
public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {
    /**
     *
     */
    public enum Status {RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPER}

    private Status status;

    public LinuxDatabaseAndWebServer(int identity, String name, String type, Status status) {
        super(identity, name, type);
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
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof LinuxDatabaseAndWebServer)) {
            return false;
        }
        LinuxDatabaseAndWebServer linuxDAW = (LinuxDatabaseAndWebServer) obj;

        return this.getIdentity() == linuxDAW.getIdentity() && this.getName().equals(linuxDAW.getName());
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public String getConnectionURL() {
        return "localhost:54321";
    }

}
