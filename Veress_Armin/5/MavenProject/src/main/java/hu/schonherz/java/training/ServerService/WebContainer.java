package hu.schonherz.java.training.ServerService;

/**
 *
 */
public interface WebContainer {
    /**
     *
     */
    enum Status { RUNNING, STOPPED }

    /**
     * Tell the status of the Web container.
     * @return String of status of Web container
     */
    String getStatus();

    /**
     * Start the stopped Web container.
     */
    void startWebContainer();

    /**
     * Stop the running Web container.
     */
    void stopWebContainer();

    /**
     * Stop the Web container if it is running
     * and start it.
     */
    void restartWebContainer();
}

