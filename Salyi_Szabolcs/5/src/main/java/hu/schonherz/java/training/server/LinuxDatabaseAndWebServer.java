package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;

/**
 * Created by Home on 2016. 07. 12..
 */
public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {

    /**
     * Server status
     */
    public enum Status {RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPER}


    private Status status;

    //created
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

