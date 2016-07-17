package hu.schonherz.java.training.server;
/**
 *
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

    public abstract int getIdentity();
    public abstract String getName();
    public abstract String getType();
    public abstract void restart();
}
