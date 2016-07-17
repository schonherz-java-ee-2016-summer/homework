package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;

/**
 *
 */
public class LinuxDatabaseAndWebServer extends
        LinuxServer implements Database, WebContainer {

    /**
     *
     */
    public enum Status { RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPER }

    /**
     *
     */
    private Status status;

    /**
     *
     * @param id id
     * @param name name
     * @param status status
     */
    public LinuxDatabaseAndWebServer(
            final String id, final String name, final String status) {
        super(id, name, status);
    }

    /**
     *
     */
    @Override
    public final void startWebContainer() {
        System.out.println("Web container is starting");
    }

    /**
     *
     */
    @Override
    public final void stopWebContainer() {
        System.out.println("Web container is stopping");
    }

    /**
     *
     */
    @Override
    public final void restartWebContainer() {
        if (status == Status.RUNNING) {
            stopWebContainer();
        }
        startWebContainer();
    }

    /**
     *
     * @return lol
     */
    @Override
    public final String getStatus() {
        return status.name();
    }

    /**
     *
     * @return lol
     */
    @Override
    public final String getConnectionURL() {
        return "localhost:54321";
    }

    /**
     *
     * @return lol
     */
    @Override
    public final int hashCode() {
        return status != null ? status.hashCode() : 0;
    }
}
