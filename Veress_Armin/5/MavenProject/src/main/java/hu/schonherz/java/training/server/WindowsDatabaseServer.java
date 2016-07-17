package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

/**
 *
 */
public class WindowsDatabaseServer extends WindowsServer implements Database {

    /**
     *
     */
    private Status status;

    /**
     *
     * @param id id
     * @param name name
     * @param status1 status
     */
    public WindowsDatabaseServer(
            final String id, final String name, final String status1) {
        super(id, name, status1);
    }

    /**
     *
     * @return lol
     */
    @Override
    public final String getStatus() {
        return status.toString();
    }

    /**
     *
     * @return lol
     */
    @Override
    public final int hashCode() {
        return status.hashCode();
    }
}
