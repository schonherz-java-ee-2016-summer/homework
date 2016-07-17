package hu.schonherz.java.training.server;

/**
 * This class extends the LinuxServer class
 * describes abstract methods which
 * implemented in other classes
 */
public abstract class Server {

    private int cpuUsage;
    private int memoryUsage;

    public abstract int getID();
    public abstract String getName();
    public abstract String getType();
  
    public int getCpuUsage() {
        return cpuUsage;
    }
  
    public int getMemoryUsage() {
        return memoryUsage;
    }
  
    public abstract void restart();

}
