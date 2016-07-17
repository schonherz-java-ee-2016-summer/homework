package hu.schonherz.java.training.serverservice;

/**
 * Describes the Database interface.
 */

public interface Database {
    /**
     * Describes the Database interface.
     */
    public enum Status {RUNNING, STOPPED}
    /**
     * Tell the status of Database.
     * @return String of status of Database.
     */
    public abstract String getStatus();
    /**
     * Tell the URL connection of the Database.
     * @return Sting of URL connection to the Database.
     */
    default String getConnectionURL() {
      return "localhost:98765";
    }

}
