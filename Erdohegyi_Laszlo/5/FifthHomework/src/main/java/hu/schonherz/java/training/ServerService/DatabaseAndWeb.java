package hu.schonherz.java.training.serverservice;

/**
 * An interface for both Database's and WebContainer's methods.
 */
public interface DatabaseAndWeb extends Database, WebContainer {
    public abstract String getLocation();
}
