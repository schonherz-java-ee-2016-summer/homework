package hu.schonherz.java.training.ServerService;

/**
 * Created by Home on 2016. 07. 12..
 */
public interface DatabaseAndWeb extends Database, WebContainer {
    public abstract String getLocation();
}
