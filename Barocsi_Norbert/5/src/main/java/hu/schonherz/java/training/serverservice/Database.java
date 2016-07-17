package hu.schonherz.java.training.serverservice;

/**
 *
 */
public interface Database {
    /**
     *
     */
    public enum Status {RUNNING, STOPPED}

    /**
     * Tell the status of Database.
     */
    public abstract String getStatus();

    /**
     * Tell the URL connection of the Database.
     */
    default String getConnectionURL() {
      return "localhost:98765";
    }

}
