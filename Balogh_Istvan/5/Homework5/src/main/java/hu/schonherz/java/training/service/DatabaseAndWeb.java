package hu.schonherz.java.training.service;

/**
 * This interface represents a database and webcontainer.
 */
// both Database's WebContainer's method present here
public interface DatabaseAndWeb extends Database, WebContainer {
    public abstract String getLocation();
}
