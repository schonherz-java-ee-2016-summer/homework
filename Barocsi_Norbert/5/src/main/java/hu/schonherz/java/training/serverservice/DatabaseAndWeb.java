package hu.schonherz.java.training.serverservice;

/**
 *
 */
public interface DatabaseAndWeb extends Database, WebContainer {
    public abstract String getLocation();
}
