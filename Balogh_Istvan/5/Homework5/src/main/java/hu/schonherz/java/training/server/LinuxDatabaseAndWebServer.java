package hu.schonherz.java.training.server;

import hu.schonherz.java.training.service.Database;
import hu.schonherz.java.training.service.WebContainer;

/**
 * This class represents a Linux Database and Web Server.
 */
public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {

    /**
     * Server status enum types.
     */
    public enum Status {RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPER}

    private Status status;

    public LinuxDatabaseAndWebServer(Status status) {
        super();
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
