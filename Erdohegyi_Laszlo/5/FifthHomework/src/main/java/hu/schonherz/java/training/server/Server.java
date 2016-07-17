package hu.schonherz.java.training.server;

/**
 * An abstract class for servers.
 */
public abstract class Server {

    private int cpuUsage;
    private int memoryUsage;
  
    public int getCpuUsage() {
        return cpuUsage;
    }
  
    public int getMemoryUsage() {
        return memoryUsage;
    }
  
    public abstract void restart();

    public abstract int getID();

    public abstract String getName();

    public abstract String getType();



}
