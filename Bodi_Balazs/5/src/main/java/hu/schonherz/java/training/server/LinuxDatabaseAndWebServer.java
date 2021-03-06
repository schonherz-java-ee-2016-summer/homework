package hu.schonherz.java.training.server;

import hu.schonherz.java.training.serverservice.Database;
import hu.schonherz.java.training.serverservice.WebContainer;

/**
 * This class extends the LinuxServer class
 * and implements Database and WebContainer
 * interfaces.
 */

public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {

    /**
     * This class extends the LinuxServer class
     * and implements Database and WebContainer
     * interfaces.
     */

    public enum Status {RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPER}

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

}
