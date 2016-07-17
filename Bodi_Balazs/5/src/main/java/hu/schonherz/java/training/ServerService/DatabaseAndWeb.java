package hu.schonherz.java.training.serverservice;

/**
 * Describes the DatabaseAndWeb interface.
 * Both Database's WebContainer's method present here.
 */

public interface DatabaseAndWeb extends Database, WebContainer {
    public abstract String getLocation();
}
