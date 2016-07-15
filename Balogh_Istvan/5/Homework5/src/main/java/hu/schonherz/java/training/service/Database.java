package hu.schonherz.java.training.service;

/**
 * This interface represents a database.
 */
public interface Database {

    /**
     * Database status enum types.
     */
    public enum Status {RUNNING, STOPPED}

    /**
     * Tell the status of Database.
     * @return String of status of Database
     */
    public abstract String getStatus();

    /**
     * Tell the URL connection of the Database.
     * @return Sting of URL connection to the Database
     */
    default String getConnectionURL() {
      return "localhost:98765";
    }

}
