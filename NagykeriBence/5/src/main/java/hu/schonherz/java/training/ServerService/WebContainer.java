package hu.schonherz.java.training.ServerService;

/**
 * This interface gives methods of a basic web container.
 */
public interface WebContainer {
    /**
     * The status of the web container.
     */
    public enum Status {
        RUNNING, STOPPED
    }

    /**
     * Tell the status of the Web container.
     *
     * @return String of status of Web container
     */
    public String getStatus();

    /**
     * Start the stopped Web container.
     */
    public void startWebContainer();

    /**
     * Stop the running Web container.
     */
    public void stopWebContainer();

    /**
     * Stop the Web container if it is running.
     * and start it
     */
    public void restartWebContainer();

}
