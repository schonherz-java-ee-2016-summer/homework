package hu.schonherz.java.training.ServerService;

/**
 * Created by Home on 2016. 07. 12..
 */
public interface Database {

    /**
     * Database status
     */
    public enum Status {RUNNING, STOPPED}

    /**
     * Tell the status of Database
     *
     * @return String of status of Database
     */
    public abstract String getStatus();

    /**
     * Tell the URL connection of the Database
     *
     * @return Sting of URL connection to the Database
     */
    default String getConnectionURL() {
        return "localhost:98765";
    }
}