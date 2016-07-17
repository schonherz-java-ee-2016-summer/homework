package hu.schonherz.java.training.serverservice;

// both Database's WebContainer's method present here
public interface DatabaseAndWeb extends Database, WebContainer {
    public abstract String getLocation();
}
